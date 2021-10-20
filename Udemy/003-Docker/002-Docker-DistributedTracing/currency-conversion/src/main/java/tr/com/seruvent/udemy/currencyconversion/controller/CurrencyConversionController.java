package tr.com.seruvent.udemy.currencyconversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tr.com.seruvent.udemy.currencyconversion.model.CurrencyConversion;
import tr.com.seruvent.udemy.currencyconversion.proxy.CurrencyExchangeProxy;

@RestController
@RequestMapping(path = "currency-conversion")
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping(path = "/rest/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyExhangeFromAndToRestTemp(@PathVariable String from,
                                                    @PathVariable String to,
                                                    @PathVariable int quantity){

        String url = String.format("http://localhost:8101/currency-exchange/from/%s/to/%s" , from , to);
        RestTemplate restTemplate = new RestTemplate();
        CurrencyConversion currencyConversion = restTemplate.getForEntity(url, CurrencyConversion.class).getBody();
        currencyConversion.setQuantity(quantity);
        currencyConversion.setConversionValue(currencyConversion.getQuantity() * currencyConversion.getValue());

        return currencyConversion;

    }

    @GetMapping(path = "/feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyExhangeFromAndToFeign(@PathVariable String from,
                                                                  @PathVariable String to,
                                                                  @PathVariable int quantity){

        CurrencyConversion currencyConversion = currencyExchangeProxy.getCurrencyFromAndTo(from,to);
        currencyConversion.setQuantity(quantity);
        currencyConversion.setConversionValue(currencyConversion.getQuantity() * currencyConversion.getValue());
        return currencyConversion;
    }

}

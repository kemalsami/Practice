package tr.com.seruvent.udemy.currencyconversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tr.com.seruvent.udemy.currencyconversion.model.CurrencyConversion;
import tr.com.seruvent.udemy.currencyconversion.proxy.CurrencyExchangeProxy;

@RestController
@RequestMapping("currency-conversion")
public class CurrencyConversionController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping(path = "/rest-template/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConversionRestTemplate(@PathVariable String from,
                                                                @PathVariable String to,
                                                                @PathVariable int quantity){

        String uri = String.format("http://localhost:8101/currency-exchange/from/%s/to/%s" , from,to);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(uri , CurrencyConversion.class);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        currencyConversion.setPort(environment.getProperty("server.port"));
        currencyConversion.setQuantity(quantity);
        return currencyConversion;

    }


    @GetMapping(path = "/feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConversionFeign(@PathVariable String from,
                                                                @PathVariable String to,
                                                                @PathVariable int quantity){

        CurrencyConversion currencyConversion = currencyExchangeProxy.getCurrencyExchange(from,to);
        currencyConversion.setPort(environment.getProperty("server.port"));
        currencyConversion.setQuantity(quantity);
        return currencyConversion;

    }

}

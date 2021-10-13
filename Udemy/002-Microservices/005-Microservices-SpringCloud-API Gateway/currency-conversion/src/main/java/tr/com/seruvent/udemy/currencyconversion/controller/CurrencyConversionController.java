package tr.com.seruvent.udemy.currencyconversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tr.com.seruvent.udemy.currencyconversion.configuration.Configuration;
import tr.com.seruvent.udemy.currencyconversion.model.CurrencyConversion;
import tr.com.seruvent.udemy.currencyconversion.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

    @Autowired
    private Configuration configuration;

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping(path = "currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion currencyConversion(@PathVariable String from,
                                   @PathVariable String to,
                                   @PathVariable int quantity){

        String url = "http://localhost:8101/currency-exchange/from/"+from+"/to/"+to;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(url, CurrencyConversion.class);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        currencyConversion.setQuantity(quantity);
        return currencyConversion;

    }

    @GetMapping(path = "currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion currencyConversionFeign(@PathVariable String from,
                                                      @PathVariable String to,
                                                      @PathVariable int quantity){

        CurrencyConversion currencyConversion = currencyExchangeProxy.getCurrencyExchange(from,to);

        currencyConversion.setQuantity(configuration.getQuantity());
        currencyConversion.setPort(environment.getProperty("server.port"));
        return currencyConversion;
    }
}

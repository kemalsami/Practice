package tr.com.seruvent.udemy.currencyconversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tr.com.seruvent.udemy.currencyconversion.model.CurrencyConversion;
import tr.com.seruvent.udemy.currencyconversion.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping(path = "currency-conversion-rest-template/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion currencyConversionRestTemplate(@PathVariable String fromCurrency,
                                               @PathVariable String toCurrency,
                                               @PathVariable int quantity){

        String uri = "http://localhost:8081/currency-exchange/from/"+fromCurrency+"/to/"+toCurrency;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity( uri, CurrencyConversion.class);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        return currencyConversion;
    }


    @GetMapping(path = "currency-conversion-feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion currencyConversionFeign(@PathVariable String fromCurrency,
                                                             @PathVariable String toCurrency,
                                                             @PathVariable int quantity){

        CurrencyConversion currencyConversion = currencyExchangeProxy.proxyCurrencyExchange(fromCurrency,toCurrency);
        return currencyConversion;
    }

}

package tr.com.seruvent.udemy.currencyconversion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tr.com.seruvent.udemy.currencyconversion.model.CurrencyConversion;

@RestController
public class CurrencyConversionController {

    // http://localhost:8001/currency-conversion/from/USD/to/TR/quantity/10

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
}

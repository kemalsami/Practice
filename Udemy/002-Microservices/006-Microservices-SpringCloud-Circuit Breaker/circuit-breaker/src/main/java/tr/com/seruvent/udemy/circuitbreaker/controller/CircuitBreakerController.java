package tr.com.seruvent.udemy.circuitbreaker.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.circuitbreaker.model.CurrencyConversion;
import tr.com.seruvent.udemy.circuitbreaker.proxy.CurrencyConversionProxy;

@RestController
@RequestMapping(path = "circuit-breaker")
public class CircuitBreakerController {

    @Autowired
    private CurrencyConversionProxy currencyConversionProxy;

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping(path = "/default")
    public CurrencyConversion getDefaultCurrenyConversion(){
        CurrencyConversion currencyConversion = currencyConversionProxy.getCurrencyConversionFeign("USD", "TR" , 2);
        return currencyConversion;
    }


    @GetMapping(path = "/test")
    @Retry(name = "CircuitBreakerRetryName", fallbackMethod = "defaultReturn")
    public CurrencyConversion getRetryExampleRequest(){

        logger.info("TEST Called");

        // Request call with Feign but there is no such url and it will 404 not found
        CurrencyConversion currencyConversion = currencyConversionProxy.getCurrencyConversionDummy();
        return currencyConversion;
    }


    public CurrencyConversion defaultReturn(Exception ex){
        CurrencyConversion currencyConversion = new CurrencyConversion();
        return currencyConversion;
    }

}

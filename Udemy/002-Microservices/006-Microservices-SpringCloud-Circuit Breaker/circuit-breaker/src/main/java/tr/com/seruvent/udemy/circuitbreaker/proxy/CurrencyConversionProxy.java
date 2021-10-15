package tr.com.seruvent.udemy.circuitbreaker.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tr.com.seruvent.udemy.circuitbreaker.model.CurrencyConversion;

@FeignClient(name="currency-conversion-service")
public interface CurrencyConversionProxy {


    @GetMapping(path = "currency-conversion/feign/from/{from}/to/{to}/quantity/{quantity}")
    CurrencyConversion getCurrencyConversionFeign(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable int quantity);

    @GetMapping(path = "currency-conversion/dummy")
    CurrencyConversion getCurrencyConversionDummy();
}

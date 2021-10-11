package tr.com.seruvent.udemy.currencyconversion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tr.com.seruvent.udemy.currencyconversion.model.CurrencyConversion;


// @FeignClient(name = "dummy-name" , url = "localhost:8101")
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping(path = "currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getCurrencyExchange(@PathVariable String from,
                                           @PathVariable String to);

}

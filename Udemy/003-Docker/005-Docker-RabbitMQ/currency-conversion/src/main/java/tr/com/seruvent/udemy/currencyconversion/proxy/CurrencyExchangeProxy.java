package tr.com.seruvent.udemy.currencyconversion.proxy;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tr.com.seruvent.udemy.currencyconversion.model.CurrencyConversion;

@Component
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping(path = "currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getCurrencyFromAndTo(@PathVariable String from, @PathVariable String to);

}

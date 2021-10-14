package tr.com.seruvent.udemy.currencyconversion.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tr.com.seruvent.udemy.currencyconversion.model.CurrencyConversion;

@FeignClient(name="currency-exchange-service" , url = "localhost:8101")
public interface CurrencyExchangeProxy {

    @GetMapping(path = "currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion getCurrencyExchange(@PathVariable String from, @PathVariable String to);
}

package tr.com.seruvent.udemy.currencyconversion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tr.com.seruvent.udemy.currencyconversion.model.CurrencyConversion;

@FeignClient(name="currency-exchange" , url = "localhost:8081")
public interface CurrencyExchangeProxy {

    @GetMapping(path = "currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyConversion proxyCurrencyExchange(@PathVariable String fromCurrency, @PathVariable String toCurrency);

}

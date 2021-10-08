package tr.com.seruvent.udemy.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.currencyexchange.model.Currency;
import tr.com.seruvent.udemy.currencyexchange.repository.CurrecyRepository;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrecyRepository currecyRepository;

    @Autowired
    private Environment environment;

    @GetMapping(path = "currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public Currency currencyExchange(@PathVariable String fromCurrency, @PathVariable String toCurrency){
        Currency currency = currecyRepository.findByFromAndTo(fromCurrency, toCurrency);

        currency.setPort(environment.getProperty("server.port"));
        return currency;
    }

}

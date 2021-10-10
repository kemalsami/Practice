package tr.com.seruvent.udemy.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.currencyexchange.model.Currency;
import tr.com.seruvent.udemy.currencyexchange.repository.CurrencyRepository;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping(path = "currency-exchange/from/{from}/to/{to}")
    public Currency currencyExchange(@PathVariable String from,
                                 @PathVariable String to){

        Currency currency = currencyRepository.findByFromAndTo(from,to);
        return currency;
    }

}

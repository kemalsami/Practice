package tr.com.seruvent.udemy.currencyexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import tr.com.seruvent.udemy.currencyexchange.model.Currency;

@Component
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    Currency findByFromAndTo(String from, String to);

}

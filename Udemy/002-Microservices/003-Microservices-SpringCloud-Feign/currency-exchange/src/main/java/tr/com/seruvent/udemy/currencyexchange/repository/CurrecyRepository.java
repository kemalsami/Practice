package tr.com.seruvent.udemy.currencyexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.seruvent.udemy.currencyexchange.model.Currency;

@Repository
public interface CurrecyRepository extends JpaRepository<Currency , Integer> {

    Currency findByFromAndTo(String from, String to);

}

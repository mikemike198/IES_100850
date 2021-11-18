package pt.ua.randomQuotes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.ua.randomQuotes.Entities.Quote;

public interface RandomQuotesRepository extends JpaRepository<Quote, Long>{
    
}

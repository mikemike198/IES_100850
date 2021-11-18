package pt.ua.randomQuotes.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pt.ua.randomQuotes.Entities.Quote;
import pt.ua.randomQuotes.Entities.Show;

public interface RandomQuotesShowRepository extends JpaRepository<Show, Long> {

    @Query(value = "SELECT s.quotes FROM shows s WHERE s.show_id = :show_id", nativeQuery = true)
    List<Quote> findQuoteByShowId(@Param("show_id") long show_id);
    
}

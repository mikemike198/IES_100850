package pt.ua.randomQuotes.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.ua.randomQuotes.Entities.Quote;
import pt.ua.randomQuotes.Entities.Show;
import pt.ua.randomQuotes.Repository.RandomQuotesRepository;
import pt.ua.randomQuotes.Repository.RandomQuotesShowRepository;

@Service
public class RandomQuotesService {

    @Autowired
    private RandomQuotesRepository repositoryQuotes;

    @Autowired
    private RandomQuotesShowRepository repositoryShows;

    public Quote getQuoteByShowId(long id) {
        
        List<Quote> quotes = repositoryShows.findQuoteByShowId(id);

        if (quotes.isEmpty()) {
            return null;
        }

        int max = quotes.size() -1 ;
        int min = 0;
        int range = (max - min) + 1;
        int index = (int)(Math.random() * range) + min;
        
        System.out.println(index);
        return quotes.get(index);
    }

    public Quote getRandomQuote() {
        
        List<Quote> quotes = repositoryQuotes.findAll();

        if (quotes.isEmpty()) {
            return null;
        }

        int max = quotes.size() -1 ;
        int min = 0;
        int range = (max - min) + 1;
        int index = (int)(Math.random() * range) + min;

        return quotes.get(index);

    }

    public List<Show> getShows() {
        List<Show> shows = repositoryShows.findAll();

        if (shows.isEmpty()) {
            return null;
        }

        return shows;
    }


    public Quote createQuote(Quote quote) {
        return repositoryQuotes.save(quote);
    }

    public Show createShow(Show show) {
        return repositoryShows.save(show);
    }

    public void deleteShow(Long showId) {
        repositoryShows.deleteById(showId);
    }

    public void deleteQuote(Long quoteId) {
        repositoryQuotes.deleteById(quoteId);
    }
    
}

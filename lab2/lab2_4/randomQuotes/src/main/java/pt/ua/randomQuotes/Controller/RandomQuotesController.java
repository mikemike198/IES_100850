package pt.ua.randomQuotes.Controller;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.ua.randomQuotes.Entities.Shows;
import pt.ua.randomQuotes.Model.Quote;
import pt.ua.randomQuotes.Model.Show;

@RestController
public class RandomQuotesController {

    private final Shows shows = new Shows();

    @GetMapping(value="api/quote")
    public Quote random_quote(@RequestParam(name = "show", required = false, defaultValue = "-1") String show_id) {
        if (show_id.equals("-1")) {
            Quote q = shows.getRandomQuote();
            System.out.println(q.quote);
            return q;
        }
        Long id = Long.parseLong(show_id);
        Quote q =shows.getQuoteByShowId(id);
        System.out.println(q);
        return q;
    }

    @GetMapping(value="api/shows")
    public ArrayList<Show> shows() {
        return shows.getShows();
    }

    
    
}

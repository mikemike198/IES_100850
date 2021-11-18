package pt.ua.randomQuotes.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.ua.randomQuotes.Entities.Quote;
import pt.ua.randomQuotes.Entities.Show;
import pt.ua.randomQuotes.Services.RandomQuotesService;

@RestController
public class RandomQuotesController {

    @Autowired
    private RandomQuotesService service;

    @GetMapping(value="api/quote")
    public ResponseEntity<Quote> random_quote(@RequestParam(name = "show", required = false, defaultValue = "-1") String show_id) {
        Quote q = service.getRandomQuote();
        return ResponseEntity.ok().body(q);
    }

    @PostMapping(value="api/quote")
    public ResponseEntity<Quote> insert_quote(@Valid @RequestBody Quote quote) {
        Quote q = service.createQuote(quote);
        return ResponseEntity.ok().body(q);
    }

    @DeleteMapping(value="api/quote/{id}")
    public Map<String, Boolean> delete_quote(@PathVariable(value = "id") Long quote_id){
        service.deleteQuote(quote_id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping(value="api/shows")
    public ResponseEntity<List<Show>> shows(){
        List<Show> s = service.getShows();
        return ResponseEntity.ok().body(s);
    }

    @PostMapping(value="api/shows")
    public ResponseEntity<Show> insert_show(@Valid @RequestBody Show show){
        Show s = service.createShow(show);
        return ResponseEntity.ok().body(s);
    }

    @DeleteMapping(value="api/shows/{id}")
    public Map<String, Boolean> delete_show(@PathVariable(value = "id") Long showId){
        service.deleteShow(showId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    
    
}

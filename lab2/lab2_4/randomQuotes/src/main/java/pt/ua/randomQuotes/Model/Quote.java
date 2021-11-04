package pt.ua.randomQuotes.Model;


public class Quote {
    
    public final long quote_id;
    public final Show show;
    public final String quote;

    public Quote(long quote_id, Show show, String quote) {
        this.quote_id = quote_id;
        this.show = show;
        this.quote = quote;
    }

    public long getId() {
        return quote_id;
    }

    public Show getShow() {
        return show;
    }

    public String getQuote() {
        return quote;
    }

}

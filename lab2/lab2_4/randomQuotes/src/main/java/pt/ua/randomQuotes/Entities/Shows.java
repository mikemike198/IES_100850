package pt.ua.randomQuotes.Entities;

import java.util.ArrayList;
import java.lang.Math;

import pt.ua.randomQuotes.Model.Quote;
import pt.ua.randomQuotes.Model.Show;

public class Shows {

    private ArrayList<Show> shows;
    private ArrayList<Quote> quotes;

    public Shows() {
        shows = new ArrayList<>();
        quotes = new ArrayList<>();
        
        Show s1 = new Show(0, "Game of Thrones", "Serie");
        Quote q1 = new Quote(0, s1, " No need to seize the last word, Lord Baelish. I’ll assume it was something clever.  —Sansa Stark");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(1, "Grey's Anathomy", "Serie");
        q1 = new Quote(1, s1, " So, pick me. Choose me. Love me.  -Meredith Grey");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(2, "Breaking Bad", "Serie");
        q1 = new Quote(2, s1, " I am not in danger, I am the danger.  —Walter White");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(2, "Lost", "Serie");
        q1 = new Quote(2, s1, " We have to go back!  —Jack");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(3, "Friends", "Serie");
        q1 = new Quote(3, s1, " Welcome to the real world. It sucks. You’re gonna love it!  —Monica");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(4, "Shrek", "Filme");
        q1 = new Quote(4, s1, " Ogres are like onions.  -Shrek");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(5, "Guradians of the Galaxy 1", "Filme");
        q1 = new Quote(5, s1, " I am Groot. -Groot");
        
        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(6, "Harry Potter and the Sorcerer's Stone", "Filme");
        q1 = new Quote(6, s1, " You're a wizard, 'arry.  -Hagrid");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(7, "Finding Nemo", "Filme");
        q1 = new Quote(7, s1, " Just keep swimming.  -Dory");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(8, "Hunger Games", "Filme");
        q1 = new Quote(8, s1, "  I volunteer as tribute.  -Katniss Everdeen's");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(9, "Spider Man (2012)", "Filme");
        q1 = new Quote(9, s1, " With great power comes great responsibility.  -Uncle Ben");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(10, "The Incredibles", "Filme");
        q1 = new Quote(11, s1, " Honey? Where's my super suit?  -Frozone");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(12, "Batman: The Dark Knight", "Filme");
        q1 = new Quote(12, s1, " Why so serious?  -Joker");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(13, "Black Panther", "Filme");
        q1 = new Quote(13, s1, " Is this your king?  -Killmonger");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(14, "The Lord of the Rings: The Fellowship of the Ring ", "Filme");
        q1 = new Quote(14, s1, " You shall not pass!  -Gandalf");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(15, "The Lord of the Rings: The Fellowship of the Ring ", "Filme");
        q1 = new Quote(15, s1, " You shall not pass!  -Gandalf");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(0, "Game of Thrones", "Serie");
        q1 = new Quote(16, s1, " Winter is coming!  -Ned Stark");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(0, "Game of Thrones", "Serie");
        q1 = new Quote(17, s1, " Power resides where men believe it resides. It’s a trick, a shadow on the wall. And, a very small man can cast a very large shadow.  -Lord Varys");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(0, "Game of Thrones", "Serie");
        q1 = new Quote(18, s1, " Chaos is a ladder.  -Petyr Baelish");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(1, "Grey's Anathomy", "Serie");
        q1 = new Quote(19, s1, " You’re my person.  -Cristina Yang");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(1, "Grey's Anathomy", "Serie");
        q1 = new Quote(20, s1, " You were like coming up for fresh air. It’s like I was drowning, and you saved me.  -Derek Shepeard");

        shows.add(s1);
        quotes.add(q1);
        s1 = new Show(1, "Grey's Anathomy", "Serie");
        q1 = new Quote(21, s1, " It’s good to be scared. It means you still have something to lose.  -Richard Webber");

    }

    public Quote getQuoteByShowId(long id) {
        ArrayList<Quote> qs = new ArrayList<>();
        for (Quote q : quotes) {
            if (q.getShow().getId() == id) {
                qs.add(q);
            }
        }
        if (qs.size() == 0) {
            return null;
        }

        int max = qs.size() -1 ;
        int min = 0;
        int range = (max - min) + 1;
        int index = (int)(Math.random() * range) + min;
        
        System.out.println(index);
        return qs.get(index);
    }

    public Quote getRandomQuote() {
        int max = quotes.size() -1 ;
        int min = 0;
        int range = (max - min) + 1;
        int index = (int)(Math.random() * range) + min;

        return quotes.get(index);

    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    
}

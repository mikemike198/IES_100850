package pt.ua.randomQuotes.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "quotes")
public class Quote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @ManyToOne //(cascade=CascadeType.ALL)
    @JoinColumn(name = "show_id", referencedColumnName = "show_id")
    public Show show;
    public String quote;

    public Quote() {}

    public Quote(long id, Show show, String quote) {
        this.id = id;
        this.show = show;
        this.quote = quote;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Quote [id=" + id + ", quote=" + quote + ", show=" + show + "]";
    }

    


}


//docker run --name quotesDB -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=quotes -e MYSQL_USER=miguel -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d mysql/mysql-server:5.7
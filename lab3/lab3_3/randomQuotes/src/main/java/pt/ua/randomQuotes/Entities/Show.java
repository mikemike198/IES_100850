package pt.ua.randomQuotes.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long show_id;
    
    public String title;
    public String type_show;
    public int year;

    public Show() {}

    public Show(long show_id,String name_show, String type_show, int year) {
        this.show_id = show_id;
        this.title = name_show;
        this.type_show = type_show;
        this.year = year;
    }

    public long getShow_id() {
        return show_id;
    }

    public void setShow_id(long show_id) {
        this.show_id = show_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType_show() {
        return type_show;
    }

    public void setType_show(String type_show) {
        this.type_show = type_show;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Show [show_id=" + show_id + ", title=" + title + ", type_show=" + type_show + ", year=" + year + "]";
    }
    
}

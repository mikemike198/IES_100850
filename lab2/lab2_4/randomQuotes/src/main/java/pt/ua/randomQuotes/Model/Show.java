package pt.ua.randomQuotes.Model;

public class Show {

    public final long show_id;
    public final String name_show;
    public final String type_show;

    public Show(long show_id,String name_show, String type_show) {
        this.show_id = show_id;
        this.name_show = name_show;
        this.type_show = type_show;
    }

    public long getId() {
        return show_id;
    }

    public String getNameShow() {
        return name_show;
    }

    public String getTypeShow() {
        return type_show;
    }
    
}

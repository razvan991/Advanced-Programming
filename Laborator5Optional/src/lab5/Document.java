package lab5;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Aici in mare parte este preluat de pe slide-uri + generat gettere , settere si constructori
public class Document implements Serializable {
    private String title;
    private int year;
    private List<String> authors;
    private String id;
    private String name;
    protected String location;
    private Map<String,Object> tags=new HashMap<>();

    public Document(String title , String location , int year , String ... authors) throws YearException, FileNotFoundException {
        if( year > Calendar.getInstance().get(Calendar.YEAR))
            throw new YearException("We are not there yet!\n");
        if( !new File(location).exists())
            throw new FileNotFoundException("Calea " + location + " este invalida");
        this.title = title;
        this.location = location;
        this.year = year;
        this.authors = new ArrayList<String>();
        for( String a : authors ) {
            this.authors.add(a);
        }
    }
    public Document()
    {

    }
    public Document(String id, String name, String location)  {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Map<String, Object> getTags() {
        return tags;
    }
    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }
    public void addTag(String key,Object obj){
        tags.put(key,obj);
    }
    public class YearException extends Exception {
        public YearException( String s) {
            super(s);
        }
    }
}

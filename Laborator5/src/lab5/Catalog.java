package lab5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
//Aici in mare parte este preluat de pe slide-uri + generat gettere , settere si constructori
public class Catalog implements Serializable {
    public Catalog() {documents = new ArrayList<Document>();
    }
    private String name;
    private String path;
    protected List<Document> documents=new ArrayList<>();
    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public List<Document> getDocuments() {
        return documents;
    }
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
    public void add(Document doc){
        documents.add(doc);
    }
    public Document findById(String id) {
        for (Document doc : documents) {if (doc.getId().equals(id)) {return doc;}}return null;
    }

}

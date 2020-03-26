package lab5;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CatalogUtil {
    private String name;
    private String path;
    protected List<Document> documents=new ArrayList<>();
    //Metoda save din Slide-uri
    public static void save(Catalog catalog)throws IOException {
        try (var oos=new ObjectOutputStream(new FileOutputStream(catalog.getPath()))){
            oos.writeObject(catalog);
        }
    }
    //Declaram un obiect de tipul catalog apoi facem cast la tipul catalog la fisierul cu pathul path folosind fileinputstream si objectinputstream
    //apoi il returnam
    public static Catalog load(String path) throws IOException, InvalidCatalogException {
        Catalog c = new Catalog();
            if( !new File(path).exists() )
                throw new FileNotFoundException("Cale invalida: " + path + " !");
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fis);
            try {
                c=(Catalog)in.readObject();
                return c;
            }
            catch (FileNotFoundException e) {
                throw new InvalidCatalogException("Eroare la load: ", e);
            } catch (IOException e) {
                throw new InvalidCatalogException("Eroare la load: ", e);
            } catch (ClassNotFoundException e) {
                throw new InvalidCatalogException("Eroare la load: ", e);
            }
    }
    //Deschidem fisierul folosind functia desktop.open pentru fisiere si desktop.browse pentru URI-ul dat
    //Daca locatia documentului incepe cu http=> trebuie utilizat browse , iar daca exista fisierul file =>open
    public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop=Desktop.getDesktop();
        File file=new File(doc.getLocation());
        if(file.exists()){
            desktop.open(file);
        }else if(doc.getLocation().startsWith("http"))
        {
            URI uri=new URI(doc.getLocation());
            desktop.browse(uri);
        }

    }
}


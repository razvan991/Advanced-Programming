package lab5;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
//Preluat de pe slide-uri
public class Main {

    public static void main(String[] args) throws InvalidCatalogException, IOException, URISyntaxException {
        Main app= new Main();
        app.testCreateSave();
        app.testLoadView();
    }
    private void testCreateSave() throws IOException {
        Catalog catalog=new Catalog("Java Resources","d:\\da.txt");
        Document doc = new Document("java1","Java Course 1","https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide");
        doc.addTag("type","Slides");
        catalog.add(doc);
        CatalogUtil.save(catalog);
    }
    private void testLoadView() throws InvalidCatalogException, IOException, URISyntaxException {
        Catalog catalog = CatalogUtil.load("d:\\da.txt");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }
}

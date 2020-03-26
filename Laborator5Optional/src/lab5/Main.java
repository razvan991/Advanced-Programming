package lab5;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
//Preluat de pe slide-uri
public class Main {

    public static void main(String[] args) throws InvalidCatalogException, IOException, URISyntaxException {
        /*Main app= new Main();
        app.testCreateSave();
        app.testLoadView();*/

        //Optional
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        //Break with Ctrl+C
        while (true) {
            //read the command(afisez shell > + citesc ce este scris la linia de comanda)
            System.out.print("shell > ");
            commandLine = console.readLine();
            //if just a return, loop(daca e doar spatiu/enter continui sa citesc)
            if (commandLine.equals(""))
                continue;
            // create new Catalog(cand se scrie new ... se creeaza un nou catalog)
            if (commandLine.matches("(new).[A-Za-z]*")) {
                String[] values = commandLine.split(" ");
                Catalog catalog = new Catalog();
                continue;
            }
            // add to catalog(pentru adaugarea in catalog e formatul add book "titlu" "path" an "autor")
            if (commandLine.matches("(add)\\s(book).*")) {
                if(commandLine.matches("(add)\\s(book)(\\s\"[^\"]*\"){2}\\s(\\d){4}(\\s\"[^\"]*\")*")) {
                    new AddCommand("book");
                    String[] values = commandLine.split("( \\\")|(\\\" )(?=\\d)|(\\\" \\\")|(\\\")");
                    for(String i : values)
                        System.out.println(i);
                }
                else {
                    System.out.println("Formatul nu este corect: add book \"Titlu\" \"Path\" An \"Autori\"");
                }
                continue;
            }
            //help command(vizualizarea comenzilor disponibile)
            if (commandLine.equals("help")) {
                Command.generalHelp();
                continue;
            }
            //clear command(stergerea din linia de comanda a tot ce s-a realizat pana in momentul respectiv)
            if (commandLine.equals("clear")) {
                for ( int cls = 0; cls< 10; cls++ ) {
                    System.out.println();
                }
                continue;
            }
            //cat *.java
            if (commandLine.endsWith(".java")) {
                if (commandLine.startsWith("cat")) {
                    System.out.println("merge");
                    ProcessBuilder pb = new ProcessBuilder();
                    pb = new ProcessBuilder(commandLine);
                } else {
                    System.out.println("Incorrect Command");
                }
                continue;
            }
            //exit command(iesirea din proces)
            if (commandLine.equals("exit")) {
                System.out.println(".\n..\n...\nGood bye!");
                System.exit(0);
                continue;
            }
            //command doesn't exist(comanda nu exista)
            System.out.println("Commanda nu exista !");
        }
    }

/*
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
    }*/
}

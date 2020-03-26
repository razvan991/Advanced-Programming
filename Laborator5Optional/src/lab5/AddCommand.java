package lab5;



public class AddCommand extends Command {
    private String type;
    private String title;
    private String path;
    private Integer year;
    private String[] authors;

    AddCommand(String title) {
        this.type=type;
        this.title=title;
        this.path=path;
        this.year=year;
        int i=0;
        for(String x : authors) {
            this.authors[i++] = x;
        }
        new Document();
    }

    @Override
    void implementCommand() {
        if(type=="book")
            addbook();
    }

    @Override
    void help() {

    }
    public void addbook(){

    }

}
package lab5;

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(String s, Exception ex){
        super("Invalid catalog file.", ex);
    }
}

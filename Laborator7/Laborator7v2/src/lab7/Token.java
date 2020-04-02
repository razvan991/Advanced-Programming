package lab7;
//Tokens getter + setter + constructor
public class Token {
    private int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Token(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "" + value;
    }
}

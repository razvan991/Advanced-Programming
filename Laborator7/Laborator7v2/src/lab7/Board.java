package lab7;

import java.util.LinkedList;
import java.util.Queue;

public class Board {
    private int limit;
    private Queue<Token> tokens = new LinkedList<Token>();
    //constructor + afisare board
    public Board(int limit) {
        this.limit = limit;
    }
    public void showBoard(){
        System.out.println(tokens);
    }
    //adaugare token in board
    public void addTokens(Token token){
        try {
            if (token.getValue() >= 1 && token.getValue()<= limit)
                tokens.add(token);
            else {
                throw new OutOfBoundsException();
            }
        }catch(OutOfBoundsException err){
            System.err.println("Valoarea este mai mare decat  "+ limit +" sau sub 1 !");
        }
    }
    //extragere token , daca are flag-ul -1 => nu mai avem token
    public synchronized  Token extract(){
        Token myToken=new Token(-1);
        if(tokens.isEmpty()) return myToken;
        return tokens.poll();
    }
}

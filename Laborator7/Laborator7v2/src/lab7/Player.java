package lab7;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    public String name;
    public Game game;
    private List<Token> progresie = new ArrayList<Token>();
    //constructor , adaugare player + game
    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    public String getPlayerName(){ return name; }
    //adaugare token in progresie
    public void addTokensInProgression(Token myToken){
        progresie.add(myToken);
    }
    //verificare daca este o progresie
    public synchronized boolean checkProgression(){
        int difference=progresie.get(1).getValue()-progresie.get(0).getValue();
        for (int i=0;i<progresie.size()-1;i++)
            if (progresie.get(i+1).getValue()-progresie.get(i).getValue()!=difference) return false;
        return true;
    }
    // extragem valoarea si adaugam in progresie
    public boolean extractToken() throws InterruptedException{
        //extragem o piesa
        Token token=game.getBoard().extract();
        //in caz ca nu mai sunt piese
        if(token.getValue()==-1){
            return false;
        }
        //creeam progresia
        Token token2=new Token(token.getValue());
        addTokensInProgression(token2);
        Thread.sleep(100);
        return true;
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", game=" + game +
                '}';
    }
    @Override
    public void run() {
    while(true){
        //eroare daca nu mai sunt piese
        try{
            if(!extractToken()) break;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //afisare
    if(checkProgression()==true){
        synchronized (this){
            System.out.println(name + progresie + " este o progresie");
        }}
      else {
          synchronized (this){
              System.out.println(name + progresie + " nu este o progresie");
          }
        }
    }
}


package lab7;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players = new ArrayList<Player>();

    //getter board + player
    public Board getBoard() {
        return board;
    }
    public List<Player> getPlayers() {
        return players;
    }
    //constructor
    public Game(Board board) {
        this.board = board;
    }
    public Game(){
        this.board=null;
        this.players=null;
    }
    //play
    public void play(){
        for(Player p : players){
            new Thread(p).start();
        }
    }
    //adaugare player in joc
    public void addPlayer(Player player){
        players.add(player);
    }
}

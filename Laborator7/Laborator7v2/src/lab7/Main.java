package lab7;

public class Main {

    public static void main(String[] args) {
        Board board=new Board(10);
        Game game=new Game(board);
        for(int i=1;i<8;i++){
            Token token=new Token(i);
            board.addTokens(token);
        }
        Player player1= new Player("Razvan", game);
        Player player2=new Player("Cazacu",game);
        game.addPlayer(player1);
        game.addPlayer(player2);

        game.play();
    }
}

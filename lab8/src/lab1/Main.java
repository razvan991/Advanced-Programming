package lab1;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            MusicAlbums createtable = new MusicAlbums();
            createtable.createArtistAlbumsTable();
            ArtistController artists = new ArtistController();
            AlbumController albums = new AlbumController();
            //adaug artisti
            artists.create("Gigel", "Romania");
            artists.create("Popescu", "America");
            //caut artisti dupa nume
            int gigelId = artists.findByName("Gigel");
            int popescuId = artists.findByName("Popescu");
            //adaug albume
            albums.create( gigelId, "Mfas", 1974);
            albums.create( popescuId,"fsadq", 2007);
            //afisez albume
            albums.list(popescuId);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}

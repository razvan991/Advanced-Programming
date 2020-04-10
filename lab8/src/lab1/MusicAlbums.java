package lab1;

import java.sql.*;
//CREEZ TABELELE ARTISTS SI ALBUMS
public class MusicAlbums {
    public void createArtistAlbumsTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Database.getConnection();
            String stmt="CREATE TABLE IF NOT EXISTS artists (id int primary key unique auto_increment, name varchar(100) not null, country varchar(100))";
            String stmt2="CREATE TABLE IF NOT EXISTS albums (id int primary key unique auto_increment, name varchar(100) not null, artist_id int not null references artists on delete restrict, release_year int)";
            PreparedStatement stmtp=connection.prepareStatement(stmt);
            PreparedStatement stmtp2=connection.prepareStatement(stmt2);
            ResultSet rs=stmtp.executeQuery();
            ResultSet rs2=stmtp2.executeQuery();
            } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

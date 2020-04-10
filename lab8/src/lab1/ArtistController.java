package lab1;

import java.sql.*;

public class ArtistController {
    //INSERT in artists
    public void create(String name, String country) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into artists (name, country) values (?, ?)")) {
            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.executeUpdate();
        }
    }
    //Cautare dupa nume
    public int findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.getResultSet()) {
            stmt.executeQuery("select id from artists where name='" + name + "'");
            return rs.next() ? rs.getInt(1) : null;
        }
    }
}

package lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Conexiunea cu db
public class Database {
    private static Database instance;
    private static Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/musicalbums?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "";

        private Database() throws SQLException {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                this.connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException ex) {
                System.out.println("Database Connection Creation Failed : " + ex.getMessage());
            }
        }
        public static Connection getConnection() {
            return connection;
        }
        public static Database getInstance() throws SQLException {
            if (instance == null) {
                instance = new Database();
            } else if (instance.getConnection().isClosed()) {
                instance = new Database();
            }
            return instance;
        }
    }

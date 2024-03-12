import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static String URL = "jdbc:mysql://localhost:3306/produkty";
    private static String user = "root";
    private static String password = "kacper";
    public static void conn(){

            try {
                java.sql.Connection con = DriverManager.getConnection(URL, user, password );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

}
    }

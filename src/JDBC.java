import java.sql.*;

public class JDBC {
    private static String URL = "jdbc:mysql://localhost:3306/user1";
    private static String user = "root";
    private static String password = "kacper";
    private static Connection conn;
    private static Statement stmt;
    private static String query;
    private static ResultSet rS;

    public static ResultSet getrS() {
        return rS;
    }

    public static void conn(){

            try {
                conn = DriverManager.getConnection(URL, user, password );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

     public static Statement createStmt(){
         try {
             Statement stmt = conn.createStatement();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         return stmt;
     }
    public static ResultSet createRS(String query){
       String query2 = "";
        query2 = query;
        try {
            rS = stmt.executeQuery(query2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rS;
     }
    }

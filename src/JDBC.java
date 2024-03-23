import java.sql.*;

public class JDBC {
    private  String URL = "jdbc:mysql://localhost:3306/produkty";
    private  String user = "root";
    private  String password = "kacper";
    private  Connection conn;
    private  Statement stmt;
    private String query;
    private ResultSet rS;

    public  void conn(){

            try {
                conn = DriverManager.getConnection(URL, user, password );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

     public  void createStmt(){
         try {
             Statement stmt = conn.createStatement();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }
    public ResultSet createRS(String query){
        this.query = query;
        try {
            rS = stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rS;
     }
    }

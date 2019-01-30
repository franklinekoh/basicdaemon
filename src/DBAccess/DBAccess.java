/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author FRANK
 */
public class DBAccess {
    
   public static Connection connectDB (){
       
       Connection connect = null;
                try{
                    
 Class.forName("com.mysql.jdbc.Driver");
         connect = DriverManager.getConnection("jdbc:mysql://localhost/cellulant_db", "root", "");

    System.out.println("Database connected successfully");
    
   }
                
   catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
                return connect;
   }
   
//   returns the id of unprocessed data in the database
   public void updateUnprocessed(Connection connect){
       
       String updateString = "UPDATE users SET status = 11 WHERE status = 7";
      
       PreparedStatement query = null;
       try{
//           connect.prepareStatement(updateString);
            Statement stmt = connect.createStatement();
          stmt.execute(updateString);
       }catch(SQLException ex){
           
           System.out.println("SQL Exception: " + ex);
       }catch(NullPointerException ex){
            System.out.println("Null Pointer Exception: " + ex);
       }
   }
   
//   get number of unprocessed
    public static int unProcessed(Connection connect) {

        String getString = "SELECT COUNT(status) AS status FROM users WHERE status = 7";

        ResultSet rs ;
        int count = 0;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(getString);
            while (rs.next()) {
                count = rs.getInt("status");
            }
            System.out.println("number of unprocessed data is " + count);
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex);
        }

        return count;
    }
   
}

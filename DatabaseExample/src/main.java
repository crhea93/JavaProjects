import java.sql.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args)
    {


      System.out.println("Loading driver...");
      try {

          ArrayList<String> Credentials;
          String user = new String();
          String password = new String();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded!");
          try {
              // Just read in credentials for database from file
              Credentials = readCredentials.readCredentials(args[0]);
              //Convert to nice list
              user = Credentials.get(2);
              password = Credentials.get(5);
          } catch (Exception e) {
              e.printStackTrace();
          }
          System.out.println("Connecting to Table...");
        Connection conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost/testDB", user, password);


        insert.insert(conn);
        //Snag table data
        ArrayList<String> user_list = select.select(conn, "users");

        for (int i=0;i<1;i++){
            System.out.println(user_list.get(i));
            delete.delete(conn,i);
        }
        conn.close();




      } catch (ClassNotFoundException e) {
        throw new IllegalStateException("Cannot find the driver in the classpath!", e);
      } catch (SQLException e) {
          e.printStackTrace();
      }





    }
  }


import java.sql.*;
import java.util.*;

public class select {
    public static ArrayList<String> select(Connection conn, String table_name){
        ArrayList<String> user_list = new ArrayList<>();

        String query = "SELECT * FROM "+table_name;

        // create the java statement
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // execute the query, and get a java resultset
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                user_list.add(String.valueOf(id)+" "+name+" "+email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return user_list;
    }
}

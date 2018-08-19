import java.sql.*;

public class insert {
    public static void insert(Connection conn){
        String query = " insert into users (id, name, email)" + " values (1,'carter rhea','carter.rhea@umontreal.ca')";
        try (PreparedStatement preparedStmt = conn.prepareStatement(query)) {
            preparedStmt.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

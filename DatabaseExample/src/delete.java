import java.sql.*;

public class delete {
    public static void delete(Connection conn, int id_to_change){
        String query = " delete from users where id = " + Integer.toString(id_to_change);
        try (PreparedStatement preparedStmt = conn.prepareStatement(query)) {
            preparedStmt.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

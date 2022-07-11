package testing;

import org.postgresql.util.PSQLException;

import java.sql.*;

public class DBProccesor {
    private static String urlAddress = "jdbc:postgresql://localhost:5432/client_db";
    private static String name = "postgres";
    private static String password = "root";
    public static boolean check(String loginParam, String passwordParam) throws ClassNotFoundException, SQLException {
        try{
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            throw e;
        }
        Connection conn = null;
        try{
            boolean marker;
            conn = DriverManager.getConnection(urlAddress, name, password);
            String sql = "SELECT login FROM client_info WHERE login = ?  AND client_password = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, loginParam);
            stmt.setString(2, passwordParam);
            ResultSet rs = stmt.executeQuery();
            conn.close();
            if (rs.getFetchSize() != 0){
                marker = true;
            }
            else {
                marker = false;
            }
            return marker;
        }
        catch (SQLException e) {
            throw e;
        }
        finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
            return false;
        }

    }
    public static void insert(String loginParam, String passwordParam) throws SQLException, ClassNotFoundException {
        try{
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            throw e;
        }
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(urlAddress, name, password);
            String sql = "INSERT INTO client_info (login, client_password) VALUES ( ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, loginParam);
            stmt.setString(2, passwordParam);
            stmt.executeUpdate();
        }
        catch (PSQLException e){
            throw e;
        }
        catch (SQLException e) {
            throw e;
        }
        finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
        }

    }
}
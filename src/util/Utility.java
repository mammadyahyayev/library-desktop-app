package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utility {

    public static void close(Connection c, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (c != null) {
            c.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (rs != null) {
            rs.close();
        }
    }
    
      public static void close(Connection c, CallableStatement ps, ResultSet rs) throws SQLException {
        if (c != null) {
            c.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (rs != null) {
            rs.close();
        }
    }
}

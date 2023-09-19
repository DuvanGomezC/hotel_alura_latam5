package seguridad;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author duvan gomez 
 */

public class ConexionBD {
    private static ComboPooledDataSource comboPooledDataSource;
    
    static {
        comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?createDatabaseIfNotExist=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("arcadeE2004$");
        // Configura otros parámetros del pool si es necesario
    }

    public static Connection obtenerConexion() {
        try {
            return comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la conexión desde el pool.");
        }
    }

    public static void cerrarRecursos(Connection conn, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

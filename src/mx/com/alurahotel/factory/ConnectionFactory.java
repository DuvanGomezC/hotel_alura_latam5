package mx.com.alurahotel.factory;

import java.sql.Connection;
import seguridad.ConexionBD;

/**
 * @author duvan gomez 
 */

public class ConnectionFactory {
    
    public static Connection realizarConexion() {
        return ConexionBD.obtenerConexion();
    }

    public void cerrarConexion(Connection conn) {
        ConexionBD.cerrarRecursos(conn, null, null);
    }
}

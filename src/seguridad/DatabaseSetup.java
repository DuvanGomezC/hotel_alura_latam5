package seguridad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author duvan gomez 
 */

public class DatabaseSetup {

	public static void createTables() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = ConexionBD.obtenerConexion();
			statement = connection.createStatement();

			// Crear la tabla 'reservas' si no existe
			String createReservasTableSQL = "CREATE TABLE IF NOT EXISTS reservas (" + "id_reserva VARCHAR(36) NOT NULL,"
					+ "fecha_entrada DATE NOT NULL," + "fecha_salida DATE NOT NULL," + "valor DECIMAL(9,2) NOT NULL,"
					+ "forma_pago VARCHAR(20) NOT NULL," + "PRIMARY KEY (id_reserva)" + ")";
			statement.executeUpdate(createReservasTableSQL);

			// Crear la tabla 'huespedes' si no existe
			String createHuespedesTableSQL = "CREATE TABLE IF NOT EXISTS huespedes ("
					+ "id_huesped INT NOT NULL AUTO_INCREMENT," + "nombre VARCHAR(25) NOT NULL,"
					+ "apellido VARCHAR(25) NOT NULL," + "fecha_nacimiento DATE NOT NULL,"
					+ "nacionalidad VARCHAR(35) NOT NULL," + "telefono VARCHAR(30) NOT NULL,"
					+ "id_reserva VARCHAR(36) DEFAULT NULL," + "PRIMARY KEY (id_huesped),"
					+ "KEY id_reserva (id_reserva),"
					+ "CONSTRAINT huespedes_ibfk_1 FOREIGN KEY (id_reserva) REFERENCES reservas (id_reserva)" + ")";
			statement.executeUpdate(createHuespedesTableSQL);

			// Verificar si la tabla 'usuarios' existe
			resultSet = connection.getMetaData().getTables(null, null, "usuarios", null);

			// La tabla 'usuarios' no existe, créala
			String createUsuariosTableSQL = "CREATE TABLE IF NOT EXISTS usuarios ("
					+ "id_usuario INT NOT NULL AUTO_INCREMENT," + "nombre_usuario VARCHAR(25) NOT NULL,"
					+ "categoria_usuario VARCHAR(25) NOT NULL," + "password VARCHAR(30) NOT NULL,"
					+ "PRIMARY KEY (id_usuario)" + ")";
			statement.executeUpdate(createUsuariosTableSQL);

			// Verificar si existe un usuario con categoría "Gerente"
			String checkAdminUserSQL = "SELECT COUNT(*) FROM usuarios WHERE categoria_usuario = 'Gerente'";
			resultSet = statement.executeQuery(checkAdminUserSQL);
			resultSet.next(); // Mover el cursor al primer resultado

			int adminUserCount = resultSet.getInt(1);

			// Si no existe un usuario con categoría "Gerente", crea el usuario 'admin'
			if (adminUserCount == 0) {
				String createAdminUserSQL = "INSERT INTO usuarios (nombre_usuario, categoria_usuario, password) VALUES ('admin', 'Gerente', 'admin')";
				statement.executeUpdate(createAdminUserSQL);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexionBD.cerrarRecursos(connection, statement, null);
		}
	}

}

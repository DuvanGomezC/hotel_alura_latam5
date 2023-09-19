
package mx.com.alurahotel.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import mx.com.alurahotel.dao.UsuarioDAO;
import mx.com.alurahotel.factory.ConnectionFactory;
import mx.com.alurahotel.modelo.Usuario;

/**
 * @author duvan gomez 
 */

public class UsuarioController {

	private final UsuarioDAO usuarioDAO;
	
	public boolean existeUsuario(String nombreUsuario, String categoriaUsuario) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establecer la conexión a la base de datos (ajusta la URL, usuario y contraseña)
            connection =  ConnectionFactory.realizarConexion();

            // Consulta SQL para verificar la existencia del usuario
            String sql = "SELECT COUNT(*) FROM usuarios WHERE nombre_usuario = ? AND categoria_usuario = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombreUsuario);
            preparedStatement.setString(2, categoriaUsuario);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                // Si el recuento es mayor a 0, el usuario existe
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos (ResultSet, PreparedStatement y Connection) en el orden inverso de apertura
            // Maneja las excepciones adecuadamente en una aplicación real
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false; // En caso de error o si no se encuentra el usuario
    }

	public UsuarioController() {
		this.usuarioDAO = new UsuarioDAO(new ConnectionFactory().realizarConexion());
	}

	public List<Usuario> listar() {
		return usuarioDAO.listar();
	}

	public List<Usuario> listar(String categoriaUsuario) {
		return usuarioDAO.listar(categoriaUsuario);
	}

	public List<Usuario> listar(String nombreUsuario, String password) {
		return usuarioDAO.listar(nombreUsuario, password);
	}

	public void guardar(Usuario usuario) {
		usuarioDAO.guardar(usuario);
	}

	public int actualizar(Integer idUsuario, String nombreUsuario, String categoriaUsuario, String password) {
		return usuarioDAO.actualizar(idUsuario, nombreUsuario, categoriaUsuario, password);
	}

	public int eliminar(Integer IdUsuario) {
		return usuarioDAO.eliminar(IdUsuario);
	}
}


package mx.com.alurahotel.modelo;

import seguridad.DatabaseSetup;

/**
 * @author duvan gomez 
 */

public class Usuario {

	static {
		DatabaseSetup.createTables();
	}

	private int idUsuario;
	private String nombreUsuario;
	private String categoriaUsuario;
	private String password;

	public Usuario(int idUsuario, String nombreUsuario, String categoriaUsuario) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.categoriaUsuario = categoriaUsuario;
	}

	public Usuario(String nombreUsuario, String categoriaUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		this.categoriaUsuario = categoriaUsuario;
		this.password = password;
	}

	public Usuario(String nombreUsuario, String categoriaUsuario) {
		this.nombreUsuario = nombreUsuario;
		this.categoriaUsuario = categoriaUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCategoriaUsuario() {
		return categoriaUsuario;
	}

	public void setCategoriaUsuario(String categoriaUsuario) {
		this.categoriaUsuario = categoriaUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("{ID Usuario: %d, Nombre Usuario: %s, Categoria Usuario: %s}", this.idUsuario,
				this.nombreUsuario, this.categoriaUsuario);
	}

}

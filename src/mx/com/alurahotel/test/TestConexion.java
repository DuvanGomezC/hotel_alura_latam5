package mx.com.alurahotel.test;

import java.sql.Connection;
import java.sql.SQLException;

import mx.com.alurahotel.factory.ConnectionFactory;

public class TestConexion {

/**
 * @author duvan gomez 
 */

	public static void main(String[] args) {
		try (Connection c = new ConnectionFactory().realizarConexion();) {
			System.out.println(c);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

}

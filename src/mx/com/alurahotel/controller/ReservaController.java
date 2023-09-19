
package mx.com.alurahotel.controller;

import java.sql.Date;
import java.util.List;

import mx.com.alurahotel.dao.ReservaDAO;
import mx.com.alurahotel.factory.ConnectionFactory;
import mx.com.alurahotel.modelo.Reserva;

/**
 * @author duvan gomez 
 */

public class ReservaController {

	private final ReservaDAO reservaDAO;

	public ReservaController() {
		this.reservaDAO = new ReservaDAO(new ConnectionFactory().realizarConexion());
	}

	public List<Reserva> listar() {
		return reservaDAO.listar();
	}

	public List<Reserva> listar(String idReserva) {
		return reservaDAO.listar(idReserva);
	}

	public void guardar(Reserva reserva) {
		reservaDAO.guardar(reserva);
	}

	public int actualizar(String idReserva, Date fechaEntrada, Date fechaSalida, double valorReserva,
			String formaPago) {
		return reservaDAO.actualizar(idReserva, fechaEntrada, fechaSalida, valorReserva, formaPago);
	}
}

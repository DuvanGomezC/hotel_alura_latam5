
package mx.com.alurahotel.view;

import com.toedter.calendar.JDateChooser;

import java.awt.Component;
import mx.com.alurahotel.util.ColoresComponentesUtil;
import java.awt.Image;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import mx.com.alurahotel.controller.HuespedController;
import mx.com.alurahotel.controller.ReservaController;
import mx.com.alurahotel.controller.UsuarioController;
import mx.com.alurahotel.modelo.Huesped;
import mx.com.alurahotel.modelo.Reserva;
import mx.com.alurahotel.util.ConvertirFecha;
import mx.com.alurahotel.util.ListarNacionalidadesUtil;
import mx.com.alurahotel.util.ValidarFormulariosUtil;
import seguridad.DatabaseSetup;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mx.com.alurahotel.modelo.Usuario;
import javax.swing.JOptionPane;

/**
 * @author duvan gomez 
 */

public class Busqueda extends javax.swing.JFrame {

	int xMouse;
	int yMouse;
	private static final Login login = new Login();
	private long diasTranscurridos;
	private final int margenColumna = 2;
	private DefaultTableModel modeloTablaHuespedes;
	private DefaultTableModel modeloTablaReservas;
	private DefaultTableModel modeloTablaUsuarios;
	private final HuespedController huespedController;
	private final ReservaController reservaController;
	private final UsuarioController usuarioController;

	static {
		DatabaseSetup.createTables();
	}

	public Busqueda() {
		initComponents();
		this.huespedController = new HuespedController();
		this.reservaController = new ReservaController();
		this.usuarioController = new UsuarioController();
		configurarEstiloComponentes();
	}

	private void configurarEstiloComponentes() {
		setBackground(ColoresComponentesUtil.TRANSPARENTE);
		btnCerrar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnBuscar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnActualizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnEliminar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnCancelar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnMenuUsuario.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnAyudaHuespedes.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnAyudaReservas.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		cargarTablaHuespedes();
		configurarAnchoColumnasTabla(tablaHuespedes, margenColumna);
		cargarTablaReservas();
		configurarAnchoColumnasTabla(tablaReservas, margenColumna);
		cargarTablaUsuarios();
		configurarAnchoColumnasTabla(tablaUsuarios, margenColumna);
		seleccionNacionalidad.setModel(new DefaultComboBoxModel<>(ListarNacionalidadesUtil.filtrarNacionalidades()));
		alternarVisualizacionCamposTablas();
		mostrarElementosHuesped();
		ocultarElementosUsuario();
		esGerente(); // Llama a la función esGerente() para verificar la categoría del usuario
		alternarVisualizacionMenu();

	}

	private void mostrarElementosHuesped() {
		jLabelInstrucionesHuesped.setVisible(true);
		seleccionNacionalidad.setVisible(true);
		fechaNacimiento.setVisible(true);
		btnEliminar.setVisible(true);
		jLabelPorApellido.setVisible(true);
		btnAyudaHuespedes.setVisible(true);
		alternarEdicionCamposHuespedes();
	}

	private void ocultarElementosHuesped() {
		jLabelInstrucionesHuesped.setVisible(false);
		seleccionNacionalidad.setVisible(false);
		fechaNacimiento.setVisible(false);
		btnEliminar.setVisible(false);
		jLabelPorApellido.setVisible(false);
		btnAyudaHuespedes.setVisible(false);
	}

	private void mostrarElementosReserva() {
		jLabelInstrucionesReserva.setVisible(true);
		fechaCheckIn.setVisible(true);
		fechaCheckOut.setVisible(true);
		seleccionFormaPago.setVisible(true);
		jLabelPorIdReserva.setVisible(true);
		btnAyudaReservas.setVisible(true);
		alternarEdicionCamposReservas();
	}

	private void ocultarElementosReserva() {
		jLabelInstrucionesReserva.setVisible(false);
		fechaCheckIn.setVisible(false);
		fechaCheckOut.setVisible(false);
		seleccionFormaPago.setVisible(false);
		jLabelPorIdReserva.setVisible(false);
		btnAyudaReservas.setVisible(false);
	}

	private void mostrarElementosUsuario() {
		tablaUsuarios.setEnabled(true);
		jLabelPorCategoriaUsuario.setVisible(true);
		jLabelCategoria.setVisible(true);
		seleccionCategoriaUsuario.setVisible(true);
		jLabelPassword.setVisible(true);
		campoPassword.setVisible(true);
		btnEliminar.setVisible(true);
		alternarEdicionCamposUsuario();
	}

	private void mostrarOpcionesGerente() {
		tablaUsuarios.setEnabled(true);
		jLabelPorCategoriaUsuario.setVisible(true);
		jLabelCategoria.setVisible(true);
		seleccionCategoriaUsuario.setVisible(true);
		jLabelPassword.setVisible(true);
		campoPassword.setVisible(true);
		btnEliminar.setVisible(true);
		alternarEdicionCamposUsuario();
	}

	private void mostrarOpcionesRecepcionista() {
		tablaUsuarios.setEnabled(true);
		jLabelPorCategoriaUsuario.setVisible(true);
		jLabelCategoria.setVisible(true);
		seleccionCategoriaUsuario.setVisible(true);
		jLabelPassword.setVisible(true);
		campoPassword.setVisible(true);
		btnActualizar.setVisible(true);
		btnEliminar.setVisible(false);
		btnCancelar.setVisible(true);
		alternarEdicionCamposUsuario();
	}

	private void ocultarElementosUsuario() {
		tablaUsuarios.setEnabled(true);
		jLabelPorCategoriaUsuario.setVisible(false);
		jLabelCategoria.setVisible(false);
		seleccionCategoriaUsuario.setVisible(false);
		jLabelPassword.setVisible(false);
		campoPassword.setVisible(false);
	}

	private void alternarVisualizacionCamposTablas() {
		if (tablaHuespedes.isShowing()) {
			mostrarElementosHuesped();
			ocultarElementosReserva();
			ocultarElementosUsuario();
		} else if (tablaReservas.isShowing()) {
			ocultarElementosHuesped();
			mostrarElementosReserva();
			ocultarElementosUsuario();
		} else {
			ocultarElementosHuesped();
			ocultarElementosReserva();
			if (MenuUsuario.esGerente()) {
				mostrarOpcionesGerente();
			} else {
				mostrarOpcionesRecepcionista();
			}
		}
	}

	private void alternarEdicionCamposReservas() {
		if (fechaCheckIn.getDate() == null && fechaCheckOut.getDate() == null) {
			fechaCheckIn.setEnabled(false);
			fechaCheckOut.setEnabled(false);
			seleccionFormaPago.setEnabled(false);
		} else {
			fechaCheckIn.setEnabled(true);
			fechaCheckOut.setEnabled(true);
			seleccionFormaPago.setEnabled(true);
		}
	}

	private void alternarEdicionCamposHuespedes() {
		if (fechaNacimiento.getDate() == null && seleccionNacionalidad.getSelectedIndex() == 0) {
			fechaNacimiento.setEnabled(false);
			seleccionNacionalidad.setEnabled(false);
		} else {
			fechaNacimiento.setEnabled(true);
			seleccionNacionalidad.setEnabled(true);
		}
	}

	private void alternarEdicionCamposUsuario() {
		if (seleccionCategoriaUsuario.getSelectedIndex() == 0) {
			seleccionCategoriaUsuario.setEnabled(false);
			campoPassword.setEnabled(false);
		} else {
			seleccionCategoriaUsuario.setEnabled(true);
			seleccionCategoriaUsuario.setEnabled(true);
			campoPassword.setEnabled(true);
		}
	}

	private void limpiarTablaRegistroHuespedes() {
		modeloTablaHuespedes.getDataVector().clear();
		tablaHuespedes.clearSelection();
	}

	private void limpiarTablaRegistroReservas() {
		modeloTablaReservas.getDataVector().clear();
		tablaReservas.clearSelection();
	}

	private void limpiarTablaRegistroUsuarios() {
		modeloTablaUsuarios.getDataVector().clear();
		tablaUsuarios.clearSelection();
	}

	private void configurarAnchoColumnasTabla(JTable tabla, int margen) {
		for (int indiceColumna = 0; indiceColumna < tabla.getColumnCount(); indiceColumna++) {
			ajustarAnchoColumnas(tabla, indiceColumna, margen);
		}
	}

	private void ajustarAnchoColumnas(JTable tabla, int indiceColumna, int margenColumna) {
		DefaultTableColumnModel colModel = (DefaultTableColumnModel) tabla.getColumnModel();
		TableColumn col = colModel.getColumn(indiceColumna);
		int ancho;
		TableCellRenderer renderer = col.getHeaderRenderer();
		if (renderer == null) {
			renderer = tabla.getTableHeader().getDefaultRenderer();
		}
		Component component = renderer.getTableCellRendererComponent(tabla, col.getHeaderValue(), false, false, 0, 0);
		ancho = component.getPreferredSize().width;
		for (int fila = 0; fila < tabla.getRowCount(); fila++) {
			renderer = tabla.getCellRenderer(fila, indiceColumna);
			component = renderer.getTableCellRendererComponent(tabla, tabla.getValueAt(fila, indiceColumna), false,
					false, fila, indiceColumna);
			ancho = Math.max(ancho, component.getPreferredSize().width);
		}
		ancho += 2 * margenColumna;
		col.setPreferredWidth(ancho);
	}

	private void cargarTablaHuespedes() {
		modeloTablaHuespedes = (DefaultTableModel) tablaHuespedes.getModel();
		List<Huesped> listaHuespedes = this.huespedController.listar();
		listaHuespedes.forEach((huesped) -> {
			modeloTablaHuespedes.addRow(new Object[] { huesped.getIdHuesped(), huesped.getNombre(),
					huesped.getApellido(), huesped.getFechaNacimiento(), huesped.getNacionalidad(),
					huesped.getTelefono(), huesped.getIdReserva() });
		});
	}

	private void cargarTablaHuespedes(JTextField campoBusqueda) {
		modeloTablaHuespedes = (DefaultTableModel) tablaHuespedes.getModel();
		String apellido = campoBusqueda.getText();
		List<Huesped> listaHuespedes = this.huespedController.listar(apellido);
		listaHuespedes.forEach((huesped) -> {
			modeloTablaHuespedes.addRow(new Object[] { huesped.getIdHuesped(), huesped.getNombre(),
					huesped.getApellido(), huesped.getFechaNacimiento(), huesped.getNacionalidad(),
					huesped.getTelefono(), huesped.getIdReserva() });
		});
	}

	private void actualizarRegistroHuesped() {
		int fila = tablaHuespedes.getSelectedRow();
		if (fila < 0) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
		} else {
			Integer idHuesped = Integer.valueOf(tablaHuespedes.getValueAt(fila, 0).toString());
			String nombre = String.valueOf(tablaHuespedes.getValueAt(fila, 1));
			String apellido = String.valueOf(tablaHuespedes.getValueAt(fila, 2));
			Date fechaNac = Date.valueOf(tablaHuespedes.getValueAt(fila, 3).toString());
			String nacionalidad = String.valueOf(tablaHuespedes.getValueAt(fila, 4));
			String telefono = String.valueOf(tablaHuespedes.getValueAt(fila, 5));
			if (ValidarFormulariosUtil.esFormularioHuespedValido(nombre, apellido, fechaNacimiento, telefono)) {
				Optional.ofNullable(modeloTablaHuespedes.getValueAt(tablaHuespedes.getSelectedRow(),
						tablaHuespedes.getSelectedColumn())).ifPresent(row -> {
							int lineasActualizadas;
							lineasActualizadas = this.huespedController.actualizar(idHuesped, nombre, apellido,
									fechaNac, nacionalidad, telefono);
							JOptionPane.showMessageDialog(null,
									lineasActualizadas + " " + "registro actualizado éxitosamente.",
									"Actualización éxitosa.", JOptionPane.INFORMATION_MESSAGE);
						});
			}
		}
	}

	private void cancelarActualizacionRegistroHuespedes(java.awt.event.MouseEvent evt) {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(this,
				"¿Desea cancelar la actualización de registro actual?\n"
						+ "Los cambios efectuados en la tabla se reestablerecán.",
				"Confirmar cancelación de actualización de registro.", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			evt.consume();
			limpiarTablaRegistroHuespedes();
			cargarTablaHuespedes();
			configurarAnchoColumnasTabla(tablaHuespedes, margenColumna);
		}
	}

	private void eliminarRegistroHuesped() {
		int fila = tablaHuespedes.getSelectedRow();
		if (fila < 0) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
		} else {
			Optional.ofNullable(modeloTablaHuespedes.getValueAt(tablaHuespedes.getSelectedRow(),
					tablaHuespedes.getSelectedColumn())).ifPresent(row -> {
						Integer idHuesped = Integer.valueOf(tablaHuespedes.getValueAt(fila, 0).toString());
						String idReserva = String.valueOf(tablaHuespedes.getValueAt(fila, 6));
						int cantidadEliminada;
						cantidadEliminada = this.huespedController.eliminar(idHuesped, idReserva);
						JOptionPane.showMessageDialog(null,
								cantidadEliminada + " " + "registro eliminado éxitosamente.",
								"Eliminación de registro éxitosa.", JOptionPane.INFORMATION_MESSAGE);
					});
		}
	}

	private void confirmarEliminacionRegistroHuesped(java.awt.event.MouseEvent evt) {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(this,
				"¿Realmente desea eliminar el registro?\n" + "El registro será eliminado definitivamente.",
				"Confirmar eliminación de registro.", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
				opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			evt.consume();
			reestablecerCampos();
			eliminarRegistroHuesped();
			limpiarTablaRegistroHuespedes();
			limpiarTablaRegistroReservas();
			cargarTablaHuespedes();
			cargarTablaReservas();
			configurarAnchoColumnasTabla(tablaHuespedes, margenColumna);
		}
	}

	private void modificarFechaNacimientoEnTablaHuespedes() {
		if (fechaNacimiento.getDate() != null) {
			Date fechaa = Date.valueOf(ConvertirFecha.convertirDateALocalDate(fechaNacimiento.getDate()));
			tablaHuespedes.setValueAt(fechaa, tablaHuespedes.getSelectedRow(), 3);
		}
	}

	private void modificarNacionalidadEnTablaHuespedes() {
		int fila = tablaHuespedes.getSelectedRow();
		String seleccion = seleccionNacionalidad.getSelectedItem().toString();
		if (tablaHuespedes.isRowSelected(fila)) {
			tablaHuespedes.setValueAt(seleccion, tablaHuespedes.getSelectedRow(), 4);
		}
	}

	private void cargarTablaReservas() {
		modeloTablaReservas = (DefaultTableModel) tablaReservas.getModel();
		List<Reserva> listaReservas = this.reservaController.listar();
		listaReservas.forEach((reserva) -> {
			modeloTablaReservas.addRow(new Object[] { reserva.getId_Reserva(), reserva.getFechaEntrada(),
					reserva.getFechaSalida(), reserva.getValorReserva(), reserva.getFormaPago() });
		});
	}

	private void cargarTablaReservas(JTextField campoBusqueda) {
		modeloTablaReservas = (DefaultTableModel) tablaReservas.getModel();
		String idReserva = campoBusqueda.getText();
		List<Reserva> listaReservas = this.reservaController.listar(idReserva);
		listaReservas.forEach((reserva) -> {
			modeloTablaReservas.addRow(new Object[] { reserva.getId_Reserva(), reserva.getFechaEntrada(),
					reserva.getFechaSalida(), reserva.getValorReserva(), reserva.getFormaPago() });
		});
	}

	private void actualizarRegistroReserva() {
		int fila = tablaReservas.getSelectedRow();
		if (fila < 0) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
		} else {
			String idReserva = String.valueOf(tablaReservas.getValueAt(fila, 0));
			Date fechaEntrada = Date.valueOf(tablaReservas.getValueAt(fila, 1).toString());
			Date fechaSalida = Date.valueOf(tablaReservas.getValueAt(fila, 2).toString());
			String valorReservaStringTabla = String.valueOf(tablaReservas.getValueAt(fila, 3));
			double valorReservaToDouble = Double.parseDouble(valorReservaStringTabla);
			String seleccionPago = String.valueOf(tablaReservas.getValueAt(fila, 4));
			if (ValidarFormulariosUtil.esFormularioReservaValido(fechaCheckIn, fechaCheckOut, valorReservaStringTabla,
					seleccionFormaPago)) {
				Optional.ofNullable(modeloTablaReservas.getValueAt(tablaReservas.getSelectedRow(),
						tablaReservas.getSelectedColumn())).ifPresent(row -> {
							int lineasActualizadas;
							lineasActualizadas = this.reservaController.actualizar(idReserva, fechaEntrada, fechaSalida,
									valorReservaToDouble, seleccionPago);
							JOptionPane.showMessageDialog(null,
									lineasActualizadas + " " + "registro actualizado éxitosamente.",
									"Actualización éxitosa.", JOptionPane.INFORMATION_MESSAGE);
						});
			}
		}
	}

	private void cancelarActualizacionRegistroReservas(java.awt.event.MouseEvent evt) {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(this,
				"¿Desea cancelar la actualización de registro actual?\n"
						+ "Los cambios efectuados en la tabla se reestablerecán.",
				"Confirmar cancelación de actualización de registro.", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			evt.consume();
			limpiarTablaRegistroReservas();
			cargarTablaReservas();
			configurarAnchoColumnasTabla(tablaReservas, margenColumna);
		}
	}

	private long calcularDiasTranscurridos(JDateChooser fechaEntrada, JDateChooser fechaSalida) {
		LocalDate fechDate = ConvertirFecha.convertirDateALocalDate(fechaEntrada.getDate());
		LocalDate date = ConvertirFecha.convertirDateALocalDate(fechaSalida.getDate());
		return diasTranscurridos = ChronoUnit.DAYS.between(fechDate, date);
	}

	private void calcularValorReservas() {
		BigDecimal valorTasaReservaPorDia = new BigDecimal("80000.00");
		BigDecimal valorReserva = new BigDecimal("0.0");
		calcularDiasTranscurridos(fechaCheckIn, fechaCheckOut);
		if (diasTranscurridos > 0) {
			BigDecimal diasReservados = new BigDecimal(diasTranscurridos);
			valorReserva = diasReservados.multiply(valorTasaReservaPorDia);
			tablaReservas.setValueAt(valorReserva, tablaReservas.getSelectedRow(), 3);
		} else {
			ValidarFormulariosUtil.desplegarMensajeError("Error en el cálculo de la Reserva.",
					"No es posible cálcular reservas si la" + " fecha de Check-Out es menor o igual a la fecha de \n"
							+ " Check-In, ya que el cálculo se realiza por días.");
			tablaReservas.setValueAt(valorReserva, tablaReservas.getSelectedRow(), 3);
		}
	}

	private void modificarFechaEntradaEnTablaReservas() {
		Date fechaEntrada = Date.valueOf(ConvertirFecha.convertirDateALocalDate(fechaCheckIn.getDate()));
		tablaReservas.setValueAt(fechaEntrada, tablaReservas.getSelectedRow(), 1);
	}

	private void modificarFechaSalidaEnTablaReservas() {
		Date fechaSalida = Date.valueOf(ConvertirFecha.convertirDateALocalDate(fechaCheckOut.getDate()));
		tablaReservas.setValueAt(fechaSalida, tablaReservas.getSelectedRow(), 2);
	}

	private void modificarSeleccionFormaPagoEnTablaReservas() {
		String seleccion = seleccionFormaPago.getSelectedItem().toString();
		int fila = tablaReservas.getSelectedRow();
		if (tablaReservas.isRowSelected(fila)) {
			tablaReservas.setValueAt(seleccion, tablaReservas.getSelectedRow(), 4);
		}
	}

	private void cargarTablaUsuarios() {
		modeloTablaUsuarios = (DefaultTableModel) tablaUsuarios.getModel();
		List<Usuario> listaUsuarios = this.usuarioController.listar();
		listaUsuarios.forEach((usuario) -> {
			modeloTablaUsuarios.addRow(
					new Object[] { usuario.getIdUsuario(), usuario.getNombreUsuario(), usuario.getCategoriaUsuario() });
		});
	}

	private void cargarTablaUsuarios(JTextField campoBusqueda) {
		modeloTablaUsuarios = (DefaultTableModel) tablaUsuarios.getModel();
		String categoriaUsuario = campoBusqueda.getText();
		List<Usuario> listaUsuarios = this.usuarioController.listar(categoriaUsuario);
		listaUsuarios.forEach((usuario) -> {
			modeloTablaUsuarios.addRow(
					new Object[] { usuario.getIdUsuario(), usuario.getNombreUsuario(), usuario.getCategoriaUsuario() });
		});
	}

	private void actualizarRegistroUsuario() {
		int fila = tablaUsuarios.getSelectedRow();
		if (fila < 0) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
		} else {
			Integer idUsuario = Integer.valueOf(tablaUsuarios.getValueAt(fila, 0).toString());
			String nombreUsuario = String.valueOf(tablaUsuarios.getValueAt(fila, 1));
			String categoriaUsuario = String.valueOf(tablaUsuarios.getValueAt(fila, 2));
			String password = String.valueOf(campoPassword.getPassword());
			if (ValidarFormulariosUtil.esFormularioUsuarioValido(nombreUsuario, seleccionCategoriaUsuario,
					campoPassword)) {
				Optional.ofNullable(modeloTablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),
						tablaUsuarios.getSelectedColumn())).ifPresent(row -> {
							int lineasActualizadas;
							lineasActualizadas = this.usuarioController.actualizar(idUsuario, nombreUsuario,
									categoriaUsuario, password);
							JOptionPane.showMessageDialog(null,
									lineasActualizadas + " " + "registro actualizado éxitosamente.",
									"Actualización éxitosa.", JOptionPane.INFORMATION_MESSAGE);
						});
			}
		}
	}

	private void cancelarActualizacionRegistroUsuarios(java.awt.event.MouseEvent evt) {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(this,
				"¿Desea cancelar la actualización de registro actual?\n"
						+ "Los cambios efectuados en la tabla se reestablerecán.",
				"Confirmar cancelación de actualización de registro.", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			evt.consume();
			limpiarTablaRegistroUsuarios();
			cargarTablaUsuarios();
			configurarAnchoColumnasTabla(tablaUsuarios, margenColumna);
		}
	}

	private void eliminarRegistroUsuario() {
		int fila = tablaUsuarios.getSelectedRow();
		if (fila < 0) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
		} else {
			Optional.ofNullable(
					modeloTablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), tablaUsuarios.getSelectedColumn()))
					.ifPresent(row -> {
						Integer idUsuario = Integer.valueOf(tablaUsuarios.getValueAt(fila, 0).toString());
						int cantidadEliminada;
						cantidadEliminada = this.usuarioController.eliminar(idUsuario);
						JOptionPane.showMessageDialog(null,
								cantidadEliminada + " " + "registro eliminado éxitosamente.",
								"Eliminación de registro éxitosa.", JOptionPane.INFORMATION_MESSAGE);
					});
		}
	}

	private void confirmarEliminacionRegistroUsuario(java.awt.event.MouseEvent evt) {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(this,
				"¿Realmente desea eliminar el registro?\n" + "El registro será eliminado definitivamente.",
				"Confirmar eliminación de registro.", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
				opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			evt.consume();
			reestablecerCampos();
			eliminarRegistroUsuario();
			limpiarTablaRegistroUsuarios();
			cargarTablaUsuarios();
			configurarAnchoColumnasTabla(tablaUsuarios, margenColumna);
		}
	}

	private void modififcarSeleccionCategoriaUsuarioEnTablaUsuarios() {
		String seleccion = seleccionCategoriaUsuario.getSelectedItem().toString();
		int fila = tablaUsuarios.getSelectedRow();
		if (tablaUsuarios.isRowSelected(fila)) {
			tablaUsuarios.setValueAt(seleccion, tablaUsuarios.getSelectedRow(), 2);
		}
	}

	private void reestablecerCampos() {
		fechaNacimiento.setDate(null);
		seleccionNacionalidad.setSelectedIndex(0);
		fechaCheckIn.setDate(null);
		fechaCheckOut.setDate(null);
		seleccionFormaPago.setSelectedIndex(0);
		seleccionCategoriaUsuario.setSelectedIndex(0);
		campoPassword.setText("");
		alternarEdicionCamposHuespedes();
		alternarEdicionCamposReservas();
		alternarEdicionCamposUsuario();
	}

	@Override
	public Image getIconImage() {
		Image retImage = Toolkit.getDefaultToolkit()
				.getImage(ClassLoader.getSystemResource("mx/com/alurahotel/imagenes/lupa2.png"));
		return retImage;
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		panelPrincipal = new JPanelTransparente();
		btnMinimizar = new javax.swing.JLabel();
		btnCerrar = new javax.swing.JLabel();
		jLabelIconoHotelAlura = new javax.swing.JLabel();
		jLabelTituloVentanaBuscar = new javax.swing.JLabel();
		btnAyudaHuespedes = new javax.swing.JLabel();
		btnAyudaReservas = new javax.swing.JLabel();
		jLabelPorIdReserva = new javax.swing.JLabel();
		jLabelPorApellido = new javax.swing.JLabel();
		jLabelPorCategoriaUsuario = new javax.swing.JLabel();
		campoBuscar = new javax.swing.JTextField();
		btnBuscar = new javax.swing.JLabel();
		jLabelInstrucionesHuesped = new javax.swing.JLabel();
		fechaNacimiento = new com.toedter.calendar.JDateChooser();
		seleccionNacionalidad = new javax.swing.JComboBox<>();
		jLabelInstrucionesReserva = new javax.swing.JLabel();
		fechaCheckIn = new com.toedter.calendar.JDateChooser();
		fechaCheckOut = new com.toedter.calendar.JDateChooser();
		seleccionFormaPago = new javax.swing.JComboBox<>();
		jLabelCategoria = new javax.swing.JLabel();
		seleccionCategoriaUsuario = new javax.swing.JComboBox<>();
		jLabelPassword = new javax.swing.JLabel();
		campoPassword = new javax.swing.JPasswordField();
		panelTablas = new javax.swing.JTabbedPane();
		scrollTablaHuespedes = new javax.swing.JScrollPane();
		tablaHuespedes = new javax.swing.JTable();
		scrollTablaReservas = new javax.swing.JScrollPane();
		tablaReservas = new javax.swing.JTable();
		scrollTablaUsuarios = new javax.swing.JScrollPane();
		tablaUsuarios = new javax.swing.JTable();
		btnActualizar = new javax.swing.JLabel();
		btnEliminar = new javax.swing.JLabel();
		btnCancelar = new javax.swing.JLabel();
		btnMenuUsuario = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setIconImage(getIconImage());
		setUndecorated(true);

		panelPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent evt) {
				panelPrincipalMouseDragged(evt);
			}
		});
		panelPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				panelPrincipalMousePressed(evt);
			}
		});
		panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		btnMinimizar.setFont(new java.awt.Font("Segoe UI", 1, 24));
		btnMinimizar.setForeground(new java.awt.Color(204, 204, 204));
		btnMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnMinimizar.setText("-");
		btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnMinimizar.setOpaque(true);
		btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnMinimizarMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnMinimizarMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnMinimizarMouseExited(evt);
			}
		});
		panelPrincipal.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(888, 0, 60, 30));

		btnCerrar.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
		btnCerrar.setForeground(new java.awt.Color(204, 204, 204));
		btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnCerrar.setText("x");
		btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCerrar.setOpaque(true);
		btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnCerrarMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnCerrarMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnCerrarMouseExited(evt);
			}
		});
		panelPrincipal.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 0, 60, 30));

		jLabelIconoHotelAlura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelIconoHotelAlura
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/Ha-100px.png")));
		panelPrincipal.add(jLabelIconoHotelAlura, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, -1, -1));

		jLabelTituloVentanaBuscar.setFont(new java.awt.Font("Segoe UI", 1, 24));
		jLabelTituloVentanaBuscar.setForeground(new java.awt.Color(12, 138, 199));
		jLabelTituloVentanaBuscar.setText("Sistema de Búsqueda");
		panelPrincipal.add(jLabelTituloVentanaBuscar,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 48, 740, -1));

		btnAyudaHuespedes.setFont(new java.awt.Font("Segoe UI", 1, 18));
		btnAyudaHuespedes.setForeground(new java.awt.Color(0, 153, 0));
		btnAyudaHuespedes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnAyudaHuespedes.setText("?");
		btnAyudaHuespedes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnAyudaHuespedes.setOpaque(true);
		btnAyudaHuespedes.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnAyudaHuespedesMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnAyudaHuespedesMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnAyudaHuespedesMouseExited(evt);
			}
		});
		panelPrincipal.add(btnAyudaHuespedes, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 40, 50, 30));

		btnAyudaReservas.setFont(new java.awt.Font("Segoe UI", 1, 18));
		btnAyudaReservas.setForeground(new java.awt.Color(0, 153, 0));
		btnAyudaReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnAyudaReservas.setText("?");
		btnAyudaReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnAyudaReservas.setOpaque(true);
		btnAyudaReservas.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnAyudaReservasMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnAyudaReservasMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnAyudaReservasMouseExited(evt);
			}
		});
		panelPrincipal.add(btnAyudaReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 40, 50, 30));

		jLabelPorIdReserva.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelPorIdReserva.setForeground(new java.awt.Color(204, 204, 204));
		jLabelPorIdReserva.setText("Buscar por ID Reserva:");
		panelPrincipal.add(jLabelPorIdReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

		jLabelPorApellido.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelPorApellido.setForeground(new java.awt.Color(204, 204, 204));
		jLabelPorApellido.setText("Buscar por Apellido:");
		panelPrincipal.add(jLabelPorApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

		jLabelPorCategoriaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelPorCategoriaUsuario.setForeground(new java.awt.Color(204, 204, 204));
		jLabelPorCategoriaUsuario.setText("Buscar por Categoría de Usuario:");
		panelPrincipal.add(jLabelPorCategoriaUsuario,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

		campoBuscar.setBackground(new java.awt.Color(60, 63, 65));
		campoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoBuscar.setForeground(new java.awt.Color(204, 204, 204));
		campoBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));
		campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				campoBuscarKeyTyped(evt);
			}
		});
		panelPrincipal.add(campoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 108, 320, 31));

		btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/lupa2.png")));
		btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBuscar.setOpaque(true);
		btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnBuscarMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnBuscarMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnBuscarMouseExited(evt);
			}
		});
		panelPrincipal.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(914, 98, 56, 41));

		jLabelInstrucionesHuesped.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelInstrucionesHuesped.setForeground(new java.awt.Color(204, 204, 204));
		jLabelInstrucionesHuesped.setText(
				"Para actualizar los campos Fecha de Nacimiento y Nacionalidad, seleccione la fila y actualice el valor que corresponda.");
		panelPrincipal.add(jLabelInstrucionesHuesped,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 141, -1, -1));

		fechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 14));
		fechaNacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				fechaNacimientoPropertyChange(evt);
			}
		});
		panelPrincipal.add(fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 173, 200, 28));

		seleccionNacionalidad.setFont(new java.awt.Font("Segoe UI", 0, 14));
		seleccionNacionalidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));
		seleccionNacionalidad.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				seleccionNacionalidadActionPerformed(evt);
			}
		});
		panelPrincipal.add(seleccionNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 173, 241, -1));

		jLabelInstrucionesReserva.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelInstrucionesReserva.setForeground(new java.awt.Color(204, 204, 204));
		jLabelInstrucionesReserva.setText(
				"Para actualizar los campos de la tabla seleccione la fila y edite los registros que desee actualizar.");
		panelPrincipal.add(jLabelInstrucionesReserva,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 141, -1, -1));

		fechaCheckIn.setFont(new java.awt.Font("Segoe UI", 0, 14));
		fechaCheckIn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				fechaCheckInPropertyChange(evt);
			}
		});
		panelPrincipal.add(fechaCheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 173, 197, 28));

		fechaCheckOut.setFont(new java.awt.Font("Segoe UI", 0, 14));
		fechaCheckOut.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				fechaCheckOutPropertyChange(evt);
			}
		});
		panelPrincipal.add(fechaCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 172, 197, 30));

		seleccionFormaPago.setFont(new java.awt.Font("Segoe UI", 0, 14));
		seleccionFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija forma de pago",
				"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en Efectivo" }));
		seleccionFormaPago.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));
		seleccionFormaPago.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				seleccionFormaPagoActionPerformed(evt);
			}
		});
		panelPrincipal.add(seleccionFormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 173, 230, -1));

		jLabelCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelCategoria.setForeground(new java.awt.Color(204, 204, 204));
		jLabelCategoria.setText("Categoría Usuario:");
		panelPrincipal.add(jLabelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

		seleccionCategoriaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
		seleccionCategoriaUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Elija la categoría de Usuario", "Gerente", "Recepcionista" }));
		seleccionCategoriaUsuario.setBorder(javax.swing.BorderFactory
				.createEtchedBorder(new java.awt.Color(12, 138, 199), new java.awt.Color(12, 138, 199)));
		seleccionCategoriaUsuario.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				seleccionCategoriaUsuarioActionPerformed(evt);
			}
		});
		panelPrincipal.add(seleccionCategoriaUsuario,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 230, -1));

		jLabelPassword.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelPassword.setForeground(new java.awt.Color(204, 204, 204));
		jLabelPassword.setText("Contraseña:");
		panelPrincipal.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

		campoPassword.setBackground(new java.awt.Color(60, 63, 65));
		campoPassword.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoPassword.setForeground(new java.awt.Color(204, 204, 204));
		campoPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));
		panelPrincipal.add(campoPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 250, 30));

		panelTablas.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				panelTablasMouseClicked(evt);
			}
		});

		tablaHuespedes.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID Huesped", "Nombre", "Apellido", "Fecha de Nacimiento", "Nacionalidad", "Teléfono",
				"ID Reserva" }) {
			boolean[] canEdit = new boolean[] { false, true, true, false, false, true, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tablaHuespedes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaHuespedes.setSelectionBackground(new java.awt.Color(12, 138, 199));
		tablaHuespedes.setSelectionForeground(new java.awt.Color(255, 255, 255));
		tablaHuespedes.getTableHeader().setResizingAllowed(false);
		tablaHuespedes.getTableHeader().setReorderingAllowed(false);
		tablaHuespedes.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tablaHuespedesMouseClicked(evt);
			}
		});
		scrollTablaHuespedes.setViewportView(tablaHuespedes);

		panelTablas.addTab("Huéspedes",
				new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/persona.png")),
				scrollTablaHuespedes);

		tablaReservas.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID_Reserva", "Fecha de Entrada", "Fecha de Salida", "Total", "Forma de Pago" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tablaReservas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaReservas.setSelectionBackground(new java.awt.Color(12, 138, 199));
		tablaReservas.setSelectionForeground(new java.awt.Color(255, 255, 255));
		tablaReservas.getTableHeader().setResizingAllowed(false);
		tablaReservas.getTableHeader().setReorderingAllowed(false);
		tablaReservas.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tablaReservasMouseClicked(evt);
			}
		});
		scrollTablaReservas.setViewportView(tablaReservas);

		panelTablas.addTab("Reservas",
				new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/calendario.png")),
				scrollTablaReservas);

		tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID Usuario", "Usuario", "Categoría Usuario" }) {
			boolean[] canEdit = new boolean[] { false, true, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tablaUsuarios.setSelectionBackground(new java.awt.Color(12, 138, 199));
		tablaUsuarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
		tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tablaUsuariosMouseClicked(evt);
			}
		});
		scrollTablaUsuarios.setViewportView(tablaUsuarios);

		panelTablas.addTab("Usuarios",
				new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/perfil-del-usuario.png")),
				scrollTablaUsuarios);

		panelPrincipal.add(panelTablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 220, 978, 305));

		btnActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnActualizar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/editar-texto.png")));
		btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnActualizar.setOpaque(true);
		btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnActualizarMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnActualizarMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnActualizarMouseExited(evt);
			}
		});
		panelPrincipal.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, 60, 40));

		btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnEliminar
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/deletar.png")));
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnEliminar.setOpaque(true);
		btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnEliminarMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnEliminarMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnEliminarMouseExited(evt);
			}
		});
		panelPrincipal.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 540, 60, 40));

		btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnCancelar
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/cancelar.png")));
		btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCancelar.setOpaque(true);
		btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnCancelarMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnCancelarMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnCancelarMouseExited(evt);
			}
		});
		panelPrincipal.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 540, 60, 40));

		btnMenuUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnMenuUsuario.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/mx/com/alurahotel/imagenes/cerrar-sesion 32-px.png")));
		btnMenuUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnMenuUsuario.setOpaque(true);
		btnMenuUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnMenuUsuarioMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnMenuUsuarioMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnMenuUsuarioMouseExited(evt);
			}
		});
		panelPrincipal.add(btnMenuUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 540, 60, 40));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelPrincipal,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
	}

	private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		this.setExtendedState(ICONIFIED);
	}

	private void btnMinimizarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnMinimizarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {
		Mensaje.confirmarSalida(evt);
	}

	private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnCerrar.setBackground(ColoresComponentesUtil.ROJO_OSCURO);
	}

	private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnCerrar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		if (tablaHuespedes.isShowing()) {
			limpiarTablaRegistroHuespedes();
			cargarTablaHuespedes(campoBuscar);
			configurarAnchoColumnasTabla(tablaHuespedes, margenColumna);
		} else if (tablaReservas.isShowing()) {
			limpiarTablaRegistroReservas();
			cargarTablaReservas(campoBuscar);
			configurarAnchoColumnasTabla(tablaReservas, margenColumna);
		} else {
			limpiarTablaRegistroUsuarios();
			cargarTablaUsuarios(campoBuscar);
			configurarAnchoColumnasTabla(tablaUsuarios, margenColumna);
		}
		reestablecerCampos();
	}

	private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnBuscar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnBuscar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {
		if (tablaHuespedes.isShowing()) {
			confirmarEliminacionRegistroHuesped(evt);
		} else {
			confirmarEliminacionRegistroUsuario(evt);
		}
	}

	private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnEliminar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnEliminar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		if (tablaHuespedes.isShowing()) {
			cancelarActualizacionRegistroHuespedes(evt);
		} else if (tablaReservas.isShowing()) {
			cancelarActualizacionRegistroReservas(evt);
		} else {
			cancelarActualizacionRegistroUsuarios(evt);
		}
	}

	private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnCancelar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnCancelar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		if (tablaHuespedes.isShowing()) {
			actualizarRegistroHuesped();
			limpiarTablaRegistroHuespedes();
			reestablecerCampos();
			cargarTablaHuespedes();
			configurarAnchoColumnasTabla(tablaHuespedes, margenColumna);
		} else if (tablaReservas.isShowing()) {
			actualizarRegistroReserva();
			limpiarTablaRegistroReservas();
			reestablecerCampos();
			cargarTablaReservas();
			configurarAnchoColumnasTabla(tablaReservas, margenColumna);
		} else {
			actualizarRegistroUsuario();
			limpiarTablaRegistroUsuarios();
			reestablecerCampos();
			cargarTablaUsuarios();
			configurarAnchoColumnasTabla(tablaUsuarios, margenColumna);
		}
	}
	
	
	// evita que un usuario que no sea el Gerente visualice y edite a los usuarios
	public static boolean esGerente() {
		String categoriaUsuario = "Gerente";
		String categoriaUsuarioActual = login.getUsuario().getCategoriaUsuario();
		return categoriaUsuarioActual.equals(categoriaUsuario);
	}
	
	private void alternarVisualizacionMenu() {
	    if (esGerente()) {
	       
	    	tablaUsuarios.setVisible(true);
	    } else {
	       
	    	tablaUsuarios.setVisible(false);
	    	mostrarAlerta("Acceso restringido", "Solo el Gerente puede visualizar a los usuarios.");
	    }
	}
	
	private void mostrarAlerta(String titulo, String mensaje) {
	    JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
	}



	private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnActualizar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnActualizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void panelPrincipalMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void panelPrincipalMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	private void btnMenuUsuarioMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		this.dispose();
		MenuUsuario menuUsuario = new MenuUsuario();
		menuUsuario.setVisible(true);
	}

	private void btnMenuUsuarioMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnMenuUsuario.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnMenuUsuarioMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnMenuUsuario.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void seleccionNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {
		evt.getActionCommand();
		modificarNacionalidadEnTablaHuespedes();
	}

	private void btnAyudaHuespedesMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		JOptionPane.showMessageDialog(null, "Puede actualizar los registros Nombre, Apellido y Fecha de Nacimiento\n"
				+ "directamente en la tabla.\n" + "Si desea actualizar la Nacionalidad, seleccione la fila que desee "
				+ "y cambie el valor en el campo de selección.");
	}

	private void btnAyudaHuespedesMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnAyudaHuespedes.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnAyudaHuespedesMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnAyudaHuespedes.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void fechaNacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {
		evt.getPropertyName();
		modificarFechaNacimientoEnTablaHuespedes();
	}

	private void tablaHuespedesMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getClickCount() == 1) {
			int fila = tablaHuespedes.getSelectedRow();
			String fecha = String.valueOf(tablaHuespedes.getValueAt(fila, 3));
			String nacionalidad = String.valueOf(tablaHuespedes.getValueAt(fila, 4));
			Date dt = Date.valueOf(fecha);
			fechaNacimiento.setDate(dt);
			seleccionNacionalidad.setSelectedItem(nacionalidad);
			alternarEdicionCamposHuespedes();
		}
	}

	private void panelTablasMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		alternarVisualizacionCamposTablas();
	}

	private void fechaCheckInPropertyChange(java.beans.PropertyChangeEvent evt) {
		if (fechaCheckIn.getDate() != null && fechaCheckOut.getDate() != null && evt.getOldValue() != null) {
			calcularValorReservas();
			modificarFechaEntradaEnTablaReservas();
		}
	}

	private void fechaCheckOutPropertyChange(java.beans.PropertyChangeEvent evt) {
		if (fechaCheckIn.getDate() != null && fechaCheckOut.getDate() != null && evt.getOldValue() != null) {
			calcularValorReservas();
			modificarFechaSalidaEnTablaReservas();
		}
	}

	private void tablaReservasMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getClickCount() == 1) {
			int fila = tablaReservas.getSelectedRow();
			String fechaEntradaOfTablaReservas = String.valueOf(tablaReservas.getValueAt(fila, 1));
			String fechaSalidaOfTablaReservas = String.valueOf(tablaReservas.getValueAt(fila, 2));
			String formaPago = String.valueOf(tablaReservas.getValueAt(fila, 4));
			Date fechaEntrada = Date.valueOf(fechaEntradaOfTablaReservas);
			Date fechaSalida = Date.valueOf(fechaSalidaOfTablaReservas);
			seleccionFormaPago.setSelectedItem(formaPago);
			fechaCheckIn.setDate(fechaEntrada);
			fechaCheckOut.setDate(fechaSalida);

			if (fechaCheckIn.getDate() != null && fechaCheckOut.getDate() != null) {

				alternarEdicionCamposReservas();
				calcularDiasTranscurridos(fechaCheckIn, fechaCheckOut);
			}
		}
	}

	private void campoBuscarKeyTyped(java.awt.event.KeyEvent evt) {
		char comodin = '%';
		if (evt.getKeyChar() == comodin) {
			evt.consume();
		}
	}

	private void btnAyudaReservasMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		JOptionPane.showMessageDialog(null,
				"Si desea actualizar los registros sólo será posible editar los campos:\n" + "Fecha de Entrada.\n"
						+ "Fecha de Salida.\n" + "Forma de Pago.\n"
						+ "El total se cálcula automáticamente al índicar las fechas.");
	}

	private void btnAyudaReservasMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnAyudaReservas.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnAyudaReservasMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnAyudaReservas.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getClickCount() == 1) {
			int fila = tablaUsuarios.getSelectedRow();
			String categoriaUsuario = String.valueOf(tablaUsuarios.getValueAt(fila, 2));
			seleccionCategoriaUsuario.setSelectedItem(categoriaUsuario);
			alternarEdicionCamposUsuario();
		}
	}

	private void seleccionFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {
		evt.getActionCommand();
		modificarSeleccionFormaPagoEnTablaReservas();
	}

	private void seleccionCategoriaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
		evt.getActionCommand();
		modififcarSeleccionCategoriaUsuarioEnTablaUsuarios();
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;

				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(() -> {
			new Busqueda().setVisible(true);
		});
	}

	private javax.swing.JLabel btnActualizar;
	private javax.swing.JLabel btnAyudaHuespedes;
	private javax.swing.JLabel btnAyudaReservas;
	private javax.swing.JLabel btnBuscar;
	private javax.swing.JLabel btnCancelar;
	private javax.swing.JLabel btnCerrar;
	private javax.swing.JLabel btnEliminar;
	private javax.swing.JLabel btnMenuUsuario;
	private javax.swing.JLabel btnMinimizar;
	private javax.swing.JTextField campoBuscar;
	private javax.swing.JPasswordField campoPassword;
	private com.toedter.calendar.JDateChooser fechaCheckIn;
	private com.toedter.calendar.JDateChooser fechaCheckOut;
	private com.toedter.calendar.JDateChooser fechaNacimiento;
	private javax.swing.JLabel jLabelCategoria;
	private javax.swing.JLabel jLabelIconoHotelAlura;
	private javax.swing.JLabel jLabelInstrucionesHuesped;
	private javax.swing.JLabel jLabelInstrucionesReserva;
	private javax.swing.JLabel jLabelPassword;
	private javax.swing.JLabel jLabelPorApellido;
	private javax.swing.JLabel jLabelPorCategoriaUsuario;
	private javax.swing.JLabel jLabelPorIdReserva;
	private javax.swing.JLabel jLabelTituloVentanaBuscar;
	private javax.swing.JPanel panelPrincipal;
	private javax.swing.JTabbedPane panelTablas;
	private javax.swing.JScrollPane scrollTablaHuespedes;
	private javax.swing.JScrollPane scrollTablaReservas;
	private javax.swing.JScrollPane scrollTablaUsuarios;
	private javax.swing.JComboBox<String> seleccionCategoriaUsuario;
	private javax.swing.JComboBox<String> seleccionFormaPago;
	private javax.swing.JComboBox<String> seleccionNacionalidad;
	private javax.swing.JTable tablaHuespedes;
	private javax.swing.JTable tablaReservas;
	private javax.swing.JTable tablaUsuarios;
}

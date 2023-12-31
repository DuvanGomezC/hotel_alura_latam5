
package mx.com.alurahotel.view;

import com.toedter.calendar.JDateChooser;
import mx.com.alurahotel.util.ColoresComponentesUtil;
import java.awt.Image;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import mx.com.alurahotel.modelo.Reserva;
import mx.com.alurahotel.util.ConvertirFecha;
import mx.com.alurahotel.util.ValidarFormulariosUtil;

/**
 * @author duvan gomez 
 */

public class Reservas extends javax.swing.JFrame {

	int xMouse;
	int yMouse;
	private static Reserva reserva;

	public Reservas() {
		initComponents();
		configurarColoresComponentes();
		campoValorReserva.setEnabled(false);
	}

	public Reserva getReserva() {
		if (Reservas.reserva == null) {
			throw new RuntimeException("El método getReserva() debe obtener los "
					+ "valores desde el formulario de la ventana de Reservas.");
		}
		return Reservas.reserva;
	}

	public void setReserva(Reserva reserva) {
		Reservas.reserva = reserva;
	}

	private void configurarColoresComponentes() {
		setBackground(ColoresComponentesUtil.TRANSPARENTE);
		panelFormularioReservas.setBackground(ColoresComponentesUtil.TRANSPARENTE);
		btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnCerrar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void guardarReferenciaReserva() {
		if (ValidarFormulariosUtil.esFormularioReservaValido(fechaCheckIn, fechaCheckOut, campoValorReserva.getText(),
				seleccionFormaPago)) {

			Date dateCheckIn = Date.valueOf(ConvertirFecha.convertirDateALocalDate(fechaCheckIn.getDate()));
			Date dateCheckOut = Date.valueOf(ConvertirFecha.convertirDateALocalDate(fechaCheckOut.getDate()));
			String valorReservaString = campoValorReserva.getText();
			BigDecimal valorReservaToBigDecimal = new BigDecimal(valorReservaString);

			setReserva(new Reserva(dateCheckIn, dateCheckOut, valorReservaToBigDecimal,
					seleccionFormaPago.getSelectedItem().toString()));
			limpiarCampos();
			this.dispose();
			RegistrarHuesped registrarHuesped = new RegistrarHuesped();
			registrarHuesped.setVisible(true);
		}
	}

	public void limpiarCampos() {
		fechaCheckIn.setCalendar(null);
		fechaCheckOut.setCalendar(null);
		campoValorReserva.setText("0.0");
		seleccionFormaPago.setSelectedIndex(0);
	}

	public BigDecimal calcularValorReserva(JDateChooser fechaEntrada, JDateChooser fechaSalida) {
		BigDecimal valorTasaReservaPorDia = new BigDecimal("80000.00");
		BigDecimal valorReserva = new BigDecimal("0.0");
		long numeroDias;
		if ((fechaEntrada.getDate() != null) && (fechaSalida.getDate() != null)) {
			LocalDate fechaIn = ConvertirFecha.convertirDateALocalDate(fechaCheckIn.getDate());
			LocalDate fechaOut = ConvertirFecha.convertirDateALocalDate(fechaCheckOut.getDate());
			numeroDias = ChronoUnit.DAYS.between(fechaIn, fechaOut);
			if (numeroDias > 0) {
				BigDecimal diasReservados = new BigDecimal(numeroDias);
				valorReserva = diasReservados.multiply(valorTasaReservaPorDia);
				campoValorReserva.setText(String.valueOf(valorReserva));
				return valorReserva;
			} else {
				ValidarFormulariosUtil.desplegarMensajeError("Error en el cálculo de la Reserva.",
						"No es posible cálcular reservas si la"
								+ " fecha de Check-Out es menor o igual a la fecha de \n"
								+ " Check-In, ya que el cálculo se realiza por días.");
				campoValorReserva.setText(String.valueOf(valorReserva));
				return valorReserva;
			}
		} else {
			campoValorReserva.setText(String.valueOf(valorReserva));
			return valorReserva;
		}
	}

	@Override
	public Image getIconImage() {
		Image retImage = Toolkit.getDefaultToolkit()
				.getImage(ClassLoader.getSystemResource("mx/com/alurahotel/imagenes/calendario.png"));
		return retImage;
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		panelPrincipal = new JPanelTransparente();
		btnCerrar = new javax.swing.JLabel();
		btnMinimizar = new javax.swing.JLabel();
		panelFormularioReservas = new javax.swing.JPanel();
		jLabelIconoHotelAlura = new javax.swing.JLabel();
		jLabelTituloFormulario = new javax.swing.JLabel();
		jLabelTextoCheckIn = new javax.swing.JLabel();
		fechaCheckIn = new com.toedter.calendar.JDateChooser();
		jLabelTextoCheckOut = new javax.swing.JLabel();
		fechaCheckOut = new com.toedter.calendar.JDateChooser();
		jLabelTextoValorReserva = new javax.swing.JLabel();
		campoValorReserva = new javax.swing.JTextField();
		jLabelTextoFormaPago = new javax.swing.JLabel();
		seleccionFormaPago = new javax.swing.JComboBox<>();
		btnContinuarReservas = new javax.swing.JLabel();
		jLabelBannerReservas = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setIconImage(getIconImage());
		setUndecorated(true);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
		panelPrincipal.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 60, 30));

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
		panelPrincipal.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 60, 30));

		jLabelIconoHotelAlura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelIconoHotelAlura
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/Ha-100px.png")));

		jLabelTituloFormulario.setFont(new java.awt.Font("Segoe UI", 1, 18));
		jLabelTituloFormulario.setForeground(new java.awt.Color(12, 138, 199));
		jLabelTituloFormulario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelTituloFormulario.setText("Sistema de Reservas");

		jLabelTextoCheckIn.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoCheckIn.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoCheckIn.setText("Fecha de Check-In:");

		fechaCheckIn.setFont(new java.awt.Font("Segoe UI", 0, 14));
		fechaCheckIn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				fechaCheckInPropertyChange(evt);
			}
		});

		jLabelTextoCheckOut.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoCheckOut.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoCheckOut.setText("Fecha de Check-Out:");

		fechaCheckOut.setFont(new java.awt.Font("Segoe UI", 0, 14));
		fechaCheckOut.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				fechaCheckOutPropertyChange(evt);
			}
		});

		jLabelTextoValorReserva.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoValorReserva.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoValorReserva.setText("Valor de la Reserva:");

		campoValorReserva.setBackground(new java.awt.Color(60, 63, 65));
		campoValorReserva.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoValorReserva.setForeground(new java.awt.Color(204, 204, 204));
		campoValorReserva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoValorReserva.setText("0.0");
		campoValorReserva.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));

		jLabelTextoFormaPago.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoFormaPago.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoFormaPago.setText("Forma de Pago:");

		seleccionFormaPago.setFont(new java.awt.Font("Segoe UI", 0, 14));
		seleccionFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija forma de pago",
				"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en Efectivo" }));
		seleccionFormaPago.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));

		btnContinuarReservas.setBackground(new java.awt.Color(12, 138, 199));
		btnContinuarReservas.setFont(new java.awt.Font("Segoe UI", 0, 14));
		btnContinuarReservas.setForeground(new java.awt.Color(204, 204, 204));
		btnContinuarReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnContinuarReservas.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/calendario.png")));
		btnContinuarReservas.setText("Continuar");
		btnContinuarReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnContinuarReservas.setOpaque(true);
		btnContinuarReservas.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnContinuarReservasMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnContinuarReservasMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnContinuarReservasMouseExited(evt);
			}
		});

		javax.swing.GroupLayout panelFormularioReservasLayout = new javax.swing.GroupLayout(panelFormularioReservas);
		panelFormularioReservas.setLayout(panelFormularioReservasLayout);
		panelFormularioReservasLayout.setHorizontalGroup(panelFormularioReservasLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelFormularioReservasLayout.createSequentialGroup().addContainerGap()
						.addComponent(jLabelTituloFormulario, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(6, 6, 6))
				.addGroup(panelFormularioReservasLayout.createSequentialGroup().addGroup(panelFormularioReservasLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(panelFormularioReservasLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelFormularioReservasLayout.createSequentialGroup().addGap(22, 22, 22)
										.addComponent(jLabelIconoHotelAlura))
								.addGroup(panelFormularioReservasLayout.createSequentialGroup().addGap(75, 75, 75)
										.addGroup(panelFormularioReservasLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabelTextoCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabelTextoCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(fechaCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(fechaCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabelTextoValorReserva,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(campoValorReserva)
												.addComponent(jLabelTextoFormaPago,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(seleccionFormaPago,
														javax.swing.GroupLayout.PREFERRED_SIZE, 251,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGroup(panelFormularioReservasLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(
								btnContinuarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 140,
								javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(14, 84, Short.MAX_VALUE)));
		panelFormularioReservasLayout.setVerticalGroup(panelFormularioReservasLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelFormularioReservasLayout.createSequentialGroup().addContainerGap()
						.addComponent(jLabelIconoHotelAlura).addGap(37, 37, 37).addComponent(jLabelTituloFormulario)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabelTextoCheckIn)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(fechaCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(12, 12, 12).addComponent(jLabelTextoCheckOut)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(fechaCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabelTextoValorReserva)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(campoValorReserva, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabelTextoFormaPago)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(seleccionFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
						.addComponent(btnContinuarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(32, 32, 32)));

		panelPrincipal.add(panelFormularioReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 540));

		jLabelBannerReservas.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/reservas-img-2.png")));
		panelPrincipal.add(jLabelBannerReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 500, 540));

		getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 540));

		pack();
		setLocationRelativeTo(null);
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

	private void panelPrincipalMousePressed(java.awt.event.MouseEvent evt) {
		evt.consume();
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void panelPrincipalMouseDragged(java.awt.event.MouseEvent evt) {
		evt.consume();
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	private void btnContinuarReservasMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnContinuarReservas.setBackground(ColoresComponentesUtil.AZUL_CLARO);
	}

	private void btnContinuarReservasMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnContinuarReservas.setBackground(ColoresComponentesUtil.AZUL);
	}

	private void btnContinuarReservasMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		guardarReferenciaReserva();
	}

	private void fechaCheckInPropertyChange(java.beans.PropertyChangeEvent evt) {
		evt.getPropertyName();
		calcularValorReserva(fechaCheckIn, fechaCheckOut);
	}

	private void fechaCheckOutPropertyChange(java.beans.PropertyChangeEvent evt) {
		evt.getPropertyName();
		calcularValorReserva(fechaCheckIn, fechaCheckIn);
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
			java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(() -> {
			new Reservas().setVisible(true);
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel btnCerrar;
	private javax.swing.JLabel btnContinuarReservas;
	private javax.swing.JLabel btnMinimizar;
	private javax.swing.JTextField campoValorReserva;
	private com.toedter.calendar.JDateChooser fechaCheckIn;
	private com.toedter.calendar.JDateChooser fechaCheckOut;
	private javax.swing.JLabel jLabelBannerReservas;
	private javax.swing.JLabel jLabelIconoHotelAlura;
	private javax.swing.JLabel jLabelTextoCheckIn;
	private javax.swing.JLabel jLabelTextoCheckOut;
	private javax.swing.JLabel jLabelTextoFormaPago;
	private javax.swing.JLabel jLabelTextoValorReserva;
	private javax.swing.JLabel jLabelTituloFormulario;
	private javax.swing.JPanel panelFormularioReservas;
	private javax.swing.JPanel panelPrincipal;
	private javax.swing.JComboBox<String> seleccionFormaPago;
	// End of variables declaration//GEN-END:variables
}

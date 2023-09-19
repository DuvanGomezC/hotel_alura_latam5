
package mx.com.alurahotel.view;

import mx.com.alurahotel.util.ColoresComponentesUtil;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import javax.swing.DefaultComboBoxModel;

import mx.com.alurahotel.controller.HuespedController;
import mx.com.alurahotel.controller.ReservaController;
import mx.com.alurahotel.modelo.Huesped;
import mx.com.alurahotel.util.ConvertirFecha;
import mx.com.alurahotel.util.ListarNacionalidadesUtil;
import mx.com.alurahotel.util.ValidarFormulariosUtil;

/**
 * @author duvan gomez 
 */

public class RegistrarHuesped extends javax.swing.JFrame {

	int xMouse;
	int yMouse;
	Reservas ventanaReservas = new Reservas();
	private final HuespedController huespedController;
	private final ReservaController reservaController;

	public RegistrarHuesped() {
		initComponents();
		configurarColoresComponentes();
		this.huespedController = new HuespedController();
		this.reservaController = new ReservaController();

		seleccionNacionalidad.setModel(new DefaultComboBoxModel<>(ListarNacionalidadesUtil.filtrarNacionalidades()));
		campoNumeroReserva.setEnabled(false);
		campoNumeroReserva.setText(ventanaReservas.getReserva().getId_Reserva());
	}

	private void configurarColoresComponentes() {
		setBackground(ColoresComponentesUtil.TRANSPARENTE);
		panelFormularioRegistroHuesped.setBackground(ColoresComponentesUtil.TRANSPARENTE);
		btnCerrar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnGuardar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnCancelar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnMenuUsuario.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void guardarReserva() {
		if (ValidarFormulariosUtil.esFormularioHuespedValido(campoNombre.getText(), campoApellido.getText(),
				fechaNacimiento, campoTelefono.getText())) {
			this.reservaController.guardar(ventanaReservas.getReserva());
			guardarHuesped();
		}
	}

	private void guardarHuesped() {
		Date fechaNac = Date.valueOf(ConvertirFecha.convertirDateALocalDate(fechaNacimiento.getDate()));
		Huesped huesped = new Huesped(campoNombre.getText(), campoApellido.getText(), fechaNac,
				seleccionNacionalidad.getSelectedItem().toString(), campoTelefono.getText());
		this.huespedController.guardar(huesped, ventanaReservas.getReserva().getId_Reserva());
		mostrarMensajeGuardado();
	}

	private void mostrarMensajeGuardado() {
		Exito e = new Exito();
		e.setVisible(true);
		this.dispose();
	}

	public void limpiarCampos() {
		campoNombre.setText("");
		campoApellido.setText("");
		fechaNacimiento.setCalendar(null);
		seleccionNacionalidad.setSelectedIndex(0);
		campoTelefono.setText("");
	}

	@Override
	public Image getIconImage() {
		Image retImage = Toolkit.getDefaultToolkit()
				.getImage(ClassLoader.getSystemResource("mx/com/alurahotel/imagenes/persona.png"));
		return retImage;
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		panelPrincipal = new JPanelTransparente();
		bannerRegistroHuesped = new javax.swing.JLabel();
		btnCerrar = new javax.swing.JLabel();
		btnMinimizar = new javax.swing.JLabel();
		panelFormularioRegistroHuesped = new javax.swing.JPanel();
		jLabelIconoHotelAlura = new javax.swing.JLabel();
		jLabelTituloFormulario = new javax.swing.JLabel();
		jLabelTextoApellido = new javax.swing.JLabel();
		campoApellido = new javax.swing.JTextField();
		jLabelTextoNombre = new javax.swing.JLabel();
		campoNombre = new javax.swing.JTextField();
		jLabelTextoFechaNacimiento = new javax.swing.JLabel();
		fechaNacimiento = new com.toedter.calendar.JDateChooser();
		jLabelTextoNacionalidad = new javax.swing.JLabel();
		seleccionNacionalidad = new javax.swing.JComboBox<>();
		jLabelTextoTelefono = new javax.swing.JLabel();
		campoTelefono = new javax.swing.JTextField();
		jLabelTextoNumeroReserva = new javax.swing.JLabel();
		campoNumeroReserva = new javax.swing.JTextField();
		btnGuardar = new javax.swing.JLabel();
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

		bannerRegistroHuesped
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/registro.png")));
		panelPrincipal.add(bannerRegistroHuesped, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 502, -1));

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
		jLabelTituloFormulario.setText("Registro de Huésped");

		jLabelTextoApellido.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoApellido.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoApellido.setText("Apellido:");

		campoApellido.setBackground(new java.awt.Color(60, 63, 65));
		campoApellido.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoApellido.setForeground(new java.awt.Color(204, 204, 204));
		campoApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoApellido.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));

		jLabelTextoNombre.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoNombre.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoNombre.setText("Nombre:");

		campoNombre.setBackground(new java.awt.Color(60, 63, 65));
		campoNombre.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoNombre.setForeground(new java.awt.Color(204, 204, 204));
		campoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));

		jLabelTextoFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoFechaNacimiento.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoFechaNacimiento.setText("Fecha de Nacimiento:");

		fechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 14));

		jLabelTextoNacionalidad.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoNacionalidad.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoNacionalidad.setText("Nacionalidad:");

		seleccionNacionalidad.setFont(new java.awt.Font("Segoe UI", 0, 14));
		seleccionNacionalidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));

		jLabelTextoTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoTelefono.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoTelefono.setText("Teléfono:");

		campoTelefono.setBackground(new java.awt.Color(60, 63, 65));
		campoTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoTelefono.setForeground(new java.awt.Color(204, 204, 204));
		campoTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoTelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));

		jLabelTextoNumeroReserva.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoNumeroReserva.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoNumeroReserva.setText("Número de Reserva:");

		campoNumeroReserva.setBackground(new java.awt.Color(60, 63, 65));
		campoNumeroReserva.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoNumeroReserva.setForeground(new java.awt.Color(0, 0, 0));
		campoNumeroReserva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoNumeroReserva.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));
		campoNumeroReserva.setDisabledTextColor(new java.awt.Color(0, 0, 0));

		btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnGuardar
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/disquete.png")));
		btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnGuardar.setOpaque(true);
		btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnGuardarMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnGuardarMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnGuardarMouseExited(evt);
			}
		});

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

		javax.swing.GroupLayout panelFormularioRegistroHuespedLayout = new javax.swing.GroupLayout(
				panelFormularioRegistroHuesped);
		panelFormularioRegistroHuesped.setLayout(panelFormularioRegistroHuespedLayout);
		panelFormularioRegistroHuespedLayout.setHorizontalGroup(panelFormularioRegistroHuespedLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioRegistroHuespedLayout
						.createSequentialGroup().addGap(12, 12, 12)
						.addGroup(panelFormularioRegistroHuespedLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabelTextoNumeroReserva, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(campoTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabelTextoTelefono, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(seleccionNacionalidad, javax.swing.GroupLayout.Alignment.TRAILING, 0,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabelTextoNacionalidad, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(fechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jLabelTextoFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(campoApellido, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(campoNombre)
								.addComponent(jLabelTextoApellido, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabelTituloFormulario, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabelTextoNombre, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(campoNumeroReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 290,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelFormularioRegistroHuespedLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabelIconoHotelAlura)
								.addGroup(panelFormularioRegistroHuespedLayout.createSequentialGroup()
										.addGap(20, 20, 20)
										.addGroup(panelFormularioRegistroHuespedLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnMenuUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
														60, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(446, 446, 446)));
		panelFormularioRegistroHuespedLayout.setVerticalGroup(panelFormularioRegistroHuespedLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelFormularioRegistroHuespedLayout.createSequentialGroup()
						.addContainerGap(37, Short.MAX_VALUE)
						.addGroup(panelFormularioRegistroHuespedLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										panelFormularioRegistroHuespedLayout.createSequentialGroup()
												.addComponent(jLabelTituloFormulario).addGap(18, 18, 18)
												.addComponent(jLabelTextoNombre))
								.addComponent(jLabelIconoHotelAlura, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 100,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(12, 12, 12)
						.addGroup(panelFormularioRegistroHuespedLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(panelFormularioRegistroHuespedLayout.createSequentialGroup()
										.addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabelTextoApellido)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabelTextoFechaNacimiento)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabelTextoNacionalidad)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(seleccionNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabelTextoTelefono)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabelTextoNumeroReserva)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(campoNumeroReserva, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(panelFormularioRegistroHuespedLayout.createSequentialGroup()
										.addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnMenuUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(23, 23, 23)));

		panelPrincipal.add(panelFormularioRegistroHuesped,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 410, 540));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelPrincipal,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

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

	private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {
		Mensaje.cancelarRegistro(evt, this);
	}

	private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnCancelar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnCancelar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		guardarReserva();
	}

	private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnGuardar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnGuardar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
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
			java.util.logging.Logger.getLogger(RegistrarHuesped.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		java.awt.EventQueue.invokeLater(() -> {
			new RegistrarHuesped().setVisible(true);
		});

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel bannerRegistroHuesped;
	private javax.swing.JLabel btnCancelar;
	private javax.swing.JLabel btnCerrar;
	private javax.swing.JLabel btnGuardar;
	private javax.swing.JLabel btnMenuUsuario;
	private javax.swing.JLabel btnMinimizar;
	private javax.swing.JTextField campoApellido;
	private javax.swing.JTextField campoNombre;
	private javax.swing.JTextField campoNumeroReserva;
	private javax.swing.JTextField campoTelefono;
	private com.toedter.calendar.JDateChooser fechaNacimiento;
	private javax.swing.JLabel jLabelIconoHotelAlura;
	private javax.swing.JLabel jLabelTextoApellido;
	private javax.swing.JLabel jLabelTextoFechaNacimiento;
	private javax.swing.JLabel jLabelTextoNacionalidad;
	private javax.swing.JLabel jLabelTextoNombre;
	private javax.swing.JLabel jLabelTextoNumeroReserva;
	private javax.swing.JLabel jLabelTextoTelefono;
	private javax.swing.JLabel jLabelTituloFormulario;
	private javax.swing.JPanel panelFormularioRegistroHuesped;
	private javax.swing.JPanel panelPrincipal;
	private javax.swing.JComboBox<String> seleccionNacionalidad;
	// End of variables declaration//GEN-END:variables
}

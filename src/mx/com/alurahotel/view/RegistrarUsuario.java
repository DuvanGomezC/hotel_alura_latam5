
package mx.com.alurahotel.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Arrays;
import javax.swing.JOptionPane;

import mx.com.alurahotel.controller.UsuarioController;
import mx.com.alurahotel.modelo.Usuario;
import mx.com.alurahotel.util.ColoresComponentesUtil;
import mx.com.alurahotel.util.ValidarFormulariosUtil;

/**
 * @author duvan gomez 
 */

public class RegistrarUsuario extends javax.swing.JFrame {

	int xMouse;
	int yMouse;
	private final UsuarioController usuarioController;

	public RegistrarUsuario() {
		initComponents();
		this.usuarioController = new UsuarioController();
		configurarEstiloComponentes();

	}

	private void configurarEstiloComponentes() {
		setBackground(ColoresComponentesUtil.TRANSPARENTE);
		btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnCerrar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnGuardar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnCancelar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void guardarUsuario() {
		String nombreUsuario = campoNombreUsuario.getText();
		if (ValidarFormulariosUtil.esFormularioUsuarioValido(nombreUsuario, seleccionCategoriaUsuario, campoPassword)) {
			Usuario usuario = new Usuario(campoNombreUsuario.getText(),
					seleccionCategoriaUsuario.getSelectedItem().toString(),
					String.valueOf(campoPassword.getPassword()));
			this.usuarioController.guardar(usuario);
			JOptionPane.showMessageDialog(null, "Usuario guardado éxitosamente.", "Guardado éxitoso.",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void reestablecerCampos() {
		campoNombreUsuario.setText("");
		seleccionCategoriaUsuario.setSelectedIndex(0);
		campoPassword.setText("");
	}

	@Override
	public Image getIconImage() {
		Image retImage = Toolkit.getDefaultToolkit()
				.getImage(ClassLoader.getSystemResource("mx/com/alurahotel/imagenes/perfil-del-usuario.png"));
		return retImage;
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		panelPrincipal = new JPanelTransparente();
		jLabelIconoUsuario = new javax.swing.JLabel();
		jLabelTituloVentanaBuscar = new javax.swing.JLabel();
		btnGuardar = new javax.swing.JLabel();
		btnCancelar = new javax.swing.JLabel();
		btnMinimizar = new javax.swing.JLabel();
		btnCerrar = new javax.swing.JLabel();
		jLabelNombreUsuario = new javax.swing.JLabel();
		campoNombreUsuario = new javax.swing.JTextField();
		jLabelCategoria = new javax.swing.JLabel();
		seleccionCategoriaUsuario = new javax.swing.JComboBox<>();
		jLabelPassword = new javax.swing.JLabel();
		campoPassword = new javax.swing.JPasswordField();

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

		jLabelIconoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelIconoUsuario
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/login.png")));

		jLabelTituloVentanaBuscar.setFont(new java.awt.Font("Segoe UI", 1, 24));
		jLabelTituloVentanaBuscar.setForeground(new java.awt.Color(12, 138, 199));
		jLabelTituloVentanaBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelTituloVentanaBuscar.setText("Registrar Usuario");

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

		jLabelNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelNombreUsuario.setForeground(new java.awt.Color(204, 204, 204));
		jLabelNombreUsuario.setText("Nombre Usuario:");

		campoNombreUsuario.setBackground(new java.awt.Color(60, 63, 65));
		campoNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoNombreUsuario.setForeground(new java.awt.Color(204, 204, 204));
		campoNombreUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoNombreUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));

		jLabelCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelCategoria.setForeground(new java.awt.Color(204, 204, 204));
		jLabelCategoria.setText("Categoría Usuario:");

		seleccionCategoriaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
		seleccionCategoriaUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Elija la categoría de Usuario", "Gerente", "Recepcionista" }));
		seleccionCategoriaUsuario.setBorder(javax.swing.BorderFactory
				.createEtchedBorder(new java.awt.Color(12, 138, 199), new java.awt.Color(12, 138, 199)));

		jLabelPassword.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelPassword.setForeground(new java.awt.Color(204, 204, 204));
		jLabelPassword.setText("Contraseña:");

		campoPassword.setBackground(new java.awt.Color(60, 63, 65));
		campoPassword.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoPassword.setForeground(new java.awt.Color(204, 204, 204));
		campoPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));

		javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
		panelPrincipal.setLayout(panelPrincipalLayout);
		panelPrincipalLayout
				.setHorizontalGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								panelPrincipalLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, 0).addComponent(
												btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout
								.createSequentialGroup().addContainerGap()
								.addGroup(panelPrincipalLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabelIconoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(panelPrincipalLayout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE)
												.addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(
												jLabelTituloVentanaBuscar, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
						.addGroup(panelPrincipalLayout.createSequentialGroup().addGap(131, 131, 131)
								.addGroup(panelPrincipalLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(panelPrincipalLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabelPassword).addComponent(campoPassword,
														javax.swing.GroupLayout.PREFERRED_SIZE, 250,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(panelPrincipalLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabelNombreUsuario).addComponent(campoNombreUsuario)
												.addComponent(jLabelCategoria).addComponent(seleccionCategoriaUsuario,
														javax.swing.GroupLayout.PREFERRED_SIZE, 250,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(136, Short.MAX_VALUE)));
		panelPrincipalLayout.setVerticalGroup(panelPrincipalLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelPrincipalLayout.createSequentialGroup()
						.addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabelIconoUsuario)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabelTituloVentanaBuscar)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabelNombreUsuario).addGap(10, 10, 10)
						.addComponent(campoNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabelCategoria)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(seleccionCategoriaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
						.addComponent(jLabelPassword)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(campoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelPrincipal,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
	}

	private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {
	    evt.consume();
	    String nombreUsuario = campoNombreUsuario.getText();
	    String categoriaUsuario = seleccionCategoriaUsuario.getSelectedItem().toString();

	    if (usuarioController.existeUsuario(nombreUsuario, categoriaUsuario)) {
	        // Si el usuario ya existe, muestra una alerta
	        JOptionPane.showMessageDialog(null, "El usuario ya existe.", "Usuario Existente",
	            JOptionPane.WARNING_MESSAGE);
	        // Limpia los campos y mantén la ventana abierta para agregar otro usuario
	        reestablecerCampos();
	    } else {
	        // Si el usuario no existe, procede a guardar
	        guardarUsuario();
			this.dispose();
			MenuUsuario menuUsuario = new MenuUsuario();
			menuUsuario.setVisible(true);


	    }

	}


	private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnGuardar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnGuardar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
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

	private void panelPrincipalMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	private void panelPrincipalMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
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
			java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		java.awt.EventQueue.invokeLater(() -> {
			new RegistrarUsuario().setVisible(true);
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel btnCancelar;
	private javax.swing.JLabel btnCerrar;
	private javax.swing.JLabel btnGuardar;
	private javax.swing.JLabel btnMinimizar;
	private javax.swing.JTextField campoNombreUsuario;
	private javax.swing.JPasswordField campoPassword;
	private javax.swing.JLabel jLabelCategoria;
	private javax.swing.JLabel jLabelIconoUsuario;
	private javax.swing.JLabel jLabelNombreUsuario;
	private javax.swing.JLabel jLabelPassword;
	private javax.swing.JLabel jLabelTituloVentanaBuscar;
	private javax.swing.JPanel panelPrincipal;
	private javax.swing.JComboBox<String> seleccionCategoriaUsuario;
	// End of variables declaration//GEN-END:variables
}

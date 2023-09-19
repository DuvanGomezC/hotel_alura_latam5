
package mx.com.alurahotel.view;

import mx.com.alurahotel.util.ColoresComponentesUtil;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;

import mx.com.alurahotel.controller.UsuarioController;
import mx.com.alurahotel.modelo.Usuario;
import mx.com.alurahotel.util.ValidarFormulariosUtil;
import seguridad.DatabaseSetup;

/**
 * @author duvan gomez 
 */

public class Login extends javax.swing.JFrame {

	int xMouse;
	int yMouse;
	private static Usuario usuario;
	private final UsuarioController usuarioController;

	static {
		DatabaseSetup.createTables();
	}

	public Login() {
		initComponents();
		this.usuarioController = new UsuarioController();
		configurarColoresComponentes();
		campoUsuario.requestFocus();
	}

	private void configurarColoresComponentes() {
		setBackground(ColoresComponentesUtil.TRANSPARENTE);
		panelFormularioLogin.setBackground(ColoresComponentesUtil.TRANSPARENTE);
		btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnCerrar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnLogin.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnCancelar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	public Usuario getUsuario() {
		if (Login.usuario == null) {
			throw new RuntimeException("Los campos usuario y" + "contraseña deben ser específicados.");
		}
		return Login.usuario;
	}

	public void setUsuario(Usuario usuario) {
		Login.usuario = usuario;
	}

	private void reestablecerCampos() {
		campoUsuario.setText("");
		campoContrasena.setText("");
	}

	private void validarUsuario() {
		String nombreUsuario = campoUsuario.getText();
		String password = String.valueOf(campoContrasena.getPassword());
		List<Usuario> listaUsuario = this.usuarioController.listar(nombreUsuario, password);
		if (listaUsuario.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectos.");
		} else {
			listaUsuario.forEach((usuario) -> {
				setUsuario(usuario);
			});
			if (ValidarFormulariosUtil.esUsuarioCorrecto(getUsuario(), nombreUsuario, campoContrasena)) {
				this.dispose();
				MenuUsuario menuUsuario = new MenuUsuario();
				menuUsuario.setVisible(true);
			}
		}
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
		jLabelBannerLogin = new javax.swing.JLabel();
		btnMinimizar = new javax.swing.JLabel();
		btnCerrar = new javax.swing.JLabel();
		panelFormularioLogin = new javax.swing.JPanel();
		jLabelIconoHotelAlura = new javax.swing.JLabel();
		jLabelTextoUsuario = new javax.swing.JLabel();
		campoUsuario = new javax.swing.JTextField();
		jLabelTextoContrasena = new javax.swing.JLabel();
		campoContrasena = new javax.swing.JPasswordField();
		btnLogin = new javax.swing.JLabel();
		btnCancelar = new javax.swing.JLabel();

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

		jLabelBannerLogin
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/hotel.png")));
		panelPrincipal.add(jLabelBannerLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 422, 540));

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
		panelPrincipal.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 60, 30));

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
		panelPrincipal.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 60, 30));

		jLabelIconoHotelAlura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelIconoHotelAlura
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/Ha-100px.png")));

		jLabelTextoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoUsuario.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoUsuario.setText("Usuario:");

		campoUsuario.setBackground(new java.awt.Color(60, 63, 65));
		campoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoUsuario.setForeground(new java.awt.Color(204, 204, 204));
		campoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));

		jLabelTextoContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoContrasena.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoContrasena.setText("Contraseña:");

		campoContrasena.setBackground(new java.awt.Color(60, 63, 65));
		campoContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoContrasena.setForeground(new java.awt.Color(204, 204, 204));
		campoContrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoContrasena.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199),
				new java.awt.Color(12, 138, 199)));

		btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 14));
		btnLogin.setForeground(new java.awt.Color(204, 204, 204));
		btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnLogin.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/mx/com/alurahotel/imagenes/perfil-del-usuario.png")));
		btnLogin.setText("Login");
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLogin.setOpaque(true);
		btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnLoginMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnLoginMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnLoginMouseExited(evt);
			}
		});

		btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14));
		btnCancelar.setForeground(new java.awt.Color(204, 204, 204));
		btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnCancelar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/cerrar-24px.png")));
		btnCancelar.setText("Cancelar");
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

		javax.swing.GroupLayout panelFormularioLoginLayout = new javax.swing.GroupLayout(panelFormularioLogin);
		panelFormularioLogin.setLayout(panelFormularioLoginLayout);
		panelFormularioLoginLayout.setHorizontalGroup(panelFormularioLoginLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelFormularioLoginLayout.createSequentialGroup().addContainerGap()
						.addGroup(panelFormularioLoginLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabelIconoHotelAlura, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(panelFormularioLoginLayout.createSequentialGroup().addGap(9, 9, 9)
										.addGroup(panelFormularioLoginLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(panelFormularioLoginLayout.createSequentialGroup()
														.addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE,
																96, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(59, 59, 59).addComponent(btnCancelar,
																javax.swing.GroupLayout.PREFERRED_SIZE, 96,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(campoContrasena).addComponent(campoUsuario)
												.addComponent(jLabelTextoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabelTextoContrasena,
														javax.swing.GroupLayout.PREFERRED_SIZE, 251,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 8, Short.MAX_VALUE)))
						.addContainerGap()));
		panelFormularioLoginLayout.setVerticalGroup(
				panelFormularioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelFormularioLoginLayout.createSequentialGroup().addGap(46, 46, 46)
								.addComponent(jLabelIconoHotelAlura).addGap(49, 49, 49).addComponent(jLabelTextoUsuario)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabelTextoContrasena)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(campoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(57, 57, 57)
								.addGroup(panelFormularioLoginLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(135, Short.MAX_VALUE)));

		panelPrincipal.add(panelFormularioLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 280, 540));

		getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 540));

		pack();
		setLocationRelativeTo(null);
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

	private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnLogin.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnLogin.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnCancelar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnCancelar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		reestablecerCampos();
		campoUsuario.requestFocus();
	}

	private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		validarUsuario();

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
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(() -> {
			new Login().setVisible(true);
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel btnCancelar;
	private javax.swing.JLabel btnCerrar;
	private javax.swing.JLabel btnLogin;
	private javax.swing.JLabel btnMinimizar;
	private javax.swing.JPasswordField campoContrasena;
	private javax.swing.JTextField campoUsuario;
	private javax.swing.JLabel jLabelBannerLogin;
	private javax.swing.JLabel jLabelIconoHotelAlura;
	private javax.swing.JLabel jLabelTextoContrasena;
	private javax.swing.JLabel jLabelTextoUsuario;
	private javax.swing.JPanel panelFormularioLogin;
	private javax.swing.JPanel panelPrincipal;
	// End of variables declaration//GEN-END:variables
}

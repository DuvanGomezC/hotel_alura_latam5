
package mx.com.alurahotel.view;

import mx.com.alurahotel.util.ColoresComponentesUtil;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * @author duvan gomez 
 */

public class MenuPrincipal extends javax.swing.JFrame {

	int xMouse;
	int yMouse;

	public MenuPrincipal() {

		initComponents();
		configurarColoresComponentes();
	}

	private void configurarColoresComponentes() {
		setBackground(ColoresComponentesUtil.TRANSPARENTE);
		panelMenuLogin.setBackground(ColoresComponentesUtil.TRANSPARENTE);
		btnCerrar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnLogin.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnSalir.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	@Override
	public Image getIconImage() {
		Image retImage = Toolkit.getDefaultToolkit()
				.getImage(ClassLoader.getSystemResource("mx/com/alurahotel/imagenes/Ha-100px.png"));
		return retImage;
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		panelPrincipal = new JPanelTransparente();
		btnCerrar = new javax.swing.JLabel();
		btnMinimizar = new javax.swing.JLabel();
		jLabelAutor = new javax.swing.JLabel();
		jLabelBannerMenuPrincipal = new javax.swing.JLabel();
		panelMenuLogin = new javax.swing.JPanel();
		jLabelIconoHotel = new javax.swing.JLabel();
		jLabelTextoLogin = new javax.swing.JLabel();
		btnLogin = new javax.swing.JLabel();
		btnSalir = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(0, 0, 894, 501);
		setIconImage(getIconImage());
		setMinimumSize(new java.awt.Dimension(910, 537));
		setUndecorated(true);
		setResizable(false);
		setSize(new java.awt.Dimension(910, 537));

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

		jLabelAutor.setBackground(new java.awt.Color(12, 138, 199));
		jLabelAutor.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelAutor.setForeground(new java.awt.Color(204, 204, 204));
		jLabelAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelAutor.setText("Desarrollado por Duvan Gomez © 2023");
		jLabelAutor.setOpaque(true);
		panelPrincipal.add(jLabelAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 910, 30));

		jLabelBannerMenuPrincipal
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/menu-img.png")));
		panelPrincipal.add(jLabelBannerMenuPrincipal,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 510));

		panelMenuLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabelIconoHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelIconoHotel
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/aH-150px.png")));
		panelMenuLogin.add(jLabelIconoHotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 180, 170));

		jLabelTextoLogin.setFont(new java.awt.Font("Segoe UI", 1, 18));
		jLabelTextoLogin.setForeground(new java.awt.Color(12, 138, 199));
		jLabelTextoLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelTextoLogin.setText("Login");
		panelMenuLogin.add(jLabelTextoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 176, 190, 40));

		btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/login.png")));
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
		panelMenuLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 190, 80));

		btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnSalir.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/mx/com/alurahotel/imagenes/cerrar-sesion 32-px.png")));
		btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSalir.setOpaque(true);
		btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnSalirMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnSalirMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnSalirMouseExited(evt);
			}
		});
		panelMenuLogin.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 60, 40));

		panelPrincipal.add(panelMenuLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 190, 480));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelPrincipal,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelPrincipal,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
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

	private void btnMinimizarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnCerrar.setBackground(ColoresComponentesUtil.ROJO_OSCURO);
	}

	private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnCerrar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnMinimizarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnLogin.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnLogin.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		this.setExtendedState(ICONIFIED);
	}

	private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {
		Mensaje.confirmarSalida(evt);
	}

	private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		this.dispose();
		Login login = new Login();
		login.setVisible(true);
	}

	private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {
		Mensaje.confirmarSalida(evt);
	}

	private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnSalir.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnSalir.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
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
			java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(() -> {
			new MenuPrincipal().setVisible(true);
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel btnCerrar;
	private javax.swing.JLabel btnLogin;
	private javax.swing.JLabel btnMinimizar;
	private javax.swing.JLabel btnSalir;
	private javax.swing.JLabel jLabelAutor;
	private javax.swing.JLabel jLabelBannerMenuPrincipal;
	private javax.swing.JLabel jLabelIconoHotel;
	private javax.swing.JLabel jLabelTextoLogin;
	private javax.swing.JPanel panelMenuLogin;
	private javax.swing.JPanel panelPrincipal;
	// End of variables declaration//GEN-END:variables
}

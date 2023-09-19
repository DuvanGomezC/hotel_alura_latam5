
package mx.com.alurahotel.view;

import mx.com.alurahotel.util.ColoresComponentesUtil;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * @author duvan gomez 
 */

public class MenuUsuario extends javax.swing.JFrame {

	int xMouse;
	int yMouse;
	private static final Login login = new Login();

	public MenuUsuario() {
		initComponents();
		configurarComponentes();
	}

	private void configurarComponentes() {
		setBackground(ColoresComponentesUtil.TRANSPARENTE);
		panelMenuUsuario.setBackground(ColoresComponentesUtil.TRANSPARENTE);
		btnCerrar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnReservas.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnBusqueda.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnUsuario.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		btnRegresar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
		jLabelBienvenidaUsuario.setText("Bienvenido(a) " + login.getUsuario().getNombreUsuario());
		esGerente();
		alternarVisualizacionMenu();
	}

	public static boolean esGerente() {
		String categoriaUsuario = "Gerente";
		String categoriaUsuarioActual = login.getUsuario().getCategoriaUsuario();
		return categoriaUsuarioActual.equals(categoriaUsuario);
	}

	private void alternarVisualizacionMenu() {
		if (esGerente()) {
			jLabelTextoUsuario.setVisible(true);
			btnUsuario.setVisible(true);
		} else {
			jLabelTextoUsuario.setVisible(false);
			btnUsuario.setVisible(false);
		}
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
		btnRegresar = new javax.swing.JLabel();
		jLabelBienvenidaUsuario = new javax.swing.JLabel();
		jLabelBannerMenuPrincipal = new javax.swing.JLabel();
		panelMenuUsuario = new javax.swing.JPanel();
		jLabelIconoHotel = new javax.swing.JLabel();
		jLabelTextoReservas = new javax.swing.JLabel();
		btnReservas = new javax.swing.JLabel();
		jLabelTextoUsuario = new javax.swing.JLabel();
		btnBusqueda = new javax.swing.JLabel();
		jLabelTextoBusqueda = new javax.swing.JLabel();
		btnUsuario = new javax.swing.JLabel();

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

		btnRegresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnRegresar.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/mx/com/alurahotel/imagenes/cerrar-sesion 32-px.png")));
		btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnRegresar.setOpaque(true);
		btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnRegresarMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnRegresarMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnRegresarMouseExited(evt);
			}
		});
		panelPrincipal.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 500, 60, 40));

		jLabelBienvenidaUsuario.setBackground(new java.awt.Color(12, 138, 199));
		jLabelBienvenidaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelBienvenidaUsuario.setForeground(new java.awt.Color(204, 204, 204));
		jLabelBienvenidaUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelBienvenidaUsuario.setOpaque(true);
		panelPrincipal.add(jLabelBienvenidaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 910, 30));

		jLabelBannerMenuPrincipal
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/menu-img.png")));
		panelPrincipal.add(jLabelBannerMenuPrincipal,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 510));

		panelMenuUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabelIconoHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelIconoHotel
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/aH-150px.png")));
		panelMenuUsuario.add(jLabelIconoHotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 180, 170));

		jLabelTextoReservas.setFont(new java.awt.Font("Segoe UI", 1, 18));
		jLabelTextoReservas.setForeground(new java.awt.Color(12, 138, 199));
		jLabelTextoReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelTextoReservas.setText("Reservas");
		panelMenuUsuario.add(jLabelTextoReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 20));

		btnReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnReservas
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/reservas.png")));
		btnReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnReservas.setOpaque(true);
		btnReservas.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnReservasMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnReservasMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnReservasMouseExited(evt);
			}
		});
		panelMenuUsuario.add(btnReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 190, 70));

		jLabelTextoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18));
		jLabelTextoUsuario.setForeground(new java.awt.Color(12, 138, 199));
		jLabelTextoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelTextoUsuario.setText("Usuario");
		panelMenuUsuario.add(jLabelTextoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 190, 20));

		btnBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnBusqueda
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/busqueda.png")));
		btnBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBusqueda.setOpaque(true);
		btnBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnBusquedaMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnBusquedaMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnBusquedaMouseExited(evt);
			}
		});
		panelMenuUsuario.add(btnBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 190, 70));

		jLabelTextoBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 18));
		jLabelTextoBusqueda.setForeground(new java.awt.Color(12, 138, 199));
		jLabelTextoBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelTextoBusqueda.setText("Búsqueda");
		panelMenuUsuario.add(jLabelTextoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 20));

		btnUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/login.png")));
		btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnUsuario.setOpaque(true);
		btnUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnUsuarioMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnUsuarioMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnUsuarioMouseExited(evt);
			}
		});
		panelMenuUsuario.add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 190, 70));

		panelPrincipal.add(panelMenuUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 190, 480));

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

	private void btnReservasMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		this.dispose();
		Reservas reservas = new Reservas();
		reservas.setVisible(true);
	}

	private void btnReservasMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnReservas.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnReservasMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnReservas.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
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

	private void btnBusquedaMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		this.dispose();
		Busqueda busqueda = new Busqueda();
		busqueda.setVisible(true);
	}

	private void btnBusquedaMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnBusqueda.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnBusquedaMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnBusqueda.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnRegresar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnRegresar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
	}

	private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		this.dispose();
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.setVisible(true);
	}

	private void btnUsuarioMouseClicked(java.awt.event.MouseEvent evt) {
		evt.consume();
		this.dispose();
		RegistrarUsuario registrarUsuario = new RegistrarUsuario();
		registrarUsuario.setVisible(true);
	}

	private void btnUsuarioMouseEntered(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnUsuario.setBackground(ColoresComponentesUtil.GRIS_CLARO);
	}

	private void btnUsuarioMouseExited(java.awt.event.MouseEvent evt) {
		evt.consume();
		btnUsuario.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
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
			java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(() -> {
			new MenuUsuario().setVisible(true);
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel btnBusqueda;
	private javax.swing.JLabel btnCerrar;
	private javax.swing.JLabel btnMinimizar;
	private javax.swing.JLabel btnRegresar;
	private javax.swing.JLabel btnReservas;
	private javax.swing.JLabel btnUsuario;
	private javax.swing.JLabel jLabelBannerMenuPrincipal;
	private javax.swing.JLabel jLabelBienvenidaUsuario;
	private javax.swing.JLabel jLabelIconoHotel;
	private javax.swing.JLabel jLabelTextoBusqueda;
	private javax.swing.JLabel jLabelTextoReservas;
	private javax.swing.JLabel jLabelTextoUsuario;
	private javax.swing.JPanel panelMenuUsuario;
	private javax.swing.JPanel panelPrincipal;
	// End of variables declaration//GEN-END:variables
}

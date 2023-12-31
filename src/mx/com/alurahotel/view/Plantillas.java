
package mx.com.alurahotel.view;

/**
 * @author duvan gomez 
 */

public class Plantillas extends javax.swing.JFrame {

	public Plantillas() {
		initComponents();
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		campoUsuario = new javax.swing.JTextField();
		jLabelTextoUsuario = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		campoUsuario.setBackground(new java.awt.Color(60, 63, 65));
		campoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
		campoUsuario.setForeground(new java.awt.Color(204, 204, 204));
		campoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		campoUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 100, 155),
				new java.awt.Color(0, 100, 155)));

		jLabelTextoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabelTextoUsuario.setForeground(new java.awt.Color(204, 204, 204));
		jLabelTextoUsuario.setText("Usuario:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(74, 74, 74)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabelTextoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(campoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
						.addGap(75, 75, 75)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(103, Short.MAX_VALUE).addComponent(jLabelTextoUsuario)
						.addGap(39, 39, 39)
						.addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(114, 114, 114)));

		pack();
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Plantillas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Plantillas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Plantillas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Plantillas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Plantillas().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField campoUsuario;
	private javax.swing.JLabel jLabelTextoUsuario;
	// End of variables declaration//GEN-END:variables
}

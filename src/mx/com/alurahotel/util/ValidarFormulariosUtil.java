
package mx.com.alurahotel.util;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import mx.com.alurahotel.modelo.Usuario;

/**
 * @author duvan gomez 
 */

public class ValidarFormulariosUtil {

	public static boolean esFormularioHuespedValido(String nombre, String apellido, JDateChooser fechaNac, String tel) {
		String regexNombre = "^[a-zA-ZÃ?Ã‰Ã?Ã“ÃšÃ‘Ã±\\s]{3,25}$";
		String regexTel = "^[0-9]{1,14}$";
		Pattern patternNombre = Pattern.compile(regexNombre);
		Pattern patternTelefono = Pattern.compile(regexTel);
		Matcher matchNombre = patternNombre.matcher(nombre);
		Matcher matchApellido = patternNombre.matcher(apellido);
		Matcher matchTelefono = patternTelefono.matcher(tel);
		if (!matchNombre.find()) {
			desplegarMensajeError("Nombre invalido", "1. El nombre debe contener solo letras, espacios y tildes.\n"
					+ "2. La longitud debe estar entre 3 y 25 caracteres.");
			return false;
		} else if (!matchApellido.find()) {
			desplegarMensajeError("Apellido invÃ¡lido.",
					"1. El apellido debe contener solo letras, espacios y tildes.\n"
							+ "2. La longitud debe estar entre 3 y 25 caracteres.");
			return false;
		} else if ((fechaNac.getDate() == null)) {
			desplegarMensajeError("Fecha invalida.", "El campo fecha esta vacio.");
			return false;
		} else if (esMayorDeEdad(fechaNac.getDate())) {
			desplegarMensajeError("Fecha invalida", "No se puede realizar el registro ya que es menor de edad.");
			return false;
		} else if (!matchTelefono.find()) {
			desplegarMensajeError("Telefono invalido.",
					"El formato admitido debe contener de 1 a 14 digitos, sin guiones ni otros caracteres.");
			return false;
		} else {
			return true;
		}
	}

	public static boolean esFormularioReservaValido(JDateChooser fechaEntrada, JDateChooser fechaSalida, String valor,
			JComboBox<String> formaPago) {
		if ((fechaEntrada.getDate() == null) && (fechaSalida.getDate() == null)) {
			desplegarMensajeError("Fechas invalidas.", "Por favor, seleccione las fechas de entrada y salida.\n"
					+ "Puede escribir la fecha manualmente si cumple con el siguiente formato:\n" + "dd/mm/yyyy");
			return false;
		} else if (valor.equals("0.0")) {
			desplegarMensajeError("Valor de reserva en cero.", "Por favor, seleccione las fechas de entrada y salida\n"
					+ "para efectuar el total monetario de la reserva.");
			return false;
		} else if (formaPago.getSelectedIndex() == 0) {
			desplegarMensajeError("Seleccion de pago invalida.", "Por favor, seleccione una forma de pago.");
			return false;
		} else {
			return true;
		}
	}

	public static boolean esFormularioUsuarioValido(String nombreUsuario, JComboBox<String> categoriaUsuario,
			JPasswordField password) {
		if (nombreUsuario.isEmpty()) {
			desplegarMensajeError("Nombre de Usuario invalido.", "El campo nombre de usuario esta vacio.");
			return false;
		} else if (categoriaUsuario.getSelectedIndex() == 0) {
			desplegarMensajeError("Categoria de Usuario invalida.", "Seleccione una categoria de usuario.");
			return false;
		} else if (password.getPassword().length == 0) {
			desplegarMensajeError("Contraseña invalida.", "El campo contraseña esta¡ vacio.");
			return false;
		} else if (password.getPassword().length > 30) {
			desplegarMensajeError("Contraseña invalida.",
					"La contraseña es demadiado larga, solo\n" + "debe tener 30 caracteres.");
			return false;
		} else {
			return true;
		}
	}

	public static boolean esUsuarioCorrecto(Usuario usuario, String nombreUsuario, JPasswordField password) {
		if (!nombreUsuario.equals(usuario.getNombreUsuario())) {
			desplegarMensajeError("Usuario incorrecto.", "El usuario ingresado es incorrecto.");
			return false;
		} else if (String.valueOf(password.getPassword()).equals(usuario.getPassword())) {
			desplegarMensajeError("Contraseña incorrecta.", "La contraseña ingresada es incorrecta.");
			return false;
		} else {
			return true;
		}
	}

	public static void numeros(KeyEvent evt) {
		char car = evt.getKeyChar();
		if ((car < '0' || car > '9') && (car != '.') && (car != '-')) {
			evt.consume();
		}
	}

	public static boolean esMayorDeEdad(Date fechaNacimiento) {
		LocalDate fechaNac = ConvertirFecha.convertirDateALocalDate(fechaNacimiento);
		LocalDate fechaActual = LocalDate.now();
		long diferenciaYears = ChronoUnit.YEARS.between(fechaNac, fechaActual);
		return diferenciaYears < 18;
	}

	public static void desplegarMensajeError(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
}


package mx.com.alurahotel.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author duvan gomez 
 */

public class ConvertirFecha {

	public static LocalDate convertirDateALocalDate(Date fechaAConvertir) {
		return fechaAConvertir.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}

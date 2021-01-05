package Filtri;

import MeteoDati.Vento;
import java.util.Vector;

/**
 * Definizione dell' interfaccia il cui metodo verrà definito dalle classi del package Filtri
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public interface Filtraggio {
	
	/**
	 * @return Vector filtrato
	 */
	public Vector<Vento> filtro();
}

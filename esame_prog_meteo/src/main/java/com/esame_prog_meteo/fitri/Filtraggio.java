/**
 * Package che contiene tutte le classi utili al filtraggio dei dati.
 */
package com.esame_prog_meteo.fitri;

import java.util.Vector;
import com.esame_prog_meteo.meteodati.Vento;

/**
 * Interfaccia che definisce il metodo filtro. Questo metodo restituisce un
 * vettore di oggetti vento filtrati in base all'implemetazione del metodo
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public interface Filtraggio {
	/**
	 * Filtra un vettore in base all'implementazione del metodo nelle classi che
	 * implementano l'interfaccia.
	 * 
	 * @return Vector Rappresenta la collezione di oggetti filtrati adeguatamente in
	 *         base al metodo
	 */
	public Vector<Vento> filtro();
}

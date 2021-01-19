package com.esame_prog_meteo.fitri;

import java.util.Vector;

import com.esame_prog_meteo.meteodati.Vento;

/**
 * Classe che restituisce il vettore filtrato settimanalmente
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class FiltroSettimanale implements Filtraggio {
	/**
	 * Vettore che contiene tutti i dati registrati dall'avvio dell'applicazione.
	 */
	protected Vector<Vento> info;

	/**
	 * Costruttore della classe
	 * 
	 * @param info Vettore che contiene tutti i dati registrati dall'avvio
	 *             dell'applicazione.
	 */
	public FiltroSettimanale(Vector<Vento> info) {
		this.info = info;
	}

	/**
	 * Ritorna un vettore di oggetti Vento riguardanti le registrazioni orarie fatte
	 * soltanto nell'ultima settimana trascorsa.
	 * 
	 * @return settimanale Vettore filtrato, contenente i dati dell'ultima settimana
	 *         trascorsa.
	 * @throws ArrayIndexOutOfBoundsException Se si tenta di analizzare l'array
	 *                                        fuori dalla sua grandezza.
	 */
	public Vector<Vento> filtro() throws ArrayIndexOutOfBoundsException {
		Vector<Vento> settimanale = new Vector<Vento>();

		for (int i = info.size() - 1; i > info.size() - (24 * 7); i--) {

			try {
				settimanale.add(info.elementAt(i));

			} catch (ArrayIndexOutOfBoundsException e) {

				throw new ArrayIndexOutOfBoundsException("Non abbiamo sufficenti registrazioni");

			}
		}
		return settimanale;
	}
}
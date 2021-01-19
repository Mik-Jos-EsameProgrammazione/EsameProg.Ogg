package com.esame_prog_meteo.fitri;

import java.util.Vector;

import com.esame_prog_meteo.meteodati.Vento;

/**
 * Classe che restituisce il vettore filtrato mensilmente
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class FiltroMensile implements Filtraggio {
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
	public FiltroMensile(Vector<Vento> info) {
		this.info = info;
	}

	/**
	 * Ritorna un vettore di oggetti Vento riguardanti le registrazioni orarie fatte
	 * soltanto nell'ultimo mese trascorso.
	 * 
	 * @return mensile Vettore filtrato, contenente i dati dell'ultimo mese
	 *         trascorso.
	 * @throws ArrayIndexOutOfBoundsException Se si tenta di analizzare l'array
	 *                                        fuori dalla sua grandezza.
	 */
	public Vector<Vento> filtro() throws ArrayIndexOutOfBoundsException {
		Vector<Vento> mensile = new Vector<Vento>();

		for (int i = info.size() - 1; i > info.size() - (24 * 30); i--) {
			try {

				mensile.add(info.elementAt(i));

			} catch (ArrayIndexOutOfBoundsException e) {

				throw new ArrayIndexOutOfBoundsException("Non abbiamo sufficenti registrazioni");

			}
		}
		return mensile;
	}
}
/**
 * Package che contiene le classi d'eccezione necessarie all'applicazione.
 */
package com.esame_prog_meteo.exception;
	/**
	 * Viene lanciata quando l'array è vuoto e la classe non lo permette
	 * @author Joshua Ciccolini
	 * @author Michele Di Renzo
	 */
public class EmptyArrayException extends ArrayStoreException {
	/**
	 * Costruttore della classe
	 */
	public EmptyArrayException() {
		super();
	}
	
	/**
	 * Costruttore della classe com messaggio
	 * @param msg messaggio da mostrare
	 */
	public EmptyArrayException(String msg) {
		super(msg);
	}
}

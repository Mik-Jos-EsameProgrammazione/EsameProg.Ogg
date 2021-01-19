package com.esame_prog_meteo.exception;
/**
 * Eccezione che viene lanciata quando un nome non ha il fromato giusto
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class InvalidNameException extends IllegalArgumentException{
	/**
	 *Costruttore della classe con messaggio
	 * @param msg messaggio da mostrare
	 */
	public InvalidNameException(String msg) {
		super(msg);
	}
	/**
	 * Costruttore della classe
	 */
	public InvalidNameException() {
		super();
	}
}

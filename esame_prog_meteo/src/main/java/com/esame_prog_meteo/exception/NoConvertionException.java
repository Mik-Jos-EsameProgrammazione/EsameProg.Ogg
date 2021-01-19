package com.esame_prog_meteo.exception;
	/**
	 * Viene lanciata quando esiste qualche errore di conversione
	 * @author Joshua Ciccolini
	 * @author Michele Di Renzo
	 */
public class NoConvertionException extends Exception{
	/**
	 * Indice dove viene rilevato l'errore
	 */
	private static int errorPosition;
	/**
	 * Costruttore della classe
	 */
	public NoConvertionException() {
		super();
	}
	/**
	 * Costruttore della classe con indice di errore
	 * @param errorPosition indice dove viene rilevato l'errore
	 */
	public NoConvertionException(int errorPosition) {
		super();
		this.errorPosition=errorPosition;
	}
	/**
	 * Costruttore della classe con indice di errore e messaggio
	 * @param msg messaggio da mostrare 
	 * @param errorPosition indice dove viene rilevato l'errore
	 */
	public NoConvertionException(String msg, int errorPosition) {
		super(msg);
		this.errorPosition=errorPosition;
	}
	/**
	 * Costruttore della classe con messaggio 
	 * @param msg messaggio da mostrare
	 */
	public NoConvertionException(String msg) {
		super(msg);
	}
	/**
	 * Permette di impostare l'indice di errore
	 * @param errorPosition indice dove viene rilevato l'errore
	 */ 
	public void setErrorPosition(int errorPosition) {
		this.errorPosition= errorPosition;
	}
	/**
	 * Restituisce l'indice di errore
	 * @return int indice dove viene rilevato l'errore
	 */
	public int getErrorPosition() {
		return errorPosition;
	}
}

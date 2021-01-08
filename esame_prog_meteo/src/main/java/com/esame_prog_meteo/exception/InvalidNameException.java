package com.esame_prog_meteo.exception;

public class InvalidNameException extends IllegalArgumentException{
	/**
	 * Eccezione che viene lanciata quando un nome non ha il fromato giusto
	 * @param msg
	 */
	public InvalidNameException(String msg) {
		super(msg);
	}
	
	public InvalidNameException() {
		super();
	}
}

package com.esame_prog_meteo.exception;

public class EmptyArrayException extends ArrayStoreException {
	
	public EmptyArrayException() {
		super();
	}
	
	public EmptyArrayException(String msg) {
		super(msg);
	}
}

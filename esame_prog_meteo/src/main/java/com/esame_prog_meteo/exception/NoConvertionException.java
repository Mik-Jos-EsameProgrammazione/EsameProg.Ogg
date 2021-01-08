package com.esame_prog_meteo.exception;

public class NoConvertionException extends Exception{
	private static int errorPosition;
	
	public NoConvertionException() {
		super();
	}
	
	public NoConvertionException(int errorPosition) {
		super();
		this.errorPosition=errorPosition;
	}
	
	public NoConvertionException(String msg, int errorPosition) {
		super(msg);
		this.errorPosition=errorPosition;
	}
	
	public NoConvertionException(String msg) {
		super(msg);
	}
	
	public void setErrorPosition(int errorPosition) {
		this.errorPosition= errorPosition;
	}
	
	public int getErrorPosition() {
		return errorPosition;
	}
}

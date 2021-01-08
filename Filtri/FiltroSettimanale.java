package com.esame_prog_meteo.Filtri;

import com.esame_prog_meteo.MeteoDati.*;
import java.util.Vector;

/**
 * E' la classe che definisce il metodo (dell' interfaccia) per il filtraggio settimanale.
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class FiltroSettimanale implements Filtraggio{
	protected Vector<Vento> info;

	/**
	 * Costruttore 
	 * @param info
	 */
	
	public FiltroSettimanale(Vector<Vento> info) {
		this.info = info;
	}
	
	/**
	 * @throws ArrayIndexOutOfBoundsException
	 * @return il vettore filtrato settimanalmente.
	 */
	
	public Vector<Vento> filtro() throws ArrayIndexOutOfBoundsException{
		Vector<Vento> settimanale = new Vector<Vento>();
		for(int i = info.size() - 1; i > info.size() - (24 * 7); i--)
		{
			try {
				settimanale.add(info.elementAt(i));
			}
			catch (ArrayIndexOutOfBoundsException e) {
				throw new ArrayIndexOutOfBoundsException("Non abbiamo sufficienti registrazioni");
			}
		}
		return settimanale;
	}
}

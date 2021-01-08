package com.esame_prog_meteo.Filtri;

import com.esame_prog_meteo.MeteoDati.*;
import java.util.Vector;

/**
 * E' la classe che definisce il metodo (dell' interfaccia) per il filtraggio mensile.
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class FiltroMensile implements Filtraggio{
	protected Vector<Vento> info;

	/**
	 * Costruttore 
	 * @param info
	 */
	
	public FiltroMensile(Vector<Vento> info) {
		this.info = info;
	}

	/**
	 * @throws ArrayIndexOutOfBoundsException
	 * @return il vettore filtrato mensilmente
	 */
	
	public Vector<Vento> filtro() throws ArrayIndexOutOfBoundsException{
		Vector<Vento> mensile = new Vector<Vento>();
		for(int i = info.size() - 1; i > info.size() - (24 * 30); i--)
		{
			try {
			mensile.add(info.elementAt(i));
			}
			catch (ArrayIndexOutOfBoundsException e) {
				throw new ArrayIndexOutOfBoundsException("Non abbiamo sufficienti registrazioni");
			}
		}
		return mensile;
	}
}

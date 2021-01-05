package Filtri;

import MeteoDati.*;
import java.util.Vector;

/**
 * E' la classe che definisce il metodo (dell' interfaccia) per il filtraggio giornaliero.
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class FiltroGiornaliero implements Filtraggio{
	protected Vector<Vento> info;
	
	/**
	 * Costruttore
	 * @param info
	 */
	public FiltroGiornaliero(Vector<Vento> info) {
		this.info = info;	
	}
	
	/**
	 * @throws ArrayIndexOutOfBoundsException
	 * @return il vettore filtrato giornalmente
	 */
	
	public Vector<Vento> filtro() throws ArrayIndexOutOfBoundsException{
		Vector<Vento> giornaliero = new Vector<Vento>();
		for(int i = info.size() - 1; i > info.size() - 24; i--)
		{
			try {
				giornaliero.add(info.elementAt(i));
			}
			catch (ArrayIndexOutOfBoundsException e) {
				throw new ArrayIndexOutOfBoundsException("Non abbiamo sufficienti registrazioni");
			}
		}
		return giornaliero;
	}
}

package Filtri;

import java.util.*;
import MeteoDati.*;

public class FiltroGiornaliero implements Filtraggio{
	protected Vector<Vento> info;
	
	public FiltroGiornaliero(Vector<Vento> info) {
		this.info = info;	
	}
	
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

package Filtri;

import java.util.*;
import MeteoDati.*;

public class FiltroMensile implements Filtraggio{
	protected Vector<Vento> info;

	public FiltroMensile(Vector<Vento> info) {
		this.info = info;
	}

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
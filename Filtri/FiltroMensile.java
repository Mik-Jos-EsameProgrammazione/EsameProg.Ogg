package Filtri;

import java.util.*;
import MeteoDati.*;

public class FiltroMensile implements Filtraggio{
	protected Vector<Vento> info;

	public FiltroMensile(Vector<Vento> info) {
		this.info = info;
	}

	public Vector<Vento> filtro(){
		Vector<Vento> mensile = new Vector<Vento>();
		for(int i = info.size() - 1; i > info.size() - (24 * 30); i--)
		{
			mensile.add(info.elementAt(i));
		}
		return mensile;
	}
}
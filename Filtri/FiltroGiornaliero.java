package Filtri;

import java.util.*;
import MeteoDati.*;

public class FiltroGiornaliero {
	protected Vector<Vento> info;
	
	public FiltroGiornaliero(Vector<Vento> info) {
		this.info = info;	
	}
	
	public Vector<Vento> filtro(){
		Vector<Vento> giornaliero = new Vector<Vento>();
		for(int i = info.size() - 1; i > info.size() - 24; i--)
		{
			giornaliero.add(info.elementAt(i));
		}
		return giornaliero;
	}
}

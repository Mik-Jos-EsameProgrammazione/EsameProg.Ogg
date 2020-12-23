package Filtri;

import java.util.*;
import MeteoDati.*;

public class FiltroSettimanale {
	protected Vector<Vento> info;

	public FiltroSettimanale(Vector<Vento> info) {
		this.info = info;
	}
	
	public Vector<Vento> filtro(){
		Vector<Vento> settimanale = new Vector<Vento>();
		for(int i = info.size() - 1; i > info.size() - (24 * 7); i--)
		{
			settimanale.add(info.elementAt(i));
		}
		return settimanale;
	}
}

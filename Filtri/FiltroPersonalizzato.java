package Filtri;

import java.util.*;
import MeteoDati.*;

public class FiltroPersonalizzato {
	protected Vector<Vento> info;

	public FiltroPersonalizzato(Vector<Vento> info) {
		this.info = info;
	}
	
	public Vector<Vento> cicloForFiltro(int x) {
		Vector<Vento> personalizzato = new Vector<Vento>();
		for(int i = info.size() - 1; i > info.size() - x; i--) {
			personalizzato.add(info.elementAt(i));
		}
		return personalizzato;
	}
	
	public Vector<Vento> filtroPersonalizzato(String filtra){ 
		String[] appoggioFiltro = filtra.split("_");
		int x = Integer.parseInt(appoggioFiltro[0]);
		switch(appoggioFiltro[1]) {
		case "giorni":
			return cicloForFiltro(24 * x);
		case "settimane":
			return cicloForFiltro(24 * x * 7);
		case "mesi":
			return cicloForFiltro(24 * x * 30);
		case "anni":
			return cicloForFiltro(24 * x * 365);
		}
		return null;
	}
}
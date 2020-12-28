package Filtri;

import java.util.*;
import java.util.regex.PatternSyntaxException;
import MeteoDati.*;


public class FiltroPersonalizzato {
	protected Vector<Vento> info;

	public FiltroPersonalizzato(Vector<Vento> info) {
		this.info = info;
	}
	
	public Vector<Vento> cicloForFiltro(int x) throws ArrayIndexOutOfBoundsException{
		Vector<Vento> personalizzato = new Vector<Vento>();
		for(int i = info.size() - 1; i > info.size() - x; i--) {
			try {
				personalizzato.add(info.elementAt(i));
			}
			catch (ArrayIndexOutOfBoundsException e) {
				throw new ArrayIndexOutOfBoundsException("Non abbiamo sufficienti registrazioni");
			}
		}
		return personalizzato;
	}
	
	public Vector<Vento> filtroPersonalizzato(String filtra) throws PatternSyntaxException, NumberFormatException{ 
		String[] appoggioFiltro;
		int x;
		try {
			appoggioFiltro = filtra.split("_");
			x = Integer.parseInt(appoggioFiltro[0]);
		}
		catch (PatternSyntaxException e){
			throw new PatternSyntaxException("Inserisci un filtro regolare", "_", -1);
		}
		catch (NumberFormatException e) {
			throw new NumberFormatException("Non è possibile convertire la stringa in intero");
		}
		try {
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
		}
		catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Non abbiamo sufficienti registrazioni");
		}
		return null;
	}
}
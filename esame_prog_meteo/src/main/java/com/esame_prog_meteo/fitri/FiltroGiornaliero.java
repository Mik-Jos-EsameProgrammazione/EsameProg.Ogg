package com.esame_prog_meteo.fitri;


import java.util.Vector;
import com.esame_prog_meteo.model.Vento;

/**
 * Classe che restituisce il vettore filtrato giornalmente
 * @author joshuaciccolini
 *
 */
public class FiltroGiornaliero implements Filtraggio{
	protected Vector<Vento> info;
	
	/**
	 * Costruttore della classe.
	 * @param info
	 */
	public FiltroGiornaliero(Vector<Vento> info) {
		this.info = info;	
	}
	/**
	 * Ritorna un vettore di oggetti Vento riguardanti le registrazioni orarie fatte soltanto nell'ultimo giorno trascorso
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public Vector<Vento> filtro() throws ArrayIndexOutOfBoundsException{
		Vector<Vento> giornaliero = new Vector<Vento>();
		for(int i = info.size() - 1; i > info.size() - 24; i--){
			try {
				giornaliero.add(info.elementAt(i));
				}catch(ArrayIndexOutOfBoundsException e) {
					throw new ArrayIndexOutOfBoundsException("Non abbiamo sufficenti registrazioni");			
					}
			}
		return giornaliero;
	}
}


package com.esame_prog_meteo.fitri;

import java.util.Vector;
import com.esame_prog_meteo.model.Vento;
/**
 * Classe che restituisce il vettore filtrato mensilmente
 * @author joshuaciccolini
 *
 */
public class FiltroMensile implements Filtraggio{
	protected Vector<Vento> info;
	/**
	 * Costruttore della classe
	 * @param info
	 */
	public FiltroMensile(Vector<Vento> info) {
		this.info = info;
	}
	/**
	 * Ritorna un vettore di oggetti Vento riguardanti le registrazioni orarie fatte soltanto nell'ultimo mese trascorso
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public Vector<Vento> filtro()throws ArrayIndexOutOfBoundsException{
		Vector<Vento> mensile = new Vector<Vento>();
		for(int i = info.size() - 1; i > info.size() - (24 * 30); i--){
			try {
				mensile.add(info.elementAt(i));
				}catch(ArrayIndexOutOfBoundsException e) {
					throw new ArrayIndexOutOfBoundsException("Non abbiamo sufficenti registrazioni");
					}
			}
		return mensile;
	}
}
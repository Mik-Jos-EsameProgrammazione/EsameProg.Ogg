package com.esame_prog_meteo.statistiche;

import java.util.Vector;

import com.esame_prog_meteo.meteodati.Vento;

import java.util.Iterator;

/**
 * Classe che implementa l'interfaccia StatsInterface e restituisce il valore
 * della velocita minima del vento.
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class StatVelocitaMin implements StatsInterface {

	/**
	 * Implementa il metodo dell'interfaccia e restituisce il valore della
	 * statistica relativa alla velocita minima
	 * 
	 * @param infoVento Vettore su cui calcolare la statistiche.
	 * @return velMin Valore della velocita minima del vento.
	 */
	public float getRisStats(Vector<Vento> infoVento) {
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		x = infoVento.elementAt(0);
		float velMin = x.getVelocita();
		x = i.next();

		while (i.hasNext()) {

			x = i.next();
			if (x.getVelocita() < velMin)
				velMin = x.getVelocita();

		}
		return velMin;
	}
}




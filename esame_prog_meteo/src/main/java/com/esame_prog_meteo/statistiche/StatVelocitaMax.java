package com.esame_prog_meteo.statistiche;

import java.util.Vector;

import com.esame_prog_meteo.meteodati.Vento;

import java.util.Iterator;

/**
 * Classe che implementa l'interfaccia StatsInterface e restituisce il valore
 * della velocià massima del vento.
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class StatVelocitaMax implements StatsInterface {
	/**
	 * implementa il metodo dell'interfaccia e restituisce il valore della
	 * statistica relativa alla velocita massima
	 * 
	 * @param infoVento Vettore su cui calcolare le statistiche.
	 * @return velMax Valore della velocita massima del vento.
	 */
	public float getRisStats(Vector<Vento> infoVento) {
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		float velMax = 0;

		while (i.hasNext()) {

			x = i.next();
			if (x.getVelocita() > velMax)
				velMax = x.getVelocita();

		}
		return velMax;
	}
}
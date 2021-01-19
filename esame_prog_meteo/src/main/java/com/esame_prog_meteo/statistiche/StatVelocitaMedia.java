package com.esame_prog_meteo.statistiche;

import java.util.Vector;

import com.esame_prog_meteo.meteodati.Vento;

import java.util.Iterator;

/**
 * Classe che implementa l'interfaccia StatsInterface e restituisce il valore
 * della velocita media del vento.
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class StatVelocitaMedia implements StatsInterface {

	/**
	 * implementa il metodo dell'interfaccia e restituisce il valore della
	 * statistica relativa alla velocita media
	 * 
	 * @param infoVento Vettore su cui calcolare le statistiche.
	 * @return velMedia Valore della velocita media del vento.
	 */
	public float getRisStats(Vector<Vento> infoVento) {
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		float somma = 0;

		while (i.hasNext()) {

			x = i.next();
			somma += x.getVelocita();

		}

		float velMedia = somma / infoVento.size();
		return velMedia;
	}
}

/**
 * Package che contiene tutte le classi utili al calcolo delle statistiche.
 */
package com.esame_prog_meteo.statistiche;

import java.util.Iterator;
import java.util.Vector;

import com.esame_prog_meteo.meteodati.Vento;

/**
 * Classe che implementa l'interfaccia StatsInterface e restituisce il valore
 * della direzione media del vento.
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class StatDirezioneMedia implements StatsInterface {

	/**
	 * Implementa il metodo dell'interfaccia e restituisce il valore della
	 * statistica relativa alla direzione media
	 * 
	 * @param infoVento Vettore su cui calcolare la statistica.
	 * @return dirMedia Valore della direzione media del vento
	 */
	public float getRisStats(Vector<Vento> infoVento) {
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		float somma = 0;

		while (i.hasNext()) {

			x = i.next();
			somma += x.getDirezione();

		}

		float dirMedia = somma / infoVento.size();
		return dirMedia;
	}
}

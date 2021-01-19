package com.esame_prog_meteo.statistiche;

import java.util.Vector;

import com.esame_prog_meteo.meteodati.Vento;

import java.util.Iterator;

/**
 * Classe che implementa l'interfaccia StatsInterface e restituisce il valore
 * della varianza della velocità del vento.
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class StatVarianzaVelocita implements StatsInterface {

	/**
	 * implementa il metodo dell'interfaccia e restituisce il valore della
	 * statistica relativa alla varianza della velocita
	 * 
	 * @param infoVento Vettore su cui calcolare la statistica
	 * @return varianzaVel Valore della varianza della velocita del vento.
	 */
	public float getRisStats(Vector<Vento> infoVento) {
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		StatVelocitaMedia appoggioMedia = new StatVelocitaMedia();
		double scarto = 0, scartoQuadroTot = 0;
		float velMedia = appoggioMedia.getRisStats(infoVento);

		while (i.hasNext()) {

			x = i.next();
			scarto = (x.getVelocita() - velMedia);
			scartoQuadroTot += Math.pow(scarto, 2);

		}

		float varianzaVel = (float) scartoQuadroTot / infoVento.size();
		return varianzaVel;
	}
}

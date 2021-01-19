package com.esame_prog_meteo.statistiche;

import java.util.Iterator;
import java.util.Vector;

import com.esame_prog_meteo.meteodati.Vento;

/**
 * Classe che implementa l'interfaccia StatsInterface e restituisce il valore
 * della varianza della direzione del vento.
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class StatVarianzaDirezione implements StatsInterface {

	/**
	 * Implementa il metodo dell'interfaccia e restituisce il valore della
	 * statistica relativa alla varianza della direzione.
	 * 
	 * @param infoVento Vettore su cui calcolare la statistica.
	 * @return varianzaDir Valore della varianza della direzione del vento.
	 */
	public float getRisStats(Vector<Vento> infoVento) {
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		StatDirezioneMedia appoggioMedia = new StatDirezioneMedia();
		double scarto = 0, scartoQuadroTot = 0;
		float dirMedia = appoggioMedia.getRisStats(infoVento);

		while (i.hasNext()) {

			x = i.next();
			scarto = (x.getDirezione() - dirMedia);
			scartoQuadroTot += Math.pow(scarto, 2);

		}

		float varianzaDir = (float) scartoQuadroTot / infoVento.size();
		return varianzaDir;
	}
}

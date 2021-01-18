package com.esame_prog_meteo.statistiche;

import com.esame_prog_meteo.model.Vento;
import java.util.Vector;
import java.util.Iterator;

/**
 * Classe che implementa l'interfaccia CalcolatoreStats.
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 *
 */
public class StatVarianzaDirezione implements CalcolatoreStats {

	/**
	 * implementa il metodo dell'interfaccia e restituisce il valore della
	 * statistica relativa alla varianza della direzione
	 * 
	 * @param infoVento
	 * @return
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

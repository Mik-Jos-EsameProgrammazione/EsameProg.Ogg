package com.esame_prog_meteo.statistiche;

import com.esame_prog_meteo.MeteoDati.Vento;
import java.util.Vector;
import java.util.Iterator;
import java.lang.Math;

/**
 * E' la classe che definisce il metodo per la statistica della varianza della direzione del vento
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class StatVarianzaDirezione extends Statistiche implements CalcolatoreStats{
	
	/**
	 * Costruttore
	 * @param infoVento ereditato dalla superclasse
	 */
	
	public StatVarianzaDirezione(Vector<Vento> infoVento){
		 super(infoVento);
	 }
	
	/**
	 * Definizione del metodo getRisStats per la varianza della direzione del vento
	 * @return varianza della direzione del vento
	 */
	
	public float getRisStats() {
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		StatDirezioneMedia appoggioMedia = new StatDirezioneMedia(infoVento);
		double scarto = 0, scartoQuadroTot = 0;
		float dirMedia = appoggioMedia.getRisStats();
		while(i.hasNext()) {
			x = i.next();
			scarto = (x.getDirezione()- dirMedia);
			scartoQuadroTot += Math.pow(scarto, 2);
		}
		float varianzaDir = (float) scartoQuadroTot / infoVento.size();
		return varianzaDir;
	}
}


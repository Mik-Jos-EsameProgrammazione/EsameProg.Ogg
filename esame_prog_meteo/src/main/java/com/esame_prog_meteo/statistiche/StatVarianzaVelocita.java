package com.esame_prog_meteo.statistiche;

import com.esame_prog_meteo.model.Vento;
import java.util.*;
/**
 * Classe che implementa l'interfaccia CalcolatoreStats. 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class StatVarianzaVelocita  implements CalcolatoreStats{
	
	/**
	 * implementa il metodo dell'interfaccia e restituisce il valore della statistica relativa alla varianza della velocita
	 * @param infoVento
	 * @return 
	 */
	public float getRisStats(Vector<Vento> infoVento) {
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		StatVelocitaMedia appoggioMedia = new StatVelocitaMedia();
		double scarto = 0, scartoQuadroTot = 0;
		float velMedia = appoggioMedia.getRisStats(infoVento);
		while(i.hasNext()) {
			x = i.next();
			scarto = (x.getVelocita() - velMedia);
			scartoQuadroTot += Math.pow(scarto, 2);
		}
		float varianzaVel = (float) scartoQuadroTot / infoVento.size();
		return varianzaVel;
	}
}

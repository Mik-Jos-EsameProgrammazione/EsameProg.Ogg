package com.esame_prog_meteo.statistiche;

import com.esame_prog_meteo.MeteoDati.Vento;
import java.util.Vector;
import java.util.Iterator;
import java.lang.Math;

/**
 * E' la classe che definisce il metodo per la statistica della varianza della velocità del vento
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class StatVarianzaVelocita extends Statistiche implements CalcolatoreStats{
	
	/**
	 * Costruttore
	 * @param infoVento ereditato dalla superclasse
	 */
	
	public StatVarianzaVelocita(Vector<Vento> infoVento){
		 super(infoVento);
	 }
	
	/**
	 * Definizione del metodo getRisStats per la varianza della velocita del vento
	 * @return varianza della velocità
	 */
	
	public float getRisStats() {
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		StatVelocitaMedia appoggioMedia = new StatVelocitaMedia(infoVento);
		double scarto = 0, scartoQuadroTot = 0;
		float velMedia = appoggioMedia.getRisStats();
		while(i.hasNext()) {
			x = i.next();
			scarto = (x.getVelocita() - velMedia);
			scartoQuadroTot += Math.pow(scarto, 2);
		}
		float varianzaVel = (float) scartoQuadroTot / infoVento.size();
		return varianzaVel;
	}
}

package com.esame_prog_meteo.Statistiche;

import com.esame_prog_meteo.MeteoDati.Vento;

import java.util.Iterator;
import java.util.Vector;

/**
 * E' la classe che definisce il metodo per la statistica della direzione media del vento.
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class StatDirezioneMedia extends Statistiche implements CalcolatoreStats{
	
	/**
	 * Costruttore
	 * @param infoVento ereditato dalla superclasse
	 */
	
	public StatDirezioneMedia(Vector<Vento> infoVento){
		 super(infoVento);
	 }
	
	/**
	 * Definizione del metodo getRisStats per la direzione media del vento
	 * @return direzione media
	 */
	
	public float getRisStats() { 
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		float somma = 0;
		while (i.hasNext())
		{
			x = i.next();
			somma += x.getDirezione();
		}
		float dirMedia =  somma / infoVento.size();
		return dirMedia;
	}
}

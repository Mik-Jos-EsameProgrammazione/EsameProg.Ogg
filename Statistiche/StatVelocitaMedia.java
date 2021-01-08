package com.esame_prog_meteo.Statistiche;

import com.esame_prog_meteo.MeteoDati.Vento;
import java.util.Vector;
import java.util.Iterator;

/**
 * E' la classe che definisce il metodo per la statistica della velocità media del vento
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class StatVelocitaMedia extends Statistiche implements CalcolatoreStats{
	
	/**
	 * Costruttore
	 * @param infoVento ereditato dalla superclasse
	 */
	
	public StatVelocitaMedia(Vector<Vento> infoVento){
		 super(infoVento);
	 }
	
	
	/**
	 * Definizione del metodo getRisStats per la velocita media del vento
	 * @return velocita media
	 */
	
	public float getRisStats() { 
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		float somma = 0;
		while (i.hasNext())
		{
			x = i.next();
			somma += x.getVelocita();
		}
		float velMedia =  somma / infoVento.size();
		return velMedia;
	}
}

package com.esame_prog_meteo.Statistiche;

import com.esame_prog_meteo.MeteoDati.Vento;
import java.util.Vector;
import java.util.Iterator;

/**
 * E' la classe che definisce il metodo per la statistica della velocità media del vento
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class StatVelocitaMin extends Statistiche implements CalcolatoreStats{
	
	/**
	 * Costruttore
	 * @param infoVento ereditato dalla superclasse
	 */
	
	public StatVelocitaMin(Vector<Vento> infoVento){
		 super(infoVento);
	 }
	
	/**
	 * Definizione del metodo getRisStats per la velocita minima del vento
	 * @return velocita minima 
	 */
	
	public float getRisStats() { 
			Iterator<Vento> i = infoVento.iterator();
			Vento x;
			x = infoVento.elementAt(0);
			float velMin = x.getVelocita(); 
			x = i.next();
			while (i.hasNext())
			{
				x = i.next();
				if (x.getVelocita() < velMin)
					velMin = x.getVelocita();
			}
		return velMin;
	}
}

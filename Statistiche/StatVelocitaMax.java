package Statistiche;

import MeteoDati.Vento;
import java.util.Vector;
import java.util.Iterator;

/**
 * E' la classe che definisce il metodo per la statistica della velocità media del vento
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class StatVelocitaMax extends Statistiche implements CalcolatoreStats{
	
	/**
	 * Costruttore
	 * @param infoVento ereditato dalla superclasse
	 */
	
	public StatVelocitaMax(Vector<Vento> infoVento){
		 super(infoVento);
	 }
	
	/**
	 * Definizione del metodo getRisStats per la velocita massima del vento
	 * @return velocita massima del vento
	 */
	
	public float getRisStats() { 
			Iterator<Vento> i = infoVento.iterator();
			Vento x;
			float velMax = 0; //il vento sarà sempre >=0
			while (i.hasNext())
			{
				x = i.next();
				if (x.getVelocita() > velMax)
					velMax = x.getVelocita();
			}
		return velMax;
	}
}

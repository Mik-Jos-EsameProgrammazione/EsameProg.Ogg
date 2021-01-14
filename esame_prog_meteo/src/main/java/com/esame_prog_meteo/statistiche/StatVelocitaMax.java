package com.esame_prog_meteo.statistiche;

import com.esame_prog_meteo.model.Vento;
import java.util.*;
/**
 * Classe che implementa l'interfaccia CalcolatoreStats. 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class StatVelocitaMax  implements CalcolatoreStats{
	/**
	 * implementa il metodo dell'interfaccia e restituisce il valore della statistica relativa alla velocita massima
	 * @param infoVento
	 * @return 
	 */
	public float getRisStats(Vector<Vento> infoVento) { 
			Iterator<Vento> i = infoVento.iterator();
			Vento x;
			float velMax = 0; //il vento sar‡ sempre >=0
			while (i.hasNext())
			{
				x = i.next();
				if (x.getVelocita() > velMax)
					velMax = x.getVelocita();
			}
			return velMax;
	}
}

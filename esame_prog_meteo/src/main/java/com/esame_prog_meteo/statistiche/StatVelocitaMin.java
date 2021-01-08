package com.esame_prog_meteo.statistiche;

import com.esame_prog_meteo.model.Vento;
import java.util.*;
/**
 * Classe che implementa l'interfaccia CalcolatoreStats. 
 * @author joshuaciccolini
 *
 */
public class StatVelocitaMin  implements CalcolatoreStats{
	
	/**
	 * implementa il metodo dell'interfaccia e restituisce il valore della statistica relativa alla velocita minima
	 * @param infoVento
	 * @return 
	 */
	public float getRisStats(Vector<Vento> infoVento) { 
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




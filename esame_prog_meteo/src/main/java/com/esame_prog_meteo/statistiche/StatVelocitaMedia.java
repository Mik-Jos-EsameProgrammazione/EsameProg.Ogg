package com.esame_prog_meteo.statistiche;
import com.esame_prog_meteo.model.Vento;
import java.util.*;
/**
 * Classe che implementa l'interfaccia CalcolatoreStats. 
 * @author joshuaciccolini
 *
 */
public class StatVelocitaMedia implements CalcolatoreStats{
	
	/**
	 * implementa il metodo dell'interfaccia e restituisce il valore della statistica relativa alla velocita media
	 * @param infoVento
	 * @return 
	 */
	public float getRisStats(Vector<Vento> infoVento) { 
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

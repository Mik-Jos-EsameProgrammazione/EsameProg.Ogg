package com.esame_prog_meteo.statistiche;
import com.esame_prog_meteo.model.Vento;



import java.util.Vector;
/**
 * Classe che implementa l'interfaccia CalcolatoreStats. 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class StatDirezioneMedia  implements CalcolatoreStats{
	
	/**
	 * implementa il metodo dell'interfaccia e restituisce il valore della statistica relativa alla direzione media
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
			somma += x.getDirezione();
		}
		float dirMedia =  somma / infoVento.size();
		return dirMedia;
	}
}

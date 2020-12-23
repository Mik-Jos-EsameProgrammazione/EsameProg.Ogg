package Statistiche;

import MeteoDati.Vento;
import java.util.*;

public class StatVelocitaMedia extends Statistiche implements CalcolatoreStats{
	public StatVelocitaMedia(Vector<Vento> infoVento){
		 super(infoVento);
	 }
	
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

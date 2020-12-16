package Statistiche;

import MeteoDati.Vento;
import java.util.*;

public class StatDirezioneMedia extends Statistiche implements CalcolatoreStats{
	public StatDirezioneMedia(Vector<Vento> infoVento){
		 super(infoVento);
	 }
	
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

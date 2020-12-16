package Statistiche;

import MeteoDati.Vento;
import java.util.*;

public class StatVelocitaMin extends Statistiche implements CalcolatoreStats{
	public StatVelocitaMin(Vector<Vento> infoVento){
		 super(infoVento);
	 }
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

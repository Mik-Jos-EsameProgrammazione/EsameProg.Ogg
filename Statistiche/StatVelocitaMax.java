package Statistiche;

import MeteoDati.Vento;
import java.util.*;

public class StatVelocitaMax extends Statistiche implements CalcolatoreStats{
	public StatVelocitaMax(Vector<Vento> infoVento){
		 super(infoVento);
	 }
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

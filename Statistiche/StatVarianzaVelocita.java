package Statistiche;

import MeteoDati.Vento;
import java.util.*;

public class StatVarianzaVelocita extends Statistiche implements CalcolatoreStats{
	public StatVarianzaVelocita(Vector<Vento> infoVento){
		 super(infoVento);
	 }
	
	public float getRisStats() {
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		StatVelocitaMedia appoggioMedia = new StatVelocitaMedia(infoVento);
		double scarto = 0, scartoQuadroTot = 0;
		float velMedia = appoggioMedia.getRisStats();
		while(i.hasNext()) {
			x = i.next();
			scarto = (x.getVelocita() - velMedia);
			scartoQuadroTot += Math.pow(scarto, 2);
		}
		float varianzaVel = (float) scartoQuadroTot / infoVento.size();
		return varianzaVel;
	}
}

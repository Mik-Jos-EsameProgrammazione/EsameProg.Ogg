package Statistiche;

import MeteoDati.Vento;
import java.util.*;

public class StatVarianzaDirezione extends Statistiche implements CalcolatoreStats{
	public StatVarianzaDirezione(Vector<Vento> infoVento){
		 super(infoVento);
	 }
	
	public float getRisStats() {
		Iterator<Vento> i = infoVento.iterator();
		Vento x;
		StatDirezioneMedia appoggioMedia = new StatDirezioneMedia(infoVento);
		double scarto = 0, scartoQuadroTot = 0;
		float dirMedia = appoggioMedia.getRisStats();
		while(i.hasNext()) {
			x = i.next();
			scarto = (x.getDirezione()- dirMedia);
			scartoQuadroTot += Math.pow(scarto, 2);
		}
		float varianzaDir = (float) scartoQuadroTot / infoVento.size();
		return varianzaDir;
	}
}


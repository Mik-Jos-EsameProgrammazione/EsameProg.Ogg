package Statistiche;

import MeteoDati.Vento;
import java.util.*;
/**
 * Description of Statistiche.
 * 
 * @author mikdr
 */
public class Statistiche {
	/**
	 * Description of the property infoVento.
	 */
	protected Vector<Vento> infoVento;
	
	/**
	 * Costruttore.
	 */
	public Statistiche(Vector<Vento> infoVento) throws IllegalArgumentException {
		if(infoVento== null) throw new IllegalArgumentException("Il vettore non contiene elementi");
		this.infoVento = infoVento;
	}

	public Vector<Vento> getInfoVento() {
		return infoVento;
	}

	public void setInfoVento(Vector<Vento> infoVento) {
		this.infoVento = infoVento;
	}
}
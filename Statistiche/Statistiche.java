package Statistiche;

import MeteoDati.Vento;
import java.util.Vector;

/**
 * Superclasse che definisce statistiche, da cui erediteranno le altre più specifiche.
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class Statistiche {
	
	protected Vector<Vento> infoVento;
	
	/**
	 * Costruttore e controllo che il Vector non sia vuoto
	 * @param infoVento
	 * @throws IllegalArgumentException
	 */
	
	public Statistiche(Vector<Vento> infoVento) throws IllegalArgumentException {
		if(infoVento== null) throw new IllegalArgumentException("Il vettore non contiene elementi");
		this.infoVento = infoVento;
	}
	
	/**
	 * @return il vector
	 */
	
	public Vector<Vento> getInfoVento() {
		return infoVento;
	}

	/**
	 * @param infoVento il nuovo infoVento
	 */
	
	public void setInfoVento(Vector<Vento> infoVento) {
		this.infoVento = infoVento;
	}
}
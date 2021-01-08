package com.esame_prog_meteo.statistiche;

import com.esame_prog_meteo.model.Vento;
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
	// protected Vector<Vento> infoVento;
	private String type_stat;
	private float value;

	/**
	 * Costruttore.
	 */
	public Statistiche(String type_stat, float value) throws IllegalArgumentException {
		// if(infoVento== null) throw new IllegalArgumentException("Il vettore non
		// contiene elementi");
		// this.infoVento = infoVento;
		this.type_stat = type_stat;
		this.value = value;
	}

	/*
	 * public Vector<Vento> getInfoVento() { return infoVento; }
	 * 
	 * public void setInfoVento(Vector<Vento> infoVento) { this.infoVento =
	 * infoVento; }
	 */
	public String getType_stat() {
		return type_stat;
	}

	public void setType_stat(String type_stat) {
		this.type_stat = type_stat;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}

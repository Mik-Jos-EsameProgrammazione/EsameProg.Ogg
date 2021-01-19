package com.esame_prog_meteo.statistiche;

import java.util.Vector;

import com.esame_prog_meteo.meteodati.Vento;

/**
 * Classe che modella le statistiche tramite il nome e il valore
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class Statistiche {
	/**
	 * Nome della statistica.
	 */
	private String type_stat;
	/**
	 * Valore della statistica.
	 */
	private float value;

	/**
	 * Costruttore della classe.
	 * 
	 * @param type_stat Nome della statistica.
	 * @param value     Valore della statistica
	 * @throws IllegalArgumentException Se il nome o il valore della statistica non
	 *                                  sono validi.
	 */
	public Statistiche(String type_stat, float value) throws IllegalArgumentException {
		if (type_stat.equals(""))
			throw new IllegalArgumentException("Il nome della statistica non è valido");
		else
			this.type_stat = type_stat;

		if (value < 0.0)
			throw new IllegalArgumentException("Il valore della statistica non è valido");
		else
			this.value = value;
	}

	/**
	 * Restituisce il nome della statistica.
	 * 
	 * @return type_stat Nome della statistica.
	 */
	public String getType_stat() {
		return type_stat;
	}

	/**
	 * Imposta il nome della statistica
	 * 
	 * @param type_stat Nome della statistica.
	 */
	public void setType_stat(String type_stat) {
		this.type_stat = type_stat;
	}

	/**
	 * Restituisce il valore della statistica.
	 * 
	 * @return Valore della statistica.
	 */
	public float getValue() {
		return value;
	}

	/**
	 * Imposta il valore della statistica.
	 * 
	 * @param value Valore della statistica.
	 */
	public void setValue(float value) {
		this.value = value;
	}

}

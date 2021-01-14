package com.esame_prog_meteo.statistiche;

import com.esame_prog_meteo.model.Vento;
import java.util.*;

/**
 * Classe che descrive una statistica
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class Statistiche {
	
	private String type_stat;
	private float value;

	/**
	 * Costruttore.
	 */
	public Statistiche(String type_stat, float value) throws IllegalArgumentException {
		this.type_stat = type_stat;
		this.value = value;
	}

	/**
	* @return type_stats, il tipo di statistica
	*/
	public String getType_stat() {
		return type_stat;
	}
	
	/**
	* @param type_stat il nuovo tipo di statistica
	*/
	public void setType_stat(String type_stat) {
		this.type_stat = type_stat;
	}
	
	/**
	* @return value, il valore della statistica
	*/
	public float getValue() {
		return value;
	}
	
	/**
	* @param value, il nuovo valore
	*/
	public void setValue(float value) {
		this.value = value;
	}

}

package com.esame_prog_meteo.statistiche;

import java.util.Vector;

import com.esame_prog_meteo.meteodati.Vento;

/**
 * Interfaccia che definisce il metodo necessario per restituire il valore delle
 * stastistiche
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public interface StatsInterface {
	/**
	 * Metodo che restituisce un valore diverso in base alla classe che lo
	 * implementa.
	 * 
	 * @param v Vettore su cui calcolare le statistiche.
	 * @return Valore della statistica.
	 */
	public float getRisStats(Vector<Vento> v);
}

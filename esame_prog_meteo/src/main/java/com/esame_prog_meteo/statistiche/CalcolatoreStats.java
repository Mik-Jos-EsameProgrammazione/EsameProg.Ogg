package com.esame_prog_meteo.statistiche;

import java.util.Vector;

import com.esame_prog_meteo.model.Vento;

/**
 * Interfaccia che definisce il metodo necessario per restituire il valore delle stastistiche
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public interface CalcolatoreStats {
	public float getRisStats(Vector<Vento> v);
}


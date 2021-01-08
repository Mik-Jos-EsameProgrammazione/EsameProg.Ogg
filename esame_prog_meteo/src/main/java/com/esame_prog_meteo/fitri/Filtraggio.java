package com.esame_prog_meteo.fitri;

import java.util.Vector;
import com.esame_prog_meteo.model.Vento;
/**
 * Interfaccia che definisce il metodo filtro. Questo metodo restituisce un vettore di oggetti vento filtrati in base all'implemetazione del metodo
 * @author joshuaciccolini
 *
 */
public interface Filtraggio {
	public Vector<Vento> filtro();
}

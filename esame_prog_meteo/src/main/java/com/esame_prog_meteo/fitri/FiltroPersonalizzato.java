package com.esame_prog_meteo.fitri;

import java.util.Vector;
import java.util.regex.PatternSyntaxException;

import com.esame_prog_meteo.meteodati.Vento;

/**
 * Classe che restituisce il vettore filtrato in base ad un parametro
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */

public class FiltroPersonalizzato {
	/**
	 * Vettore che contiene tutti i dati registrati dall'avvio dell'applicazione.
	 */
	protected Vector<Vento> info;

	/**
	 * Costruttore della classe
	 * 
	 * @param info Vettore che contiene tutti i dati registrati dall'avvio
	 *             dell'applicazione.
	 */
	public FiltroPersonalizzato(Vector<Vento> info) {
		this.info = info;
	}

	/**
	 * Ritorna un vettore di oggetti vento selezionato tramite un apposito indice x
	 * 
	 * @param x indice che seleziona l'array
	 * @return Vettore che contiene il vettore filtrato.
	 * @throws ArrayIndexOutOfBoundsException Se si tenta di analizzare l'array
	 *                                        fuori dalla sua grandezza.
	 */
	private Vector<Vento> cicloForFiltro(int x) throws ArrayIndexOutOfBoundsException {
		Vector<Vento> personalizzato = new Vector<Vento>();

		for (int i = info.size() - 1; i > info.size() - x; i--) {

			try {

				personalizzato.add(info.elementAt(i));

			} catch (ArrayIndexOutOfBoundsException e) {

				throw new ArrayIndexOutOfBoundsException("Non abbiamo sufficenti registrazioni");

			}
		}
		return personalizzato;
	}

	/**
	 * Ritorna un vettore di oggetti Vento riguardanti le registrazioni orarie fatte
	 * soltanto nel periodo selezionato tramite la stringa filtra
	 * 
	 * @param filtra Stringa che contiene il periodo su cui filtrare i dati.
	 * @return Vector Vettore effettivamente filrato.
	 * @throws PatternSyntaxException         Se non è possibile trovare il filtro.
	 * @throws NumberFormatException          Se non è possibile convertire la
	 *                                        stringa passata come parametro in
	 *                                        intero.
	 * @throws ArrayIndexOutOfBoundsException Se il parametro risulta superiore al
	 *                                        numero di dati immagazzinati.
	 */
	public Vector<Vento> filtroPersonalizzato(String filtra) throws PatternSyntaxException, NumberFormatException {
		String[] appoggioFiltro;
		int x;

		try {

			appoggioFiltro = filtra.split("_");
			x = Integer.parseInt(appoggioFiltro[0]);

			switch (appoggioFiltro[1]) {

			case "ore":
				return cicloForFiltro(x);

			case "giorni":
				return cicloForFiltro(24 * x);

			case "settimane":
				return cicloForFiltro(24 * x * 7);

			case "mesi":
				return cicloForFiltro(24 * x * 30);

			case "anni":
				return cicloForFiltro(24 * x * 365);

			}
		} catch (PatternSyntaxException e) {

			throw new PatternSyntaxException("Inserisci un filtro regolare", "_ ", -1);

		} catch (NumberFormatException e) {

			throw new NumberFormatException("Non è possibile convertire la stringa in intero");

		} catch (ArrayIndexOutOfBoundsException e) {

			throw new ArrayIndexOutOfBoundsException("Non abbiamo sufficenti registrazioni");

		}

		return null;
	}
}

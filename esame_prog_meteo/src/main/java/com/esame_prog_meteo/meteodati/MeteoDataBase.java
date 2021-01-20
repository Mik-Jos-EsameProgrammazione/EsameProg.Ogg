package com.esame_prog_meteo.meteodati;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.esame_prog_meteo.exception.EmptyArrayException;
import com.esame_prog_meteo.exception.InvalidNameException;
import com.esame_prog_meteo.exception.NoConvertionException;
import com.esame_prog_meteo.gestionejson.ConvertiJSON;
import com.esame_prog_meteo.gestionejson.JSONTimer;
import com.esame_prog_meteo.gestionejson.LeggiJSON;

	/**
	 * Classe che crea un database derivate dalla lettura dell'API
	 * @author Joshua Ciccolini
	 * @author Michele Di Renzo
	 */
public class MeteoDataBase {
	/**
	 * Array contenente tutte le misurazioni fatte dall'avvio dell'applicazione
	 */
	private static JSONArray array;
	
	/**
	 * Costruttore della classe
	 * @param city Citta su cui effettuare le misurazioni 
	 * @param APIKey Chiave necessaria all'accesso al servizio OpenWeather
	 * @throws InvalidNameException Quando la citta o l'APIKey non contiene nessun carattere
	 */
	public MeteoDataBase(String city, String APIKey) throws InvalidNameException {
	JSONTimer timer = new JSONTimer(3600000, city, APIKey);
	try {
	array = timer.schedulaArray();
	}catch(InvalidNameException e) {
		throw new InvalidNameException();
	}
	}
	
	/**
	 * Restituisce tutti i dati registrati dall'avvio dell'applicazione
	 * @return JSONArray Contiene tutti i dati registrati
	 * @throws EmptyArrayException Quando non ci sono dati salvati 
	 */
	public static JSONArray getData() throws EmptyArrayException {
		if(array.isEmpty()) throw new EmptyArrayException();
		else return array;
	}
	
	/**
	 * Restituisce tutti i metadati delle misurazioni registrate dall'avvio dell'applicazione
	 * @return JSONArray Contiene tutti i metadati registrati
	 * @throws NoConvertionException Quando viene rilevato qualche errore di conversione
	 */
	public static JSONArray getMeta() throws NoConvertionException {
		JSONArray a;
		try {
			a = ConvertiJSON.getMeta(ConvertiJSON.getVento(array));
		}catch(NoConvertionException e) {
			throw new NoConvertionException(e.getErrorPosition());
		}
		 return a;
	}
	
	/**
	 * Permette di importare un database
	 * @param newArray Database da importare
	 */
	public void setDataBase(JSONArray newArray) {
		array=newArray;
	}
	
	/**
	 * Permette di aggiungere un singolo elemento al database
	 * @param newElement Elemento da aggiungere
	 */
	public void addElement(JSONArray newElement) {
		array.add(newElement);
	}
	
	
	
}

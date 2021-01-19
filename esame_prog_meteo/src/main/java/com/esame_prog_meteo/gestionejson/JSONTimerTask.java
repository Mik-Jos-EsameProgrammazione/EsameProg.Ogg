package com.esame_prog_meteo.gestionejson;

import java.io.IOException;
import java.util.TimerTask;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

/**
 * Classe che implementa i metodi necessari per utilizzare la classe Timer
 * Implementa il metodo run() che contiene le istruzioni da eseguire ogni volta che il timer lo richiede
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class JSONTimerTask extends TimerTask{
	
	/**
	 * array che contiene ogni singola lettura sotto forma di JSONObject
	 */
	private JSONArray a = new JSONArray();
	
	/**
	 * contiene il nome della citta su cui fare le misurazioni
	 */
	private String city;
	
	/**
	 * contine la APIKey necessaria all'accesso al servizio OpenWeather 
	 */
	private String APIKey;
	
	 /**
	  * Costruttore della classe. Richiede come parametro la città su cui fare la lettura;
	  * @param city nome della citta su cui fare le registrazioni
	  * @param APIKey chiave necessaria all'accesso al servizio OpenWeather
	  */
	public JSONTimerTask(String city, String APIKey) {
		this.city=city;
		this.APIKey=APIKey;
		run();
	}
	
	/**
	 * Implementazione del metodo astratto di TimerTask. Il corpo viene eseguito quando viene creato un nuovo oggetto TimerTask
	 */
	public void run(){
			try {
				a.add(ConvertiJSON.converti(APICall.chiama(city, APIKey)));
			} catch (ParseException | IOException e) {
				e.printStackTrace();
			}
	
	}
	
	/**
	 * Restituisce l'array contentente la chiamata all'API
	 * @return JSONArray Contiene l'array con tutti i letti ogni schedulazione
	 */
	public JSONArray getJSONArray() {
		return a;
	}
}

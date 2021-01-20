package com.esame_prog_meteo.gestionejson;
import com.esame_prog_meteo.exception.InvalidNameException;

import org.json.simple.JSONArray;


import java.io.IOException;
import java.util.Timer;

/**
 * Rappresenta la classe che effettua la chiamata ogni periodo di tempo specificato.
 * Tramite l'apposito metodo salva la lettura convertita in oggetto JSON in un JSONArray oppure 
 * in un file di testo
 * @author Joshua Ciccolini 
 * @author Michele Di Renzo
 */

public class JSONTimer{
	/**
	 * Ritardo che deve intercorrere fra una misurazione e quella successiva
	 */
	private long delay;
	/**
	 * task da eseguire ogni volta che il timer lo richiede
	 */
	JSONTimerTask task;
	/**
	 * timer che esegue il task ogni determinato periodo
	 */
	Timer timer;
	/**
	 * Costruttore della classe. Imposta la variabile delay
	 * con il valore passato come parametro
	 * @param delay ritardo con cui viene fatta la schedulazione
	 * @param city città su cui effettuare le misurazioni
	 * @param APIKey APIKey necessaria all'accesso al servizio OpenWeather
	 * @throws IllegalArgumentException quando viene fornito un periodo non valido per le misurazioni
	 * @throws ImvalidNameException Quando venfono passati città o APIKey non validi
	 */
	public JSONTimer(long delay, String city,  String APIKey) 
	throws IllegalArgumentException, InvalidNameException{
		timer = new Timer();
		if(city.equals("")) throw  new InvalidNameException("Il nome della città deve contenere almeno un carattere");
		else if(APIKey.equals("")) throw  new InvalidNameException("L'APIKey deve contenere almeno un carattere");
		else {
		task = new JSONTimerTask(city, APIKey);
		if(delay < 0) throw new IllegalArgumentException("Il ritardo deve essere sempre maggiore di zero");
		else this.delay=delay;		
		}
	}
	
	/**
	 * Effettua una chiamata all'API e scrive il risultato convertito in array sul file denominato nome_file
	 * @param nome_file nome del file su cui scrivere le misurazioni
	 * @throws InvalidNameException Quando viene passato il nome del file non valido
	 * @throws IOException Quando non è possibile lavorare con lo stream o non è possibile creare il nuovo file
	 */
	public void schedulaFile(String nome_file) 
	throws InvalidNameException, IOException{
		if(nome_file.equals("")) throw new InvalidNameException("Il nome del file deve contenere almeno un carattere");
		else {
		timer.schedule(task, 0, delay);
		ScriviJSON.scrivisuFile(task.getJSONArray(), nome_file);
		}
	}
	
	/**
	 * Effettua una chiamata all'API e restituisce il risultato convertito in JSONArray
	 * @return JSONArray Array contenente le letture aggiornandole ogni periodo
	 */
	public JSONArray schedulaArray(){
		JSONArray b = new JSONArray();
		timer.schedule(task,0, delay);
		JSONArray a = task.getJSONArray();
		return a;
	}
	/**
	 * Restituisce il valore del ritardo fra una misurazione e quella succesiva
	 * @return long valore del ritardo
	 */
	public long getDelay() {
		return delay;
	}
	
	/**
	 * Permette di impostare il valore del ritardo fra una misurazione e quella successiva
	 * @param delay valore del ritardo
	 * @throws IllegalArgumentException Se il ritardo risulta minore di zero
	 */
	public void setDelay(long delay)
	throws IllegalArgumentException{
		if(delay < 0) throw new IllegalArgumentException("Il ritardo deve essere sempre maggiore di zero");
		else this.delay=delay;
	}
	
}

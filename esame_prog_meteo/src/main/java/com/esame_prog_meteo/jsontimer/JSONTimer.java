package com.esame_prog_meteo.jsontimer;
import com.esame_prog_meteo.exception.InvalidNameException;
import com.esame_prog_meteo.jsonio.ScriviJSON;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;



import java.util.Timer;
import java.util.TimerTask;
/**
 * Rappresenta la classe che effettua la chiamata ogni periodo di tempo specificato.
 * Tramite l'apposito metodo salva la lettura convertita in oggetto JSON in un JSONArray oppure 
 * in un file di testo
 * @author Joshua Ciccolini 
 */
public class JSONTimer{
	
	private long delay;
	
	/**
	 * Costruttore della classe. Imposta la variabile delay(ritardo con cui viene fatta la schedulazione) 
	 * con il valore passato come parametro
	 * @param delay
	 */
	public JSONTimer(long delay) 
	throws IllegalArgumentException{
		if(delay < 0) throw new IllegalArgumentException("Il ritardo deve essere sempre maggiore di zero");
		else this.delay=delay;		
	}
	
	/**
	 * Effettua un chiamata all'API e scrive il risultato convertito in array sul file denominato nome_file
	 * @param nome_file
	 */
	public void schedulaFile(String nome_file, String city, String APIKey) 
	throws InvalidNameException{
		if(nome_file.equals("")) throw new InvalidNameException("Il nome del file deve contenere almeno un carattere");
		if(city.equals("")) throw  new InvalidNameException("Il nome della città deve contenere almeno un carattere");
		Timer timer = new Timer();
		JSONTimerTask task = new JSONTimerTask(city, APIKey);
		timer.schedule(task, 0, delay);
		ScriviJSON.scrivisuFile(task.getJSONArray(), nome_file);
		
	}
	
	/**
	 * Effettua un chiamata all'API e restituisce il risultato convertito in JSONArray
	 * @return
	 */
	public JSONArray schedulaArray(String city, String APIKey)
	throws InvalidNameException{
		JSONArray b = new JSONArray();
		if(city.equals("")) throw new InvalidNameException("Il nome della città deve contenere almeno un carattere");
		Timer timer = new Timer();
		JSONTimerTask task = new JSONTimerTask(city, APIKey);
		timer.schedule(task,0, delay);
		JSONArray a = task.getJSONArray();
		return a;
	}
	
	public long getDelay() {
		return delay;
	}
	
	public void setDelay(long delay)
	throws IllegalArgumentException{
		if(delay < 0) throw new IllegalArgumentException("Il ritardo deve essere sempre maggiore di zero");
		else this.delay=delay;
	}
	
}

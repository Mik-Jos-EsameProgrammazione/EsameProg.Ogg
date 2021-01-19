package com.esame_prog_meteo.controller;

import java.lang.reflect.Constructor;

import java.lang.reflect.InvocationTargetException;

import com.esame_prog_meteo.statistiche.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.json.simple.JSONArray;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.esame_prog_meteo.exception.EmptyArrayException;
import com.esame_prog_meteo.exception.InvalidNameException;
import com.esame_prog_meteo.exception.NoConvertionException;
import com.esame_prog_meteo.meteodati.MeteoDataBase;
import com.esame_prog_meteo.meteodati.Vento;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Vector;
import com.esame_prog_meteo.fitri.*;
import com.esame_prog_meteo.gestionejson.ConvertiJSON;

/**
 * Classe che controlla tutte le rotte necessarie all'applicazione per
 * funzionare e per ricevere risultati
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 *
 */
@RestController
public class SpringController {
	/**
	 * Contiene tutti i dati necessari per il calcolo delle statistiche
	 */
	private MeteoDataBase database; 
	/**
	 * Rappresenta il nome della citta su cui effettuare le misurazioni
	 */
	private String city; 
	/**
	 * contiene pacchetti di dati filtrati differentemente in base al periodo

	 */
	Map<String, Vector<Vento>> filtered = new HashMap<>(); 
	
	/**
	 * Restituisce i metadati di tutte le misurazioni effettuate dall'avvio della
	 * chiamata
	 * 
	 * @return JSONArray che contiene i metadati delle misure effettuate dall'avvio
	 * @throws NoConvertionException Quando non è possibile la conversione dalla
	 *                               sorgente dei dati ad un JSONObject
	 */
	@GetMapping("/metadata")
	public JSONArray getMetadati() throws NoConvertionException {
		JSONArray a = null;
		
		try {
			
			a = MeteoDataBase.getMeta();
			
		} catch (NoConvertionException e) {
			
			throw new NoConvertionException(
					"Non è stato possibile convertire la striga in JSONObject alla posizione: " + e.getErrorPosition());
		
		}
		return a;
	}

	/**
	 * Permette di configurare il sistema inserendo la città su cui effettuare le
	 * statistiche e l'APIkey necessaria all'accesso al sistema OpenWeather per il
	 * rilevamento dei dati
	 * 
	 * @param city Richiede la città su cui effettuare le misurazioni
	 * @param APIKey Richiede l'APIKey necessaria all'accesso al servizio OpenWeather
	 * @return String Ritorna una stringa contenente i dati effettivi della configurazione
	 */
	@GetMapping("/configuration")
	public String setConfiguration(@RequestParam("city") String city, String APIKey) {
		this.city = city;
		
		try {
			
			database = new MeteoDataBase(city, APIKey);
			
		} catch (InvalidNameException e) {
			
			throw new InvalidNameException("Il nome della citta inserita non è valido");
		
		}
		return "Configurazione: [city] -> " + city + ", [APIKey] -> " + APIKey;
	}

	/**
	 * Restituisce i dati di tutte le misurazioni effettuate dall'avvio della
	 * chiamata
	 * 
	 * @return JSONArray che contiene i dati delle misure effettuate dall'avvio
	 * @throws EmptyArrayException Quando non è presente nessun dato nel database
	 */
	@GetMapping("/data")
	public JSONArray getDati() throws EmptyArrayException {
		JSONArray a = null;
		
		try {
			
			a = MeteoDataBase.getData();
		
		} catch (EmptyArrayException e) {
			
			throw new EmptyArrayException("Non sono presenti dati nel database");
		
		}
		return a;
	} 
	/**
	 * Restituisce le statistiche in base ai parametri inseriti (è possibile
	 * selezionare più statistiche e filtrarle per determinati periodi)
	 * 
	 * @param type Un numero variabile di Statistiche da calcolare sui dati immagazzinati
	 * @return map Che contiene tutte le statistiche calcolate per ogni pacchetto di dati filtrato adeguatamente
	 * @throws IllegaStateException Quando la map non viene definita a dovere
	 * @throws NullPointerException Quando le chiavi e i valori da inserire nella
	 *                              map sono nulli e la map non non lo permette
	 * @throws IllegalArgumentException Quando qualche proprietà delle chiavi e dei valori
	 *                           non permettono il salvataggio di essi nella map
	 * @throws Exception Quando vengono lanciate eccezioni relative alla selezione
	 *                   dei filtri
	 */
	@GetMapping("/stats")
	public Map<String, Vector<Statistiche>> getCombStats(@RequestParam("type") String... type) throws Exception {
		Map<String, Vector<Statistiche>> map = new HashMap<>();
		Iterator<Map.Entry<String, Vector<Vento>>> i = filtered.entrySet().iterator();
		Vector<Statistiche> stats;
		
		try {
			
			if (filtered.isEmpty()) {
				stats = new Vector<Statistiche>();
				for (String t : type)
					stats.add(instanziateStatClass(t, ConvertiJSON.getVento(MeteoDataBase.getData())));
				
				map.put("No Filter", stats);
				
			}
			
			while (i.hasNext()) {
				Map.Entry<String, Vector<Vento>> entry = i.next();
				
				try {
					stats = new Vector<Statistiche>();
					for (String t : type) {
						stats.add(instanziateStatClass(t, entry.getValue()));
					}
					
					map.put(entry.getKey(), stats);
					System.out.println(map.toString());
					
				} catch (IllegalStateException e) {
					
					throw new Exception("Non è possibile trovare la map");
					
				}
			}
		} catch (NullPointerException e) {
			
			throw new NullPointerException("Non è stato possibile impostare i filtri");
			
		} catch (IllegalArgumentException e) {
			
			throw new IllegalArgumentException("Non è stato possibile impostare i filtri");
			
		}

		return map;
	} 

	/**
	 * Permette di impostare i filtri in base ai parametri inseriti (è possibili
	 * inserire più filtri)
	 * 
	 * @param filter numero variabile di filtri da inserire
	 * @return String filtri effettivi inseriti 
	 * @throws NullPointerException     Quando le chiavi e i valori da inserire
	 *                                  nella map sono nulli e la map non non lo
	 *                                  permette
	 * @throws IllegalArgumentException Quando qualche proprietà delle chiavi e dei
	 *                                  valori non permettono il salvataggio di essi
	 *                                  nella map
	 * @throws Exception                Quando vengono lanciate eccezioni relative
	 *                                  alla selezione dei filtri
	 */
	@GetMapping("/filter")
	public String setFilter(@RequestParam("type") String... filter) throws Exception {
		String str = "";
		
		try {
			
			for (String f : filter) {
				filtered.put(f, instanziateFilterClass(f));
				
				str += "filtro applicato: " + f + '\n';
				
			}
		} catch (NullPointerException e) {
			
			throw new NullPointerException("Non è stato possibile impostare i filtri");
			
		} catch (IllegalArgumentException e) {
			
			throw new IllegalArgumentException("Non è stato possibile impostare i filtri");
			
		}
		return str;
	}

	/**
	 * Permette di impostare i filtri in base ai parametri inseriti (è possibili
	 * inserire più filtri, il parametro deve essere però formattato come
	 * valore_periodo)
	 * 
	 * @param period Periodo con il quale devono essere filtrati i dati
	 * @return Filtri effettivamente applicati
	 * @throws NullPointerException     Quando le chiavi e i valori da inserire
	 *                                  nella map sono nulli e la map non non lo
	 *                                  permette
	 * @throws IllegalArgumentException Quando qualche proprietà delle chiavi e dei
	 *                                  valori non permettono il salvataggio di essi
	 *                                  nella map
	 */
	@GetMapping("/custom_filter")
	public String setCustomFilter(@RequestParam("period") String... period)
			throws NullPointerException, IllegalArgumentException {
		String str = "";
		
		try {
			FiltroPersonalizzato filter = new FiltroPersonalizzato(ConvertiJSON.getVento(MeteoDataBase.getData()));
			
			for (String p : period) {
				filtered.put("Filtro Personalizzato_" + p, filter.filtroPersonalizzato(p));
				str += "filtro applicato: " + p + '\n';
			}
			
		} catch (NullPointerException e) {
			
			throw new NullPointerException("Non è stato possibile impostare i filtri");
			
		} catch (IllegalArgumentException e) {
			
			throw new IllegalArgumentException("Non è stato possibile impostare i filtri");
			
		}
		return str;
	} 

	/**
	 * 
	 * @throws UnsupportedOperationException Quando non è possibile rimuovere i
	 *                                       filtri impostati
	 */
	@GetMapping("/remove_filters")
	public void removeFilters() throws UnsupportedOperationException {
		
		try {
			
			filtered.clear();
			
		} catch (UnsupportedOperationException e) {
			
			throw new UnsupportedOperationException("Non è stato possibile rimuovere i filtri");
		
		}
	}

	/**
	 * Restituisce un oggetto Statistiche contenente il nome e il risultato della
	 * rispettiva statistica passata come parametro al metodo
	 * 
	 * @param type Nome della classe corrispondente alla statistica da calcolare
	 * @param vento Vettore di oggetti vento su cui calcolare le rispettive statistiche
	 * @return Statistiche 
	 * @throws ClassNotFoundExceptionn   Quando non è stato possibile trovare la
	 *                                   classe tramite il metodo forName
	 * @throws InstantiationException    Quando non è stato possibile instanziare un
	 *                                   oggetto di una determinata classe
	 * @throws IllegalArgumentException  Quando l'argomento passato al metodo non è
	 *                                   valido
	 * @throws NoSuchMethodException     Quando non viene ritrovato il metodo da
	 *                                   utilizzare
	 * @throws SecurityException Quando viene rilevata una violazione della sicurezza 
	 * @throws IllegalAccessException    Quando non è possiobile creare un nuovo
	 *                                   oggetto
	 * @throws InvocationTargetExcetpion Quando viene trovata qualche eccezione
	 *                                   lanciata da qualche metodo
	 */
	private Statistiche instanziateStatClass(String type, Vector<Vento> vento) throws Exception {
		try {
			
			Class<?> generic = Class.forName("com.esame_prog_meteo.statistiche." + type);
			Constructor<?> costr = generic.getDeclaredConstructor();
			StatsInterface stats = (StatsInterface) costr.newInstance();
			
			return new Statistiche(type, stats.getRisStats(vento));
			
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("La statistica da cercare non esiste");
		} catch (InstantiationException e) {
			throw new InstantiationException("Non è stato possibile instanziare un oggetto di questa classe");
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("L'argomento passato non è corretto");
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			throw new Exception("Eccezioni Generiche");
		}

	} 

	/**
	 * Restituisce un vettore di oggetti Vento contenente i dati filtrati dato un
	 * determinato periodo, in base al nome parametro passato al metodo
	 * 
	 * @param type Nome della classe relativa al filtro da utilizzare
	 * @return filter.filtro() Che rappresenta i dati filtrati su un determinato periodo
	 * @throws ClassNotFoundExceptionn   Quando non è stato possibile trovare la
	 *                                   classe tramite il metodo forName
	 * @throws InstantiationException    Quando non è stato possibile instanziare un
	 *                                   oggetto di una determinata classe
	 * @throws IllegalArgumentException  Quando l'argomento passato al metodo non è
	 *                                   valido
	 * @throws NoSuchMethodException     Quando non viene ritrovato il metodo da
	 *                                   utilizzare
	 * @throws SecurityException Quando viene rilevata una violazione della sicurezza
	 * @throws IllegalAccessException    Quando non è possiobile creare un nuovo
	 *                                   oggetto
	 * @throws InvocationTargetExcetpion Quando viene trovata qualche eccezione
	 *                                   lanciata da qualche metodo
	 */
	private Vector<Vento> instanziateFilterClass(String type) throws Exception {
		try {
			
			Class<?> generic = Class.forName("com.esame_prog_meteo.fitri." + type);
			Constructor<?> costr = generic.getDeclaredConstructor(Vector.class);
			Filtraggio filter = (Filtraggio) costr.newInstance(ConvertiJSON.getVento(MeteoDataBase.getData()));
			
			return filter.filtro();
			
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("La statistica da cercare non esiste");
		} catch (InstantiationException e) {
			throw new InstantiationException("Non è stato possibile instanziare un oggetto di questa classe");
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("L'argomento passato non è corretto");
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			throw new Exception("Eccezioni Generiche");
		}

	} 

}

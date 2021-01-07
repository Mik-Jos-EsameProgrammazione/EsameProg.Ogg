package com.esame_prog_meteo.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.esame_prog_meteo.statistiche.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esame_prog_meteo.apicall.APICall;
import com.esame_prog_meteo.database.MeteoDataBase;
import com.esame_prog_meteo.exception.EmptyArrayException;
import com.esame_prog_meteo.exception.InvalidNameException;
import com.esame_prog_meteo.jsonconvertion.ConvertiJSON;
import com.esame_prog_meteo.model.Vento;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Vector;
import com.esame_prog_meteo.fitri.*;

@RestController
public class Controller {
	private MeteoDataBase database;
	private String city;
	private String[] campi = new String[7];
	private Vector<Vento> array;
	Map<String, Vector<Vento>> filtered = new HashMap<>();

	/*
	 * @GetMapping("/metadati") public getMetadati() {
	 * 
	 * }
	 */
	@GetMapping("/configuration")
	public String setConfiguration(@RequestParam("city") String city, String APIKey) {
		this.city = city;
		try {
		database = new MeteoDataBase(city, APIKey);
		}catch(InvalidNameException e) {
			throw new InvalidNameException("Il nome della citta inserita non è valido");
		}
		return "Configurazione: [city] -> " + city + ", [APIKey] -> " + APIKey;
	} //  eccezioni controllate

	@GetMapping("/data")
	public JSONArray getDati() throws EmptyArrayException{
		JSONArray a = null;
		try {
		a= MeteoDataBase.getData();
		}catch (EmptyArrayException e) {
			throw new EmptyArrayException("Non sono presenti dati nel database");
		}
		return a;
	} // eccezioni controllate

	@GetMapping("/stats")
	public Map<String, Vector<Statistiche>> getCombStats(@RequestParam("type") String... type) throws Exception {
		if (filtered.isEmpty())
			throw new IllegalArgumentException("Non sono stati settati filtri");
		Map<String, Vector<Statistiche>> map = new HashMap<>();
		Iterator<Map.Entry<String, Vector<Vento>>> i = filtered.entrySet().iterator();
		while (i.hasNext()) {
			Vector<Statistiche> stats = new Vector<Statistiche>();
			Map.Entry<String, Vector<Vento>> entry = i.next();
			try {
			for (String t : type)
				stats.add(instanziateStatClass(t, entry.getValue()));
			map.put(entry.getKey(), stats);
			}catch (IllegalStateException e) {
				throw new Exception("Non è possibile trovare la map");
			}
		}
		return map;
	} // eccezioni da controllare

	@GetMapping("/filter")
	public void setFilter(@RequestParam("type") String... filter) throws Exception {
		if (filter.length == 0)
			filtered.put("NoFilter", ConvertiJSON.getVento(MeteoDataBase.getData()));
		for (String f : filter)
			filtered.put(f, instanziateFilterClass(f));

	}

	@GetMapping("/custom_filter")
	public void setCustomFilter(@RequestParam("period") String period) {
		try {
		FiltroPersonalizzato filter = new FiltroPersonalizzato(ConvertiJSON.getVento(MeteoDataBase.getData()));
		filtered.put("Filtro Personalizzato_" + period, filter.filtroPersonalizzato(period));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/remove_filters")
	public void removeFilters() throws UnsupportedOperationException {
		try {
			filtered.clear();
		} catch (UnsupportedOperationException e) {
			throw new UnsupportedOperationException("Non è stato possibile rimuovere i filtri");
		}
	}

	private Statistiche instanziateStatClass(String type, Vector<Vento> vento) throws Exception {
		try {
			Class<?> generic = Class.forName("com.esame_prog_meteo.statistiche." + type);
			Constructor<?> costr = generic.getDeclaredConstructor();
			CalcolatoreStats stats = (CalcolatoreStats) costr.newInstance();
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
		} catch (NoSuchMethodException e) {
			throw new Exception("no");
		} catch (SecurityException e) {
			throw new SecurityException("Security");
		} catch (IllegalAccessException e) {
			throw new IllegalAccessException("illegal");
		}

	}

}

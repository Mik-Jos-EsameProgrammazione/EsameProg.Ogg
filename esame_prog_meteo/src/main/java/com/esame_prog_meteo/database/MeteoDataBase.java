package com.esame_prog_meteo.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.esame_prog_meteo.exception.EmptyArrayException;
import com.esame_prog_meteo.exception.InvalidNameException;
import com.esame_prog_meteo.exception.NoConvertionException;
import com.esame_prog_meteo.jsonconvertion.ConvertiJSON;
import com.esame_prog_meteo.jsonio.LeggiJSON;
import com.esame_prog_meteo.jsontimer.JSONTimer;

	/**
	 * Classe che crea un database derivate dalla lettura dell'API
	 * @author joshuaciccolini
	 *
	 */
public class MeteoDataBase {
	
	private static JSONArray array;
	/**
	 * Costruttore della classe
	 * @param city
	 * @param APIKey
	 */
	public MeteoDataBase(String city, String APIKey) throws InvalidNameException {
	JSONTimer timer = new JSONTimer(10000);
	try {
	array = timer.schedulaArray(city,APIKey);
	}catch(InvalidNameException e) {
		throw new InvalidNameException();
	}
	}
	
	public static JSONArray getData() throws EmptyArrayException {
		if(array.isEmpty()) throw new EmptyArrayException();
		else return array;
	}
	
	public static JSONArray getMeta() throws NoConvertionException {
		JSONArray a;
		try {
			a = ConvertiJSON.getMeta(ConvertiJSON.getVento(array));
		}catch(NoConvertionException e) {
			throw new NoConvertionException(e.getErrorPosition());
		}
		 return ConvertiJSON.getMeta(ConvertiJSON.getVento(array));
	}
	
	public void setDataBase(JSONArray newArray) {
		array=newArray;
	}
	
	public void addElement(JSONArray newElement) {
		array.add(newElement);
	}
	
	
	
}

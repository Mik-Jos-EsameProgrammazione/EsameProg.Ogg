package com.esame_prog_meteo.jsonconvertion;
import java.util.Iterator;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.esame_prog_meteo.exception.NoConvertionException;
import com.esame_prog_meteo.model.DatiMeteo;
import com.esame_prog_meteo.model.Vento;
/**
 * Classe che che effettua le determinate conversioni da stringhe a JSONOBject e viceversa. Oppure converte un JSONArray in un vettore di oggetti Vento
 * @author joshuaciccolini
 *
 */
public class ConvertiJSON {
	private String str;
	static JSONObject macro_obj;
	static int count;
	/**
	 * Costruttore della classe che prende come parametro la stringa da convertire in un oggetto JSONArray
	 * @param str
	 */
	public ConvertiJSON(String str) {
		this.str = str;
		count=0;
	}
	/**
	 * Costruttore di default della classe
	 */
	public ConvertiJSON() {}
	/**
	 * Converte la stringa passata come parametro str in un oggetto JSONArray
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static JSONObject converti(String str) throws ParseException {
		JSONObject obj =(JSONObject) JSONValue.parseWithException(str);
		String macro_object= "";
		macro_object = "{\"general_information\":{";
		macro_object= macro_object.concat("\"visibility\":" +(obj.get("visibility").toString()));
		macro_object = macro_object.concat(",\"base\":\"" +(obj.get("base").toString())+"\"");
		macro_object = macro_object.concat(",\"dt\":" +(obj.get("dt").toString()));
		macro_object = macro_object.concat(",\"timezone\":" +(obj.get("timezone").toString()));
		macro_object = macro_object.concat(",\"id\":" +(obj.get("id").toString()));
		macro_object = macro_object.concat(",\"name\":\"" +(obj.get("name").toString())+"\"");
		macro_object = macro_object.concat(",\"cod\":" +(obj.get("cod").toString())+"}");
		macro_object = macro_object.concat(",\"main\":" +(obj.get("main").toString()));
		
		macro_object = macro_object.concat(",\"clouds\":" +(obj.get("clouds").toString()));
		macro_object = macro_object.concat(",\"sys\":" +(obj.get("sys").toString()));
		if(obj.get("rain") !=null)macro_object = macro_object.concat(",\"rain\":" +(obj.get("rain").toString()));
		if(obj.get("snow") !=null)macro_object = macro_object.concat(",\"rain\":" +(obj.get("rain").toString()));
		macro_object = macro_object.concat(",\"coord\":" +(obj.get("coord").toString()));
		
		JSONArray a = (JSONArray) obj.get("weather");
		JSONObject b = (JSONObject) a.get(0);
		b.get("icon:");
		macro_object = macro_object.concat(",\"weather\":{ \"icon\": \"" +(b.get("icon").toString())+"\"");
		macro_object = macro_object.concat(",\"description\":\"" +(b.get("description").toString())+"\"");
		macro_object = macro_object.concat(",\"main\":\"" +(b.get("main").toString())+"\"");
		macro_object = macro_object.concat(",\"id\":" +(b.get("id").toString())+"}");
		
		macro_object = macro_object.concat(",\"wind\":" +(obj.get("wind").toString())+"}");
		
		macro_obj =(JSONObject) JSONValue.parseWithException(macro_object);
		return macro_obj;
	}
	/**
	 * Restituisce l'oggetto JSONArray relativo alla striga attributo dell'oggetto stesso
	 * @return
	 * @throws ParseException
	 */
	public JSONObject getJSONArray() throws ParseException {
		return converti(str);
	}
	
	/**
	 * Imposta la variabile str con il valore passato come parametro. Questa stringa potrà essere convertita in oggetto JSON
	 * @param str
	 */
	public void setSringa(String str) {
		this.str=str;
	}
	
	/**
	 * Restuisce la variabile stringa che deve essere convertita in oggetto JSON
	 * @return
	 */
	public String getStringa() {
		return str;
	}
	
	public static Vector<Vento> getVento(JSONArray array) {
		Vector<Vento> v = new Vector<Vento>();
		for(Object o : array) {
		JSONObject j = (JSONObject) o;
		JSONObject gi = (JSONObject) j.get("general_information");
		JSONObject wd  = (JSONObject) j.get("wind");
		v.add(new Vento(gi.get("name").toString(), Integer.parseInt(gi.get("id").toString()), Integer.parseInt(gi.get("cod").toString()), Integer.parseInt(gi.get("timezone").toString()), Long.parseLong(gi.get("dt").toString()), Integer.parseInt(gi.get("visibility").toString()), gi.get("base").toString(),
				Float.parseFloat(wd.get("speed").toString()), Integer.parseInt(wd.get("deg").toString())));
		}
		return v;
	
	}
	
	public static JSONArray getMeta(Vector<Vento> array) throws NoConvertionException {
		JSONArray newArray = new JSONArray();
		Iterator<Vento> i = array.iterator();
		int j=1;
		try {
		while(i.hasNext()) {
			DatiMeteo v = (DatiMeteo) i.next();
			JSONObject obj = (JSONObject) JSONValue.parseWithException("{\"name\":\"" + v.getNome() + "\",\"timezone\":" + v.getTimezone() + ",\"dt\":" + v.getDataRilevazione() + ",\"cod\":" + v.getCod() + ",\"id\":" + v.getIdCitta() + ",\"data_counter\":" + j++ + "}");
			newArray.add(obj);
		}
		}catch(ParseException e) {
			throw new NoConvertionException(e.getPosition());
		}
		return newArray;
	}
	
}

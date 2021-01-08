package com.esame_prog_meteo.jsonconvertion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.esame_prog_meteo.model.Vento;




class ConvertiJSONTest {
	String str1 = "{\"coord\":{\"lon\":13.55,\"lat\":43.13},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"main\":{\"temp\":280.74,\"feels_like\":279.14,\"temp_min\":278.15,\"temp_max\":282.04,\"pressure\":1005,\"humidity\":77},\"visibility\":10000,\"wind\":{\"speed\":0.36,\"deg\":260},\"clouds\":{\"all\":28},\"dt\":1609775824,\"sys\":{\"type\":3,\"id\":2010593,\"country\":\"IT\",\"sunrise\":1609742255,\"sunset\":1609775021},\"timezone\":3600,\"id\":3172901,\"name\":\"Montegiorgio\",\"cod\":200}";
	String str2 = "{\"coord\":{\"lon\":13.55,\"lat\":43.13},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"main\":{\"temp\":280.74,\"feels_like\":279.14,\"temp_min\":278.15,\"temp_max\":282.04,\"pressure\":1005,\"humidity\":77},\"visibility\":10000,\"wind\":{\"speed\":0.36,\"deg\":260},\"clouds\":{\"all\":28},\"dt\":1609775824,\"sys\":{\"type\":3,\"id\":2010593,\"country\":\"IT\",\"sunrise\":1609742255,\"sunset\":1609775021},\"timezone\":3600,\"id\":3172901,\"name\":\"Montegiorgio\",\"cod\":200}";
	JSONObject obj = null;
	JSONArray array= null;
	ConvertiJSON c1 = null;
	Vector<Vento> vento = null;
	
	@BeforeEach
	void setUp() throws Exception {
		c1 = new ConvertiJSON(str1);
		obj = ConvertiJSON.converti(str2);
		array = new JSONArray();
		array.add(ConvertiJSON.converti(str1));
		array.add(ConvertiJSON.converti(str2));
		vento = ConvertiJSON.getVento(array);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws ParseException {
		assertNotNull(c1.getJSONArray());
		assertEquals(obj ,c1.getJSONArray());
	}
	
	@Test
	void test1() throws ParseException {
		assertNotNull(ConvertiJSON.converti(str2));
		assertEquals(obj, ConvertiJSON.converti(str2));
	}
	
	@Test
	void test2() {
		assertNotNull(vento.elementAt(0));
		assertNotNull(vento.elementAt(1));
		// da ridefinire
	}

}

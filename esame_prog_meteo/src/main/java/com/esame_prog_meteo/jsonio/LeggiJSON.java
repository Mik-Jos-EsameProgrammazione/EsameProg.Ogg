package com.esame_prog_meteo.jsonio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
/**
 * Legge un file e restituisce un JSONArray derivato dalla lettura
 * @author joshuaciccolini
 *
 */
public class LeggiJSON {
	 public static String nome_file;
	 public static Scanner in; 
	 
	 /**
	  * Costruttore della classe. Richiede come parametro la il nome del file su cui leggere gli oggetti
	  * @param nome_file
	  */
	 public LeggiJSON(String nome_file) {
		 LeggiJSON.nome_file= nome_file;
		 try {
			 in = new Scanner(new BufferedReader(new FileReader(LeggiJSON.nome_file)));
		 	}catch(IOException e) {
		 		e.printStackTrace();
		 	}catch(Exception e) {
		 		e.printStackTrace();
		 		}
	 		}
	 
	 /**
	  * Restituisce un array di array i quali contengono oggetti JSON singoli
	  * @return
	  */
	 public JSONArray leggifile() {
		 JSONArray a = new JSONArray(), b= new JSONArray();
		 while(in.hasNextLine()) {
			 try {
				 a = (JSONArray) JSONValue.parseWithException(in.nextLine());
				 in.nextLine();
			 	}catch(ParseException e) {
			 		e.printStackTrace();
			 	}
			 b.add(a);
		 }
		 return b;
	 }
	 
	 /**
	  * Restituisce un array di array i quali contengono oggetti JSON singoli.
	  * Richiede come parametro il nome del file da leggere.
	  * @param nome_file
	  * @return
	  */
	 public static JSONArray leggifile(String nome_file) {
		 Scanner in = null;
		 try {
			 in = new Scanner(new BufferedReader(new FileReader(nome_file)));
		 	}catch(IOException e) {
		 		e.printStackTrace();
		 	}catch(Exception e) {
		 		e.printStackTrace();
		 	}
		 
		 JSONArray a = new JSONArray(), b= new JSONArray();
		 while(in.hasNextLine()) {
			 try {
				 a = (JSONArray) JSONValue.parseWithException(in.nextLine());
				 in.nextLine();
			 	}catch(ParseException e) {
			 		e.printStackTrace();
			 	}
			b.add(a);
		 }
		 return b;
	 }
	 
	 /**
	  * Imposta l'attributo nome_file con il valore passato come parametro
	  * @param nome_file
	  */
	 public void setNomeFile(String nome_file) {
		 this.nome_file=nome_file;
	 }
	 
	 /**
	  * Restituiusce il contenuto dell'attributo nome_file
	  * @return
	  */
	 public String getNomeFile() {
		 return nome_file;
	 }
}

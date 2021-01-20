package com.esame_prog_meteo.gestionejson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.esame_prog_meteo.exception.InvalidNameException;
import com.esame_prog_meteo.exception.NoConvertionException;
/**
 * Legge un file e restituisce un JSONArray derivato dalla lettura
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class LeggiJSON {
	/**
	 * Nome del file da convertire
	 */
	 public static String nome_file;
	 /**
	  * Oggetto utilizzato per leggere il file
	  */
	 public static Scanner in; 
	 
	 /**
	  * Costruttore della classe.
	  * @param nome_file nome del file su cui leggere gli oggetti
	 * @throws IOException Quando non è possibile lavorare con lo stream oppure non è stato trovato il file
	  */
	 public LeggiJSON(String nome_file) throws IOException {
		 LeggiJSON.nome_file= nome_file;
		 try {
			 in = new Scanner(new BufferedReader(new FileReader(LeggiJSON.nome_file)));
		 	}catch(IOException e) {
		 		throw new IOException("Non è stato possibile lavorare con lo stream o non è stato trovato il file");
	 		}
	 }
	 /**
	  * Restituisce un array contenente i dati letti dal file
	  * @return JSONArray array di dati ricavato dal file
	  * @throws NoConvertionException Quando non è possibile convertire il file 
	  * @throws IllegalStateException Quando lo scanner non permette il funzionamento normale del metodo
	  */
	 public JSONArray leggifile() throws NoConvertionException, IllegalStateException {
		 JSONArray b= new JSONArray();
		 JSONObject a= new JSONObject();
		 while(in.hasNextLine()) {
			 try {
				 a = (JSONObject) JSONValue.parseWithException(in.nextLine());
				 in.nextLine();
			 	}catch(ParseException e) {
			 		throw new NoConvertionException("Non è stato possibile convertire la riga del file in JSONObject");
			 	}catch(IllegalStateException e ) {
			 		throw new IllegalStateException("Lo scanner si è chiuso in modo anomalo");
			 	}
			 b.add(a);
		 }
		 return b;
	 }
	 
	 /**
	  * Restituisce un array contenente i dati letti dal file
	  * @param nome_file nome del file da leggre
	  * @return JSONArray array contenente i dati letti dal file
	 * @throws NoConvertionException Quando non è possibile convertire il file nel modo corretto
	 * @throws IOException Quando non è possibile lavorare con lo stream oppure non è stato trovato il file
	 * @throws IllegalStateException Quando lo scanner non permette il funzionamento normale del metodo
	  */
	 public static JSONArray leggifile(String nome_file) throws NoConvertionException, IOException , IllegalStateException{
		 Scanner in = null;
		 JSONArray b= new JSONArray();
		 JSONObject a= new JSONObject();
		 try {
			 in = new Scanner(new BufferedReader(new FileReader(nome_file)));
		 while(in.hasNextLine()) {
				 a = (JSONObject) JSONValue.parseWithException(in.nextLine());
				 in.nextLine();
			 	
			b.add(a);
		 }}catch(ParseException e) {
			 throw new NoConvertionException("Non è stato possibile convertire la riga del file in JSONObject");
		 }catch(IllegalStateException e) {
			 throw new IllegalStateException("Lo scanner si è chiuso in modo anomalo");
		 }catch(IOException e) {
			 throw new IOException("Non è stato possibile lavorare con lo stream o non è stato trovato il file");
		 }
		 return b;
	 }
	 
	 /**
	  * Imposta l'attributo nome_file con il valore passato come parametro
	  * @param nome_file nome del file
	  * @throws IllegalNameException Quando il nome del file non è valido o non è stato inserito
	  */
	 public void setNomeFile(String nome_file) throws InvalidNameException  {
		 if(nome_file.equals("")) throw new InvalidNameException("Il nome del file non è valido");
		 else this.nome_file=nome_file;
	 }
	 
	 /**
	  * Restituiusce il contenuto dell'attributo nome_file
	  * @return String nome del file
	  */
	 public String getNomeFile() {
		 return nome_file;
	 }
}

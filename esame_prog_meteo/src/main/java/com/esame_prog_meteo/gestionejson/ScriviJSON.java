package com.esame_prog_meteo.gestionejson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;

/**
 * Scrive un file contenente le letture effettuate
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class ScriviJSON {
	/**
	 * Nome del file su cui scrivere
	 */
	private static String nome_file;
	/**
	 * Oggetto che permette la scrittura su file
	 */
	private static PrintWriter out;
	
	/**
	 * Costruttore della classe.
	 * @param nome_file nome del file su cui salvare gli oggetti
	 * @throws IOException Quando non è possibile creare il file o lavorare con lo stream
	 */
	public ScriviJSON(String nome_file) throws IOException {
		ScriviJSON.nome_file=nome_file;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(ScriviJSON.nome_file, true)));
			}catch(IOException e) {
				throw new IOException("Non è stato possibile creare il file o lavorare con lo stream");
		}}
	/**
	 * Costruttore di Default.
	 */
	public ScriviJSON() {}
	
	/**
	 * Scrive sul file l'array passato come parametro
	 * @param a array da scrivere
	 */
	public void scrivisuFile(JSONArray a) {
		out.println(a);
		out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		out.close();
	}
	
	/**
	 * Scrive sul nuovo file passato come parametro l'oggetto passato come parametro
	 * @param a array da scrivere
	 * @param nome_file nome del file su cui salvare gli oggetti
	 * @throws IOException Quando non è possibile creare il file o lavorare con lo stream
	 */
	public static void scrivisuFile(JSONArray a, String nome_file) throws IOException {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nome_file, true)));
			out.println(a);
			out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			out.close();
		}catch(IOException e) {
			throw new IOException("Non è stato possibile creare il file o lavorare con lo stream");
	}
		}
	 /**
	  * Imposta l'attributo nome_file con il valore passato come parametro
	  * @param nome_file nome del file
	  */
	 public void setNomeFile(String nome_file) {
		 this.nome_file=nome_file;
	 }
	 
	 /**
	  * Restituiusce il contenuto dell'attributo nome_file
	  * @return String nome del file
	  */
	 public String getNomeFile() {
		 return nome_file;
	 }
	}

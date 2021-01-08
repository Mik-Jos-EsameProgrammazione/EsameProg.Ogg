package com.esame_prog_meteo.jsonio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;

/**
 * Scrive un file contenente le letture effettuate
 * @author joshuaciccolini
 *
 */
public class ScriviJSON {
	private static String nome_file;
	private static PrintWriter out;
	
	/**
	 * Costruttore della classe. Richiede come parametro il nome del file su cui salvare gli oggetti
	 * @param nome_file
	 */
	public ScriviJSON(String nome_file) {
		ScriviJSON.nome_file=nome_file;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(ScriviJSON.nome_file, true)));
			}catch(IOException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	public ScriviJSON() {}
	
	/**
	 * Scrive sul file l'array passato come parametro
	 * @param a
	 */
	public void scrivisuFile(JSONArray a) {
		out.println(a);
		out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		out.close();
	}
	
	/**
	 * Scrive sul nuovo file passato come parametro l'oggetto passato come parametro
	 * @param a
	 * @param nome_file
	 */
	public static void scrivisuFile(JSONArray a, String nome_file) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nome_file, true)));
			out.println(a);
			out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			out.close();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
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

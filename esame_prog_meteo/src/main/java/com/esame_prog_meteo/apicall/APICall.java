package com.esame_prog_meteo.apicall;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class APICall {
	/**
	 * Rappresenta la classe che effettua la chiamata alla API e tramite l'apposito
	 * metodo restituisce la lettura sottoforma di stringa
	 * @author Joshua Ciccolini
	 * 
	 */
	
	/**
	 * Effettua un chiamata all'API aprendo una connessione impostando come città su cui lavorare il valore passato come parametro
	 * @param city
	 * @return
	 * @throws IOException 
	 */
	public static String chiama(String city, String APIKey) throws IOException {
		String url = "https://api.openweathermap.org/data/2.5/weather?q="+ city +"&appid=" + APIKey;
		String lettura = "";
		String line = "";
		try {
			URLConnection connection = new URL(url).openConnection();
			connection.setDoOutput(true);
			InputStream in = connection.getInputStream();
	
				try {
					BufferedReader reader = new BufferedReader( new InputStreamReader(in));
					while((line=reader.readLine()) != null) {
					lettura +=line ;
					}
				}finally{
					in.close();
					}
			}catch(IOException e) {
				e.printStackTrace();
				throw new IOException();
				}
		return lettura;
		}
		
	}
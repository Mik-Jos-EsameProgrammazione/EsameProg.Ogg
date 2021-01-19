/**
 * Package che contiene tutte le classi necessarie all'ottenimento dei dati e alla conversione di quest'ultimi in JSONObject, JSONArray e oggetti Vento.
 * Inoltre contiene anche le classi necessarie per chiamare le api del servizio OpenWeather dopo un determinato periodo
 */
package com.esame_prog_meteo.gestionejson;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Rappresenta la classe che effettua la chiamata alla API e tramite l'apposito
 * metodo restituisce la lettura sottoforma di stringa
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */

public class APICall {

	/**
	 * Effettua un chiamata all'API aprendo una connessione impostando come città su
	 * cui lavorare il valore passato come parametro
	 * 
	 * @param city   Nome della citta su cui effettuare le misurazioni
	 * @param APIKey Chiave necessaria all'accesso al servizio OpenWeather
	 * @return String Risultato della chiamata all'API del servizio OpenWeather
	 *         sotto forma di stringa
	 * @throws IOException Se viene rilevato qualche problema nella lettura dello
	 *                     Stream
	 */
	public static String chiama(String city, String APIKey) throws IOException {
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + APIKey;
		String lettura = "";
		String line = "";

		try {
			URLConnection connection = new URL(url).openConnection();
			connection.setDoOutput(true);
			InputStream in = connection.getInputStream();

			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));

				while ((line = reader.readLine()) != null) {

					lettura += line;

				}
			} finally {

				in.close();

			}
		} catch (IOException e) {

			throw new IOException("Non è stato possibile convertire lo stream");

		}
		return lettura;
	}

}
/**
 * Package contenente tutte le classi utili al contenimento dei dati e alla loro modellazione.
 */
package com.esame_prog_meteo.meteodati;

/**
 * Classe che contiene tutte le informazioni utili al riconoscimento della
 * località in cui vengono effettuate le misurazioni.
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */

public class DatiMeteo {
	/**
	 * Parametro interno
	 */
	protected String base;
	/**
	 * Valore della visibilità nella località
	 */
	protected int visibilita;
	/**
	 * Data della rilevazione in formato UTC (secondi trascorsi dal 1 Gennaio 1970).
	 */
	protected long dataRilevazione;
	/**
	 * Fuso orario in millisecondi.
	 */
	protected int timezone;
	/**
	 * Identificativo della città.
	 */
	protected int idCitta;
	/**
	 * Nome della città.
	 */
	protected String nome;
	/**
	 * Codice della città.
	 */
	protected int cod;

	/**
	 * Costruttore della classe.
	 * 
	 * @param nome       Nome della città.
	 * @param idCitta    Identificativo della città.
	 * @param cod        Codice della città.
	 * @param timezone   Fuso orario in millisecondi.
	 * @param dR         Data della rilevazione in formato UTC.
	 * @param visibilita Valore della visibilità nella località.
	 * @param base       Parametro interno.
	 */
	public DatiMeteo(String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base) {
		this.nome = nome;
		this.idCitta = idCitta;
		this.cod = cod;
		this.timezone = timezone;
		this.dataRilevazione = dR;
		this.visibilita = visibilita;
		this.base = base;
	}

	/**
	 * Costruttore di default.
	 */
	public DatiMeteo() {
	}

	/**
	 * Restituisce il parametro interno base.
	 * 
	 * @return base Parametro interno
	 */
	public String getBase() {
		return base;
	}

	/**
	 * Imposta il parametro interno base.
	 * 
	 * @param base Parametro interno
	 */
	public void setBase(String base) {
		this.base = base;
	}

	/**
	 * Restituisce il valore della visibilità della località.
	 * 
	 * @return visibilita Valore della visibilità della località.
	 */
	public int getVisibilita() {
		return visibilita;
	}

	/**
	 * Restituisce il valore della visibilità della località.
	 * 
	 * @param visibilita Valore della visibilità della località.
	 */
	public void setVisibilita(int visibilita) {
		this.visibilita = visibilita;
	}

	/**
	 * Restituisce la data di rilevazione delle informazioni.
	 * 
	 * @return dataRilevazione Data di rilevazione delle informazioni.
	 */
	public long getDataRilevazione() {
		return dataRilevazione;
	}

	/**
	 * Imposta la data di rilevazione delle informazioni
	 * 
	 * @param dataRilevazione Data di rilevazione delle informazioni.
	 */
	public void setDataRilevazione(long dataRilevazione) {
		this.dataRilevazione = dataRilevazione;
	}

	/**
	 * Restituisce il fusorario.
	 * 
	 * @return timezone Valore del fusorario.
	 */
	public int getTimezone() {
		return timezone;
	}

	/**
	 * Imposta il fusorario.
	 * 
	 * @param timezone Imposta il fusorario.
	 */
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	/**
	 * Restituisce l'identificativo della città.
	 * 
	 * @return idCitta Identificativo della città.
	 */
	public int getIdCitta() {
		return idCitta;
	}

	/**
	 * Imposta l'identificativo della città
	 * 
	 * @param idCitta Identificativo della città.
	 */
	public void setIdCitta(int idCitta) {
		this.idCitta = idCitta;
	}

	/**
	 * Restituisce il nome della città
	 * 
	 * @return nome Nome della città.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Imposta il nome della città.
	 * 
	 * @param nome Nome della città.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce il codice della città.
	 * 
	 * @return cod Codice della città.
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * Imposta il codice della città.
	 * 
	 * @param cod Codice della città.
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}

	/**
	 * Restituisce le informazioni formattate sotto forma di stringa (Overriding del
	 * toString() di Object).
	 * 
	 * @return Informazioni sotto forma di stringa.
	 */
	public String toString() {
		return ("Nome città: " + nome + ", id città: " + idCitta + "cod : " + cod + ", timezone : " + timezone
				+ "data rilevazione : " + dataRilevazione + ", visibilità : " + visibilita + ", base: " + base);
	}
}


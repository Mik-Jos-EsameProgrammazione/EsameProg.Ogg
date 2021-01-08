package com.esame_prog_meteo.model;

//è la superclasse

public class DatiMeteo {
	protected String base; //parametro interno
	protected int visibilita; //è un intero in metri
	protected long dataRilevazione; //tempo in millisecondi trascorso dal 1/01/1970 alle 00:00 fino alla 
									//data e ora della rilevazione della misura
	protected int timezone; //Shift in seconds from UTC????
	protected int idCitta; //id univoco citta
	protected String nome; //nome citta
	protected int cod; //parametro interno
	
	/*
	 * Descrizione costruttore
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
	
	public DatiMeteo() {}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public int getVisibilita() {
		return visibilita;
	}

	public void setVisibilita(int visibilita) {
		this.visibilita = visibilita;
	}

	public long getDataRilevazione() {
		return dataRilevazione;
	}

	public void setDataRilevazione(long dataRilevazione) {
		this.dataRilevazione = dataRilevazione;
	}

	public int getTimezone() {
		return timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public int getIdCitta() {
		return idCitta;
	}

	public void setIdCitta(int idCitta) {
		this.idCitta = idCitta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public String toString() {
		return ("Nome città: " + nome + ", id città: " + idCitta + "cod : " + cod + 
				", timezone : " + timezone + "data rilevazione : " + dataRilevazione + 
				", visibilità : " + visibilita + ", base: " + base);
	}
}


package MeteoDati;

/**
 * Superclasse contenente i dati della risposta API
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class DatiMeteo {
	protected String base; //parametro interno
	protected int visibilita; //è un intero in metri
	protected long dataRilevazione; //tempo in millisecondi trascorso dal 1/01/1970 alle 00:00 fino alla 
									//data e ora della rilevazione della misura
	protected int timezone; //Shift in seconds from UTC????
	protected int idCitta; //id univoco citta
	protected String nome; //nome citta
	protected int cod; //parametro interno
	
	/**
	 * Costruttore
	 * @param nome
	 * @param idCitta 
	 * @param cod
	 * @param timezone
	 * @param dR
	 * @param visibilita
	 * @param base
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
	 * @return base
	 */
	
	public String getBase() {
		return base;
	}

	/**
	 * @param base la nuova base
	 */
	
	public void setBase(String base) {
		this.base = base;
	}
	
	/**
	 * @return visibilità
	 */

	public int getVisibilita() {
		return visibilita;
	}
	
	/**
	 * @param visibilita la nuova visibilità
	 */

	public void setVisibilita(int visibilita) {
		this.visibilita = visibilita;
	}

	/**
	 * Data della rilevazione della misura
	 * @return dataRilevazione
	 */
	
	public long getDataRilevazione() {
		return dataRilevazione;
	}
	
	/**
	 * @param dataRilevazione la nuova dataRilevazione
	 */

	public void setDataRilevazione(long dataRilevazione) {
		this.dataRilevazione = dataRilevazione;
	}
	
	/**
	 * @return timezone
	 */

	public int getTimezone() {
		return timezone;
	}

	/**
	 * @param timezone il nuovo timezone
	 */
	
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}
	
	/**
	 * @return idCitta
	 */

	public int getIdCitta() {
		return idCitta;
	}

	/**
	 * @param idCitta il nuovo idCitta
	 */
	
	public void setIdCitta(int idCitta) {
		this.idCitta = idCitta;
	}
	
	/**
	 * @return nome
	 */

	public String getNome() {
		return nome;
	}

	/**
	 * @param nome il nuovo nome
	 */
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return cod
	 */
	
	public int getCod() {
		return cod;
	}
	
	/**
	 * @param cod il nuovo cod
	 */

	public void setCod(int cod) {
		this.cod = cod;
	}
	
	/**
	 * @return i dati
	 */
	
	public String toString() {
		return ("Nome città: " + nome + ", id città: " + idCitta + "cod : " + cod + 
				", timezone : " + timezone + "data rilevazione : " + dataRilevazione + 
				", visibilità : " + visibilita + ", base: " + base);
	}
}


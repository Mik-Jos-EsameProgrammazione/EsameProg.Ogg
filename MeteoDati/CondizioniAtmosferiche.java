package MeteoDati;

//questa classe corrisponde all'oggetto weather della risposta API

public class CondizioniAtmosferiche extends DatiMeteo{
	protected String condizioni; //condizioni atmosferiche (pioggia neve) (corrisponde a main nella risposta API)
	protected int idCondizioni; //id univoco che rappresenta la condizione atmosferica
	protected String descrizione; //descrive meglio le condizioni atmosferiche (es: cielo pulito)
	protected String idIcona; //id icona meteo corrisponde nella risposta API a icon (alfanumerico)
	public CondizioniAtmosferiche(String nome, int idCitta, int cod, int timezone, long dR, int visibilita,
								  String base, int idCondizioni, String condizioni, String descrizione, 
								  String idIcona){
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.idCondizioni = idCondizioni;
		this.condizioni = condizioni;
		this.descrizione = descrizione;
		this.idIcona = idIcona;
	}
	public String getCondizioni() {
		return condizioni;
	}
	
	public void setCondizioni(String condizioni) {
		this.condizioni = condizioni;
	}
	
	public int getIdCondizioni() {
		return idCondizioni;
	}
	
	public void setIdCondizioni(int idCondizioni) {
		this.idCondizioni = idCondizioni;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getIdIcona() {
		return idIcona;
	}
	
	public void setIdIcona(String idIcona) {
		this.idIcona = idIcona;
	}

	public String toString() {
		return ("Condizioni atmosferiche: " + condizioni + ", id condizioni: " + idCondizioni + ", descrizione: "
				+ descrizione + ", id icona: " + idIcona);
	}
	
}

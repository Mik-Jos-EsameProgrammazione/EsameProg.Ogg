package MeteoDati;

//nella risposta API questa classe corrisponde all'oggetto main

public class InfoAggiuntive extends DatiMeteo{
	protected float temperatura; //in kalvin
	protected float temperaturaPercepita; //in kalvin
	protected float temperaturaMin; //in kalvin
	protected float temperaturaMax; //in kalvin
	protected int pressioneAtm; //in hPa (etto Pascal, centinaia di Pascal)
	protected int umidita; //in %
	protected int pressioneMare; //pressione a livello del mare in hPa
	protected int pressioneSuolo; //pressione a livello del suolo in hPa
	
	//costruttore senza differenza tra pressione al mare e sul suolo
	public InfoAggiuntive(String nome, int idCitta, int cod, int timezone, long dR, int visibilita,
			  			  String base, float temperatura, float temperaturaPercepita, float temperaturaMin, 
			  			  float temperaturaMax, int pressioneAtm, int umidita) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.temperatura = temperatura;
		this.temperaturaPercepita = temperaturaPercepita;
		this.temperaturaMin = temperaturaMin;
		this.temperaturaMax = temperaturaMax;
		this.pressioneAtm = pressioneAtm;
		this.umidita = umidita;
	}
	
	//costruttore con differenza tra pressione al mare e sul suolo
	public InfoAggiuntive(String nome, int idCitta, int cod, int timezone, long dR, int visibilita,
			  String base, float temperatura, float temperaturaPercepita, float temperaturaMin, 
			  float temperaturaMax, int pressioneAtm, int umidita, int pressioneMare, int pressioneSuolo) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.temperatura = temperatura;
		this.temperaturaPercepita = temperaturaPercepita;
		this.temperaturaMin = temperaturaMin;
		this.temperaturaMax = temperaturaMax;
		this.pressioneAtm = pressioneAtm;
		this.umidita = umidita;
		this.pressioneMare = pressioneMare;
		this.pressioneSuolo = pressioneSuolo;
	}

	public float getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
	
	public float getTemperaturaPercepita() {
		return temperaturaPercepita;
	}
	
	public void setTemperaturaPercepita(float temperaturaPercepita) {
		this.temperaturaPercepita = temperaturaPercepita;
	}
	
	public float getTemperaturaMin() {
		return temperaturaMin;
	}
	
	public void setTemperaturaMin(float temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}
	
	public float getTemperaturaMax() {
		return temperaturaMax;
	}
	
	public void setTemperaturaMax(float temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}
	
	public int getPressioneAtm() {
		return pressioneAtm;
	}
	
	public void setPressioneAtm(int pressioneAtm) {
		this.pressioneAtm = pressioneAtm;
	}
	
	public int getUmidita() {
		return umidita;
	}
	
	public void setUmidita(int umidita) {
		this.umidita = umidita;
	}
	
	public int getPressioneMare() {
		return pressioneMare;
	}

	public void setPressioneMare(int pressioneMare) {
		this.pressioneMare = pressioneMare;
	}

	public int getPressioneSuolo() {
		return pressioneSuolo;
	}

	public void setPressioneSuolo(int pressioneSuolo) {
		this.pressioneSuolo = pressioneSuolo;
	}

	public String toString1() { //toString senza differenze di pressioni mare-suolo
		return ("Temperatura: " + temperatura + ", temperatura percepita: " + temperaturaPercepita
				+ ", temperatura minima: " + temperaturaMin + ", temperatura massima=" + temperaturaMax 
				+ ", pressione atmosferica: " + pressioneAtm + ", umidità: " + umidita);
	}	
	
	public String toString2() { //toString con differenze di pressioni mare-suolo
		return ("Temperatura: " + temperatura + ", temperatura percepita: " + temperaturaPercepita
				+ ", temperatura minima: " + temperaturaMin + ", temperatura massima=" + temperaturaMax 
				+ ", pressione atmosferica: " + pressioneAtm + ", umidità: " + umidita + 
				", pressione livello del mare: " + pressioneMare + ", pressione livello del suolo: " 
				+ pressioneSuolo);
	}
}

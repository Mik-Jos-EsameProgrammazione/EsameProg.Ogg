package MeteoDati;

//questa classe corrisponde all'oggetto sys della risposta API

public class Sistema extends DatiMeteo{
	protected int tipo; //parametro interno
	protected int id; // parametro interno	
	protected String paese; //sigla nazione
	protected long alba; //tempo in millisecondi trascorsi daa 1/01/1970 00:00 (ora alba)
	protected long tramonto; //tempo in millisecondi trascorsi daa 1/01/1970 00:00 (ora tramonto)
	
	public Sistema(String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base,
				   int tipo, int id, String paese, long alba, long tramonto) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.tipo = tipo;
		this.id = id;
		this.paese = paese;
		this.alba = alba;
		this.tramonto = tramonto;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public long getAlba() {
		return alba;
	}

	public void setAlba(long alba) {
		this.alba = alba;
	}

	public long getTramonto() {
		return tramonto;
	}

	public void setTramonto(long tramonto) {
		this.tramonto = tramonto;
	}

	public String toString() {
		return ("Tipo: " + tipo + ", id: " + id + ", paese: " + paese + ", alba: "+ alba + 
				", tramonto: " + tramonto);
	}
}


package MeteoDati;

//questa classe corrisponde all'oggetto clouds della risposta API

public class Nuvole extends DatiMeteo{
	protected int nuvolosita; //in %
	public Nuvole(String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base, 
				  int nuvolosita) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.nuvolosita = nuvolosita;
	}
	
	public int getNuvolosita() {
		return nuvolosita;
	}
	
	public void setNuvolosita(int nuvolosita) {
		this.nuvolosita = nuvolosita;
	}

	public String toString() {
		return ("Nuvolosita: " + nuvolosita);
	}
}
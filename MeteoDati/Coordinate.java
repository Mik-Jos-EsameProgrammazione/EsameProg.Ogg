package MeteoDati;

/**
 * @author mikdr
 */

//questa classe corrisponde all'oggetto coord della risposta API

public class Coordinate extends DatiMeteo{
	protected float longitudine;
	protected float latitudine;
	public Coordinate(String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base, 
					  float lon, float lat) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.longitudine = lon;
		this.latitudine = lat;
	}
	
	public float getLongitudine() {
		return longitudine;
	}
	
	public void setLongitudine(float longitudine) {
		this.longitudine = longitudine;
	}
	
	public float getLatitudine() {
		return latitudine;
	}
	
	public void setLatitudine(float latitudine) {
		this.latitudine = latitudine;
	}
	
	public String toString() {
		return ("Longitudine: " + longitudine + ", latitudine: " + latitudine);
	}
}


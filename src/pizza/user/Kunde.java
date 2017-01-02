package pizza.user;

public class Kunde{

	private final String nummer;
	private final String vname;
	private final String nname;
	private final String adresse;
	private final int plz;
	private final String ort;
	
	public Kunde(String nummer, String vname, String nname, String adresse, int plz, String ort){
		this.nummer = nummer;
		this.vname = vname;
		this.nname = nname;
		this.adresse = adresse;
		this.plz = plz;
		this.ort = ort;
	}

	public String getNummer() {
		return nummer;
	}

	public String getVname() {
		return vname;
	}

	public String getNname() {
		return nname;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getPlz() {
		return plz;
	}

	public String getOrt() {
		return ort;
	}

}

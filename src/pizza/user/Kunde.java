package pizza.user;

/*
 * String rep: 
 * Nummer, VName, NName, add, ort, plz
 */
public class Kunde {

	private final String nummer;
	private final String vname;
	private final String nname;
	private final String adresse;
	private final String ort;
	private final int plz;

	/**
	 * Creates a new Kunde object with specified data
	 * 
	 * @param nummer
	 * @param vname
	 * @param nname
	 * @param adresse
	 * @param ort
	 * @param plz
	 */
	public Kunde(String nummer, String vname, String nname, String adresse, String ort, int plz) {
		this.nummer = nummer;
		this.vname = vname;
		this.nname = nname;
		this.adresse = adresse;
		this.ort = ort;
		this.plz = plz;

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

	@Override
	public String toString() {

		return String.format("%s, %s, %s, %s, %s, %d", nummer, vname, nname, adresse, ort, plz);
	}

	/**
	 * Pares a String to a Kunde, the String has to be in the following format:
	 * <br>
	 * Nummer, VName, NName, add, ort, plz
	 * 
	 * @param s
	 * @return
	 */
	public static Kunde valueOf(String s) {
		String parts[];
		s = s.replace(" ", ""); // Leerzeichen entfernen
		parts = s.split(",");
		int plzn = Integer.parseInt(parts[5]);
		Kunde ret = new Kunde(parts[0], parts[1], parts[2], parts[3], parts[4], plzn);
		return ret;
	}
}

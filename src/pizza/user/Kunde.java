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
		if (isEmptyOrNull(nummer) || isEmptyOrNull(vname) || isEmptyOrNull(nname) || isEmptyOrNull(adresse)
				|| isEmptyOrNull(ort))
			throw new NullPointerException("Kunde values may not be null");
		this.nummer = nummer;
		this.vname = vname;
		this.nname = nname;
		this.adresse = adresse;
		this.ort = ort;
		this.plz = plz;

	}

	private boolean isEmptyOrNull(String s) {
		return s == null || s.equals("");
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
		s = s.replace(", ", ","); // Leerzeichen entfernen
		parts = s.split(",");
		int plzn = Integer.parseInt(parts[5]);
		Kunde ret = new Kunde(parts[0], parts[1], parts[2], parts[3], parts[4], plzn);
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((nname == null) ? 0 : nname.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + plz;
		result = prime * result + ((vname == null) ? 0 : vname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kunde other = (Kunde) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (nname == null) {
			if (other.nname != null)
				return false;
		} else if (!nname.equals(other.nname))
			return false;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (plz != other.plz)
			return false;
		if (vname == null) {
			if (other.vname != null)
				return false;
		} else if (!vname.equals(other.vname))
			return false;
		return true;
	}
}

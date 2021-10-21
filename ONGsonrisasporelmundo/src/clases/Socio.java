package clases;

public class Socio {
	
	private int idPartner;
	private String namePartner;
	

	public Socio() {
	}

	public Socio(int idPartner, String namePartner) {
		this.idPartner = idPartner;
		this.namePartner = namePartner;
	}

	public int getIdPartner() {
		return idPartner;
	}
	public void setIdPartner(int idPartner) {
		this.idPartner = idPartner;
	}
	public String getNamePartner() {
		return namePartner;
	}
	public void setNamePartner(String namePartner) {
		this.namePartner = namePartner;
	}
	
}

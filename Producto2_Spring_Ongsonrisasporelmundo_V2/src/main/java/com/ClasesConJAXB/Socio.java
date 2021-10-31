package com.ClasesConJAXB;

public class Socio {
	
	private String idPartner;
	private String namePartner;
	private String lastNamePartner;
	
	//Constructors
	
	public Socio(String idPartner, String namePartner, String lastNamePartner) {
		super();
		this.idPartner = idPartner;
		this.namePartner = namePartner;
		this.lastNamePartner = lastNamePartner;
	}

	public String getLastNamePartner() {
		return lastNamePartner;
	}

	public void setLastNamePartner(String lastNamePartner) {
		this.lastNamePartner = lastNamePartner;
	}

	@Override
	public String toString() {
		return "Socio idPartner:" + idPartner + ", namePartner:" + namePartner + ", lastNamePartner:" + lastNamePartner
				+ "";
	}

	public Socio() {
	}

	public Socio(String idPartner, String namePartner) {
		this.idPartner = idPartner;
		this.namePartner = namePartner;
	}

	//Getter and Setter
	public String getIdPartner() {
		return idPartner;
	}
	public void setIdPartner(String idPartner) {
		this.idPartner = idPartner;
	}
	public String getNamePartner() {
		return namePartner;
	}
	public void setNamePartner(String namePartner) {
		this.namePartner = namePartner;
	}
	
}

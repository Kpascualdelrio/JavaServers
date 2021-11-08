package com.ClasesConJAXB;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement (name = "Socio")
@XmlAccessorType(XmlAccessType.FIELD)
public class Socio {
	@XmlAttribute(name = "idPartner")
	private String idPartner;
	@XmlElement(name ="namePartner")
	private String namePartner;
	@XmlElement(name ="lastNamePartner")
	private String lastNamePartner;
	 @XmlElement(name = "socios")
	private List<Socio> socios;
	
	//Constructors

	public Socio(String idPartner, String namePartner, String lastNamePartner) {
		super();
		this.idPartner = idPartner;
		this.namePartner = namePartner;
		this.lastNamePartner = lastNamePartner;
		
	}

	

	@Override
	public String toString() {
		return "Socio idPartner:" + idPartner + ", namePartner:" + namePartner + ", lastNamePartner:" + lastNamePartner
				+ "";
	}

	public Socio() {
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
	
	public void setLastNamePartner(String lastNamePartner) {
		this.lastNamePartner = lastNamePartner;
	}
	public String getLastNamePartner() {
		return lastNamePartner;
	}
	
	public List<Socio> getSocios() {
		return socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
				
	}
	public void add(Socio socio) {
        if (this.socios == null) {
            this.socios = new ArrayList<Socio>();
        }
        this.socios.add(socio);
    }
}

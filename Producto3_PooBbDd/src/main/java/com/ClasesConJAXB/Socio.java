package com.ClasesConJAXB;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Socio")
@XmlAccessorType(XmlAccessType.FIELD)
public class Socio {
	@XmlAttribute(name = "idPartner")
	private int idPartner;
	@XmlElement(name = "namePartner")
	private String namePartner;
	@XmlElement(name = "lastNamePartner")
	private String lastNamePartner;
	@XmlElement(name = "socios")
	private List<Socio> socios;
	
	@XmlTransient
	private static final AtomicInteger idPartnerCount = new AtomicInteger(1);
	@XmlTransient
	private String prevNamePartner;
	@XmlTransient
	private String prevLastNamePartner;
	// Constructors
	
	
	
	public Socio(String namePartner, String lastNamePartner) {
		super();
		this.idPartner = idPartnerCount.getAndIncrement();
		this.namePartner = namePartner;
		this.lastNamePartner = lastNamePartner;

	}

	@Override
	public String toString() {
		return namePartner + " " + lastNamePartner;
	}

	public Socio() {
	}

	// Getter and Setter
	public int getIdPartner() {
		return idPartner;
	}

	public void setIdPartner(int idPartner) {
		this.idPartner = idPartnerCount.getAndDecrement();
	}

	public String getNamePartner() {
		return namePartner;
	}

	public void setNamePartner(String namePartner) {
		prevNamePartner = this.namePartner;
		this.namePartner = namePartner;
	}

	public void setLastNamePartner(String lastNamePartner) {
		prevLastNamePartner = this.lastNamePartner;
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

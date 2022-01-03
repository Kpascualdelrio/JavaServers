package javaservers.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Socio {
	
	private int idPartner;
	private String namePartner;
	private String lastNamePartner;
	private List<Socio> socios;
	
	private static final AtomicInteger idPartnerCount = new AtomicInteger(1);
	private String prevNamePartner;
	private String prevLastNamePartner;
	// Constructors
	
	
	
	public Socio(String namePartner, String lastNamePartner) {
		super();
		this.idPartner = idPartnerCount.getAndIncrement();
		this.namePartner = namePartner;
		this.lastNamePartner = lastNamePartner;

	}

	public String getPrevNamePartner() {
		return prevNamePartner;
	}

	public void setPrevNamePartner(String prevNamePartner) {
		this.prevNamePartner = prevNamePartner;
	}

	public String getPrevLastNamePartner() {
		return prevLastNamePartner;
	}

	public void setPrevLastNamePartner(String prevLastNamePartner) {
		this.prevLastNamePartner = prevLastNamePartner;
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

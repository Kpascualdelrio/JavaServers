package javaservers.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Equipo {
	
	private int idTeam;
	private String nameTeam;
	private String nameMember;
	
	private List<Equipo> equipos;
	
	private static final AtomicInteger idTeamCount = new AtomicInteger(1);
	private String prevNameTeam;
	private String prevNameMember;
	// Constructors
	public Equipo() {
	}

	public String getPrevNameTeam() {
		return prevNameTeam;
	}

	public void setPrevNameTeam(String prevNameTeam) {
		this.prevNameTeam = prevNameTeam;
	}

	public String getPrevNameMember() {
		return prevNameMember;
	}

	public void setPrevNameMember(String prevNameMember) {
		this.prevNameMember = prevNameMember;
	}

	public Equipo( String teamName, String memberName) {
		idTeam = idTeamCount.getAndIncrement();
		this.nameTeam = teamName;
		this.nameMember = memberName;
	}

	@Override
	public String toString() {
		return nameTeam;
	}

	// Getter and Setter
	public int getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeamCount.getAndDecrement();
	}

	public String getTeamName() {
		return nameTeam;
	}

	public void setTeamName(String teamName) { 
		prevNameTeam = this.nameTeam;
		this.nameTeam = teamName;
	}

	public String getMemberName() {
		return nameMember;
	}

	public void setMemberName(String memberName) {
		prevNameMember = this.nameMember;
		this.nameMember = memberName;
	}

	public void add(Equipo equipo) {
		if (this.equipos == null) {
			this.equipos = new ArrayList<Equipo>();
		}

		this.equipos.add(equipo);
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}
	
}

package javaservers.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Proyecto {
	
	private int idProject;
	private String socio;
	private String equipo;
	private String startDate;
	private String endDate;
	private String funder;
	private String financingProvided;
	private String projectCode;
	private String actionTaken;
	private String localPartner;
	private List<Proyecto> proyectos;
	
	private static final AtomicInteger idProjectCount = new AtomicInteger(1);
	//@XmlTransient
	//private String prevNameTeam;
	//@XmlTransient
	////private String prevNameMember;
	// Constructors
	

	// Constructors

	public Proyecto() {

	}

	public Proyecto( Socio socio, Equipo equipo, String startDate, String endDate, String funder,
			String financingProvided, String projectCode, String actionTaken, String localPartner) {

		this.idProject = idProjectCount.getAndIncrement();
		this.socio = socio.toString();
		this.equipo = equipo.toString();
		this.startDate = startDate;
		this.endDate = endDate;
		this.funder = funder;
		this.financingProvided = financingProvided;
		this.projectCode = projectCode;
		this.actionTaken = actionTaken;
		this.localPartner = localPartner;
	}

	// Getters and Setters
	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProjectCount.getAndIncrement();
	}

	public String getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio.toString();
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo.toString();
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getFunder() {
		return funder;
	}

	public void setFunder(String funder) {
		this.funder = funder;
	}

	public String getFinancingProvided() {
		return financingProvided;
	}

	public void setFinancingProvided(String financingProvided) {
		this.financingProvided = financingProvided;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getLocalPartner() {
		return localPartner;
	}

	public void add(Proyecto proyecto) {
		if (this.proyectos == null) {
			this.proyectos = new ArrayList<Proyecto>();
		}
		this.proyectos.add(proyecto);
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	@Override
	public String toString() {
		return "Proyecto idProject:" + idProject + ", socio:" + socio + ", equipo:" + equipo
				+ ", startDate:" + startDate + ", endDate:" + endDate + ", funder:" + funder + ", financingProvided:"
				+ financingProvided + ", projectCode:" + projectCode + ", actionTaken:" + actionTaken
				+ ", localPartner:" + localPartner + "";
	}

	public void setLocalPartner(String localPartner) {
		this.localPartner = localPartner;
	}

}

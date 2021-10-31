package com.clases;

public class Proyecto {

	private String idProject;
	private Socio socio;
	private Equipo equipo;
	private String startDate;
	private String endDate;
	private String funder;
	private String financingProvided;
	private String projectCode;
	private String actionTaken;
	private String localPartner;

	// Constructors

	public Proyecto() {

	}

	public Proyecto(String idProject, Socio socio, Equipo equipo, String startDate, String endDate, String funder,
			String financingProvided, String projectCode, String actionTaken, String localPartner) {

		this.idProject = idProject;
		this.socio = socio;
		this.equipo = equipo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.funder = funder;
		this.financingProvided = financingProvided;
		this.projectCode = projectCode;
		this.actionTaken = actionTaken;
		this.localPartner = localPartner;
	}

	// Getters and Setters
	public String getIdProject() {
		return idProject;
	}

	public void setIdProject(String idProject) {
		this.idProject = idProject;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
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

	@Override
	public String toString() {
		return "Proyecto idProject:" + idProject + ", socio:" + socio.getIdPartner() + ", equipo:" + equipo + ", startDate:"
				+ startDate + ", endDate:" + endDate + ", funder:" + funder + ", financingProvided:" + financingProvided
				+ ", projectCode:" + projectCode + ", actionTaken:" + actionTaken + ", localPartner:" + localPartner
				+ "";
	}

	public void setLocalPartner(String localPartner) {
		this.localPartner = localPartner;
	}

}

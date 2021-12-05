package com.ClasesConJAXB;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Proyecto")
@XmlAccessorType(XmlAccessType.FIELD)

public class Proyecto {
	@XmlAttribute(name = "idProject")
	private String idProject;
	@XmlElement(name = "socio")
	private Socio socio;
	@XmlElement(name = "equipo")
	private Equipo equipo;
	@XmlElement(name = "startDate")
	private String startDate;
	@XmlElement(name = "endDate")
	private String endDate;
	@XmlElement(name = "funder")
	private String funder;
	@XmlElement(name = "financingProvided")
	private String financingProvided;
	@XmlElement(name = "projectCode")
	private String projectCode;
	@XmlElement(name = "actionTaken")
	private String actionTaken;
	@XmlElement(name = "localPartner")
	private String localPartner;
	@XmlElement(name = "proyectos")
	private List<Proyecto> proyectos;

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
		return "Proyecto idProject:" + idProject + ", socio:" + socio.getIdPartner() + ", equipo:" + equipo
				+ ", startDate:" + startDate + ", endDate:" + endDate + ", funder:" + funder + ", financingProvided:"
				+ financingProvided + ", projectCode:" + projectCode + ", actionTaken:" + actionTaken
				+ ", localPartner:" + localPartner + "";
	}

	public void setLocalPartner(String localPartner) {
		this.localPartner = localPartner;
	}

}

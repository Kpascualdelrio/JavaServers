package transfersClass;

import genericClass.Equipo;
import genericClass.Socio;

public class DtoProyecto {
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

	public DtoProyecto(String idProject, Socio socio, Equipo equipo, String startDate, String endDate, String funder,
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
}

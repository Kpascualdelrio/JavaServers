package transfersClass;

import genericClass.ONG;

public class DtoEquipo {
	
	private String idTeam;
	private ONG ong;
	private String nameTeam;
	private String nameMember;
	
	public DtoEquipo(String idTeam, ONG ong, String teamName, String memberName) {
		this.idTeam = idTeam;
		this.ong = ong;
		this.nameTeam = teamName;
		this.nameMember = memberName;
	}


}

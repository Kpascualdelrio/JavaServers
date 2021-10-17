package clases;

public class Equipo {
	
	private int idTeam;
	private ONG ong;
	private String teamName;
	private String memberName;
	
	//Constructors
	public Equipo() {
	}
	
	public Equipo(int idTeam, ONG ong, String teamName, String memberName) {
		this.idTeam = idTeam;
		this.ong = ong;
		this.teamName = teamName;
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Equipo [idTeam=" + idTeam + "]";
	}
	
	//Getter y Setter
	public int getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}
	public ONG getOng() {
		return ong;
	}
	public void setOng(ONG ong) {
		this.ong = ong;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
}

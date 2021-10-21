package domainClass;

public class Equipo {
	
	
	private String idTeam;
	private ONG ong;
	private String nameTeam;
	private String nameMember;
	

	public Equipo() {
	}
	
	public Equipo(String idTeam, ONG ong, String teamName, String memberName) {
		this.idTeam = idTeam;
		this.ong = ong;
		this.nameTeam = teamName;
		this.nameMember = memberName;
	}

	@Override
	public String toString() {
		return "Equipo idTeam: " + idTeam + "";
	}
	
	
	public String getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(String idTeam) {
		this.idTeam = idTeam;
	}
	public ONG getOng() {
		return ong;
	}
	public void setOng(ONG ong) {
		this.ong = ong;
	}
	public String getTeamName() {
		return nameTeam;
	}
	public void setTeamName(String teamName) {
		this.nameTeam = teamName;
	}
	public String getMemberName() {
		return nameMember;
	}
	public void setMemberName(String memberName) {
		this.nameMember = memberName;
	}
	
}
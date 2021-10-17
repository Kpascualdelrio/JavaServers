package clases;

public class ONG {

	private int idOng;
	private String nameOng;
	
	//Constructors
	public ONG() {	
	}
	
	public ONG(int idOng, String name) {
		this.idOng = idOng;
		this.nameOng = name;
	}

	@Override
	public String toString() {
		return "ONG [idOng=" + idOng + ", name=" + nameOng + "]";
	}
	
	//Getter and Setter
	public int getIdOng() {
		return idOng;
	}
	
	public void setIdOng(int idOng) {
		this.idOng = idOng;
	}
	
	public String getName() {
		return nameOng;
	}
	
	public void setName(String name) {
		this.nameOng = name;
	}
	
	

}

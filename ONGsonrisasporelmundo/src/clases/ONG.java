package clases;

public class ONG {

	private int idOng;
	private String name;
	
	
	
	public ONG() {	
	}
	

	public ONG(int idOng, String name) {
		this.idOng = idOng;
		this.name = name;
	}


	@Override
	public String toString() {
		return "ONG [idOng=" + idOng + ", name=" + name + "]";
	}
	
	public int getIdOng() {
		return idOng;
	}
	
	public void setIdOng(int idOng) {
		this.idOng = idOng;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	

}

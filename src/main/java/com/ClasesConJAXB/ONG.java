package com.ClasesConJAXB;

import javax.xml.bind.annotation.*;

@XmlRootElement (name ="ONG")
@XmlAccessorType(XmlAccessType.FIELD)

	public class ONG {
@XmlElement (name = "idOng")
		private String idOng;
@XmlElement (name = "nameOng")
		private String nameOng;
		
		//Constructors
		public ONG() {	
		}
		
		public ONG(String idOng, String name) {
			this.idOng = idOng;
			this.nameOng = name;
		}

		@Override
		public String toString() {
			return "ONG idOng=" + idOng + ", name=" + nameOng + "";
		}
		
		//Getter and Setter
		public String getIdOng() {
			return idOng;
		}
		
		public void setIdOng(String idOng) {
			this.idOng = idOng;
		}
		
		public String getName() {
			return nameOng;
		}
		
		public void setName(String name) {
			this.nameOng = name;
		}
		
		

	}

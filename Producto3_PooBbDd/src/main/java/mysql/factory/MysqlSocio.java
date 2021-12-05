package mysql.factory;

import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ClasesConJAXB.Socio;

import mysql.factory.dao.factory.MysqlFactory;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlSocio implements MysqlFactory {
	final String INSERT = "INSERT INTO Socio(idPartner,namePartner,lastNamePartner) VALUES(?,?,?) ON DUPLICATE KEY UPDATE idPartner=idPartner, namePartner=namePartner,lastNamePartner=lastNamePartner";
	final String UPDATE = "UPDATE Socio SET namePartner=? lastNamePartner=? WHERE idPartner=? ";
	final String DELETE = "DELETE FROM Socio WHERE idPartner=? ";
	final String GETPARTNERS = "SELECT idPartner,namePartner, lastNamePartner FROM Socio";
	final String GETSOOCIO = "SELECT idPartner,namePartner, lastNamePartner  WHERE idPartner=? ";
	private Connection conn;
	public MysqlSocio(Connection conn) {
		this.conn = conn;
	}
	public MysqlSocio() {
		// TODO Auto-generated constructor stub
	}
	//método que recoge los datos del fichero xml
	public void parse() throws ParserConfigurationException, SAXException, Exception {
		File f = null;
		File file = new File("socios.xml");
		// an instance of factory that gives a document builder
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// an instance of builder to parse the specified xml file
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName("Socio");
		// nodeList is not iterable, so we are using for loop

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node id = nodeList.item(i);
			// Node personalDetails = nodeList.item(i);

			for (int j = 0; j < id.getChildNodes().getLength(); j++) {
				Node n = id.getChildNodes().item(j);

				if (n instanceof Element) {
					Element e = (Element) n;
					String idPartner=e.getAttribute("idPartner");
					String name= e.getElementsByTagName("namePartner").item(0).getTextContent();
					String lastName =e.getElementsByTagName("lastNamePartner").item(0).getTextContent();
				}

			}
		}
	}
	//método que toma los datos del fichero y retorna en un objeto de clase
	private Socio convert(ResultSet rs) throws SQLException {

		String idPartner = rs.getString("idPartner");
		String namePartner = rs.getString("namePartner");
		String lastNamePartner = rs.getString("lastNamePartner");
		Socio socio = new Socio(idPartner, namePartner, lastNamePartner);
		return socio;
	}

	
	@Override
	public void insertar(Object a) throws Exception, Throwable {
		PreparedStatement stat = null;
		try {

			stat = conn.prepareStatement(INSERT);
			stat.setString(1, ((Socio) a).getIdPartner());
			stat.setString(2, ((Socio) a).getNamePartner());
			stat.setString(3, ((Socio) a).getLastNamePartner());
			if (stat.executeUpdate() == 0) {
				throw new Exception("No se han podido insertar los datos correctamente");
			} else {
				System.out.println("Datos introducidos correctamente: " + a.toString());
			}
		} catch (SQLException ex) {
			throw new Exception("Error en SQL ", ex);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new Exception("Error en SQL ", ex);
				}
			}
		}
	}

	@Override
	public void modificar(Object a) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminar(Object a) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object obtener(Object idPartner) throws Exception {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Socio socio = null;
		try {
			stat = conn.prepareStatement(GETSOOCIO);
			stat.setString(1, (String) idPartner);
			rs = stat.executeQuery();
			if (rs.next()) {

				socio = convert(rs);
			} else {
				throw new Exception("No tienes socios con ese id ");
			}

		} catch (SQLException e) {
			throw new Exception("Error en SQL", e);
		}
		try {

			try {
				stat = conn.prepareStatement(GETSOOCIO);
			} catch (SQLException ex) {
				throw new Exception("Error en SQL ", ex);
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new Exception("Error en SQL", e);
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new Exception("Error en SQL", e);
				}
			}
		}

		return socio;
	}

	
	@Override
	public void spec() {
		System.out.println("Socio");
		
	}
	

	

}

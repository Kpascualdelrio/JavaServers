package dao;

import java.util.List;

import clases.Socio;

// métodos que implementaré en mis clases
public interface Dao<clase, tipoDatoClavePrimaria>{

	void insertar(clase a) throws Daoexceptions;
	void modificar(clase a) throws Daoexceptions;
	void eliminar(clase a) throws Daoexceptions;
	List<clase>obtenerTodos() throws Daoexceptions;
	clase obtener(tipoDatoClavePrimaria id) throws Exception;

	
	
	
}

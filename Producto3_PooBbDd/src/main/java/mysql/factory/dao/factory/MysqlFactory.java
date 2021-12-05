package mysql.factory.dao.factory;

import java.util.List;

public interface MysqlFactory<clase, tipoDatoClavePrimaria>{

	void insertar(clase a) throws Exception, Throwable;
	void modificar(clase a);
	void eliminar(clase a) ;
	List<clase>obtenerTodos();
	clase obtener(tipoDatoClavePrimaria id) throws Exception;
	void spec();
	
	
	
}

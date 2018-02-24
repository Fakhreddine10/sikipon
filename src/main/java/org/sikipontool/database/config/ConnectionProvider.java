package org.sikipontool.database.config;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionProvider extends Serializable {
	
	
	Connection getConnection() throws SQLException;
	
	void releaseConnection(Connection conn) throws SQLException; 

}

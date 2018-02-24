package org.sikipontool.database.config;

import java.io.Serializable;


public interface DriverLoader extends Serializable {

	void loadDriver() throws Exception;
}

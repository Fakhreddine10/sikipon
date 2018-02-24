package org.sikipontool.database.config;

import org.springframework.stereotype.Component;

@Component
public class DriverLoaderImpl implements DriverLoader {

	private static final long serialVersionUID = 1995689661872755788L;

	public void loadDriver() throws Exception {
		DataSourceProperties dataSourceProperties = ConfigurationFileReaderImpl.getInstance().getDataSourceProperties();
		String className = dataSourceProperties.getDriverClassName();
		Class.forName(className);
	}

}

package org.sikipontool.database.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectionProviderImpl implements ConnectionProvider {
	private static final Logger logger = Logger.getLogger(ConnectionProviderImpl.class.getName());

	private boolean isInitiliazed = false;
	private boolean isConnectionClosed = false;
	private Connection connection;

	@Autowired
	private DriverLoader driverLoader;
	@Autowired
	private transient ConfigurationFileReader configurationFileReader;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7162255578075420455L;

	public Connection getConnection() throws SQLException {
		DataSourceProperties dataSourceProperties = configurationFileReader.getDataSourceProperties();
		if (!isInitiliazed) {
			try {
				driverLoader.loadDriver();
				connection = DriverManager.getConnection(dataSourceProperties.getUrl(),
						dataSourceProperties.getUserName(), dataSourceProperties.getPassword());
				isInitiliazed = true;
			} catch (Exception e) {
				logger.log(Level.WARNING, "Cannot load the driver", e);
			}
		}
		if (!isConnectionClosed)
			return connection;
		return DriverManager.getConnection(dataSourceProperties.getUrl(), dataSourceProperties.getUserName(),
				dataSourceProperties.getPassword());

	}

	public void releaseConnection(Connection conn) throws SQLException {
		conn.close();
		isConnectionClosed = true;

	}

}

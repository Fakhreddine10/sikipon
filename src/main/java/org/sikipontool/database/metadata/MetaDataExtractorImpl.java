package org.sikipontool.database.metadata;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.sikipontool.database.config.ConnectionProvider;

public class MetaDataExtractorImpl implements MetaDataExtractor {

	private static final Logger LOGGER = Logger.getLogger(MetaDataExtractorImpl.class.getName());

	private ConnectionProvider connectionProvider;
	private DatabaseMetaData databaseMetaData;
	private String catalogName;
	private String schemaName;

	public DatabaseMetaData getJdbcDatabaseMetaData() {
		if (databaseMetaData == null) {
			try {
				databaseMetaData = connectionProvider.getConnection().getMetaData();
			} catch (SQLException e) {
				LOGGER.log(Level.SEVERE, "Unable to obtain JDBC DatabaseMetaData", e);
			}
		}
		return databaseMetaData;
	}

	public String getDefaultCatalog() {
		if (catalogName != null)
			return catalogName;
		try {
			catalogName = connectionProvider.getConnection().getCatalog();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to obtain the Catalog Name", e);
		}
		return catalogName;
	}

	public String getDefaultSchema() {
		if (schemaName != null)
			return schemaName;
		try {
			schemaName = connectionProvider.getConnection().getSchema();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to obtain the Schema Name", e);
		}
		return schemaName;
	}

	public void cleanUp() {
		if (databaseMetaData != null) {
			databaseMetaData = null;
		}
	}

}

package org.sikipontool.database.metadata;

import java.sql.DatabaseMetaData;

/**
 * Defines a context for performing extraction including providing access to
 * information DataBase metaData.
 */
public interface MetaDataExtractor {

	DatabaseMetaData getJdbcDatabaseMetaData();

	String getDefaultCatalog();

	String getDefaultSchema();

	void cleanUp();
}

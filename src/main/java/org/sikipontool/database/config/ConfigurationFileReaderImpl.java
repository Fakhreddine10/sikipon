package org.sikipontool.database.config;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@Component
public class ConfigurationFileReaderImpl implements ConfigurationFileReader {

	private DataSourceProperties dataSourceProperties;
	private static final String FILENAME = "DataSourceProp.yml";
	private static final Logger logger = Logger.getLogger(ConfigurationFileReaderImpl.class.getName());
	private static final ConfigurationFileReader INSTANCE = new ConfigurationFileReaderImpl();

	private ConfigurationFileReaderImpl() {

	}

	public DataSourceProperties getDataSourceProperties() {
		if (dataSourceProperties == null) {
			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			try {
				dataSourceProperties = mapper.readValue(new File(FILENAME), DataSourceProperties.class);
				return dataSourceProperties;
			} catch (Exception e) {
				logger.log(Level.WARNING, getErrorMessage(), e);
			}
		}
		return dataSourceProperties;
	}

	private String getErrorMessage() {
		return "Cannot Fine the " + FILENAME + "File";

	}

	public static ConfigurationFileReader getInstance() {
		return INSTANCE;
	}

}

package org.sikipontool.database.config;

public class DataSourceProperties {

	private String platform;
	private String username;
	private String password;
	private String url;
	private String driverClassName;
	private String schemaName;

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

}

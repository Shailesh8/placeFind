package com.project.sources;

import java.io.IOException;
import java.util.Properties;

import com.project.utils.CommonUtils;
import com.project.utils.MongoConstants;

// TODO: Auto-generated Javadoc
/**
 * Configuration class for mongo database.
 */
public class MongoPropertyObject {

	/** The ip. */
	private String ip;
	
	/** The port. */
	private String port;
	
	/** The db name. */
	private String dbName;
	
	/** The mongo object. */
	public static MongoPropertyObject mongoObject;

	/**
	 * Instantiates a new mongo property object.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private MongoPropertyObject() throws IOException {
		Properties prop = setProperty();
		if (prop.getProperty(MongoConstants.INFRA_FLAG) != null
				&& Boolean.valueOf(prop.getProperty(MongoConstants.INFRA_FLAG).equals("true"))) {
			// TODO infra functionality
		} else {
			setIp(prop.getProperty(MongoConstants.IP));
			setPort(prop.getProperty(MongoConstants.PORT_PROPERTY));
			setDbName(prop.getProperty(MongoConstants.DBNAME_PROPERTY));
		}
	}

	/**
	 * Initialize mongo property object.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void initialize() throws IOException {
		if (mongoObject == null) {
			setMongoObject(new MongoPropertyObject());
		}
	}

	/**
	 * Sets the property.
	 *
	 * @return the properties
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static Properties setProperty() throws IOException {
		Properties prop = CommonUtils.getProperty(MongoConstants.DBCONFIG_PROPERTIES);
		if (prop == null) {
			CommonUtils.loadConfigProperties();
			prop = CommonUtils.getProperty(MongoConstants.DBCONFIG_PROPERTIES);
		}
		return prop;
	}

	/**
	 * Sets the mongo object.
	 *
	 * @param mongoObject the new mongo object
	 */
	private static void setMongoObject(MongoPropertyObject mongoObject) {
		MongoPropertyObject.mongoObject = mongoObject;
	}

	/**
	 * Gets the ip.
	 *
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Sets the ip.
	 *
	 * @param ip the new ip
	 */
	private void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	private void setPort(String port) {
		this.port = port;
	}

	/**
	 * Gets the db name.
	 *
	 * @return the db name
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * Sets the db name.
	 *
	 * @param dbName the new db name
	 */
	private void setDbName(String dbName) {
		this.dbName = dbName;
	}
}

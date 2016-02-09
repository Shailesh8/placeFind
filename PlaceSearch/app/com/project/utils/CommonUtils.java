package com.project.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import play.Logger;
import com.google.gson.JsonElement;
import com.project.logger.LoggerConstants;
import com.project.migration.DataMigration;
import com.project.placeModel.Place;
import com.rits.cloning.Cloner;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonUtils.
 */
public class CommonUtils {

	/** The property map. */
	static Map<String, Properties> propertyMap = new HashMap<String, Properties>();
	
	/** The config prop. */
	static Properties configProp = null;
	
	/** The input. */
	static InputStream input = null;
	
	/** The cloner. */
	private static Cloner cloner = new Cloner();

	/**
	 * Gets the cloner.
	 *
	 * @return the cloner
	 */
	public static Cloner getCloner() {
		return cloner;
	}


	/**
	 * Load config properties.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*
	 * Load Properties from configuration files
	 */
	public static void loadConfigProperties() throws IOException {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		File folder = new File(CommonUtilConstants.CONFIGPATH);
		FilenameFilter filter = getFileNameFilter(folder);
		File[] listOfFiles = folder.listFiles(filter);

		if (listOfFiles == null) {
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.CONFIGURATION_FILES_MISSING);
			Logger.of(LoggerConstants.PROJECT_LOGGER).error(LoggerConstants.CONFIGURATION_FILES_MISSING);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return;
		}

		for (int i = 0; i < listOfFiles.length; i++) {
			input = new FileInputStream(listOfFiles[i]);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.PROP_LOAD);
			configProp = new Properties();
			if (input == null) {
				continue;
			}
			configProp.load(input);
			propertyMap.put(listOfFiles[i].getName(), configProp);
		}

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.PROP_LOAD_EVENT_SUCCESS);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
	}

	/**
	 * Gets the file name filter.
	 *
	 * @param file the file
	 * @return the file name filter
	 */
	/*
	 * Gets filename filter
	 * 
	 * @Return filter
	 */
	private static FilenameFilter getFileNameFilter(File file) {

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);

		FilenameFilter fileNameFilter = new FilenameFilter() {

			@Override
			public boolean accept(File file, String name) {
				if (name.lastIndexOf('.') > 0) {
					// get last index for '.' char
					int lastIndex = name.lastIndexOf('.');

					// get extension
					String str = name.substring(lastIndex);

					// match path name extension
					if (str.equals(CommonUtilConstants.PROPERTYCONSTANT)) {
						return true;
					}
				}
				return false;
			}
		};
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		return fileNameFilter;
	}
	
	/**
	 * Gets the property.
	 *
	 * @param fileName the file name
	 * @return the property
	 */
	/*
	 * Retrieves properties based on file name in property Map
	 * 
	 * @Param filename
	 * 
	 * @Return properties
	 */
	public static Properties getProperty(String fileName) {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);

		return propertyMap.get(fileName);
	}

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 */
	/*
	 * Returns propertymap
	 */
	public static Map<String, Properties> getProperties() {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		return propertyMap;
	}

	/**
	 * Obj to json.
	 *
	 * @param obj the obj
	 * @return the string
	 */
	/*
	 * Converts object to json
	 * 
	 * @Param object
	 */
	public static String objToJson(Object obj) {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		String jsonResult = ModelUtils.getGson().toJson(obj);
		return jsonResult;
	}

	/**
	 * Json to obj.
	 *
	 * @param data the data
	 * @return the place
	 */
	/*
	 * Converts Json to Object
	 * 
	 * @Param String data
	 * 
	 * @Returns: CompositeObject
	 */
	public static Place jsonToObj(JsonElement data) {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		Place obj = ModelUtils.getGson().fromJson(data, Place.class);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		return obj;
	}

	/**
	 * Read file.
	 *
	 * @param path the path
	 * @param encoding the encoding
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*
	 * Reads file from specified path
	 * 
	 * @params: path of the file, charset encoding
	 */
	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	/**
	 * Generate datafrom csv into mongo db.
	 *
	 * @throws JSONException the JSON exception
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public static void generateDatafromCSVIntoMongoDB() throws JSONException, NoSuchFieldException, SecurityException {

		DataMigration.doMigrate();
	}

	/**
	 * Paramcheck.
	 *
	 * @param param the param
	 * @return true, if successful
	 */
	public static boolean paramcheck(String param) {
		if (param == null || param.isEmpty()) {
			return false;
		}
		return true;
	}
}

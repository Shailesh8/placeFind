package com.project.utils;

import play.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.logger.LoggerConstants;
import com.project.migration.placeDeserialize;
import com.project.placeModel.Place;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelUtils.
 */
public class ModelUtils {

	/**
	 * Gson.
	 *
	 * @return the gson
	 */
	public static Gson getGson() {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Place.class, new placeDeserialize());
		Logger.info(LoggerConstants.GSON_CREATED);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		return gsonBuilder.create();
	}

}

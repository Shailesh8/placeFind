package com.project.placeModel;

import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.project.logger.LoggerConstants;
import com.project.sources.MorphiaObject;
import com.project.utils.CommonUtils;

import play.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class Place.
 */
@Entity
public class Place implements IPersistanceObject, Cloneable {

	/** The id. */
	@Id
	String id;
	
	/** The name. */
	String name;
	
	/** The category. */
	String category;
	
	/** The rating. */
	Double rating;
	
	/** The latitude. */
	Double latitude;
	
	/** The longitude. */
	Double longitude;

	/**
	 * Instantiates a new place.
	 */
	public Place() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/* (non-Javadoc)
	 * @see com.project.placeModel.IPersistanceObject#get(java.lang.String)
	 */
	@Override
	public Place get(String id) {

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.ID + id);

		// TODO use input parameter check
		if (id == null || id.isEmpty()) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}

		Place savedObj = MorphiaObject.getDatastore().get(this.getClass(), id);

		if (savedObj == null) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}

		Logger.of(LoggerConstants.PROJECT_LOGGER).info(LoggerConstants.GET_DB_OBJECT);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.GET_DB_OBJECT);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);

		return savedObj;
	}

	/* (non-Javadoc)
	 * @see com.project.placeModel.IPersistanceObject#put(com.project.placeModel.Place)
	 */
	@Override
	public void put(Place obj) {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.INPUT_PARAMS + LoggerConstants.LOGGER_SPACE
				+ LoggerConstants.LOGGER_COLON + LoggerConstants.LOGGER_SPACE + CommonUtils.objToJson(obj));

		if (obj == null) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return;
		}
		MorphiaObject.getDatastore().save(obj);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.SAVE_MESSAGE);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
	}

	/* (non-Javadoc)
	 * @see com.project.placeModel.IPersistanceObject#delete(java.lang.String)
	 */
	@Override
	/*
	 * Deletes the object in Database
	 * 
	 * @Params Id of the Object
	 * 
	 * @return deleted object
	 */
	public Place delete(String Id) {

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.INPUT_PARAMS + LoggerConstants.LOGGER_SPACE
				+ LoggerConstants.LOGGER_COLON + LoggerConstants.LOGGER_SPACE + Id);

		if (Id == null || Id.isEmpty()) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}

		Place savedObj = get(Id);

		if (savedObj == null) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);

			return null;
		}

		MorphiaObject.getDatastore().delete(this.getClass(), Id);

		Logger.info(LoggerConstants.DELETED);
		return savedObj;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public static long getCount() throws NoSuchFieldException, SecurityException {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
	    long counter = MorphiaObject.getDatastore().getCount(Place.class);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		return counter;
	}

	/**
	 * Find query.
	 *
	 * @return the list
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public static List<Place> findQuery() throws NoSuchFieldException, SecurityException {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		List<Place> userList = MorphiaObject.getDatastore().createQuery(Place.class).retrievedFields(true,
				PlaceContext.ID, PlaceContext.name, PlaceContext.rating, PlaceContext.latitude, PlaceContext.longitude)
				.asList();
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		return userList;
	}

	/**
	 * Find query.
	 *
	 * @param fieldName the field name
	 * @param fieldValue the field value
	 * @return the list
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public static List<Place> findQuery(String fieldName, String fieldValue)
			throws NoSuchFieldException, SecurityException {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		List<Place> userList = MorphiaObject.getDatastore().createQuery(Place.class).filter(fieldName, fieldValue)
				.asList();
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		return userList;
	}
}

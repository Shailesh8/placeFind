




package com.project.placeModel;


// TODO: Auto-generated Javadoc
/**
 * The Interface IPersistanceObject.
 */
public interface IPersistanceObject {

	/**
	 * Gets the.
	 *
	 * @param Id the id
	 * @return the place
	 */
	public Place get(String Id);
	
	/**
	 * Put.
	 *
	 * @param obj the obj
	 */
	public  void put(Place obj);
	
	/**
	 * Delete.
	 *
	 * @param Id the id
	 * @return the place
	 */
	public  Place delete(String Id);
}

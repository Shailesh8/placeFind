package com.project.sources;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;


// TODO: Auto-generated Javadoc
/**
 * Creates Morphia Object to do operations with DB.
 */
public class MorphiaObject {

    /** The mongo. */
    private static  Mongo mongo;

    /** The morphia. */
    private static  Morphia morphia;

    /** The datastore. */
    private static  Datastore datastore;

	/**
	 * Gets the mongo.
	 *
	 * @return the mongo
	 */
	public static Mongo getMongo() {
		return mongo;
	}

	/**
	 * Sets the mongo.
	 *
	 * @param mongo the new mongo
	 */
	public static void setMongo(Mongo mongo) {
		MorphiaObject.mongo = mongo;
	}

	/**
	 * Gets the morphia.
	 *
	 * @return the morphia
	 */
	public static Morphia getMorphia() {
		return morphia;
	}

	/**
	 * Sets the morphia.
	 *
	 * @param morphia the new morphia
	 */
	public static void setMorphia(Morphia morphia) {
		MorphiaObject.morphia = morphia;
	}

	/**
	 * Gets the datastore.
	 *
	 * @return the datastore
	 */
	public static Datastore getDatastore() {
		return datastore;
	}

	/**
	 * Sets the datastore.
	 *
	 * @param datastore the new datastore
	 */
	public static void setDatastore(Datastore datastore) {
		MorphiaObject.datastore = datastore;
	}
}

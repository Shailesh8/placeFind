package com.project.sources;

import java.io.IOException;
import java.net.UnknownHostException;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.project.logger.LoggerConstants;
import com.project.utils.MongoConstants;
import play.Logger;

/**
 * The Class MongoDB.
 */
public final class MongoDB {

	/**
	 * Connects to MongoDB based on the configuration settings.
	 * <p/>
	 * If the database is not reachable, an error message is written and the
	 * application exits.
	 *
	 * @return true, if successful
	 */
	public static boolean connectToDB(){

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		MorphiaObject.setMongo(null);
		try {
			MongoPropertyObject.initialize();
			MorphiaObject.setMongo(new Mongo(MongoPropertyObject.mongoObject.getIp(), Integer.parseInt(MongoPropertyObject.mongoObject.getPort())));
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.CONNECT_MONGODB);

			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(
					LoggerConstants.MONGO_PORT+MongoConstants.PORT);

		} catch (UnknownHostException e) {
			Logger.of(LoggerConstants.PROJECT_LOGGER).info(
					LoggerConstants.HOST_UNKNOWN);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(
					LoggerConstants.METHOD_EXIT);
			return false;
		} catch (IOException e) {
			Logger.info(LoggerConstants.FILE_NOTFOUND_INPUTSTREAMREADER);
			return false;
		}

		if (MorphiaObject.getMongo() != null) {
			MorphiaObject.setMorphia(new Morphia());
			MorphiaObject.setDatastore(MorphiaObject.getMorphia().createDatastore(MorphiaObject.getMongo(), MongoPropertyObject.mongoObject.getDbName()));
			Logger.info(LoggerConstants.CREATED_DATA_STORE);
		}
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		return true;
	}

	/**
	 * Disconnect from MongoDB.
	 *
	 * @return true, if successful
	 */
	public static boolean disconnectFromDB() {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);

		if (MorphiaObject.getMongo() == null) {
			return false;
		}

		MorphiaObject.setMorphia(null);
		MorphiaObject.setDatastore(null);
		MorphiaObject.getMongo().close();
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.DISCONNECT_MONGODB);

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		return true;
	}
}
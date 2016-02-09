package com.project.migration;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ModelContext objects.
 */
public class ModelContextFactory {

	/**
	 * Return ModelContext based on model name.
	 *
	 * @param name the name
	 * @return the model context
	 */
	public static PlaceRecordContext getModelContext(String name) {

		if (name.equals(ModelRegistery.PLACE_RECORD_CONTEXT)) {
			return new PlaceRecordContext();
		}
		return null;
	}
}

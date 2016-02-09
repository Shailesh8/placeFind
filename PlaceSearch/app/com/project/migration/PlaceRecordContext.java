package com.project.migration;

import com.project.placeModel.PlaceContext;
import com.project.placeModel.PlaceContextConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class PlaceRecordContext.
 */
public class PlaceRecordContext {

	/**
	 * Return the all filed name present in Model as single String that
	 * Describes model.
	 *
	 * @return the pattern
	 */
	public String getPattern() {
		return PlaceContext.ID + PlaceContextConstant.COMMA + PlaceContext.name + PlaceContextConstant.COMMA
				+ PlaceContext.category + PlaceContextConstant.COMMA + PlaceContext.rating
				+ PlaceContextConstant.COMMA + PlaceContext.longitude + PlaceContextConstant.COMMA
				+ PlaceContext.latitude+PlaceContextConstant.NEW_LINE;
	}
}

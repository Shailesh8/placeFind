package com.project.migration;

import java.lang.reflect.Type;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.project.placeModel.Place;
import com.project.placeModel.PlaceContext;

// TODO: Auto-generated Javadoc
/**
 * The Class placeDeserialize.
 */
public class placeDeserialize implements JsonDeserializer<Place> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public Place deserialize(JsonElement json, Type arg1, JsonDeserializationContext context)
			throws JsonParseException {
		final JsonObject jsonObject = json.getAsJsonObject();
			Place compObj = new Place();
			final JsonElement idJson = jsonObject.get(PlaceContext.ID);
			if (idJson != null) {
				final String id = idJson.getAsString();
				compObj.setId(id);
			}

			final JsonElement name = jsonObject.get(PlaceContext.name);
			if (name != null) {
				compObj.setName(name.getAsString());
			}
	
			final JsonElement category = jsonObject.get(PlaceContext.category);
			if (category != null) {
				compObj.setCategory(category.getAsString());
			}
	
			final JsonElement rating = jsonObject.get(PlaceContext.rating);
			if (rating != null) {
				compObj.setRating(Double.parseDouble(rating.getAsString()));
			}
	
			System.out.println("");
			final JsonElement longitude = jsonObject.get(PlaceContext.longitude);
			if (longitude != null) {
				compObj.setLongitude(Double.parseDouble(longitude.getAsString()));
			}
	
			final JsonElement latitude = jsonObject.get(PlaceContext.latitude);
			if (latitude != null) {
				compObj.setLatitude(Double.parseDouble(latitude.getAsString()));
			}
			return compObj;
		}
	}


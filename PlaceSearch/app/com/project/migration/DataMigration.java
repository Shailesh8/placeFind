package com.project.migration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.CDL;
import org.json.JSONException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.project.placeModel.Place;
import com.project.utils.CommonUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class DataMigration.
 */
public class DataMigration {

	/**
	 * Do migrate.
	 *
	 * @throws JSONException the JSON exception
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public static void doMigrate() throws JSONException, NoSuchFieldException, SecurityException {
		String modelFielsPatterns = getModelFileds();
		;
		String csvFileToRead = "convertcsv.csv";
		BufferedReader br = null;
		String line = "";

		try {
			int count = 0;
			br = new BufferedReader(new FileReader(csvFileToRead));
			while ((line = br.readLine()) != null) {
				org.json.JSONArray array = CDL.toJSONArray(modelFielsPatterns + line);
				String d = array.toString(2);
				JsonParser parser = new JsonParser();
				JsonArray jArray = parser.parse(d).getAsJsonArray();
				for (JsonElement obj : jArray) {
					Place cse = null;
					if (count != 0) {
						cse = CommonUtils.jsonToObj(obj);
						cse.put(cse);
					}
					count++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Gets the model fileds.
	 *
	 * @return the model fileds
	 */
	private static String getModelFileds() {
		PlaceRecordContext placeRecordContextModel = ModelContextFactory
				.getModelContext(ModelRegistery.PLACE_RECORD_CONTEXT);
		return placeRecordContextModel.getPattern();
	}
}

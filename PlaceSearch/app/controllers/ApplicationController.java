package controllers;

import java.util.List;
import com.project.placeModel.Place;
import com.project.utils.ModelUtils;
import views.html.map;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import com.project.logger.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationController.
 */
public class ApplicationController extends Controller {

		/**
		 * Index.
		 *
		 * @return the result
		 */
		public static Result index() {
					return ok();
		}
		
		/**
		 * Gets the all.
		 *
		 * @return the all
		 * @throws NoSuchFieldException the no such field exception
		 * @throws SecurityException the security exception
		 */
		public static Result getAll() throws NoSuchFieldException, SecurityException{
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
			List<Place> records = Place.findQuery();
			String recordsJson = ModelUtils.getGson().toJson(records);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return ok(recordsJson);
		}
		
		/**
		 * Gets the map service.
		 *
		 * @return the map service
		 */
		public static Result getMapService(){
			return ok(map.render());
		}

		/**
		 * Gets the count.
		 *
		 * @return the count
		 * @throws NoSuchFieldException the no such field exception
		 * @throws SecurityException the security exception
		 */
		public static Result getCount() throws NoSuchFieldException, SecurityException{
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		    long count = Place.getCount();
			String recordsJson = ModelUtils.getGson().toJson(count);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
			return ok(recordsJson);
		}
		
		/**
		 * Gets the result.
		 *
		 * @param query the query
		 * @return the result
		 * @throws NoSuchFieldException the no such field exception
		 * @throws SecurityException the security exception
		 */
		public static Result getResult(String query) throws NoSuchFieldException, SecurityException{
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
			
			if (query == null || query.isEmpty()) {
				Logger.of(LoggerConstants.PROJECT_LOGGER).error(LoggerConstants.STRING_EMPTY);
				return status(400);
			}
                 
			String[] q = query.split("=");
			if(q.length != 2 || q[0] == null || q[1] == null || q[0].isEmpty() || q[1].isEmpty()){
				Logger.of(LoggerConstants.PROJECT_LOGGER).error(LoggerConstants.STRING_EMPTY);
				return status(400);
			}
			List<Place> records = Place.findQuery(q[0], q[1]);
			String recordsJson = ModelUtils.getGson().toJson(records);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return ok(recordsJson);
		}
}

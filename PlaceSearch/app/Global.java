import java.io.IOException;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import com.project.logger.LoggerConstants;
import com.project.sources.MongoDB;
import com.project.utils.CommonUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class Global.
 */
public class Global extends GlobalSettings {
	
	/* (non-Javadoc)
	 * @see play.GlobalSettings#onStart(play.Application)
	 */
	public void onStart(Application app) {
		Logger.of(LoggerConstants.PROJECT_LOGGER).info(LoggerConstants.APP_START);

		try {
			CommonUtils.loadConfigProperties();
			MongoDB.connectToDB();
			CommonUtils.generateDatafromCSVIntoMongoDB();
			
		} catch (IOException e) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + e.getMessage());
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		} 
		catch (Exception e) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + e.getMessage());
		}
	}
}
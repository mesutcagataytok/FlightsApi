

package Base;


import Constants.Constants;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;


public class TestBase implements Constants {

	public Logger logger;

	@BeforeClass
	public void setup(){

		logger=Logger.getLogger("API");//added Logger
		PropertyConfigurator.configure("log4j.properties"); //added logger
		logger.setLevel(Level.DEBUG);

	}






}

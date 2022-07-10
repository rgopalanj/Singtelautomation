package common.helpers;

public class Constants {

    //Folders
    public static final String CONFIG_FOLDER = "config";
    public static final String DRIVERS_FOLDER = "drivers";

    //WaitTimes
    public static final String WAIT_NUMBER = "wait_number";
    public static final String OBJECT_WAIT_TIME = "object_wait_time";

    //ExecutionTYpe
    public static final String ENV_VARIABLE_BROWSER_NAME = "browser_name";
    public static final String ENV_VARIABLE_EXECUTION_TYPE = "execution_type";

    //Drivers
    public static final String GECKO_DRIVER_PATH = CONFIG_FOLDER + "/" + DRIVERS_FOLDER + "/" + "geckodriver.exe";
    public static final String CHROME_DRIVER_PATH = CONFIG_FOLDER + "/" + DRIVERS_FOLDER + "/" + "chromedriver.exe";
    public static final String IE_DRIVER_PATH = CONFIG_FOLDER + "/" + DRIVERS_FOLDER + "/" + "IEDriverServer.exe";

}

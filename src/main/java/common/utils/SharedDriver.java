package common.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Map;


public class SharedDriver extends EventFiringWebDriver {

    public static Map<String,String> env_config_map = null;

    protected static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    static {

        driver = DriverUtil.getDriver();
        System.out.println("<----------------------WeDriver is launched---------------------->");

    }

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            try {
                System.out.println("Driver gets Killed Here");
                driver.quit();
            }
            catch(Exception e) {

            }
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedDriver() {
        super(driver);
    }

}
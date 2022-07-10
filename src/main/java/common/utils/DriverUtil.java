package common.utils;
import common.helpers.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverUtil {

    public static WebDriver getDriver() {
        WebDriver driver = null;
        String strExecutionType = System.getProperty(Constants.ENV_VARIABLE_EXECUTION_TYPE, "");
        DesiredCapabilities capability = null;
        String strEnvironment = "";
        String strPlatform = "";
        try {
            //<-------------Browser Execution Type Starts Here----------------->
            if (strExecutionType.equalsIgnoreCase("BROWSER")) {
                String strBrowser = System.getProperty(Constants.ENV_VARIABLE_BROWSER_NAME, "");
                driver = getLocalDriver(strBrowser);

            }
            //<-------------Browser Execution Type ends Here----------------->

            else if (strExecutionType.isEmpty()) {
                System.out.println("\nCAP Fatal Error : Type is missing. E.g. Type=Browser");
                System.exit(0);
            } else {
                System.out.println("\nCAP Fatal Error : Invaild Type. Valid types: Browser/Mobile");
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return driver;
    }


    private static WebDriver getLocalDriver(String strBrowserName) {
        WebDriver driver = null;

        try {
            switch (strBrowserName) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
                    driver = new ChromeDriver();
                    break;
                case "ie":
                    System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_PATH);
                    InternetExplorerOptions caps = new InternetExplorerOptions();
                    caps.introduceFlakinessByIgnoringSecurityDomains();
                    caps.ignoreZoomSettings();
                    caps.enablePersistentHovering();
                    caps.takeFullPageScreenshot();
                    caps.withInitialBrowserUrl("http://bmsdr.prod.mobily.lan");
                    caps.takeFullPageScreenshot();
                    driver = new InternetExplorerDriver(caps);
                    break;

                default:
                    System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
                    driver = new ChromeDriver();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(new StringBuilder().append("\nCAP Fatal Error : ").append(e.getMessage()));
        }

        return driver;
    }

}
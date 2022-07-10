package hooks;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import common.utils.SharedDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.java.Before;

import org.openqa.selenium.WebDriverException;
import pages.DemoPageContainer;

import java.io.File;
import java.io.IOException;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        Reporter.assignAuthor("Chowdri");
    }

    @After
    public static void after(Scenario scenario) throws WebDriverException, IOException {
        System.out.println("After Hook Scenario");
        scenario.embed(((TakesScreenshot) SharedDriver.getDriver()).getScreenshotAs(OutputType.BYTES),
                "image/png");

        String screenshotName = scenario.getName().replaceAll(" ", "_");

        File sourcePath = ((TakesScreenshot) SharedDriver.getDriver()).getScreenshotAs(OutputType.FILE);

        //Building up the destination path for the screenshot to save
        //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
        File destinationPath = new File( "target/extent-reports/" + screenshotName + ".png");

        //Copy taken screenshot from source location to destination location
        Files.copy(sourcePath, destinationPath);

        //This attach the specified screenshot to the test
        Reporter.addScreenCaptureFromPath(screenshotName + ".png");


    }
}

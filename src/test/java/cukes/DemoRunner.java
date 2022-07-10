package cukes;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

//"com.cucumber.listener.ExtentCucumberFormatter:"
@CucumberOptions(features = "src/test/resources/ui_features/demo.feature", monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/single",
        "json:target/cucumber-report/single/cucumber.json",
        "com.cucumber.listener.ExtentCucumberFormatter:"},
        glue = {"hooks","step_definitions"})
public class DemoRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
//        FileUtil.deleteFile("/reports/Eportal-Regression-Test-Suite-Report.html");
        extentProperties.setReportPath(System.getProperty("user.dir") + "/target/extent-reports/testreport.html");
    }

    @AfterClass
    public void teardown() {
        Reporter.loadXMLConfig(new File("config/extent-config.xml"));
        Reporter.setSystemInfo("User", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", Platform.getCurrent().name());
    }
}



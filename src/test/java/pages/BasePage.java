package pages;

import common.utils.WaitTimeUtil;
import common.helpers.Constants;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

//public class BasePage {
//}
public class BasePage {
//    @Getter
    protected final WebDriver driver;

//    @Getter
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, WaitTimeUtil.getWaitTime(Constants.OBJECT_WAIT_TIME));
    }

    public void navigateURL(String URL) {
        driver.manage().deleteAllCookies();
        driver.get(URL);
    }

    protected WebElement waitForElementClickable(By by, int secs) {
        return new WebDriverWait(driver, secs).until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitForElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitForElement(By by, int secs) {
        return new WebDriverWait(driver, secs).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForElementClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected boolean verifyText(String strExpectedText) {
        return driver.getPageSource().contains(strExpectedText);
    }

    public void waitForSeconds(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (Exception e) {
        }
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void mouseOver(WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public WebElement enterValue(WebElement elmnt, String strValue) {
        wait.until(ExpectedConditions.visibilityOf(elmnt));
        elmnt.click();
        elmnt.clear();
        elmnt.sendKeys(strValue);
        return elmnt;
    }
    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", element);
        waitForSeconds(1);
    }

    public void jsClick(By by) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",
                driver.findElement(by));
        waitForSeconds(1);
    }

    public String getAlertMessage() {
        return driver.switchTo().alert().getText();

    }

    public static boolean compareList(List<WebElement> lstElements, List<String> lstDataValues) {
        List<String> lstActualValue = new ArrayList<String>();
        List<String> lstExpectedValues = new ArrayList<String>();
        lstElements.stream().forEach(eleItem -> lstActualValue.add(eleItem.getText().trim()));
        lstDataValues.stream().forEach(strData -> lstExpectedValues.add(strData));
        return (lstActualValue.equals(lstExpectedValues));
    }




}
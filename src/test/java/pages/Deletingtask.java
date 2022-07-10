package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Deletingtask extends BasePage
{
    public Deletingtask (WebDriver driver){super(driver);}

    @FindBy(how= How.XPATH,using ="//li[@class='todo completed'][1]/div[@class='view' ]//button[@class='destroy']")
    protected WebElement deletetask;
    @FindBy(how= How.XPATH,using ="//li[@class='todo'][1]/div[@class='view' ]//button[@class='destroy']")
    protected WebElement activedeletetask;

    @FindBy(how =How.XPATH,using = "//a[normalize-space(.)='Active']")
    protected WebElement clicklactive;
    @FindBy(how =How.XPATH,using = "//a[normalize-space(.)='All']")
    protected WebElement clicklAll;
    @FindBy(how =How.XPATH,using = "//label[@for='toggle-all']")
    protected WebElement selectalltask;
    @FindBy(how =How.XPATH,using = "//input[@class='new-todo'']")
    protected WebElement clicktodo;
    @FindBy(how = How.XPATH, using="//input[@class=\"new-todo\"]")
    protected WebElement txtTodovalue;



    public void Deletetask()
    {
        waitForSeconds(2);

        jsClick(clicklactive);
        waitForSeconds(5);
        jsClick(deletetask);
    }

    public void clickactive()
    {
        waitForSeconds(2);

        jsClick(clicklactive);

    }

    public void selectalltask()
    {
       // waitForSeconds(10);
        //jsClick(clicktodo);
        jsClick(clicklactive);
        waitForSeconds(3);
        jsClick(clicklAll);
        waitForSeconds(3);
        jsClick(selectalltask);


    }
    public void deletealltask()
    {
        waitForSeconds(2);
        jsClick(deletetask);
    }
    public void addtask()
    {
        waitForSeconds(2);
        WebElement ky = enterValue(txtTodovalue,"add task");
        ky.sendKeys(Keys.ENTER);
    }
    public void deleteactivetask()
    {
        waitForSeconds(3);
        jsClick(activedeletetask);
    }


}



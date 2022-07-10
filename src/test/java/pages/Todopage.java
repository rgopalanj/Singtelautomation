package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Todopage extends BasePage {

    public Todopage(WebDriver driver) {
        super(driver);
    }

    String strtaskdetails;

    @FindBy(how = How.XPATH, using="//input[@class=\"new-todo\"]")
    protected WebElement txtTodovalue;

    @FindBy(how =How.XPATH,using = "//a[normalize-space(.)='Completed']")
    protected WebElement clicklink;

    @FindBy(how =How.XPATH,using = "//a[normalize-space(.)='All']")
    protected WebElement Allclicklink;


    @FindBy(how=How.XPATH,using ="//li[@class='todo'][1]/div[@class='view' ]//input[@type='checkbox']")
    protected WebElement verifytask;


    public void visitPage() {
        waitForSeconds(5);
        navigateURL("https://todomvc.com/examples/vue/");
        driver.manage().window().maximize();
    }

    public String addtesk(String strtaskdetails)
    {
        waitForElement(txtTodovalue);
        WebElement ky = enterValue (txtTodovalue,strtaskdetails);
        ky.sendKeys(Keys.ENTER);

        return(strtaskdetails);
    }
    public void validatelinks()
    {
       waitForSeconds(10);

       jsClick(Allclicklink);

        System.out.println("test");

    }
    public void clicklinks()
    {
        waitForSeconds(10);

        jsClick(verifytask);
        waitForSeconds(5);
        jsClick(clicklink);
    }



}

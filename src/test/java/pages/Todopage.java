package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Todopage extends BasePage {

    public Todopage(WebDriver driver) {
        super(driver);
    }

    String strtaskdetails;
    String a;

    @FindBy(how = How.XPATH, using="//input[@class=\"new-todo\"]")
    protected WebElement txtTodovalue;



    @FindBy(how = How.XPATH, using="//li[@class='todo']//label[1]")
    protected WebElement txtTodovalue2;


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
        a=txtTodovalue2.getText();
        System.out.println("Raj"+" "+strtaskdetails);

        System.out.println("Raj" +" "+ a);
        Assert.assertEquals(strtaskdetails,a);
        System.out.println(strtaskdetails +" "+ a);

        return(strtaskdetails);
    }
    public void validatelinks()
    {
       waitForSeconds(10);
       jsClick(Allclicklink);

    }
    public void clicklinks()
    {
        waitForSeconds(10);
        jsClick(verifytask);
        waitForSeconds(5);
        jsClick(clicklink);
    }



}

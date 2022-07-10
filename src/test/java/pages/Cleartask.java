package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cleartask extends BasePage {
    public Cleartask (WebDriver driver){super(driver);}


        @FindBy(how= How.XPATH,using ="//button[@class='clear-completed']")
        protected WebElement Clearcompletbtn;

    //a[@class='selected']
    @FindBy(how= How.XPATH,using ="//a[@class='selected']")
    protected WebElement clickcompletedbut;

    public void cleacompleted()
    {
        waitForSeconds(5);
        jsClick(Clearcompletbtn);
    }

    public void selectcompletetask()
    {
        waitForSeconds(5);
        jsClick(clickcompletedbut);
    }


}

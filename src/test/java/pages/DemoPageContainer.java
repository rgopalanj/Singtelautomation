package pages;

import common.utils.SharedDriver;
import cucumber.api.Scenario;

public class DemoPageContainer {
    private SharedDriver sharedDriver;
    public static Todopage todopage;
    public Deletingtask deletingtask;
    public Cleartask cleartask;

    {
        sharedDriver = new SharedDriver();
        initPages();
    }

    private void initPages() {
        todopage = new Todopage(sharedDriver);
        deletingtask =new Deletingtask(sharedDriver);
        cleartask =new Cleartask(sharedDriver);


    }

    public static void after(Scenario scenario)
    {
        if (scenario.getSourceTagNames().contains("@Closed"))
            System.out.println("Inside Logout");
            todopage.clicklinks();

    }


}

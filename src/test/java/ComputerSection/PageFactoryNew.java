package ComputerSection;

import org.openqa.selenium.WebDriver;

public class PageFactoryNew
{
    WebDriver driver;
    private AddItems addComputerItems;

    public PageFactoryNew(WebDriver driver)
    {
        this.driver = driver;

    }

    public AddItems getAddComputerItems()
    {
        if (addComputerItems == null) {
            addComputerItems = new AddItems(driver);
        }
        return addComputerItems;
    }
}

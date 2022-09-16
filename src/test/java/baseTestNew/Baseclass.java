package baseTestNew;

import ComputerSection.PageFactoryNew;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class Baseclass {
    static WebDriver driver;
    protected static PageFactoryNew pageFactoryNew;

    @Parameters("browserName")
    @BeforeClass

    public static void setup(String browserName) throws MalformedURLException {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver.manage().window().maximize();
           WebDriver driver = new RemoteWebDriver(new URL(" http://10.20.20.80:4444/wd/hub"), chromeOptions);
            driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
            pageFactoryNew = new PageFactoryNew(driver);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
            pageFactoryNew = new PageFactoryNew(driver);
        }
    }

    @AfterClass
    public void close() {
        driver.close();
    }
}



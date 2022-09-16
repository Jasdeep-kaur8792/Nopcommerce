package ComputerSection;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddItems {
    WebDriver driver;
    WebDriverWait wait;
    By clickOnComputerOnUpperMenuBar = By.xpath("//a[contains(text(),'Computers ')][1]");
    By clickOnNoteBooks = By.xpath("//a[contains(text(),' Notebooks ')]");
    By verifySixItemsAreShown = By.xpath("//div[@class='page-title']");
    By addToCartButton = By.xpath("(//button[contains(text(),'Add to cart')])[2]");
    By goToTheShoppingCart = By.xpath("//span[contains(text(),'Shopping cart')]");
    By verificationOfAddToCart = By.xpath("(//a[contains(text(),'Asus N551JK-XO076H Laptop')])[2]");

    By clickOnCheckBox = By.xpath("(//input[@type='checkbox'])[2]");
    By clickOnCheckOutButton = By.xpath("(//button[contains(text(),' Checkout ')])");
    By clickOnRegisterButton = By.xpath("//button[@class='button-1 register-button']");

    By enterFirstName =By.xpath("  //input[@name='FirstName']");
    By enterLastName =By.xpath("//input[@name='LastName']");
    By emailInput =By.xpath("//input[@name='Email']");
    By enterPassword =By.xpath("//input[@name='Password']");
    By enterConfirmedPassword =By.xpath("//input[@name='ConfirmPassword']");
    By enterRegisterButton =By.xpath("  //button[contains(text(),'Register')]");


    public AddItems(WebDriver driver)

    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public void verifyComputer()

    {
        driver.findElement(clickOnComputerOnUpperMenuBar).click();
        driver.findElement(clickOnNoteBooks).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='page-title']"))));
        String actual = driver.findElement(verifySixItemsAreShown).getText();
        Assert.isTrue(actual.equals("Notebooks"), "Expected result does not match with actual result");
        driver.findElement(addToCartButton).click();
        driver.findElement(goToTheShoppingCart).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[contains(text(),'Asus N551JK-XO076H Laptop')])[2]"))));
        actual = driver.findElement(verificationOfAddToCart).getText();
        Assert.isTrue(actual.equals("Asus N551JK-XO076H Laptop"), "Expected result does not match with actual result");
        driver.findElement(clickOnCheckBox).click();
       driver.findElement(clickOnCheckOutButton).click();
        driver.findElement(clickOnRegisterButton).click();
        driver.findElement(enterFirstName).sendKeys("Jas");
        driver.findElement(enterLastName).sendKeys("Kaur");
        driver.findElement(emailInput).sendKeys("jsdp@gmail.com");
        driver.findElement(enterPassword).sendKeys("password");
        driver.findElement(enterConfirmedPassword).sendKeys("password");
        driver.findElement(enterRegisterButton).click();

    }
}



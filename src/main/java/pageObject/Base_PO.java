package pageObject;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Base_PO {
    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver(){
        return DriverFactory.getDriver();
    }

    public void navigateTo(String url){
        getDriver().get(url);
    }


    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }


    public void sendKeys(Object element, String text) {

        if (element instanceof WebElement) {
            webDriverWaitFactory().until(ExpectedConditions.elementToBeClickable((WebElement) element)).sendKeys(text);
        }
        if (element instanceof By) {
            webDriverWaitFactory().until(ExpectedConditions.elementToBeClickable((By) element)).sendKeys(text);
        }
    }

    public void waitForWebElementAndClick(Object element) {

        if (element instanceof WebElement) {
            webDriverWaitFactory().until(ExpectedConditions.elementToBeClickable((WebElement) element)).click();
        }
        if (element instanceof By) {
            webDriverWaitFactory().until(ExpectedConditions.elementToBeClickable((By) element)).click();
        }
    }

    private static WebDriverWait webDriverWaitFactory() {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
    }

    public void waitForAlertAndValidateText(String expectedText) {
        //String alertText =  getDriver().switchTo().alert().getText();
        String alertText =  webDriverWaitFactory().until(ExpectedConditions.alertIsPresent()).getText();
        Assert.assertEquals(alertText, expectedText);



    }

    public void validateSuccessMessage() {
        waitForAlertAndValidateText("validation succeeded");
    }


    public void validateUnSuccessMessage() {
        waitForAlertAndValidateText("validation failed");
    }


}

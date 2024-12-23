package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.Base_PO;

public class Contact_US_Steps extends Base_PO {


    private WebDriver driver = getDriver();


    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        navigateTo("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
        i_enter_a_specific_first_name("AutoFN" + generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        //driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("AutoLN" + generateRandomNumber(5));
        i_enter_a_specific_last_name("AutoLN" + generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        //driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("AutoEmail" + generateRandomNumber(10) + "@mail.com");
        i_enter_a_specific_email_address("AutoEmail" + generateRandomNumber(10) + "@mail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        //driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("Hello world " + generateRandomString(20));
        i_enter_a_specific_comment("Hello world " + generateRandomString(20));
    }


    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        sendKeys(By.xpath("//input[@name='first_name']"), firstName);
    }

    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        sendKeys(By.xpath("//input[@name=\"last_name\"]"),lastName);
    }

    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        sendKeys(By.xpath("//input[@name=\"email\"]"),email);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String string) {
        sendKeys(By.xpath("//textarea[@name=\"message\"]"),string);
    }


    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        waitForWebElementAndClick(By.xpath("//input[@value=\"SUBMIT\"]"));
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUsSubmissionMessage = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUsSubmissionMessage.getText(), "Thank You for your Message!");
    }


}

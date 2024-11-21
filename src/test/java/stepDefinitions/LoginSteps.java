package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginSteps extends AbstractSeleniumInit {

    @Before
    public void setup() {
        initializeDriver();
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }
    @When("I enter a unique user name")
    public void i_enter_a_unique_user_name() {
        //driver.findElement(By.id("text")).sendKeys("username" + generateRandomString(5));
        i_enter_a_specific_user_name("username" + generateRandomString(5));
    }

    @When("I enter a username {word}")
    public void i_enter_a_username_webdriver(String userName) {
        i_enter_a_specific_user_name(userName);
    }


    @When("I enter a unique password")
    public void i_enter_a_unique_password() {
        //driver.findElement(By.id("password")).sendKeys("password" + generateRandomString(5));
        i_enter_a_specific_password("password" + generateRandomString(5));
    }

    @When("I enter a password {}")
    public void i_enter_a_password(String password) {
        // Write code here that turns the phrase above into concrete actions
        i_enter_a_specific_password(password);
    }


    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();

    }
    @Then("I should be presented with a unsuccessful login message")
    public void i_should_be_presented_with_a_unsuccessful_login_message() {
        Assert.assertEquals(getAlertText(), "validation failed");
    }




    @When("I enter a specific user name {word}")
    public void i_enter_a_specific_user_name(String userName) {
        driver.findElement(By.id("text")).sendKeys(userName);
    }
    @When("I enter a specific password {word}")
    public void i_enter_a_specific_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("I should be presented with a successful login message")
    public void i_should_be_presented_with_a_successful_login_message() {

        Assert.assertEquals(getAlertText(), "validation succeeded");
    }

    private String getAlertText(){
        return driver.switchTo().alert().getText();
    }



    @Then("I should be presented with the following validation message {}")
    public void i_should_be_presented_with_the_following_validation_message(String expectedMessage) {
        String loginMessage = getAlertText();
        Assert.assertEquals(loginMessage, expectedMessage);
    }




}

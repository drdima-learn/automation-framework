package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.Base_PO;
import pageObject.Login_PO;

public class LoginSteps extends Base_PO {



    
    private Login_PO loginPo;

    public LoginSteps(Login_PO loginPo) {
        this.loginPo = loginPo;
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        loginPo.navigateToWebDriverUniversityLoginPage();
    }

    @When("I enter a unique user name")
    public void i_enter_a_unique_user_name() {
        i_enter_a_specific_user_name("username" + generateRandomString(5));
    }

    @When("I enter a username {word}")
    public void i_enter_a_username_webdriver(String userName) {
        i_enter_a_specific_user_name(userName);
    }


    @When("I enter a unique password")
    public void i_enter_a_unique_password() {
        i_enter_a_specific_password("password" + generateRandomString(5));
    }

    @When("I enter a password {}")
    public void i_enter_a_password(String password) {
        i_enter_a_specific_password(password);
    }


    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPo.clickLoginButton();

    }

    @Then("I should be presented with a unsuccessful login message")
    public void i_should_be_presented_with_a_unsuccessful_login_message() {
        loginPo.validateUnSuccessMessage();
    }


    @When("I enter a specific user name {word}")
    public void i_enter_a_specific_user_name(String userName) {
        loginPo.setUserName(userName);
    }

    @When("I enter a specific password {word}")
    public void i_enter_a_specific_password(String password) {
        loginPo.setPassword(password);
    }

    @Then("I should be presented with a successful login message")
    public void i_should_be_presented_with_a_successful_login_message() {

        loginPo.validateSuccessMessage();
    }




    @Then("I should be presented with the following validation message {}")
    public void i_should_be_presented_with_the_following_validation_message(String expectedMessage) {
        loginPo.waitForAlertAndValidateText(expectedMessage);

    }


}

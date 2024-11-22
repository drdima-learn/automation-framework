package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO{

    @FindBy(id="text")
    private WebElement userNameTextField;

    @FindBy(id="password")
    private WebElement passwordTextField;

    @FindBy(id="login-button")
    private WebElement loginButton;


    public Login_PO() {
        super();
    }

    public void navigateToWebDriverUniversityLoginPage() {
        navigateTo("https://webdriveruniversity.com/Login-Portal/index.html");
    }

    public void setUserName(String userName) {
        sendKeys(userNameTextField, userName);
    }

    public void setPassword(String password) {
        sendKeys(passwordTextField, password);
    }

    public void clickLoginButton() {
        waitForWebElementAndClick(loginButton);
    }


}


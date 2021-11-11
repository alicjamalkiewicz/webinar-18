package pl.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoadingPage extends BasePage{

    public LoadingPage(WebDriver driver) {
        super(driver);
    }

    public static final String CORRECT_USER_NAME = "tomsmith";
    public static final String CORRECT_USER_PASSWORD = "SuperSecretPassword!";
    public static final String INCORRECT_USER_NAME = "tomsmith?";
    public static final String INCORRECT_USER_PASSWORD = "SuperSecretPassword?";
    //public static final String FAIL_MESSAGE_INCORRECT_NAME = "Your username is invalid!";

//    public String getFailMessage(){
//         return failMessage.getText();
//    }

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement usersPassword;

    @FindBy(className = "radius")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement successMessage;

    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    private WebElement logoutButton;

    @FindBy(id = "flash")                          //"//*[@id=\"flash\"]/text()"
    private WebElement failMessage;

    public void provideCorrectName(){
        userNameField.sendKeys(CORRECT_USER_NAME);
    }

    public void provideCorrectPassword(){
        usersPassword.sendKeys(CORRECT_USER_PASSWORD);
    }

    public void provideInCorrectName(){
        userNameField.sendKeys(INCORRECT_USER_NAME);
    }

    public void provideInCorrectPassword(){
        usersPassword.sendKeys(INCORRECT_USER_PASSWORD);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public boolean successMessageShown(){
        return successMessage.isDisplayed();
    }

    public boolean failMessageShown(){
        return failMessage.isDisplayed();
    }


}

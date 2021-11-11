package pl.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends BasePage {

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public static final String EXPECTED_CONFIRMATION_TEXT = "Hello World!";

    @FindBy(css = ("#start > button"))
    private WebElement startButton;

    @FindBy(id = "loading")
    private WebElement loadingBar;

    @FindBy(css = "#finish > h4")
    private WebElement finishTextHeader;


    public DynamicLoadingPage clickStartButton() {
        startButton.click();
        return this;
    }

    public String finishLoadingConfirmation() {
        return finishTextHeader.getText();
    }

    public boolean barVisible(){
        loadingBar.isDisplayed();
        return true;
    }

    public boolean barNotVisible(){
        loadingBar.isDisplayed();
        return false;
    }
}


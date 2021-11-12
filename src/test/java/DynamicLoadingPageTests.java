import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.test.pages.BasePage;
import pl.test.pages.DynamicLoadingPage;

import java.time.Duration;

import static pl.test.pages.DynamicLoadingPage.EXPECTED_CONFIRMATION_TEXT;

public class DynamicLoadingPageTests extends BaseTest {
    DynamicLoadingPage dynamicLoadingPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @Test
    public void checkConfirmationText() {
        dynamicLoadingPage.clickStartButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));

        Assert.assertTrue(dynamicLoadingPage.barVisible());

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        Assert.assertFalse(dynamicLoadingPage.barNotVisible());

        String actualConfirmationText = dynamicLoadingPage.finishLoadingConfirmation();

        Assert.assertEquals(actualConfirmationText, EXPECTED_CONFIRMATION_TEXT);
    }

//    @Test
//    public void checkConfirmationText() {
//        dynamicLoadingPage.clickStartButton();
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish")));
//
//        String actualConfirmationText = dynamicLoadingPage.finishLoadingConfirmation();
//
//        Assert.assertEquals(actualConfirmationText, EXPECTED_CONFIRMATION_TEXT);
//    }

}


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.test.pages.LoadingPage;

public class LoadingPageTest extends BaseTest{
    LoadingPage loadingPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        driver.get("https://the-internet.herokuapp.com/login");
        loadingPage = new LoadingPage(driver);
    }

    @Test
    public void loginWithCorrectCredentials(){
        loadingPage.provideCorrectName();
        loadingPage.provideCorrectPassword();
        loadingPage.clickLoginButton();

        Assert.assertTrue(loadingPage.successMessageShown());

        loadingPage.clickLogoutButton();
    }

    @Test
    public void loginWithIncorrectUserName(){
        loadingPage.provideInCorrectName();
        loadingPage.provideCorrectPassword();
        loadingPage.clickLoginButton();

        //Assert.assertEquals(loadingPage.getFailMessage(), LoadingPage.FAIL_MESSAGE_INCORRECT_NAME);

        Assert.assertTrue(loadingPage.failMessageShown());
    }

    @Test
    public void loginWithIncorrectPassword(){
        loadingPage.provideCorrectName();
        loadingPage.provideInCorrectPassword();
        loadingPage.clickLoginButton();

        //Assert.assertEquals(loadingPage.getFailMessage(), LoadingPage.FAIL_MESSAGE_INCORRECT_NAME);

        Assert.assertTrue(loadingPage.failMessageShown());
    }

    @Test
    public void loginWithNoCredentials(){
        loadingPage.clickLoginButton();
        Assert.assertTrue(loadingPage.failMessageShown());
    }
}


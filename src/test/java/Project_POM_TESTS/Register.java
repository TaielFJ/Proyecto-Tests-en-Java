package Project_POM_TESTS;

import Project_POM_MAIN.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Register {

    private WebDriver driver;

    RegisterPage registerPage;

    @BeforeClass
    public void setUp() {
        registerPage = new RegisterPage(driver);
        driver = registerPage.chromeDriverConnection();
        driver.manage().window().maximize();
        registerPage.visit("http://automationpractice.com/index.php");
    }

    @Test
    public void test1() throws InterruptedException {
        registerPage.registerUser();
    }

    @AfterClass
    public void afterClass() {
      driver.close();
    }
}

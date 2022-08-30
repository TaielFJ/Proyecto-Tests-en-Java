package Project_POM_TESTS;

import Project_POM_MAIN.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Searchs {
    private WebDriver driver;
    SearchPage searchPage;

    @BeforeClass
    public void beforeClass() {
        searchPage = new SearchPage(driver);
        driver = searchPage.chromeDriverConnection();
        driver.manage().window().maximize();
        searchPage.visit("http://automationpractice.com/index.php");
    }

    @Test
    public void test2() throws InterruptedException {
        searchPage.signIn();
        searchPage.searchClothes();
        searchPage.searchAllClothes();
    }


    @AfterClass
    public void afterClass() {
        driver.close();
    }
}

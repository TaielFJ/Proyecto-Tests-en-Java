package Project_POM_MAIN;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchPage extends Base{ //page object model 1

    By emailLocator = By.id("email");
    By passLocator = By.id("passwd");
    By singInBtnLocator = By.className("login");
    By btnSingIn = By.id("SubmitLogin");
    By inputSearch = By.id("search_query_top");
    By btnSearch = By.className("button-search");
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void signIn() {
        click(singInBtnLocator);
        waitFor(emailLocator);
        type("taielfernandezjara@gmail.com", emailLocator);
        type("pass1", passLocator);
        click(btnSingIn);
        try {
            WebElement divErrorLogin = findElement(By.className("alert alert-danger"));
            Assert.fail("Errores al iniciar sesion.");
        }catch (NoSuchElementException e){
            //errores
        }
    }

    public void searchClothes() throws InterruptedException {
        waitFor(inputSearch);
        type("blouses", inputSearch);
        click(btnSearch);
        Thread.sleep(4000);
        try{
            WebElement containerImgsProducts = findElement(By.xpath("//*[@id='center_column']/ul/li/div"));
            System.out.println(containerImgsProducts);

        }catch (NoSuchElementException e){
            Assert.fail("problemas al encontrar produdctos.");
        }
    }

    public void searchAllClothes() throws InterruptedException {
        delete(inputSearch);
        type("all", inputSearch);
        click(btnSearch);
        Thread.sleep(2000);
        try{
            WebElement containerImgsProducts = findElement(By.xpath("//*[@id='center_column']/ul/li/div"));
            System.out.println(containerImgsProducts);

        }catch (NoSuchElementException e){
            Assert.fail("problemas al encontrar todos los produdctos.");
        }
    }
}

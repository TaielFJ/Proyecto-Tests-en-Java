package Project_POM_MAIN;


import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Base {  //base object model
    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void visit(String url){
        driver.get(url);
    }

    public void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void delete(By locator){
        driver.findElement(locator).clear();
    }

}

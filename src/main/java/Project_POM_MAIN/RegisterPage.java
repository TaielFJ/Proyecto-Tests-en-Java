package Project_POM_MAIN;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class RegisterPage extends Base{ //page object model 2
    By registerPageLocator = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");

    By inputEmailRegister = By.id("email_create");
    By registerBtnLocator = By.id("SubmitCreate");
    By inputFirstName = By.name("customer_firstname");
    By inputLastName = By.name("customer_lastname");
    By inputPassword = By.name("passwd");
    By inputRadioGender1 = By.id("uniform-id_gender1");//ACAAA
    By inputSelectDays = By.id("days");
    By optionOfSelectD = By.xpath("//*[@id='days']/option[2]");
    By inputSelectMoths = By.id("months");
    By optionSelectM = By.xpath("//*[@id='months']/option[4]");
    By inputSelectYears = By.id("years");
    By optionSelectY = By.xpath("//*[@id='years']/option[37]");
    By addresName = By.name("firstname");
    By addresLastName = By.name("lastname");
    By addresA = By.id("address1");
    By addresCity = By.name("city");
    By country = By.id("id_country");
    By optionCountry = By.xpath("//*[@id='id_country']/option[2]");
    By phone = By.name("phone_mobile");
    By aliasAddres = By.name("alias");
    By btnRegisterCount = By.name("submitAccount");
    By state = By.id("id_state");
    By optionState = By.xpath("//*[@id='id_state']/option[3]");
    By postalCode = By.id("postcode");
//    By btnHome = By.xpath("//*[@id='center_column']/ul/li/a");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser() throws InterruptedException {

        StringBuilder builder;
        String random;

        click(registerPageLocator);

        Thread.sleep(1500);
        //letras y numeros randoms para el mail
        builder = new StringBuilder();
        random = "ABCDFGHIJKLMNOPKRSTUVWXYZ" + "0123456789";

        for(int i = 0; i < 15; i++){
            int index = (int) (random.length() * Math.random());
            builder.append(random.charAt(index));
        }


        String words = builder.toString();
        String mailRandom = words + "@gmail.com";
        String nameWithoutNumbers = words.replaceAll("[0-9]", "");


        type(mailRandom, inputEmailRegister);
        click(registerBtnLocator);
        waitFor(inputRadioGender1);
        click(inputRadioGender1);
        type(nameWithoutNumbers, inputFirstName);
        type(nameWithoutNumbers + "JTS", inputLastName);
        type(words, inputPassword);
        click(inputSelectDays);
        click(optionOfSelectD);
        click(inputSelectMoths);
        click(optionSelectM);
        click(inputSelectYears);
        click(optionSelectY);
        type(nameWithoutNumbers, addresName);
        type(nameWithoutNumbers + "AS", addresLastName);
        type(words +"1347", addresA);
        type("Buenos Aires", addresCity);
        click(state);
        click(optionState);
        type("12345", postalCode);
        click(country);
        click(optionCountry);
        type("1124574617", phone);
        type(words + "980", aliasAddres);

        click(btnRegisterCount);
        Thread.sleep(2000);

        try {
            WebElement divErrorRegister = findElement(By.xpath("//*[@id='center_column']/div/p"));
            Assert.fail("tuviste errores en el formulario de Registro.");
        } catch(NoSuchElementException e) {
            // No error
        }
    }
}

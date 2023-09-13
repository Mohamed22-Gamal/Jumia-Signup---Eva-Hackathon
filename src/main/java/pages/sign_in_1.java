package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class sign_in_1 {
    private WebDriver driver;
    public sign_in_1(WebDriver driver){
        this.driver=driver;
    }
    By email= By.xpath("//input[@id=\"input_identifierValue\"]");
    By continu=By.xpath("//div[@class=\"mdc-touch-target-wrapper\"]//button[@type=\"submit\"]");
    By pass=By.xpath("//input[@class=\"mdc-text-field__input password-input  \"]");
    By confpass=By.className("confirm-password-input");
    By cont2but=By.xpath("//div[@class=\"mdc-touch-target-wrapper\"]//button[@class=\"mdc-button mdc-button--touch mdc-button--raised to-personal-details mdc-ripple-upgraded\"]");
    By firstname=By.id("input_first_name");
    By lastname=By.id("input_last_name");
    By prefix=By.xpath(" //div[@class=\"mdc-select__anchor\"]");
    By phone=By.xpath("//input[@class=\"mdc-text-field__input phone-input\"]");
    By cont3but=By.xpath(" //div[@class=\"mdc-touch-target-wrapper\"]//button[@class=\"mdc-button mdc-button--touch mdc-button--raised to-personal-details-part-2 mdc-ripple-upgraded\"]");

    By gender=By.xpath(" //div[@id=\"gender\"]//div[@class=\"mdc-select__anchor\"]");
    By male=By.xpath("//*[@id=\"gender\"]/div[2]/ul/li[1]");
    By birthdate=By.id("input_birth_date");
    By checkbox=By.id("acceptTC");
    By cont4but=By.xpath("//div[@class=\"mdc-touch-target-wrapper\"]//button[@id=\"confirmBtn\"]");
    By verify =By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label");
    By logout=By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label");
    By Log =By.xpath("//*[@id=\"dpdw-login-box\"]/div/form");


    public void enteremail(String emails){
        driver.findElement(email).sendKeys(emails);
        driver.findElement(continu).click();
    }
    public void enterpassword(String password) throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(pass).sendKeys(password);
        Thread.sleep(10000);
        driver.findElement(confpass).sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(
                ExpectedConditions.elementToBeClickable(cont2but)).click();
    }
    public void enternameandphone(String name1,String name2,String phoneno) throws InterruptedException {

        driver.findElement(firstname).sendKeys(name1);
        driver.findElement(lastname).sendKeys(name2);
        driver.findElement(prefix).click();
        Thread.sleep(10000);
        driver.findElement(phone).sendKeys(phoneno);
        driver.findElement(cont3but).click();
    }
    public void set_gender_Birthdate() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(gender).click();
        Thread.sleep(10000);
        driver.findElement(male).click();
        Thread.sleep(10000);
        driver.findElement(birthdate).sendKeys("08302005");
        driver.findElement(checkbox).click();
        driver.findElement(cont4but).click();

        Thread.sleep(10000);
    }
    public boolean verifylogin(){
        String accountStatusMessage =  driver.findElement(verify).getText();
        System.out.println(accountStatusMessage);
        if(accountStatusMessage == "Account"){
            return false;
        }
        return true;
    }
    public void logout(){
        driver.findElement(logout).click();
        driver.findElement(Log).click();
    }

}

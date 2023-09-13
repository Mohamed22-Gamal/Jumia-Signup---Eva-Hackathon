package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;


public class Homepage {
    private WebDriver driver;
public Homepage(WebDriver driver){
    this.driver=driver;
}
By Account=By.xpath("//label[@for=\"dpdw-login\"]");
By signin=By.xpath("//a[@class=\"btn _prim -fw _md\"]");
public void setSignin(){
    driver.findElement(Account).click();
    driver.findElement(signin).click();
}
}

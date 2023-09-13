package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DialogSkipp {
    private WebDriver driver;
    public DialogSkipp(WebDriver driver){
        this.driver=driver;
    }

    By cancel=By.xpath("//*[@id=\"pop\"]/div/section/button");
    public void skiip(){
        driver.findElement(cancel).click();
    }
}

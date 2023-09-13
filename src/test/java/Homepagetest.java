import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.DialogSkipp;
import pages.Homepage;
import pages.sign_in_1;

import java.util.concurrent.TimeUnit;

public class Homepagetest {
    WebDriver driver;
    Homepage homepage;
    sign_in_1 signIn1;
    DialogSkipp s1;
    @DataProvider(name = "signupinformations")
    public Object[][] getdata(){
        Object[][] data={
                {"mohamedgemy110@gmail.com","Ramadahh99#","Ali","Ahmed","01226692397"},
                {"mohamedgemy127@gmail.com","Ask2next7after5@","Gamal","Ahmed","01226154897"}
        };
        return data;
    }
    @BeforeClass()
    public void setDriver(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jumia.com.eg/");
    }
    @Test(priority =0)
    public void skipmessage() throws InterruptedException {
        Thread.sleep(3000);
        s1=new DialogSkipp(driver);
        s1.skiip();
    }
    @Test(priority = 1)
    public void Navigatetosignin() throws InterruptedException {
        Thread.sleep(3000);
        homepage=new Homepage(driver);
        homepage.setSignin();
        Thread.sleep(3000);
    }
    @Test(priority = 2,dataProvider = "signupinformations")
    public void signup(String emai,String pasword,String name1,String name2,String phonno) throws InterruptedException {
        signIn1=new sign_in_1(driver);
        signIn1.enteremail(emai);
        Thread.sleep(3000);
        signIn1.enterpassword(pasword);
        signIn1.enternameandphone(name1,name2,phonno);
        signIn1.set_gender_Birthdate();
        signIn1.verifylogin();
        Thread.sleep(3000);
        signIn1.logout();
        Navigatetosignin();

    }
    @AfterClass
    public void closeDriver(){
        driver.close();
    }
}

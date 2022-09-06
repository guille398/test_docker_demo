package Pages;

import infra.Setup;
import infra.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;


public class BasePage {

    protected RemoteWebDriver driver;
    protected Wait wait;

   public BasePage(){
       this.driver = Setup.driver;
       this.wait = new Wait(this.driver);
   }

    public void navigateTo(String url){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(url);
    }

    //Inputs a value in the received object
    public static void inputCharacters(WebElement inputBox, String characters){
        inputBox.click();
        inputBox.clear();
        inputBox.sendKeys(characters);
    }
    //Clicks button, receives the object webElement
    public static void clickButton(WebElement button){
        button.click();
    }

}

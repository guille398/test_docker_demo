package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;


public class BasePage {
    public static WebDriver driver;
    public static WebDriver wait;

       static{
        ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }
    public static void navigateTo(String url){
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
    public static void closeDriver(){
        driver.close();
    }


}

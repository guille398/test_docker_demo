package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.MasterPage;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SearchPage extends MasterPage {

    static String inputBoxLocator = "div.restool-app div.app-page:nth-child(2) main.app-page-content section.query-params-form form:nth-child(2) div.form-row.row > input:nth-child(2)";
    static String searchButtonLocator = "div.restool-app div.app-page:nth-child(2) main.app-page-content section.query-params-form form:nth-child(2) > button.button";
    static String addItemButtonLocator = "div:nth-child(2) div.restool-app div.app-page:nth-child(2) header.app-page-header > button.button.add-item.green:nth-child(2)";
    static String submitItemButtonLocator = "div.popup.form-popup div.popup-content section:nth-child(2) form:nth-child(1) div.buttons-wrapper.center:nth-child(6) > button.button.green";
    static String FirstCardLocator = "div.restool-app div.app-page:nth-child(2) main.app-page-content div.infinite-scroll-component__outerdiv div.infinite-scroll-component.cards-wrapper > div.card:nth-child(1)";

    static String DeleteButtonLocator = "button[title='Delete']";

    static String thumbnailTextBoxLocator = "div.popup.form-popup div.popup-content section:nth-child(2) form:nth-child(1) div.form-row.row:nth-child(1) > input:nth-child(2)";
    static String nameTextBoxLocator = "div.popup.form-popup div.popup-content section:nth-child(2) form:nth-child(1) div.form-row.row:nth-child(2) > input:nth-child(2)";
    static String realNameTextBoxLocator = "div.popup.form-popup div.popup-content section:nth-child(2) form:nth-child(1) div.form-row.row:nth-child(3) > input:nth-child(2)";
    static String locationTextBoxLocator = "div.popup.form-popup div.popup-content section:nth-child(2) form:nth-child(1) div.form-row.row:nth-child(4) > select:nth-child(2)";
    static String aliveTextBoxLocator = "div.popup.form-popup div.popup-content section:nth-child(2) form:nth-child(1) div.form-row.row:nth-child(5) > input:nth-child(2)";

    static String actualValueMsgLocator = "div:nth-child(2) div.restool-app div.app-page:nth-child(2) main.app-page-content > div.app-error";



    public void navigateTo(String url){
        auto_openURLInBrowser(url);
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
    public void navigateToSearchPage(String url){
        navigateTo(url);
    }


    public void TypeInSearchBox(String character) {
        WebElement inputBox = searchWaitUntil(inputBoxLocator);
        inputCharacters(inputBox, "");
        inputCharacters(inputBox, character);
    }

    public void ClickButton(String buttonId) {
        WebElement button = null;

        switch(buttonId){
            case "Search Submit":
                button = searchWaitUntil(searchButtonLocator);
                break;
            case "+Add Item":
                button = searchWaitUntil(addItemButtonLocator);
                break;
            case "Submit Item":
                button = searchWaitUntil(submitItemButtonLocator);
                break;
            case "Delete button":
                button = searchWaitUntil(DeleteButtonLocator);
                break;

        }
        clickButton(button);
    }

    public void addItemsValues(  String THUMBNAIL,
                                        String NAME,
                                        String REALNAME,
                                        String LOCATION,
                                        String ALIVE){
        WebElement thumbnailTextBox = searchWaitUntil(thumbnailTextBoxLocator);
        WebElement nameTextBox = searchWaitUntil(nameTextBoxLocator);
        WebElement realNameTextBox = searchWaitUntil(realNameTextBoxLocator);
        WebElement locationWebObject = searchWaitUntil(locationTextBoxLocator);
        Select locationTextBox = new Select(locationWebObject);
        WebElement aliveTextBox = searchWaitUntil(aliveTextBoxLocator);

        inputCharacters(thumbnailTextBox, THUMBNAIL);
        inputCharacters(nameTextBox, NAME);
        inputCharacters(realNameTextBox, REALNAME);
        locationTextBox.selectByValue(LOCATION);
        if(ALIVE.equals("YES")){
            aliveTextBox.click();
        }

    }

    public void alertAccept(){
        closeAlert();
    }

    public boolean haveItems(){
        WebElement el = searchWaitUntil("p.center.pagination-state");
        sleep(5000);
        if(el.getText().toLowerCase().contains("showing")) {
            return true;
        }
        return false;
    }

    //Asserts ---------------------------------------------------------------------------------
    static String actualValueNameLocator = "div.restool-app div.app-page:nth-child(2) main.app-page-content div.infinite-scroll-component__outerdiv div.infinite-scroll-component.cards-wrapper div.card:nth-child(1) div.card-row.text:nth-child(3) > span:nth-child(2)";
    static String ActualValueRealNameLocator = "div.restool-app div.app-page:nth-child(2) main.app-page-content div.infinite-scroll-component__outerdiv div.infinite-scroll-component.cards-wrapper div.card:nth-child(1) div.card-row.text:nth-child(4) > span:nth-child(2)";
    static String ActualValueCurrentLocationLocator = "div.restool-app div.app-page:nth-child(2) main.app-page-content div.infinite-scroll-component__outerdiv div.infinite-scroll-component.cards-wrapper div.card:nth-child(1) div.card-row.text:nth-child(5) > span:nth-child(2)";

    public void CheckCardValues(String ExpectedValueName,
                                       String ExpectedValueRealName,
                                       String ExpectedValueCurrentLocation) {

            WebElement actualValueName = searchWaitUntil(actualValueNameLocator);
            WebElement ActualValueRealName = searchWaitUntil(ActualValueRealNameLocator);
            WebElement ActualValueCurrentLocation = searchWaitUntil(ActualValueCurrentLocationLocator);
            ArrayList<String> exceptionCapture = new ArrayList<>();
        try
        {
            Assert.assertEquals(ExpectedValueName, actualValueName.getText());
            Assert.assertEquals(ExpectedValueRealName, ActualValueRealName.getText());
            Assert.assertEquals(ExpectedValueCurrentLocation, ActualValueCurrentLocation.getText());
        }
        catch(AssertionError e)
        {
            exceptionCapture.add(e.getMessage());
        }

    }

    public void checkMsg(String ExpectedMsg){
        WebElement actualValueMsg = searchWaitUntil(actualValueMsgLocator);
        ArrayList<String> exceptionCapture = new ArrayList<>();
        try
        {
            Assert.assertEquals(ExpectedMsg, actualValueMsg.getText());
        }
        catch(AssertionError e)
        {

            exceptionCapture.add(e.getMessage());
        }
    }

    //Search webelements by cssLocator, returns an object
    public WebElement searchWaitUntil(String locator) {
        WebElement webElement = auto_getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        return webElement;
    }

}

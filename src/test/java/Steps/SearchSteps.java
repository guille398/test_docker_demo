package Steps;

import Pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
    SearchPage google = new SearchPage();
    @Given("a Chrome browser navigates to Search page {}")
    public void navigate(String url){
        SearchPage.navigateToSearchPage(url);
    }
    @When("I type on search box the value {}")
    public void enterValue(String character){
        SearchPage.TypeInSearchBox(character);
    }

    @When("I click on {}")
    public void clickButton(String buttonId){
        SearchPage.ClickButton(buttonId);
        if (buttonId.equals("Delete button")) {
            SearchPage.alertAccept();
        }
    }





    @Then("the app shows a card which includes the name {}, the real name {}, and current location {}")
    public void CheckCard(String ExpectedValueName,
                          String ExpectedValueRealName,
                          String ExpectedValueCurrentLocation) {
        
        SearchPage.CheckCardValues(ExpectedValueName,ExpectedValueRealName,ExpectedValueCurrentLocation);
    }


    @When("I enter a valid data: {}, {}, {}, {}, {}")
    public void AddItems(
            String THUMBNAIL,
            String NAME,
            String REALNAME,
            String LOCATION,
            String ALIVE
            ) {
        SearchPage.addItemsValues(THUMBNAIL, NAME, REALNAME, LOCATION, ALIVE);
    }

    @Then("I check than {} don't exist anymore")
    public void CheckDelete(String value){
      enterValue(value);
      clickButton("Search Submit");
      SearchPage.checkMsg("Nothing to see here. Result is empty");
    }
}

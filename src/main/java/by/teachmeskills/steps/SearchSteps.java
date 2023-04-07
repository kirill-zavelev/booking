package by.teachmeskills.steps;

import by.teachmeskills.page.ResultPage;
import by.teachmeskills.page.SearchPage;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchSteps {

    private final SearchPage searchPage;
    private final ResultPage resultPage;

    public SearchSteps() {
        this.searchPage = new SearchPage();
        this.resultPage = new ResultPage();
    }

    @Given("User is on {string} page")
    public void userIsOnPage(String url) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = chromeOptions;
        open(url);
    }

    @And("The browser is maximized")
    public void theBrowserIsMaximized() {
        getWebDriver().manage().window().maximize();
    }

    @When("User types {string} in Destination input field")
    public void userTypesInDestinationInputField(String hotelName) {
        searchPage.searchForHotel(hotelName);
    }

    @Then("Clicks on the {string} is the dropdown")
    public void clicksOnTheIsTheDropdown(String hotelName) {
        searchPage.selectHotelFromDropdown(hotelName);
    }

    @And("Clicks on the Search button")
    public void clicksOnTheSearchButton() {
        searchPage.clickSearch();
    }

    @Then("Search result consists of {string} and {string}")
    public void searchResultConsistsOfAnd(String hotelName, String hotelRate) {
        Assertions.assertThat(resultPage.getHotelsName()).contains(hotelName);
        Assertions.assertThat(resultPage.getHotelRate(hotelName)).contains(hotelRate);
    }
}

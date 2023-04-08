package by.teachmeskills.step;

import by.teachmeskills.page.ResultPage;
import by.teachmeskills.page.SearchPage;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchSteps {

    private final SearchPage searchPage;
    private final ResultPage resultPage;

    public SearchSteps() {
        this.searchPage = new SearchPage();
        this.resultPage = new ResultPage();
    }

    @Given("User is on {string} page with maximized browser")
    public void userIsOnPage(String url) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = chromeOptions;
        open(url);
        getWebDriver().manage().window().maximize();
    }

    @When("User types {string} in Destination input field")
    public void userTypesHotelName(String hotelName) {
        searchPage.searchForHotel(hotelName);
    }

    @Then("Clicks on the {string} is the dropdown")
    public void userClicksOnTheHotelNameInDropdown(String hotelName) {
        searchPage.selectHotelFromDropdown(hotelName);
    }

    @And("Clicks on the Search button")
    public void userClicksOnTheSearchButton() {
        searchPage.clickSearch();
    }

    @Then("Search result consists of {string} and {string}")
    public void verifyHotelNameAndRate(String hotelName, String hotelRate) {
        assertThat(resultPage.getHotelsName())
                .as(hotelName + " should exist in the list")
                .contains(hotelName);
        assertThat(resultPage.getHotelRate(hotelName))
                .as("Rate of the " + hotelName + " should be: " + hotelRate)
                .isEqualTo(hotelRate);
    }
}

package by.teachmeskills.page;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    private static final String HOTEL_FROM_DROPDOWN = "//div[@data-testid='autocomplete-result']//div[text()='%s']";
    private static final String SEARCH_BTN = "//span[text()='Search']";

    public void searchForHotel(String hotelName) {
        $x("//input[@name='ss']").shouldBe(visible, enabled).sendKeys(hotelName);
    }

    public void selectHotelFromDropdown(String hotelName) {
        $x(String.format(HOTEL_FROM_DROPDOWN, hotelName)).shouldBe(visible).click();
    }

    public ResultPage clickSearch() {
        $x(SEARCH_BTN).shouldBe(visible, enabled).click();
        return new ResultPage();
    }
}

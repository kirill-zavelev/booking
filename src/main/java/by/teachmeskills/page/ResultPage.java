package by.teachmeskills.page;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class ResultPage {

    private static final ElementsCollection HOTEL_FROM_DROPDOWN = $$(By.xpath("//div[@data-testid='title']"));
    private static final String RATE = "//div[text()='%s']//ancestor::div[@data-testid='property-card']" +
            "//div[@data-testid='review-score']//div";

    public List<String> getHotelsName() {
        return HOTEL_FROM_DROPDOWN.texts();
    }

    public String getHotelRate(String hotelName) {
        return $x(String.format(RATE, hotelName)).shouldBe(visible).getText();
    }
}

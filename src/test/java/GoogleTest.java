import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import base.BasicTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.GooglePage;
import pages.SearchResultsPage;

public class GoogleTest extends BasicTest {
    @Test
    @DisplayName("This test should fail")
    public void failingTest() {
        GooglePage page = open("https://google.com/ncr", GooglePage.class);
        SearchResultsPage results = page.searchFor("selenidesss");

        results.checkResultsSize(1);
        results.getResults().get(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }

    @Test
    @DisplayName("This test should succeed")
    public void successfulTest() {
        GooglePage page = open("https://google.com/ncr", GooglePage.class);
        SearchResultsPage results = page.searchFor("selenide");

        results.checkResultsSize(1);
        results.getResults().get(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
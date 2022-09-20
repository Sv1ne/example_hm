import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    @Test
    void successfulSearchTest() {
        holdBrowserOpen = true;
        browser = "opera";
        open("https://www.google.com/");
        $("#W0wltc").click();
        $("[name=q]").setValue("selenide").pressEnter();
        $("#search").shouldHave(text("https://selenide.org"));
    }
}
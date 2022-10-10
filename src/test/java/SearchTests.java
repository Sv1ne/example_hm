import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SearchTests {

    @BeforeAll
    static void setUp(){
        holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
    }

    @Test
    void testForm() {
        open(baseUrl);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Gordon");
        $("#userEmail").setValue("name@gmail.com");
        $("#userEmail").setValue("name@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__day--008:not(.react-datepicker__day--outside-month)").click();
        $("#uploadPicture").uploadFromClasspath("Screenshot_4.png");
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#currentAddress").setValue("Bunina 12");
        $("#state").scrollIntoView(true);
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();

        $(".table-responsive table").$(byText("Student Name")).parent().shouldHave(text("Alex Gordon"));
        $(".table-responsive table").$(byText("Student Email")).parent().shouldHave(text("name@gmail.com"));
        $(".table-responsive table").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive table").$(byText("Mobile")).parent().shouldHave(text("0123456789"));
        $(".table-responsive table").$(byText("Date of Birth")).parent().shouldHave(text("08 August,1998"));
        $(".table-responsive table").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive table").$(byText("Hobbies")).parent().shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive table").$(byText("Picture")).parent().shouldHave(text("Screenshot_4.png"));
        $(".table-responsive table").$(byText("Address")).parent().shouldHave(text("Bunina 12"));
        $(".table-responsive table").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));

//       react-datepicker__day react-datepicker__day--008 react-datepicker__day--weekend
//        $(setDay("02")).click();


    }

}
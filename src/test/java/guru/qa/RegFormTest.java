package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1080";

    }

    @Test
    void successfulTest() {
        Selenide.open("/automation-practice-form");
        $("#close-fixedban").click();
        $("#firstName").setValue("Anuar");
        $("#lastName").setValue("Abitay");
        $("#userEmail").setValue("anuarabitay@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("7473050157");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1999");
        $("[aria-label$='October 21st, 1999']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img\\photo.jpg");
        $("#currentAddress").setValue("8 micro-district");
        $("#state").scrollIntoView(true);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#city").click();
        $("#submit").pressEnter();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Anuar Abitay"),
                text("anuarabitay@gmail.com"),
                text("Male"),
                text("7473050157"),
                text("21 October,1999"),
                text("Math"),
                text("Sports, Music"),
                text("photo.jpg"),
                text("8 micro-district"),
                text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}

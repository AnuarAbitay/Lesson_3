package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "2100x1080";
    }

    @Test
    void successfulTest() {
        Selenide.open("/automation-practice-form");
        $("#firstName").setValue("Anuar");
        $("#lastName").setValue("Abitay");
        $("#userEmail").setValue("anuarabitay@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("87473050157");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1999");
        $("#subjectsInput").scrollIntoView(true);
        $("[aria-label$='October 21st, 1999']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img\\photo.jpg");

    }
}

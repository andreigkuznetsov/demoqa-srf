package yahoo.andreikuzn;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillRegFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Kuznetsov");
        $("#userEmail").setValue("andrey@kuznetsov.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("8950789456");

        //$("#submit").click();

        //$("#output #name").shouldHave(text("Some name"));
        //$("#output").$("#email").shouldHave(text("aaa@aa.aa"));
        //$("#output").$("#currentAddress").shouldHave(text("Some address"));
        //$("#output").$("#permanentAddress").shouldHave(text("Another address"));

//        $("#output").shouldHave(text("Some name"), text("aaa@aa.aa"),
//                text("Some address"), text("Another address"));
    }
}

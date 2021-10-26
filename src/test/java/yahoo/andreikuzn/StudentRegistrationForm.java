package yahoo.andreikuzn;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("10");
        $(".react-datepicker__year-select").selectOptionByValue("1976");
        $$(".react-datepicker__day").find(text("13")).click();
        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys("c");
        $(byText("Economics")).click();
        $(byText("Sports")).click();
        File image = new File("src/test/resources/pic.jpg");
        $("#uploadPicture").uploadFile(image);
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").scrollIntoView(true);
        $("#submit").click();



                //$("#submit").click();

        //$("#output #name").shouldHave(text("Some name"));
        //$("#output").$("#email").shouldHave(text("aaa@aa.aa"));
        //$("#output").$("#currentAddress").shouldHave(text("Some address"));
        //$("#output").$("#permanentAddress").shouldHave(text("Another address"));

//        $("#output").shouldHave(text("Some name"), text("aaa@aa.aa"),
//                text("Some address"), text("Another address"));
    }
}

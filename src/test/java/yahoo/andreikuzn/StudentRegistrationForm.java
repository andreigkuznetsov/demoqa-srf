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

        //скрол страницы максимально вниз, т.к. нижнюю видимую часть формы закрывает баннер
        $("#submit").scrollIntoView(true);

        //заполняем и отправляем форму
        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Kuznetsov");
        $("#userEmail").setValue("andrey@kuznetsov.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("8950789456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOptionByValue("1996");
        $$(".react-datepicker__day").find(text("15")).click();
        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys("c");
        $(byText("Economics")).click();
        $(byText("Sports")).click();
        File image = new File("src/test/resources/pic.jpg");
        $("#uploadPicture").uploadFile(image);
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $(byText("Rajasthan")).click();
        $("#city").click();
        $(byText("Jaiselmer")).click();
        $("#submit").click();


        //проверяем введенные данные и закрываем модальное окно
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("/html/body/div[4]/div/div/div[2]/div/table").shouldHave(text("Andrey Kuznetsov"),
                text("andrey@kuznetsov.com"), text("Male"), text("8950789456"), text("15 October,1996"),
                text("Economics"), text("Sports"), text("pic.jpg"),
                text("Russia"), text("Rajasthan Jaiselmer"));
        $("#closeLargeModal").click();






        //$("#output #name").shouldHave(text("Some name"));
        //$("#output").$("#email").shouldHave(text("aaa@aa.aa"));
        //$("#output").$("#currentAddress").shouldHave(text("Some address"));
        //$("#output").$("#permanentAddress").shouldHave(text("Another address"));

//        $("#output").shouldHave(text("Some name"), text("aaa@aa.aa"),
//                text("Some address"), text("Another address"));
    }
}

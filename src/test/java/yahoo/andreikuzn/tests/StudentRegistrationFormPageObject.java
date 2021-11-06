package yahoo.andreikuzn.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormPageObject extends TestBase {

    @Test
    void fillRegFormTest() {
        //открываем страницу с формой
        registrationPage.openPage();

        //скрол страницы, т.к. нижнюю видимую часть формы закрывает баннер
        registrationPage.scrollPageUp();

        //заполняем и отправляем форму
        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("andrey@Smith.com");
        $("#genterWrapper").$(byText("Male")).click(); 
        $("#userNumber").setValue("8950789456");

        registrationPage.calendar.setDate("30", "October", "1996");

        $("#subjectsInput").click();
        $("#subjectsInput").setValue("c");
        $(byText("Economics")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(image);
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $(byText("Rajasthan")).click();
        $("#city").click();
        $(byText("Jaiselmer")).click();
        $("#submit").click();


        //проверяем введенные данные и закрываем модальное окно
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Andrey Smith"));
        $(".table-responsive").$(byText("Student Email"))
                .parent().shouldHave(text("andrey@Smith.com"));
        $(".table-responsive").$(byText("Gender"))
                .parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile"))
                .parent().shouldHave(text("8950789456"));
        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text("30 October,1996"));
        $(".table-responsive").$(byText("Subjects"))
                .parent().shouldHave(text("Economics"));
        $(".table-responsive").$(byText("Hobbies"))
                .parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture"))
                .parent().shouldHave(text("pic.jpg"));
        $(".table-responsive").$(byText("Address"))
                .parent().shouldHave(text("Russia"));
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave(text("Rajasthan Jaiselmer"));
        $("#closeLargeModal").click();
    }
}

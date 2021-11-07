package yahoo.andreikuzn.tests;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRegistrationFormPageObject extends TestBase {

    @Test
    void fillRegFormTest() {
//      Коллекция строк для проверки циклом
        Map<String, String> expectedData = new HashMap<String, String>()
        {{
            put("Student Name", TestData.FIRSTNAME + " " + TestData.LASTNAME);
            put("Student Email", TestData.EMAIL);
            put("Gender", TestData.GENDER);
            put("Mobile", TestData.PHONE);
            put("Date of Birth", TestData.DAY + " " + TestData.MONTH + "," + TestData.YEAR);
            put("Subjects", TestData.SUBJECT);
            put("Hobbies", TestData.HOBBY);
            put("Picture", TestData.IMAGENAME);
            put("Address", TestData.ADDRESS);
            put("State and City", TestData.STATE + " " + TestData.CITY);
        }};

        registrationPage.openPage()
                .scrollPageUp()
                .typeFirstName(TestData.FIRSTNAME)
                .typeLastName(TestData.LASTNAME)
                .typeEmail(TestData.EMAIL)
                .makeGenderChoice(TestData.GENDER)
                .typePhone(TestData.PHONE)
                .typeBirthday(TestData.DAY, TestData.MONTH, TestData.YEAR)
                .typeSubject(TestData.SEARCHLETTER, TestData.SUBJECT)
                .typeHobby(TestData.HOBBY)
                .uploadImage(TestData.IMAGE)
                .typeAddress(TestData.ADDRESS)
                .typeState(TestData.STATE)
                .typeCity(TestData.CITY)
                .submitRegistration();

/*      Проверка без коллекции строк
        registrationPage.checkRegistrationResults ("Student name", TestData.FIRSTNAME + " " + TestData.LASTNAME)
                .checkRegistrationResults("Student Email", TestData.EMAIL)
                .checkRegistrationResults("Gender", TestData.GENDER)
                .checkRegistrationResults("Mobile", TestData.PHONE)
                .checkRegistrationResults("Date of Birth", TestData.DAY + " " + TestData.MONTH + "," + TestData.YEAR)
                .checkRegistrationResults("Subjects", TestData.SUBJECT)
                .checkRegistrationResults("Hobbies", TestData.HOBBY)
                .checkRegistrationResults("Picture", TestData.IMAGENAME)
                .checkRegistrationResults("Address", TestData.ADDRESS)
                .checkRegistrationResults("State and City", TestData.STATE + " " + TestData.CITY);*/

//     Проверка с коллекцией строк
        ElementsCollection lines = $$(".table-responsive tbody tr").snapshot();
        for (SelenideElement line: lines) {
            String key = line.$("td").text(); // Student Name
            String expectedValue = expectedData.get(key);
            String actualValue = line.$("td", 1).text();
            assertEquals(expectedValue, actualValue, "The actual value is not equal to the expected value");
        }
       registrationPage.closeModalWidow();
    }
}

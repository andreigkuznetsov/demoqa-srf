package yahoo.andreikuzn.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRegistrationFormPageObject extends TestBase {

    @Test
    void fillRegFormTest() {

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
                .submitRegistration()
                .checkRegistrationResults(TestData.EXPECTEDDATA)
                .closeModalWidow();

    }
}

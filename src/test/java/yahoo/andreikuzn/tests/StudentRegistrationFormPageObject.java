package yahoo.andreikuzn.tests;

import org.junit.jupiter.api.Test;

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
                .typeState(TestData.STATE)
                .typeCity(TestData.CITY)
                .typeHobby(TestData.HOBBY)
                .uploadImage(TestData.IMAGE)
                .typeAddress(TestData.ADDRESS)
                .submitRegistration();

        registrationPage.checkRegistrationResults ("Student name", TestData.FIRSTNAME + " " + TestData.LASTNAME)
                .checkRegistrationResults("Student Email", TestData.EMAIL)
                .checkRegistrationResults("Gender", TestData.GENDER)
                .checkRegistrationResults("Mobile", TestData.PHONE)
                .checkRegistrationResults("Date of Birth", TestData.DAY + " " + TestData.MONTH + "," + TestData.YEAR)
                .checkRegistrationResults("Subjects", TestData.SUBJECT)
                .checkRegistrationResults("Hobbies", TestData.HOBBY)
                .checkRegistrationResults("Picture", TestData.IMAGENAME)
                .checkRegistrationResults("Address", TestData.ADDRESS)
                .checkRegistrationResults("State and City", TestData.STATE + " " + TestData.CITY);

        registrationPage.closeModalWidow();
    }
}

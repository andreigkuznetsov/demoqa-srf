package yahoo.andreikuzn.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class StudentRegistrationFormPageObject extends TestBase {

    Faker faker = new Faker(new Locale("ru"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String address = faker.address().streetAddress();

    @Test
    void fillRegFormTest() {

        registrationPage.openPage()
                .scrollPageUp()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(TestData.EMAIL)
                .makeGenderChoice(TestData.GENDER)
                .typePhone(TestData.PHONE);

        registrationPage.calendar.setDate(TestData.DAY, TestData.MONTH, TestData.YEAR);
        registrationPage.subject.setSubject(TestData.SEARCHLETTER, TestData.SUBJECT);

        registrationPage.typeHobby(TestData.HOBBY)
                .uploadImage(TestData.IMAGE)
                .typeAddress(address);

        registrationPage.state.setState(TestData.STATE);
        registrationPage.city.setCity(TestData.CITY);

        registrationPage.submitRegistration();

        registrationPage.checkRegistrationResults ("Student name", firstName + " " + lastName)
                .checkRegistrationResults("Student Email", TestData.EMAIL)
                .checkRegistrationResults("Gender", TestData.GENDER)
                .checkRegistrationResults("Mobile", TestData.PHONE)
                .checkRegistrationResults("Date of Birth", TestData.DAY + " " + TestData.MONTH + "," + TestData.YEAR)
                .checkRegistrationResults("Subjects", TestData.SUBJECT)
                .checkRegistrationResults("Hobbies", TestData.HOBBY)
                .checkRegistrationResults("Picture", TestData.IMAGENAME)
                .checkRegistrationResults("Address", address)
                .checkRegistrationResults("State and City", TestData.STATE + " " + TestData.CITY);

        registrationPage.closeModalWidow();
    }
}

package yahoo.andreikuzn.pages;

import yahoo.andreikuzn.pages.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;
import yahoo.andreikuzn.pages.components.CityComponent;
import yahoo.andreikuzn.pages.components.StateComponent;
import yahoo.andreikuzn.pages.components.SubjectComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private final String RESULT_TITLE = "Thanks for submitting the form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            scrollPage = $("#submit"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderChoice = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            hobbyInput = $("#hobbiesWrapper"),
            photoUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submitForm = $("#submit"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive"),
            closeModal = $("#closeLargeModal");
    public CalendarComponent calendar = new CalendarComponent();
    public SubjectComponent Subject = new SubjectComponent();
    public StateComponent State = new StateComponent();
    public CityComponent City = new CityComponent();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));

        return this;
    }
    public RegistrationPage scrollPageUp() {
        scrollPage.scrollIntoView(true);

        return this;
    }
    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage typeEmail(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage makeGenderChoice() {
        genderChoice.$(byText("Male")).click();

        return this;
    }
    public RegistrationPage typePhone(String value) {
        phoneInput.setValue(value);

        return this;
    }
    public RegistrationPage typeHobby() {
        hobbyInput.$(byText("Sports")).click();

        return this;
    }
}
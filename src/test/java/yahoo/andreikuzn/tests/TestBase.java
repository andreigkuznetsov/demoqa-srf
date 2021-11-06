package yahoo.andreikuzn.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import yahoo.andreikuzn.pages.RegistrationPage;

import java.io.File;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    File image = new File("src/test/resources/pic.jpg");

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

}

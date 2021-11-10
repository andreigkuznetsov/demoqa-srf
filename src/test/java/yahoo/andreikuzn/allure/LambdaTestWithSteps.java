package yahoo.andreikuzn.allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaTestWithSteps extends TestBase {

    private static final String REPOSITORY = "andreigkuznetsov/demoqa-srf";

    @Test
    @Owner("Andrei Kuznetsov")
    @Feature("Repository webpage")
    @Story("Find Issue link")
    @DisplayName("Lambda Test with Steps and Screenshot")
    @Link(name = "GitHub repository", url = "https://github.com")
    public void checkingTheIssueOnWebpage() {
        AllureLifecycle lifecycle = Allure.getLifecycle();

        step("Open website GitHub", () -> {
            open("https://github.com");
        });
        step("Searching the repository " + REPOSITORY, () -> {
            $("[data-test-selector=nav-search-input]")
                    .setValue("andreigkuznetsov/demoqa-srf").pressEnter();
        });
        step("Open the repository " + REPOSITORY, () -> {
            $(partialLinkText("andreigkuznetsov/demoqa-srf")).click();
        });
        step("Checking, that the Issues section is present", () -> {
            $("#repository-container-header").shouldHave(text("Issues"));
        });
        step("Checking, that the Links section is absent", () -> {
            $("#repository-container-header").shouldNotHave(text("Links"));
            lifecycle.addAttachment("Screenshot", "image/png", "png", getScreenshot());
        });
    }

    private byte[] getScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

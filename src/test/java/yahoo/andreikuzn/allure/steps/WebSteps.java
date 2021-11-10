package yahoo.andreikuzn.allure.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Open the Guthub main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Searching for repository {repository}")
    public void searchForRepository(String repository) {
        $("[data-test-selector=nav-search-input]")
                .setValue(repository).pressEnter();
    }

    @Step("Open the repository {repository}")
    public void goToRepository(String repository) {
        $(partialLinkText(repository)).click();
    }

    @Step("Checking, that the Issues section is present")
    public void shouldSeeIssue() {
        $("#repository-container-header").shouldHave(text("Issues"));
    }

    @Step("Checking, that the Kinks section is absent")
    public void shouldNotSeeLinks() {
        $("#repository-container-header").shouldNotHave(text("Links"));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

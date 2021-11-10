package yahoo.andreikuzn.allure;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTestWithListener extends TestBase{

    @Test
    @Owner("Andrei Kuznetsov")
    @Feature("Repository webpage")
    @Story("Find Issue link, not find Links link")
    @DisplayName("Selenide Test with Listener")
    @Link(name = "GitHub repository", url = "https://github.com/andreigkuznetsov/demoqa-srf/")

    public void checkingTheIssueOnWebpage() {
        AllureLifecycle lifecycle = Allure.getLifecycle();

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $("[data-test-selector=nav-search-input]")
                .setValue("andreigkuznetsov/demoqa-srf").pressEnter();
        $(partialLinkText("andreigkuznetsov/demoqa-srf")).click();
        $("#repository-container-header").shouldHave(text("Issues"));
        $("#repository-container-header").shouldNotHave(text("Links"));
        lifecycle.addAttachment("Screenshot", "image/png", "png", getScreenshot());
    }
    private byte[] getScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

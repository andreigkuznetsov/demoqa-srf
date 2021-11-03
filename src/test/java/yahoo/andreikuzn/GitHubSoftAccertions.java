package yahoo.andreikuzn;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSoftAccertions {

    @Test
    void checkGithubWikiPage() {
        // Открыть страницу Selenide в Github
        open ("https://github.com/selenide/selenide");
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        // Перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        $("#user-content-welcome-to-the-selenide-wiki").closest("h1")
                .shouldHave(text("Welcome to the selenide wiki!"));
        // Убедиться, что в списке страниц (Pages) есть страница SoftAssertion
        // Открыть страницу SoftAssertions,
        $(".markdown-body").$(byText("Soft assertions")).click();
        $(".gh-header-title").shouldHave(text("SoftAssertions"));
        //проверить, что внутри есть пример кода для JUnit5
        $x("//*[@id=\"wiki-body\"]/div[1]/ol[1]/li[3]/code")
                .shouldHave(text("com.codeborne.selenide.junit5.SoftAssertsExtension"));
        $x("//*[@id=\"wiki-body\"]/div[1]/ol[4]/li").shouldHave(text("Using JUnit5 extend test class:"));
        $x("//*[@id=\"wiki-body\"]/div[1]/div[5]/pre/span[1]")
                .shouldHave(text("@ExtendWith"));
        $x("//*[@id=\"wiki-body\"]/div[1]/div[5]/pre/span[2]")
                .shouldHave(text("SoftAssertsExtension"));





    }
}

package yahoo.andreikuzn;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSoftAccertions {

    @Test
    void checkGithubWikiPage() {
        // Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");
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
        $("#wiki-body").shouldHave(text("com.codeborne.selenide.junit5.SoftAssertsExtension"));
        $("#wiki-body").shouldHave(text("@ExtendWith"));
        $("#wiki-body").shouldHave(text("SoftAssertsExtension"));

    }
}

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
        $("#repository-container-header").$(byText("Wiki")).click();
        // Убедиться, что в списке страниц (Pages) есть страница SoftAssertion
        // Открыть страницу SoftAssertions,
        $(".markdown-body").$(byText("Soft assertions")).click();
        //проверить, что внутри есть пример кода для JUnit5
        $x("//*[@id=\"wiki-body\"]/div[1]/div[5]/pre/span[1]")
                .shouldHave(exactText("@ExtendWith"));





    }
}

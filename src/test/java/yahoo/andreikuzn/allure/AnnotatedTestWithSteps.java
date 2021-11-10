package yahoo.andreikuzn.allure;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yahoo.andreikuzn.allure.steps.WebSteps;

public class AnnotatedTestWithSteps extends TestBase {

    private static final String REPOSITORY = "andreigkuznetsov/demoqa-srf";

    private WebSteps steps = new WebSteps();

    @Test
    @Owner("Andrei Kuznetsov")
    @Feature("Repository webpage")
    @Story("Find Issue link, not find Links link")
    @DisplayName("Annotated Test")
    @Link(name = "GitHub repository", url = "https://github.com/andreigkuznetsov/demoqa-srf/")
    public void checkingTheIssueOnWebpage() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.shouldSeeIssue();
        steps.shouldNotSeeLinks();
        steps.takeScreenshot();
    }
}

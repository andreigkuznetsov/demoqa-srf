package yahoo.andreikuzn.allure;

import org.junit.jupiter.api.Test;
import yahoo.andreikuzn.allure.steps.WebSteps;

public class AnnotatedTestWithSteps extends TestBase {

    private static final String REPOSITORY = "andreigkuznetsov/demoqa-srf";

    private WebSteps steps = new WebSteps();

    @Test
    public void checkingTheIssueOnWebpage() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.shouldSeeIssue();
        steps.shouldNotSeeLinks();
        steps.takeScreenshot();
    }
}

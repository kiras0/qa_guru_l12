import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
@DisplayName("GitHub test with Allure")
public class GitHubTest extends BaseTest{
private final static String REPOSITORY = "eroshenkoam/allure-example";
private final static int ISSUE_NUMBER = 80;
    @DisplayName("Selenide issue search test")
    @Test
    public void selenideIssueSearchTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");

        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").submit();

        $(By.linkText(REPOSITORY)).click();

        $("#issues-tab").click();

        $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
    }

    @DisplayName("Issue search step test with lambda")
    @Test
    public void lambdaIssueStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () ->
                open(""));

        step("Inputting search request for " + REPOSITORY, () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });

        step("Clicking on our link for " + REPOSITORY, () ->
                $(By.linkText(REPOSITORY)).click());

        step("Clicking on Issues tab", () ->
                $("#issues-tab").click());

        step("Checking that we have Issue number:" + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
    }
    @DisplayName("Annotated issue search test")
    @Test
    public void annotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        AnnotatedSteps steps = new AnnotatedSteps();

        steps.openMainPage();
        steps.inputRequest(REPOSITORY);
        steps.clickRepositoryLink(REPOSITORY);
        steps.clickIssueTab();
        steps.checkingIssueNumber(ISSUE_NUMBER);

    }
}

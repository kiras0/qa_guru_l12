import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AnnotatedSteps extends BaseTest {
    @Step("Open main page")
    public void openMainPage(){
        open("");
    }
    @Step("Inputting search request for {repo}")
    public void inputRequest(String repo){
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }
    @Step("Clicking on our link for {repo}")
    public void clickRepositoryLink(String repo){
        $(By.linkText(repo)).click();
    }
    @Step("Clicking on Issues tab")
    public void clickIssueTab(){
        $("#issues-tab").click();
    }
    @Step("Checking that we have Issue number: {issue}")
    public void checkingIssueNumber(int issue){
        $(withText("#" + issue)).should(Condition.exist);
    }
}

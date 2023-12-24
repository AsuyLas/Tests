package Issues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class IssuesPage {
    private WebDriver driver;
    private By newIssueButton = By.xpath("a[@class='Button--primary Button--medium Button xh-highlight']");
    private By issueTitleField = By.id("issue_title");
    private By issueBodyField = By.id("issue_body");
    private By submitIssueButton = By.cssSelector("button.btn.btn-primary.ml-2");
    private By issuesList = By.cssSelector("ul.list-style-none");
    public IssuesPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickNewIssue() {
        driver.findElement(newIssueButton).click();
    }
    public void createNewIssue(String title, String body) {
        clickNewIssue();
        driver.findElement(issueTitleField).sendKeys(title);
        driver.findElement(issueBodyField).sendKeys(body);
        driver.findElement(submitIssueButton).click();
    }
    public int getNumberOfIssues() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElements(issuesList).size();
    }
}


package Issues;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IssuesTest {
    private static final Logger logger = LogManager.getLogger(IssuesTest.class);
    private static WebDriver driver;
    private IssuesPage issuesPage;

    @BeforeAll
    public static void setUpDriver() {
        logger.info("Setting up WebDriver...");
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void setUp() {
        logger.info("Logging into GitHub...");
        driver.get("https://github.com/login");

        WebElement loginField = driver.findElement(By.id("login_field"));
        loginField.sendKeys("asa1216911@gmail.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Mnbvc890.");

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();

        logger.info("Setting up for testing...");
        driver.get("https://github.com/DarynaHorobei97/MyTestFramework/issues");
        issuesPage = new IssuesPage(driver);
    }

    @Test
    public void testViewExistingIssues() {
        logger.info("Testing view existing issues...");
        assertTrue(issuesPage.getNumberOfIssues() > 0);
    }

   // @Test
    //public void testCreateNewIssue() {
       // logger.info("Testing create new issue...");
        //int initialNumberOfIssues = issuesPage.getNumberOfIssues();
        //issuesPage.createNewIssue("Тестовый заголовок", "Это тестовый вопрос.");
        //int updatedNumberOfIssues = issuesPage.getNumberOfIssues();
        //Assertions.assertEquals(updatedNumberOfIssues, initialNumberOfIssues + 1);
    //}
    //Было предпринято много попыток запустить этот тест, но все они не увенчались успехом,
    //если ты посмотришь и поможешь пофиксить этот баг, буду очень благодарна.

    @AfterAll
    public static void tearDown() {
        logger.info("Tearing down...");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

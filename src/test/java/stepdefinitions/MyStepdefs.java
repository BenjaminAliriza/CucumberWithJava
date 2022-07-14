package stepdefinitions;

import base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class MyStepdefs extends BaseUtil {

    private BaseUtil baseUtil;
    public MyStepdefs(BaseUtil util){
        this.baseUtil = util;
    }
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "r/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @Given("I am in the login page of the Para Bank Application")
    public void iAmInTheLoginPageOfTheParaBankApplication() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @When("I enter valid {string} and {string} with {string}")
    public void iEnterValidCredentials(String username, String password, String fullName) {
        baseUtil.userFullName = fullName;

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password + Keys.ENTER);
    }
    @Then("I should be taken to the Overview page")
    public void iShouldBeTakenToTheOverviewPage() {
        String actualFullName = driver.findElement(By.className("smallText")).getText();

        System.out.println(actualFullName);
        System.out.println(baseUtil.userFullName);

        Assertions.assertTrue(actualFullName.contains(userFullName));

        driver.findElement(By.linkText("Log Out")).click();

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}

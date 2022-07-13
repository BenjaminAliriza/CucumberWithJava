package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyStepdefs {

    private WebDriver driver;
    @Given("I am in the login page of the Para Bank Application")
    public void iAmInTheLoginPageOfTheParaBankApplication() {

        System.getProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

    }
    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        driver.findElement(By.name("username")).sendKeys("tautester");
        driver.findElement(By.name("password")).sendKeys("password" + Keys.ENTER);
    }
    @Then("I should be taken to the Overview page")
    public void iShouldBeTakenToTheOverviewPage() {
        driver.findElement(By.xpath("//*[@id='rightPanel']")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();
        driver.close();
        driver.quit();
    }
}

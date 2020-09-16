package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.searchAndviewproductlistPageObject;

import java.util.concurrent.TimeUnit;

public class viewproductpage {
    WebDriver driver;
    private By txtSearch = By.id("search");

    @Given("I am a visitor")
    public void i_am_a_visitor() {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Ramuhuyu\\Desktop\\IntelliJ\\drivers\\geckodriver.exe");


        driver = new FirefoxDriver();//This code launches the Firefox browser
        driver.get("https://magento.abox.co.za");// then gets the visitor to the homepage
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expectedTitle ="Home Page";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);//this is where you check that you are on the correct landing page
    }

    @When("I search for a product")
    public void i_search_for_a_product() {

        searchAndviewproductlistPageObject viewproductpage =
                PageFactory.initElements(driver, searchAndviewproductlistPageObject.class);
         viewproductpage.searchstore();
      //the above code gets you to the searchAndviewproductpage and executes the searchstore method
    }

    @Then("the product list page will be displayed")
    public void the_product_list_page_will_be_displayed() {


       WebElement body = driver.findElement(By.tagName("body"));
       String bodyText = body.getText();
        //this checks that you are on the correct product page and displays a message if you are not
        Assert.assertTrue("You are on Product view page",bodyText.contains("Home"));


        //negative test to check that you are on the correct product page and displays a message if you are not
       // Assert.assertTrue("Your search returned no results",bodyText.contains("Vuyo"));
       // driver.close();



    }

}

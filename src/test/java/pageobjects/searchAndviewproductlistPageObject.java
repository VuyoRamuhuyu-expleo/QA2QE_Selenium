package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class searchAndviewproductlistPageObject {
    WebDriver driver;
    private WebElement search;



    public searchAndviewproductlistPageObject(WebDriver driver) {

        this.driver = driver;

    }

       public void searchstore() {

        driver.findElement(By.id("search")).sendKeys("tees");
        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
        //locates the search textbox by id and sends input
    }



    }


package com.ibm.SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity4 {
	private WebDriver driver;
    
	@BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/crm");
	}
    
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "admin", "pa$$w0rd" }};
    }
    
    @Test (dataProvider = "Authentication")
    public void loginTestCase(String username, String password) {
        //Find username and password fields
        WebElement usernameField = driver.findElement(By.id("user_name"));
        WebElement passwordField = driver.findElement(By.id("username_password"));
        
        //Enter values
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        
        //Click Log in
        driver.findElement(By.id("bigbutton")).click();
        
        //Get title after login
        String title = driver.getTitle();
        
        //Print the title of the page after login
        System.out.println("Title after login is: " + title);
            
        //Assertion for page title after login
        Assert.assertEquals("SuiteCRM", title);
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}

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

public class Activity5 {
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
    public void loginToCRM(String username, String password) {
        //Find username and password fields and enter values
    	driver.findElement(By.id("user_name")).sendKeys(username);
        driver.findElement(By.id("username_password")).sendKeys(password);
        
        //Click Log in
        driver.findElement(By.id("bigbutton")).click();
        //Get title after login
        String title = driver.getTitle();
        System.out.println("Title after login is: " + title);
    }
    
    @Test (dependsOnMethods = { "loginToCRM" })
    public void getMenuColor() {
        //Get color of the navigation menu
    	String menuColor = driver.findElement(By.id("toolbar")).getCssValue("color");

        //Print color of the navigation menu
        System.out.println("Color of the navigation menu is: " + menuColor);
        
        //Assertion for color of the navigation menu
        Assert.assertEquals(menuColor, "rgb(83, 77, 100)");
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}

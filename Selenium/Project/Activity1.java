package com.ibm.SuiteCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	private WebDriver driver;
    
	 @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();

        //Open browser
        //driver.get("https://alchemy.hguy.co/crm/index.php");
        driver.get("https://alchemy.hguy.co/crm");
    }
    @Test
    public void websiteTitle() {
        // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        System.out.println("Website title is: " + title);
            
        //Assertion for page title
        Assert.assertEquals("SuiteCRM", title);
    }
	
	@AfterMethod 
	public void afterMethod() {
		  //Close the browser 
		  driver.close();
	}
	 	
}

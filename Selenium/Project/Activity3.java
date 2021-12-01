package com.ibm.SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
	private WebDriver driver;
    
	@BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/crm");
    }

    @Test
    public void getCopyrightText() {
        // Get the first copyright text in the footer
    	WebElement copyrightOne = driver.findElement(By.id("admin_options"));
    	           
        //Print the first copyright text in the footer
        System.out.println("The first copyright text in the footer is: " + copyrightOne.getText());
    }
	
	@AfterMethod 
	public void afterMethod() {
		//Close the browser 
		 driver.close();
	}

}

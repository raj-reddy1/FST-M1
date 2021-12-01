package com.ibm.SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
	private WebDriver driver;
    
	@BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/crm");
    }
	
    @Test
    public void getHeaderURL() {
        // Check the URL of the page header
    	WebElement headerURL = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a"));
    	WebElement headerURL1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form[1]/div[1]/img"));
            
        //Print the header URL
        System.out.println("URL of the page header is: " + headerURL.getAttribute("href"));
        System.out.println("URL of the page header is: " + headerURL1.getAttribute("src"));
    }
	
	@AfterMethod 
	public void afterMethod() {
		//Close the browser 
		 driver.close();
	}
	 	
}

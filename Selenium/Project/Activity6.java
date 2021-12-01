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

public class Activity6 {
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
    public void checkActivitiesMenuItem() {
        //Get value of the navigation menu
        String navigationMenu = driver.findElement(By.id("toolbar")).getAttribute("class");
        //Print value of the navigation menu
        System.out.println("Navigation menu class is: " + navigationMenu);
        
        //Get activities menu label
        /*WebElement activitiesMenuTab = driver.findElement(By.id("grouptab_3"));
        System.out.println("Activities Menu Tab lable is: " + activitiesMenuTab.getText());
        System.out.println("Activities Menu Tab is clickable: " + activitiesMenuTab.getAttribute("href").contains("#"));*/
        
        //Use linkText() to find <a> tag
        WebElement anchorTag = driver.findElement(By.linkText("ACTIVITIES"));
        //Use getText() to get innerHTML text
        String anchorText = anchorTag.getText();
        //Print the String
        System.out.println("Anchor tag text is: " + anchorText);
        
        //Assertion for activities menu label
        Assert.assertEquals(anchorText, "ACTIVITIES");
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}

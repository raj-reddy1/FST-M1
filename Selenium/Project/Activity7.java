package com.ibm.SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
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
    public void navigateToLeadsPage() {
        //Get SALES manu tab
        WebElement salesMenuTab = driver.findElement(By.id("grouptab_0"));
        //Click on SALES tab
        salesMenuTab.click();
        
        //Click on Leads sub menu
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        // Wait until page loads
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"content\"]/div[1]/h2[@class='module-title-text']")));
        
        // Check the title of the page
        WebElement moduleTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/h2[@class='module-title-text']"));
            
        //Print the title of the page
        System.out.println("Module title is: " + moduleTitle.getText());
            
        //Assertion for page title
        Assert.assertEquals(" LEADS", moduleTitle.getText());
    }
    
    @Test (dependsOnMethods = { "navigateToLeadsPage" })
    public void readAdditionalInfo() {
         //WebElement currentElement = driver.switchTo().activeElement(); 
        //System.out.println("currentElement is: " + currentElement.getText());
        driver.findElement(By.xpath("//*[@id=\"adspan_683f9f93-9423-1a6e-4a4d-5fd8a89ceaab\"]")).click();
        // Wait until page loads
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("phone")));
        //Get mobile phone number
        WebElement phoneNumber = driver.findElement(By.className("phone"));
        System.out.println("Phone Number in popup is: " + phoneNumber.getText());
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}

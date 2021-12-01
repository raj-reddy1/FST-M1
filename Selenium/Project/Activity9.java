package com.ibm.SuiteCRM;

import java.util.List;

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

public class Activity9 {
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
    public void printNameAndUserValues() {
        List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr[1]/th"));
        System.out.println("No. of table headers: " + cols.size());
        
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("No. of table rows: " + rows.size());
        
        System.out.println("----------Print the first 10 values in the ​Name​ column and the ​User​ column-------------");
        for(int i=1; i <= 10; i++ ) {
        	WebElement rowName = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]/b/a"));
        	WebElement rowUser = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[8]/a"));
            System.out.println("Row " + i + ": Name: " + rowName.getText() + ",  User: " + rowUser.getText());
        }
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}

package com.ibm.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

	public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Find checkbox and toggle button
        WebElement checkbox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
        WebElement toggleCheckboxButton = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
        
        //Print status
        System.out.println("The checkbox is selected: " + checkbox.isSelected());
        
        //Click the toggle button
        toggleCheckboxButton.click();
        
        //Wait for checkbox to disappear
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        //Print status
        System.out.println("The checkbox is displayed: " + checkbox.isDisplayed());
        
        //Click toggle button again
        toggleCheckboxButton.click();
        
        //Wait for checkbox to appear
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        //Print status
        System.out.println("The checkbox is displayed: " + checkbox.isDisplayed());
        checkbox.click();
        //Print status
        System.out.println("The checkbox is selected: " + checkbox.isSelected());
        
        //Close browser
        driver.close();
    }
}

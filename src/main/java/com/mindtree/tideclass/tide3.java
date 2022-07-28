package com.mindtree.tideclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tide3 {
	public static void main(String[] args) {
		search();
	}
	public static void search() {
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
         WebDriver driver=new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
         driver.get("https://tide.com/en-us"); 
         driver.manage().window().maximize();
         driver.findElement(By.xpath("//div[@id='lilo3746-wrapper']//div[@class='lilo3746-overlay lilo3746-overlay-lightbox']//a[@class='lilo3746-close-link lilo3746-close-icon']")).click();
         driver.findElement(By.xpath("//div[@class='container']//div[@class='input-wrap']//input[@name='q']")).sendKeys("Liquid");
         driver.findElement(By.xpath("//div[@class='container']//div[@class='input-wrap']//button[@type='submit']")).click();
         WebDriverWait d = new WebDriverWait(driver,20);
         d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']//div[@class='col-12 search-total-results']//span[text()='35 results']")));
         WebElement web1=driver.findElement(By.xpath("//div[@class='container']//div[@class='col-12 search-total-results']//span"));
         String result=web1.getText();
         System.out.println("There are "+result+ " for liquid");
         //driver.findElement(By.xpath("//div[@class='container']//div[@class='col-12 search-total-results']//div[@class='search-sorting-select']//option[@value='desc']")).click();
         driver.findElement(By.xpath("//div[@class='container']//div[@class='col-12 search-total-results']//div[@class='search-sorting-select']//option[@value='asc']")).click();
         //driver.findElement(By.xpath("//div[@class='search-container']//div[@class='container']//button[text()='Products (34)']")).click();
         d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-preview']//a[@href='/en-us/shop/type/liquid/tide-free-and-gentle-liquid']")));
         driver.findElement(By.xpath("//div[@class='product-preview']//a[@href='/en-us/shop/type/liquid/tide-free-and-gentle-liquid']")).click();
         driver.findElement(By.xpath("//div[@class='select-wrapper']//option[@value='Regular']")).click();
         //driver.findElement(By.xpath("//div[@class='select-wrapper']//option[@value='High Efficiency']")).click();
         driver.findElement(By.xpath("//div[contains(@class,'ps-widget ps-59923902a81961211a377174')]")).click();
         WebElement web2=driver.findElement(By.xpath("//div[@class='ps-container ps-lightbox ps-59923902a81961211a377174 ps-open']//div[@class='ps-wtb']"));
         WebElement web3=web2.findElement(By.xpath("//div[@class='ps-wtb-content']//div[@class='ps-online-sellers']//div[@class='ps-online-seller-select']"));
         //web2.findElement(By.xpath("//div[@class='ps-header']//div[@class='ps-bubble-product-selector']//span[text()='29 loads, 46 oz']")).click();
         WebElement web4=web3.findElement(By.xpath("//span[@class='ps-price']"));
         WebElement web5=web4.findElement(By.xpath("//span[@class='ps-stock-status available']"));
         String price1=web4.getText();
         String avail1=web5.getText();
         System.out.println("Price of the item: "+price1);
         System.out.println("Availability: "+avail1);
         
	}

}

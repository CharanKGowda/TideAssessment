package com.mindtree.tideclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class tide2 {
	public static void main(String[] args) {
		shop();
	}
	public static void shop(){
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
    driver.get("https://tide.com/en-us"); 
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//div[@id='lilo3746-wrapper']//div[@class='lilo3746-overlay lilo3746-overlay-lightbox']//a[@class='lilo3746-close-link lilo3746-close-icon']")).click();
    Actions a=new Actions(driver);
    a.moveToElement(driver.findElement(By.xpath("//div[@class='container']//a[@href='/en-us/shop']"))).build().perform();
    driver.findElement(By.xpath("//div[@class='submenu-child']//a[@data-action-detail='Pacs']")).click();
    driver.findElement(By.xpath("//div[@class='col-lg-4 product']//a[@href='/en-us/shop/type/laundry-pods/tide-pods-plus-febreze-spring-and-renewal']")).click();
    driver.findElement(By.xpath("//div[@class='select-wrapper']//option[@value='12 ct']")).click();
    driver.findElement(By.xpath("//div[contains(@class,'ps-widget ps-59923902a81961211a377174')]")).click();
    WebElement w1=driver.findElement(By.xpath("//div[@class='ps-container ps-lightbox ps-59923902a81961211a377174 ps-open']//div[@class='ps-wtb']"));
    WebElement w2=w1.findElement(By.xpath("//div[@class='ps-wtb-content']//div[@class='ps-online-sellers']//div[@class='ps-online-seller-select']"));
    WebElement w3=w2.findElement(By.xpath("//span[@class='ps-price']"));
    WebElement w4=w2.findElement(By.xpath("//span[@class='ps-stock-status available']"));
    String price=w3.getText();
    String avail=w4.getText();
    System.out.println("Price of the item: "+price);
    System.out.println("Availability: "+avail);
}
}


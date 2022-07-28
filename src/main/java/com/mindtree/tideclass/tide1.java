package com.mindtree.tideclass;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tide1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter\n 1 to LOG IN\n 2 to SELECT A PRODUCT FROM SHOP PRODUCTS\n 3 to SEARCH FOR PRODUCT\n 4 to PERFORM ALL ");
		a=sc.nextInt();
		if(a==1) {
		 login();
		}
 		if(a==2) {
 			tide2.shop();
 		}
 		if(a==3) {
 			tide3.search();
 		}
 		if(a==4) {
 			login();
 			tide2.shop();
 			tide3.search();
 		}
 		else {
 			System.out.println("INVALID INPUT");
 		}
	}
	public static void login() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
        driver.get("https://tide.com/en-us"); 
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='/en-us/sign-in']")).click();
        driver.findElement(By.xpath("//div[@id='lilo3746-wrapper']//div[@class='lilo3746-overlay lilo3746-overlay-lightbox']//a[@class='lilo3746-close-link lilo3746-close-icon']")).click();
        driver.findElement(By.xpath("//a[@class='event_internal_link']")).click();
		Set <String> ids=driver.getWindowHandles();
		Iterator <String> it=ids.iterator();
		String parentid=it.next();
		String childid=it.next();
		driver.switchTo().window(childid);
		//System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//form[@name='registrationForm']//input[@id='name']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//form[@name='registrationForm']//input[@id='email']")).sendKeys("ABCD@gmail.com");
		driver.findElement(By.xpath("//form[@name='registrationForm']//input[@id='password']")).sendKeys("Abcd$123");
		//driver.findElement(By.xpath("//form[@name='registrationForm']//input[@value='CREATE ACCOUNT']")).click();
		driver.findElement(By.xpath("//form[@name='registrationForm']//button[@class='underline text-primaryCta lg:text-base leading-light font-montserratSemiBold font-semibold']")).click();
		driver.findElement(By.xpath("//form[@name='signInForm']//input[@id='login-email']")).sendKeys("qwerty786@gmail.com");
		driver.findElement(By.xpath("//form[@name='signInForm']//input[@id='login-password']")).sendKeys("Qwerty@123");
		driver.findElement(By.xpath("//form[@name='signInForm']//input[@value='LOG IN']")).click();
		driver.switchTo().window(parentid);
	}
}


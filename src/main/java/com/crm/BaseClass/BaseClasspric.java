package com.crm.BaseClass;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.javaUtility.JavaUtility;
import com.crm.pom.Pric_pom;

public class BaseClasspric 
{
	public static WebDriver driver;
	
    @BeforeClass
	public void preCondition() throws IOException
	{
		String browser = JavaUtility.logindata("browser");
		String url = JavaUtility.logindata("url");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	@BeforeMethod
	public void login() throws IOException, InterruptedException
	{
//		String mob = JavaUtility.logindata("num");
//		
//		 Pric p=new Pric(driver);
//		p.mob_num.sendKeys(mob);
		
		otpValidate();
		
	}
	public void otpValidate() throws InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		 
		Pric_pom pom = new Pric_pom(driver);
		Reporter.log("Enter number",true);
		driver.findElement(By.name("tel")).sendKeys(""+sc.next());
		
		
		
		Thread.sleep(2000);
		pom.send_otp.click();
	    Reporter.log("enter first",true);
		 driver.findElement(By.xpath("(//input[@class='pincode-input-text'][1])")).sendKeys(""+sc.nextInt());
		 
		 Reporter.log("enter second",true);
		 driver.findElement(By.xpath("(//input[@class='pincode-input-text'][2])")).sendKeys(""+sc.nextInt());
		 
		 
		 Reporter.log("enter third",true);
		 driver.findElement(By.xpath("(//input[@class='pincode-input-text'][3])")).sendKeys(""+sc.nextInt());
		 
		 Reporter.log("enter fourth",true);
		 driver.findElement(By.xpath("(//input[@class='pincode-input-text'][4])")).sendKeys(""+sc.nextInt());
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[text()='Verify OTP']")).click();
	}
	
	@AfterMethod
	public void logout() throws InterruptedException
	{
		System.out.println("Aftermethod");
		
		 Pric_pom pom = new Pric_pom(driver);
		
		Thread.sleep(10000);
		
		 Actions act = new Actions(driver);
		
	    act.moveByOffset(90, 600);
	    
		act.keyDown(Keys.PAGE_DOWN);
		
		act.keyDown(Keys.PAGE_DOWN);
		
		act.build().perform();

		Thread.sleep(4000);
	
		pom.sign_out1.click();
		pom.sign_out2.click();
		

		
	}
	@AfterClass
	public void postCondition()
	{
		driver.close();
	}
	
	


}


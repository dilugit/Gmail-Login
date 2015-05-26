package chk;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GmailLogin {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		
		// 1. Log into Gmail account..............
		driver.get("https://mail.google.com/");
		driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");//Correct Gmail User Name
		driver.findElement(By.id("next")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Passwd")).sendKeys("########");// Correct Gmail Password
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("signIn")).click();
		
		// 2. Go to Inbox.........................
		//driver.findElement(By.xpath("//a[@class='J-Ke n0 aBU']/title[@")).click();
		
		// 3. Compose a new mail..................
		 driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
        driver.findElement(By.xpath("//textarea[@name='to']")).clear();
        driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("def@gmail.com");
        driver.findElement(By.xpath("//input[@name='subjectbox']")).clear();
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("THIS IS THE SUBJECT");
        driver.findElement(By.xpath("//div[@id=':oy']")).sendKeys("THIS IS THE MAIL CONTENT");
        
        // 4. Send the email......................
        driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       
        // 5. Verify the email is in Sent Mail....
       driver.findElement(By.xpath("//a[@title='Sent Mail']")).click();
       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       			if(driver.getPageSource().contains("THIS IS THE SUBJECT"))
       					{
       						System.out.println("Mail is Sent and Test Passed");
       					}
       			else
       					{
       						System.out.println("Mail isn't Sent and Test Failed");
       					}   
     
         // 6. Log out from Gmail account........
       driver.findElement(By.xpath("//span[@class='gb_d gbii']")).click();
       driver.findElement(By.xpath("//a[@id='gb_71']")).click();
       
       driver.close();
       System.exit(0);

	}
	
}

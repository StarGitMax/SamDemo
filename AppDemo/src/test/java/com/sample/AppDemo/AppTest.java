package com.sample.AppDemo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{ 
	
	 public static WebDriver driver;
	 String pwd = System.getProperty("pwd");
	 String sPath = System.getProperty("user.dir");
	 static String OS = System.getProperty("os.name").toLowerCase();
	
   @Test
    public void testApp() throws Exception
    {
	   System.out.println("Osname "+OS);
	   System.out.println("sPath "+sPath);
	   System.out.println("This is for Testing Ouput in Concource Console Using Maven");
       System.out.println("Project Working Dirctory: "+pwd);
	   if (isWindows()) {
			System.out.println("This is Windows");
			  //System.setProperty("webdriver.chrome.driver", sPath+"\\Drivers\\chromedriver.exe");
			  System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("Drivers/chromedriver.exe").getPath());
		} else if (isMac()) {
			System.out.println("This is Mac");
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
			  //System.setProperty("webdriver.chrome.driver", sPath+"//Drivers//chromedriver");
			  System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
			 //System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("Drivers/chromedriver").getPath());
		} else if (isSolaris()) {
			System.out.println("This is Solaris");
		} else {
			System.out.println("Your OS is not support!!");
		}
	   ChromeOptions options = new ChromeOptions();
	   //options.addArguments("--headless");
	   options.addArguments("--no-sandbox");
       options.addArguments("--disable-dev-shm-usage");
       options.addArguments("--disable-gpu");
       options.setExperimentalOption("useAutomationExtension", false);
       options.addArguments("start-maximized");
       options.addArguments("--window-size=1920,1200");
		driver=new ChromeDriver(options);
		driver.get("https://news.ycombinator.com/login?goto=new");
		Thread.sleep(10000);
		System.out.println("Title "+driver.getTitle());
		/*driver.findElement(By.name("q")).sendKeys("Testing"+Keys.ENTER);
		 Thread.sleep(5000);
		 System.out.println("Title "+driver.getTitle());*/
		
		driver.findElement(By.xpath("//input[@name='acct']")).sendKeys("userName");
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
	    driver.findElement(By.xpath("//input[@value='login']")).click();
	    Thread.sleep(10000);
	      
	    if(driver.getCurrentUrl().equals("https://news.ycombinator.com/login")){
	       	System.out.println("Incorrect credentials");
	       	//driver.quit();
	       	//System.exit(1);
	      }else{
	       	System.out.println("Successfuly logged in");
	        // Logout
	        driver.findElement(By.id("logout")).click();
	      }
	    
	    
	 // Take a screenshot of the current page
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File( sPath+"/target/screenshot.png"));
        
         driver.close();
         driver.quit();
    }
   
   
   public static boolean isWindows() {
 
		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		
	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}
}

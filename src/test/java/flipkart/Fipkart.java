package flipkart;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

import flipkart.actions.Actions;
import flipkart.elements.Elements;

public class Fipkart {
	public static WebDriver driver;
    @BeforeTest
    void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        if (!SystemUtils.IS_OS_WINDOWS) {
            chromeOptions.addArguments("--headless=new");
        }
        chromeOptions.addArguments("--force-device-scale-factor=1");
       // chromeOptions.addArguments("--incognito");
       // chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--dns-prefetch-disable");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("enable-features=NetworkServiceInProcess");
     //   chromeOptions.addArguments("--proxy-server=http://web-proxy.austin.hpicorp.net:8080");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
      //  driver = new ChromeDriver();
       
    }
    @Test
	public static void Flipkartassmt() throws InterruptedException, Exception {
        //String currenURL="https://www.flipkart.com";
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.flipkart.com");
        Thread.sleep(5000);
        System.out.println("Waiting for Login page to be loaded with details");
        driver.manage().window().maximize();// Maximize Window for Chrome Instance
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE); 
        robot.keyRelease(KeyEvent.VK_ESCAPE); 
        System.out.println("Login to Help Desk portal");
        Thread.sleep(6000);
      
       
        
        System.out.println("Logged in to Flipkart successfully and Home page loaded");
        Actions.searchProduct(driver);
	
    }

}


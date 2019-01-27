package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webdriver {

   public static WebDriver webdriverInitialize(){

        System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
        return new ChromeDriver();
    }
    }


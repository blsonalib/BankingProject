package com.banking.base;


import com.banking.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static Properties properties ;
    public static  WebDriver driver;
    FileInputStream fileInputStream;

    {
        try {
            properties = new Properties();
            fileInputStream = new FileInputStream("/Users/sonalibankar/Desktop/BankingProject/src/main/java/com/banking/config/config.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialize(){
        String browseName = properties.getProperty("browser");
        if(browseName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/sonalibankar/Desktop/FacebookProject/Driver/chromedriver 2");
            driver = new ChromeDriver();
        }else if(browseName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.driver.gecko","/Users/sonalibankar/Desktop/FacebookProject/Driver/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }

}

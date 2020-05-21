package com.banking.base;


import com.banking.util.IAutoConstant;
import com.banking.util.TestUtil;
import org.apache.log4j.Logger;
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
    public static final Logger log = Logger.getLogger(BaseTest.class);
    FileInputStream fileInputStream;

    {
        try {
            properties = new Properties();
            fileInputStream = new FileInputStream(IAutoConstant.CONFIG_FILE_PATH);
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
            System.setProperty(IAutoConstant.CHROM_KEY,IAutoConstant.CHROM_VALUE);
            driver = new ChromeDriver();
        }else if(browseName.equalsIgnoreCase("firefox")){
            System.setProperty(IAutoConstant.GECKO_KEY,IAutoConstant.GECKO_VALUE);
            driver = new FirefoxDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }

}

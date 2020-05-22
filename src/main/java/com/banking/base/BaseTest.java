package com.banking.base;


import com.banking.util.IAutoConstant;
import com.banking.util.TestUtil;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final Logger log = Logger.getLogger(BaseTest.class);
    public static Properties properties ;
    public static  WebDriver driver;
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
    public static void captureScreen(WebDriver driver, Class<? extends ITestResult> tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

}

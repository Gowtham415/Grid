package selenium.grid;

import org.testng.annotations.Test;

import com.sun.tools.xjc.Driver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class GridDemoTest {
	String hubURL = "http://192.168.0.104:4444/wd/hub";
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		DesiredCapabilities chromeCap = new DesiredCapabilities();
		DesiredCapabilities firefoxCap = new DesiredCapabilities();
		chromeCap.setBrowserName("chrome");
		chromeCap.setPlatform(Platform.WINDOWS);
		
		firefoxCap.setBrowserName("firefox");
		firefoxCap.setPlatform(Platform.WINDOWS);

		ChromeOptions options = new ChromeOptions();
		options.merge(chromeCap);
		try {
			driver = new RemoteWebDriver(new URL(hubURL), firefoxCap);
			//driver = new RemoteWebDriver(new URL(hubURL), options);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get("https:\\www.gmail.com");
		
		
	}

	@Test
	public void test1() {
		System.out.println(driver.getTitle());;
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}

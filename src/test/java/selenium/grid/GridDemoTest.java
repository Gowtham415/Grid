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
	public void beforeMethod() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		driver = new RemoteWebDriver(new URL(hubURL), options);
		driver.get("https:\\www.gmail.com");
	}

	@Test
	public void test1() {
	}

	@AfterMethod
	public void afterMethod() {
	}

}

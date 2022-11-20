package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginTests {
	DesiredCapabilities cap;
	AppiumDriver<MobileElement> appiumDriver;
	static String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";

	@Test(priority = 1, groups = { "skipFlow", "googleLoginFlow" })
	public void setCapabilties() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Mi A3");
		cap.setCapability(MobileCapabilityType.UDID, "6d7cbd627486");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		cap.setCapability("appPackage", "com.avegen.together");
		cap.setCapability("appActivity", "com.avegen.together.MainActivity");
		URL url = new URL(LoginTests.APPIUM_SERVER_URL);
		appiumDriver = new AppiumDriver<MobileElement>(url, cap);
		Thread.sleep(5000);
		// Setting implicit timeout between 2 actions and redirections in 2 pages
		appiumDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test(priority = 2, groups = { "skipFlow", "googleLoginFlow" })
	public void selLanguage() {
		// Select Language Option
		appiumDriver.findElement(By.xpath("//android.view.ViewGroup[@index='4']")).click();
		appiumDriver.findElement(By.xpath("//android.view.ViewGroup[@index='5']")).click();
	}

	@Test(priority = 3, groups = { "skipFlow", "googleLoginFlow" })
	public void enterName() {
		// Enter Name
		appiumDriver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys("Jayanti More");
		appiumDriver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Done"));
		appiumDriver.findElement(By.xpath("//android.view.ViewGroup[@index='3']//android.view.ViewGroup[@index='3']"))
				.click();
	}

	@Test(priority = 4, groups = {"googleLoginFlow" })
	public void selectMonth() {
		// Please select your current month of pregnancy
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='9']")).click();
		appiumDriver.findElement(By.xpath(
				"//android.view.ViewGroup[@index='17']//android.view.ViewGroup[@index='0']//android.view.ViewGroup[@index='1']"))
				.click();

	}
	@Test(priority = 4, groups = { "skipFlowDate","skipFlow" })
	public void selectDate() {
		appiumDriver.findElement(By.xpath("//android.view.ViewGroup[@index='16']")).click();
		appiumDriver.findElement(By.xpath(
				"//android.widget.Button[@content-desc=\" Wednesday 23 November 2022 \"]/android.widget.TextView"))
				.click();
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();
		appiumDriver.findElement(By.xpath(
				"//android.view.ViewGroup[@index='17']//android.view.ViewGroup[@index='0']//android.view.ViewGroup[@index='1']"))
				.click();
	}

	@Test(priority = 5, groups = { "googleLoginFlow" })
	public void signInWithGoogle() {
//		appiumDriver.findElement(By.xpath("//android.widget.EditText[@text='Enter your number']"))
//				.sendKeys("9172164861");
//		appiumDriver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Done"));
		// click on signIn option
		appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
				+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout"
				+ "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"
				+ "/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup"
				+ "/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup"
				+ "/android.view.ViewGroup[4]")).click();
		appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
				+ "/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout"
				+ "/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]"
				+ "/android.widget.LinearLayout")).click();
		appiumDriver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
	}

	@Test(priority = 6, groups = { "skipFlow" })
	public void testForSKip() {
		// Enter your mobile number: Skip
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();

	}

	@Test(priority = 7, groups = { "skipFlow", "googleLoginFlow" })
	public void clickOnPopUp() {
		// click on Don't Allow Button
		appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
				+ "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"
				+ "/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.HorizontalScrollView"
				+ "/android.view.ViewGroup/android.view.ViewGroup[1]")).click();

	}

}

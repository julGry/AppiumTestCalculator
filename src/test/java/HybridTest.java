import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Set;

public class HybridTest {
    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/yuliia/Downloads/hybrid-app.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "my device");
        desiredCapabilities.setCapability("appPackage", "com.dmytro.herasymchuk.hybridapp");
        desiredCapabilities.setCapability("appActivity", "com.dmytro.herasymchuk.hybridapp.MainActivity");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);

        driver.findElement(By.id("com.dmytro.herasymchuk.hybridapp:id/search_field")).sendKeys("https://www.calculator.net");
        driver.findElement(By.id("com.dmytro.herasymchuk.hybridapp:id/search_btn")).click();
        Thread.sleep(5000);

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
            if (contextName.contains("WEBVIEW")) {
                driver.context(contextName);
            }
        }
    }

    @Test
    public void testAddition() {

        HybridCalc page = new HybridCalc(driver);
        page.set_number("10.5");
        page.set_add();
        page.set_number("20.3");
        page.set_eq();
        Assert.assertEquals(page.get_result(),"30.8");
    }

    @Test
    public void testSubtraction() {
        HybridCalc page = new HybridCalc(driver);
        page.set_number("123.8");
        page.set_sub();
        page.set_number("83.3");
        page.set_eq();
        Assert.assertEquals(page.get_result(),"40.5");
    }

    @AfterTest
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}

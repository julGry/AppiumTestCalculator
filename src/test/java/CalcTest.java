import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalcTest {
    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/yuliia/Downloads/Calculator_v8.2.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "my device");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void testAddition() {
        NativeCalc page = new NativeCalc(driver);
        page.set_number("10.5");
        page.set_add();
        page.set_number("20.3");
        page.set_eq();
        Assert.assertEquals(page.get_result(),"30.8");
    }

    @Test
    public void testSubtraction() {
        NativeCalc page = new NativeCalc(driver);
        page.set_number("123.8");
        page.set_sub();
        page.set_number("83.3");
        page.set_eq();
        Assert.assertEquals(page.get_result(),"40.5");
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }

}
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HybridCalc {
    private int init_duration = 10;
    private AppiumDriver<MobileElement> driver;

    @FindBy(xpath = "//div[@id='sciOutPut']")
    private MobileElement calcInputField;

    @FindBy(xpath = "//div[@id='sciOutPut']")
    private MobileElement calcResult;

    @FindBy(xpath = "//span[@class='sciop' and text()='+']")
    private MobileElement calcAdd;

    @FindBy(xpath = "//span[@class='sciop' and text()='–']")
    private MobileElement calcSub;

    @FindBy(xpath = "//span[@class='sciop' and text()='*']")
    private MobileElement calcMul;

    @FindBy(xpath = "//span[@class='sciop' and text()='/']")
    private MobileElement calcDiv;

    @FindBy(xpath = "//span[@class='scieq' and text()='=']")
    private MobileElement calcEq;

    @FindBy(xpath = "//span[@class='scinm' and text()='.']")
    private MobileElement calcPoint;
    @FindBy(xpath = "//span[@class='scinm' and text()='0']")
    private MobileElement calcDigit0;
    @FindBy(xpath = "//span[@class='scinm' and text()='1']")
    private MobileElement calcDigit1;
    @FindBy(xpath = "//span[@class='scinm' and text()='2']")
    private MobileElement calcDigit2;
    @FindBy(xpath = "//span[@class='scinm' and text()='3']")
    private MobileElement calcDigit3;
    @FindBy(xpath = "//span[@class='scinm' and text()='4']")
    private MobileElement calcDigit4;
    @FindBy(xpath = "//span[@class='scinm' and text()='5']")
    private MobileElement calcDigit5;
    @FindBy(xpath = "//span[@class='scinm' and text()='6']")
    private MobileElement calcDigit6;
    @FindBy(xpath = "//span[@class='scinm' and text()='7']")
    private MobileElement calcDigit7;
    @FindBy(xpath = "//span[@class='scinm' and text()='8']")
    private MobileElement calcDigit8;
    @FindBy(xpath = "//span[@class='scinm' and text()='9']")
    private MobileElement calcDigit9;

    private void pressDigit(char c) {
        MobileElement sym = null;
        switch (c){
            case '0': sym = calcDigit0;break;
            case '1': sym = calcDigit1;break;
            case '2': sym = calcDigit2;break;
            case '3': sym = calcDigit3;break;
            case '4': sym = calcDigit4;break;
            case '5': sym = calcDigit5;break;
            case '6': sym = calcDigit6;break;
            case '7': sym = calcDigit7;break;
            case '8': sym = calcDigit8;break;
            case '9': sym = calcDigit9;break;
            case '.': sym = calcPoint;break;
            case '+': sym = calcAdd;break;
            case '-': sym = calcSub;break;
            case '*': sym = calcMul;break;
            case '/': sym = calcDiv;break;
            case '=': sym = calcEq;break;
        }
        if (sym != null) {
            sym.click();
        }
    }

    public String get_result() {
        return calcResult.getAttribute("innerHTML").substring(6);
    }

    public void set_add() {
        pressDigit('+');
    }

    public void set_sub() {
        pressDigit('-');
    }

    public void set_mul() {
        pressDigit('*');
    }

    public void set_div() {
        pressDigit('/');
    }

    public void set_eq() {
        pressDigit('=');
    }

    public void set_number(String a) {
        for (char c: a.toCharArray()) {
            pressDigit(c);
        }
    }

    public HybridCalc(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(init_duration)), this);
    }

}

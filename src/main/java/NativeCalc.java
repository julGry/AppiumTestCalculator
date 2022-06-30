import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class NativeCalc  {
    private int init_duration = 10;
    private AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.google.android.calculator:id/formula")
    private MobileElement calcInputField;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    private MobileElement calcResult;

    @AndroidFindBy(id="com.google.android.calculator:id/op_add")
    private MobileElement calcAdd;

    @AndroidFindBy(id="com.google.android.calculator:id/op_sub")
    private MobileElement calcSub;

    @AndroidFindBy(id="com.google.android.calculator:id/op_mul")
    private MobileElement calcMul;

    @AndroidFindBy(id="com.google.android.calculator:id/op_div")
    private MobileElement calcDiv;

    @AndroidFindBy(id="com.google.android.calculator:id/eq")
    private MobileElement calcEq;

    @AndroidFindBy(id="com.google.android.calculator:id/dec_point")
    private MobileElement calcPoint;

    @AndroidFindBy(id="com.google.android.calculator:id/digit_0")
    private MobileElement calcDigit0;

    @AndroidFindBy(id="com.google.android.calculator:id/digit_1")
    private MobileElement calcDigit1;

    @AndroidFindBy(id="com.google.android.calculator:id/digit_2")
    private MobileElement calcDigit2;

    @AndroidFindBy(id="com.google.android.calculator:id/digit_3")
    private MobileElement calcDigit3;

    @AndroidFindBy(id="com.google.android.calculator:id/digit_4")
    private MobileElement calcDigit4;

    @AndroidFindBy(id="com.google.android.calculator:id/digit_5")
    private MobileElement calcDigit5;

    @AndroidFindBy(id="com.google.android.calculator:id/digit_6")
    private MobileElement calcDigit6;

    @AndroidFindBy(id="com.google.android.calculator:id/digit_7")
    private MobileElement calcDigit7;

    @AndroidFindBy(id="com.google.android.calculator:id/digit_8")
    private MobileElement calcDigit8;

    @AndroidFindBy(id="com.google.android.calculator:id/digit_9")
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
        return calcResult.getAttribute("text");
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

    public NativeCalc(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(init_duration)), this);
    }

}

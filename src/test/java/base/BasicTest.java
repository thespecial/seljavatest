package base;

import io.qameta.allure.Attachment;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasicTest {
    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
        }

        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }
    };

//    @BeforeClass
//    public static void setup() {
//        Configuration.browser = "chrome";
//        Configuration.headless = true;
//    }
}

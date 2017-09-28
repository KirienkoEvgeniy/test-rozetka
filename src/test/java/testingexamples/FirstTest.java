package testingexamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import webpage.TestPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class FirstTest {
    private WebDriver driver;
    private TestPage testPage;

    @BeforeClass(groups = {"checkH1"})
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\new\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/mobile-phones/c80003/");
        testPage = new TestPage(driver);
    }

    @Test(groups = {"checkH1"})
    public void testH1() throws Exception {
        List<WebElement> myTags = testPage.getTagsH1();
        List<String> myTagsValues = new ArrayList<String>();
        for (WebElement myTag : myTags) {
            myTagsValues.add(myTag.getText());
        }
        Assert.assertTrue(myTagsValues.contains("Мобильные телефоны"));
    }

    @AfterClass(groups = {"checkH1"})
    public void afterMethod() {
        driver.quit();
    }

}

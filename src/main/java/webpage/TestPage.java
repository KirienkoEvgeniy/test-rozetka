package webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestPage {
    private WebDriver driver;

    @FindAll(@FindBy(tagName = "h1"))
    private List<WebElement> tagsH1;

    public List<WebElement> getTagsH1(){
        return tagsH1;
    }

    public TestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}

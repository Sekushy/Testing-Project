import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumPage extends PageObject {

    @FindBy(xpath = "/html/body/h1")
    private WebElement seleniumHeader;

    @FindBy(xpath = "/html/body/a")
    private WebElement returnToHomePageButton;

    public SeleniumPage (WebDriver driver) {
        super(driver);
    }

    String getSeleniumHeaderText() {
        return this.seleniumHeader.getText();
    }

    String getReturnToHomePageButton() {
        return this.returnToHomePageButton.getText();
    }

    void clickReturnToHomePageButton() {
        this.returnToHomePageButton.click();
    }

}
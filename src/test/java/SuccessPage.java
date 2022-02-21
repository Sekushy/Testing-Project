import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends PageObject {

    // SUCCESS ELEMENTS

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[5]/h3")
    private WebElement successHeader;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[5]/a")
    private WebElement returnToHomePageButton;

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    // SUCCESS ACTIONS

    String getSuccessHeaderText() {
        return this.successHeader.getText();
    }

    String getReturnToHomePageButtonText() {
        return this.returnToHomePageButton.getText();
    }

    void clickReturnToHomePage() {
        this.returnToHomePageButton.click();
    }
}

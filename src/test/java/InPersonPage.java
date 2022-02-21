import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InPersonPage extends PageObject {

    @FindBy(xpath = "/html/body/h1")
    private WebElement inPersonHeader;

    @FindBy(xpath = "/html/body/a")
    private WebElement returnToHomePageButton;

    public InPersonPage(WebDriver driver) {
        super(driver);
    }

    public String getInPersonHeaderText() {
        return this.inPersonHeader.getText();
    }

    String getReturnToHomePageButton() {
        return this.returnToHomePageButton.getText();
    }

    void clickReturnToHomePageButton() {
        this.returnToHomePageButton.click();
    }

}

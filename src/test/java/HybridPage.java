import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HybridPage extends HomePage {

    @FindBy(xpath = "/html/body/h1")
    private WebElement hybridHeader;

    @FindBy(xpath = "/html/body/a")
    private WebElement returnToHomePageButton;

    public HybridPage(WebDriver driver) {
        super(driver);
    }

    String getHybridHeaderText() {
        return this.hybridHeader.getText();
    }

    String getReturnToHomePageButton() {
        return this.returnToHomePageButton.getText();
    }

    void clickReturnToHomePageButton() {
        this.returnToHomePageButton.click();
    }

}

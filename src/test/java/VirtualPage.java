import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VirtualPage extends PageObject {

    @FindBy(xpath = "/html/body/h1")
    private WebElement virtualHeader;

    @FindBy(xpath = "/html/body/a")
    private WebElement returnToHomePageButton;

    public VirtualPage(WebDriver driver) {
        super(driver);
    }

    String getVirtualHeaderText() {
        return this.virtualHeader.getText();
    }

    String getReturnToHomePageButton() {
        return this.returnToHomePageButton.getText();
    }

    void clickReturnToHomePageButton() {
        this.returnToHomePageButton.click();
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundamentalsPage extends HomePage {

    @FindBy(xpath = "/html/body/h1")
    private WebElement fundamentalsHeader;

    @FindBy(xpath = "/html/body/a")
    private WebElement returnToHomePageButton;

    public FundamentalsPage(WebDriver driver) {
        super(driver);
    }

    String getFundamentalsHeaderText() {
        return this.fundamentalsHeader.getText();
    }

    String getReturnToHomePageButton() {
        return this.returnToHomePageButton.getText();
    }

    void clickReturnToHomePageButton() {
        this.returnToHomePageButton.click();
    }

}

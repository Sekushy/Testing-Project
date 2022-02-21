import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsletterSection extends HomePage {

    // NEWSLETTER ELEMENTS

    @FindBy(xpath = "/html/body/section[1]/div/div/div/h1/span")
    private WebElement referenceElement;

    @FindBy(xpath = "/html/body/section[2]/div/div/h3")
    private WebElement newsletterHeader;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/input")
    private WebElement enterEmailField;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/button")
    private WebElement submitEmailButton;

    public NewsletterSection(WebDriver driver) {
        super(driver);
        Utils.scrollToElement(driver,referenceElement);
    }

    // NEWSLETTER ACTIONS

    String getNewsletterHeaderText() {
        return this.newsletterHeader.getText();
    }

    String getNewsletterPlaceholderText() {
        return this.enterEmailField.getAttribute("placeholder");
    }

    String getSubmitButtonText() {
        return this.submitEmailButton.getText();
    }

    String getErrorBorder() {
        return this.enterEmailField.getAttribute("class");
    }

    void inputEmailForNewsletter(String email) {
        this.enterEmailField.sendKeys(email);
    }

    void clickSubmitEmailButton() {
        this.submitEmailButton.click();
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterSection extends HomePage {

    // CONTACT ELEMENTS

    @FindBy(xpath = "/html/body/footer")
    private WebElement referenceElement;

    @FindBy(xpath = "/html/body/section[8]/div/div/div[1]/h2")
    private WebElement contactInfoHeader;

    @FindBy (xpath = "/html/body/section[8]/div/div/div[1]/ul/li[1]")
    private WebElement mainLocationItem;

    @FindBy (xpath = "/html/body/section[8]/div/div/div[1]/ul/li[2]")
    private WebElement enrollmentPhoneItem;

    @FindBy (xpath = "/html/body/section[8]/div/div/div[1]/ul/li[3]")
    private WebElement studentPhoneItem;

    @FindBy (xpath = "/html/body/section[8]/div/div/div[1]/ul/li[4]")
    private WebElement enrollmentEmailItem;

    @FindBy (xpath = "/html/body/section[8]/div/div/div[1]/ul/li[5]")
    private WebElement studentEmailItem;

    // FOOTER ELEMENTS

    @FindBy(xpath = "/html/body/footer/div/p")
    private WebElement copyrightText;

    @FindBy(xpath = "/html/body/footer/div/a/i")
    private WebElement backToTopButton;

    public FooterSection(WebDriver driver) {
        super(driver);
        Utils.scrollToElement(driver, this.referenceElement);
    }

    // CONTACT ACTIONS
    String getMainLocationText() {
        return this.mainLocationItem.getText();
    }

    String getEnrollmentPhoneText() {
        return this.enrollmentPhoneItem.getText();
    }

    String getStudentPhoneText() {
        return this.studentPhoneItem.getText();
    }

    String getEnrollmentEmailText() {
        return this.enrollmentEmailItem.getText();
    }

    String getStudentEmailText() {
        return this.studentEmailItem.getText();
    }

    // FOOTER ACTIONS

    String getCopyrightText() {
        return this.copyrightText.getText();
    }

    void clickOnBackToTopButton() {
        Utils.scrollToElement(driver, this.referenceElement);
        this.backToTopButton.click();
    }



}

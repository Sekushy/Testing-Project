import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PaymentInformationPage extends PageObject {

    // PAYMENT INFORMATION ELEMENTS

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/h3")
    private WebElement paymentInformationHeader;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[2]/label")
    private WebElement cardHolderLabel;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[2]/input")
    private WebElement cardHolderNameField;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[1]/label")
    private WebElement cardNumberLabel;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[1]/input")
    private WebElement cardNumberField;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[2]/label")
    private WebElement cardVerificationValueLabel;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[2]/input")
    private WebElement cardVerificationValueField;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[4]/div/div[1]/label")
    private WebElement expirationDateLabel;

    @FindBy(xpath = "//*[@id=\"month\"]")
    private WebElement expirationMonth;

    @FindBy(xpath = "//*[@id=\"year\"]")
    private WebElement expirationYear;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[4]/button[2]")
    private WebElement nextButton;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[4]/button[1]")
    private WebElement previousButton;

    public PaymentInformationPage(WebDriver driver) {
        super(driver);
    }

    // CHECK PAYMENT INFORMATION ELEMENTS

    String getPaymentInformationHeaderText() {
        return this.paymentInformationHeader.getText();
    }

    String getCardHolderNameLabelText() {
        return this.cardHolderLabel.getText();
    }

    String getCardNumberLabelText() {
        return this.cardNumberLabel.getText();
    }

    String getCardVerificationValueLabelText() {
        return this.cardVerificationValueLabel.getText();
    }

    String getExpirationDateLabelText() {
        return this.expirationDateLabel.getText();
    }

    // PAYMENT INFORMATION ACTIONS

    void inputCardHolderName(String keys) {
        this.cardHolderNameField.sendKeys(keys);
    }

    void inputCardNumber(String keys) {
        this.cardNumberField.sendKeys(keys);
    }

    void inputCardVerificationValue(String keys) {
        this.cardVerificationValueField.sendKeys(keys);
    }

    void selectExpirationMonth(int index) {
        Select expMonth = new Select(driver.findElement(By.id("month")));
        expMonth.selectByIndex(index);
    }

    void selectExpirationYear(int index) {
        Select expYear = new Select(driver.findElement(By.id("year")));
        expYear.selectByIndex(index);
    }

    // EASE OF ACCESS

    void inputEverything() {
        this.cardHolderNameField.sendKeys(Constants.GENERAL_INPUT);
        this.cardNumberField.sendKeys(Constants.GENERAL_INPUT);
        this.cardVerificationValueField.sendKeys(Constants.GENERAL_INPUT);
    }

    void clickNextButton() {
        this.nextButton.click();
    }

    void clickPreviousButton() {
        this.previousButton.click();
    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactInformationPage extends HomePage {

    // CONTACT INFORMATION ELEMENTS

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/h3")
    private WebElement contactInformationHeader;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/div[1]/label")
    private WebElement emailLabel;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/div[2]/label")
    private WebElement phoneLabel;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneField;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/div[3]/label")
    private WebElement countryLabel;

    @FindBy(xpath = "//*[@id=\"country\"]")
    private WebElement countryField;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/div[4]/label")
    private WebElement cityLabel;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement cityField;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/div[5]/label")
    private WebElement postalCodeLabel;

    @FindBy(xpath = "//*[@id=\"postCode\"]")
    private WebElement postalCodeField;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/button[2]")
    private WebElement nextButton;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/button[1]")
    private WebElement previousButton;

    public ContactInformationPage(WebDriver driver) {
        super(driver);
    }

    // CHECK ALL CONTACT INFORMATION ELEMENTS

    String getContactInformationHeaderText() {
        return this.contactInformationHeader.getText();
    }

    String getEmailLabel() {
        return this.emailLabel.getText();
    }

    String getPhoneLabel() {
        return this.phoneLabel.getText();
    }

    String getCountryLabel() {
        return this.countryLabel.getText();
    }

    String getCityLabel() {
        return this.cityLabel.getText();
    }

    String getPostCodeLabel() {
        return this.postalCodeLabel.getText();
    }

    // INPUT DATA IN CONTACT INFORMATION

    void inputEmailToEmailField(String keys) {
        this.emailField.sendKeys(keys);
    }

    void inputPhoneToPhoneField(String keys) {
        this.phoneField.sendKeys(keys);
    }

    void inputCountryToCountryField(String keys) {
        this.countryField.sendKeys(keys);
    }

    void inputCityToCityField(String keys) {
        this.cityField.sendKeys(keys);
    }

    void inputPostCodeToPostCodeField(String keys) {
        this.postalCodeField.sendKeys(keys);
    }

    void clickNextButton() {
        this.nextButton.click();
    }

    void clickPreviousButton() {
        this.previousButton.click();
    }

    // EASE OF ACCESS

    void inputEverything(String keys) {
        this.emailField.sendKeys(keys);
        this.phoneField.sendKeys(keys);
        this.countryField.sendKeys(keys);
        this.cityField.sendKeys(keys);
        this.postalCodeField.sendKeys(keys);
    }

    // CHECK INPUT DATA IN CONTACT INFORMATION

    String checkEmailFieldText() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.textToBePresentInElementValue(emailField, Constants.POSITIVE_EMAIL));
        return this.emailField.getAttribute("value");
    }

    String checkPhoneFieldText() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.textToBePresentInElementValue(phoneField, Constants.POSITIVE_PHONE));
        return this.phoneField.getAttribute("value");
    }

    String checkCountryFieldText() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.textToBePresentInElementValue(countryField, Constants.POSITIVE_COUNTRY));
        return this.countryField.getAttribute("value");
    }

    String checkCityFieldText() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.textToBePresentInElementValue(cityField, Constants.POSITIVE_CITY));
        return this.cityField.getAttribute("value");
    }

    String checkPostCodeFieldText() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.textToBePresentInElementValue(postalCodeField, Constants.POSITIVE_ZIP_CODE));
        return this.postalCodeField.getAttribute("value");
    }

}

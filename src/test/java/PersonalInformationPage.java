import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInformationPage extends PageObject {

    // HEADER TEXT

    @FindBy(xpath = "/html/body/div[1]/div/h2/span")
    private WebElement softwareTestingSpanText;

    // PERSONAL INFORMATION ELEMENTS

    @FindBy(xpath = "/html/body/div[1]/div/section/div/form/div[1]/h3")
    private WebElement personalInformationHeader;

    @FindBy(xpath = "/html/body/div[1]/div/section/div/form/div[1]/div[1]/label")
    private WebElement firstNameLabel;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstNameField;

    @FindBy(xpath = "/html/body/div[1]/div/section/div/form/div[1]/div[2]/label")
    private WebElement lastNameLabel;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "/html/body/div[1]/div/section/div/form/div[1]/div[3]/label")
    private WebElement usernameLabel;

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement usernameField;

    @FindBy(xpath = "/html/body/div[1]/div/section/div/form/div[1]/div[4]/label")
    private WebElement passwordLabel;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/div[1]/div/section/div/form/div[1]/div[5]/label")
    private WebElement confirmPasswordLabel;

    @FindBy(xpath = "//*[@id=\"cpassword\"]")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[1]/button")
    private WebElement nextButton;


    public PersonalInformationPage(WebDriver driver) {
        super(driver);
        new PageNavigation(driver).switchMyEnrollmentPage(MyEnrollmentPages.PERSONAL_INFORMATION);
    }

    String getSoftwareTestingSpanText() {
        return this.softwareTestingSpanText.getText();
    }

    // CHECK ALL PERSONAL INFORMATION ELEMENTS

    String getPersonalInformationHeaderText() {
        return this.personalInformationHeader.getText();
    }

    String getFirstNameLabel() {
        return this.firstNameLabel.getText();
    }

    String getLastNameLabel() {
        return this.lastNameLabel.getText();
    }

    String getUsernameLabel() {
        return this.usernameLabel.getText();
    }

    String getPasswordLabel() {
        return this.passwordLabel.getText();
    }

    String getConfirmPasswordLabel() {
        return this.confirmPasswordLabel.getText();
    }

    // INPUT DATA IN PERSONAL INFORMATION

    void inputFirstNameToFirstNameField(String keys) {
        this.firstNameField.sendKeys(keys);
    }

    void inputLastNameToLastNameField(String keys) {
        this.lastNameField.sendKeys(keys);
    }

    void inputUsernameToUsernameField(String keys) {
        this.usernameField.sendKeys(keys);
    }

    void inputPasswordToPasswordField(String keys) {
        this.passwordField.sendKeys(keys);
    }

    void inputConfirmPasswordToConfirmPasswordField(String keys) {
        this.confirmPasswordField.sendKeys(keys);
    }

    void clickNextButton() {
        this.nextButton.click();
    }

    // EASE OF ACCESS
    void inputEverything(String keys) {
        this.firstNameField.sendKeys(keys);
        this.lastNameField.sendKeys(keys);
        this.usernameField.sendKeys(keys);
        this.passwordField.sendKeys(keys);
        this.confirmPasswordField.sendKeys(keys);
    }

    // CHECK INPUT DATA IN PERSONAL INFORMATION

    String checkFirstNameFieldText() {
        return this.firstNameField.getAttribute("value");
    }

    String checkLastNameFieldText() {
        return this.lastNameField.getAttribute("value");
    }

    String checkUsernameFieldText() {
        return this.usernameField.getAttribute("value");
    }

    String checkPasswordFieldText() {
        return this.passwordField.getAttribute("value");
    }

    String checkConfirmPasswordFieldText() {
        return this.confirmPasswordField.getAttribute("value");
    }
}

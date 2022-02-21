import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseOptionsPage extends HomePage {

    // COURSE OPTIONS ELEMENTS

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/h3")
    private WebElement courseOptionsHeader;

    @FindBy(xpath = "//*[@id=\"flexRadioButton1\"]")
    private WebElement manualTesterRadioButton;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/div[1]/label")
    private WebElement manualTesterLabel;

    @FindBy(xpath = "//*[@id=\"flexRadioButton2\"]")
    private WebElement automationTesterRadioButton;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/div[2]/label")
    private WebElement automationTesterLabel;

    @FindBy(xpath = "//*[@id=\"flexRadioButton3\"]")
    private WebElement manualAndAutomationTesterRadioButton;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/div[3]/label")
    private WebElement manualAndAutomationTesterLabel;

    @FindBy(xpath = "//*[@id=\"flexRadioButton4\"]")
    private WebElement securityTesterRadioButton;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/div[4]/label")
    private WebElement securityTesterLabel;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/button[2]")
    private WebElement nextButton;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/button[1]")
    private WebElement previousButton;

    public CourseOptionsPage(WebDriver driver) {
        super(driver);
    }

    // CHECK COURSE OPTIONS ELEMENTS

    String getCourseOptionsHeaderText() {
        return this.courseOptionsHeader.getText();
    }

    String getManualTesterLabelText() {
        return this.manualTesterLabel.getText();
    }

    String getAutomationTesterLabelText() {
        return this.automationTesterLabel.getText();
    }

    String getManualAndAutomationTesterLabelText() {
        return this.manualAndAutomationTesterLabel.getText();
    }

    String getSecurityTesterLabelText() {
        return this.securityTesterLabel.getText();
    }

    // COURSE OPTIONS ACTIONS

    void clickOnManualTesterRadioButton() {
        this.manualTesterRadioButton.click();
    }

    void clickOnAutomationTesterRadioButton() {
        this.automationTesterRadioButton.click();
    }

    void clickOnManualAndAutomationRadioButton() {
        this.manualAndAutomationTesterRadioButton.click();
    }

    void clickOnSecurityTesterRadioButton() {
        this.securityTesterRadioButton.click();
    }

    boolean isManualTesterRadioButtonSelected() {
        return this.manualTesterRadioButton.isSelected();
    }

    boolean isAutomationTesterRadioButtonSelected() {
        return this.automationTesterRadioButton.isSelected();
    }

    boolean isManualAndAutomationRadioButtonSelected() {
        return this.manualAndAutomationTesterRadioButton.isSelected();
    }

    boolean isSecurityTesterRadioButtonSelected() {
        return this.securityTesterRadioButton.isSelected();
    }

    void clickNextButton() {
        this.nextButton.click();
    }

    void clickPreviousButton() {
        this.previousButton.click();
    }
}

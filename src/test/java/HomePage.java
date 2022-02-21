import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    // NAVBAR ELEMENTS
    @FindBy(xpath = "/html/body/section[1]/div/div/div/h1")
    private WebElement referenceElement;

    @FindBy(xpath = "/html/body/nav/div/a")
    private WebElement softwareTestingCourseText;

    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[1]/a")
    private WebElement whatYouWillLearnText;

    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[2]/a")
    private WebElement questionText;

    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[3]/a")
    private WebElement instructorsText;

    // ENROLLMENT ELEMENTS

    @FindBy(xpath = "/html/body/section[1]/div/div/div/h1/span")
    private WebElement certifiedSoftwareTesterSpanText;

    @FindBy(xpath = "/html/body/section[1]/div/div/div/a")
    private WebElement startEnrollment;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // NAVBAR ACTIONS

    boolean isSoftwareTestingCourseTextVisible() {
        return this.softwareTestingCourseText.isDisplayed();
    }

    String getSoftwareTestingCourseText() {
        return this.softwareTestingCourseText.getText();
    }

    String getWhatYouWillLearnText() {
        return this.whatYouWillLearnText.getText();
    }

    String getQuestionsText() {
        return this.questionText.getText();
    }

    String getInstructorsText() {
        return this.instructorsText.getText();
    }

    void clickOnSoftwareTestingCourseButton() {
        this.softwareTestingCourseText.click();
    }

    void clickOnWhatYouWillLearnButton() {
        this.whatYouWillLearnText.click();
    }

    void clickOnQuestionsButton() {
        this.questionText.click();
    }

    void clickOnInstructorsButton() {
        this.instructorsText.click();
    }

    // ENROLLMENT ACTIONS

    String getCertifiedSoftwareTesterSpanText() {
        return this.certifiedSoftwareTesterSpanText.getText();
    }

    void clickOnStartEnrollment() {
        this.startEnrollment.click();
    }

}

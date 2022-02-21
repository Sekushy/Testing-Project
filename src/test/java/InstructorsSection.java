import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InstructorsSection extends HomePage {

    // INSTRUCTORS ELEMENTS
    @FindBy(xpath = "//*[@id=\"instructors\"]")
    private WebElement referenceElement;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/h2")
    private WebElement ourInstructorsHeader;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[1]/div/div/h3")
    private WebElement firstInstructorName;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[1]/div/div/a[1]")
    private WebElement firstInstructorTwitter;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[1]/div/div/a[2]")
    private WebElement firstInstructorFaceBook;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[1]/div/div/a[3]")
    private WebElement firstInstructorLinkedIn;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[1]/div/div/a[4]")
    private WebElement firstInstructorInstagram;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[2]/div/div/h3")
    private WebElement secondInstructorName;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[2]/div/div/a[1]")
    private WebElement secondInstructorTwitter;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[2]/div/div/a[2]")
    private WebElement secondInstructorFaceBook;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[2]/div/div/a[3]")
    private WebElement secondInstructorLinkedIn;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[2]/div/div/a[4]")
    private WebElement secondInstructorInstagram;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[3]/div/div/h3")
    private WebElement thirdInstructorName;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[3]/div/div/a[1]")
    private WebElement thirdInstructorTwitter;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[3]/div/div/a[2]")
    private WebElement thirdInstructorFaceBook;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[3]/div/div/a[3]")
    private WebElement thirdInstructorLinkedIn;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[3]/div/div/a[4]")
    private WebElement thirdInstructorInstagram;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[4]/div/div/h3")
    private WebElement fourthInstructorName;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[4]/div/div/a[1]")
    private WebElement fourthInstructorTwitter;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[4]/div/div/a[2]")
    private WebElement fourthInstructorFaceBook;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[4]/div/div/a[3]")
    private WebElement fourthInstructorLinkedIn;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[4]/div/div/a[4]")
    private WebElement fourthInstructorInstagram;

    public InstructorsSection(WebDriver driver) {
        super(driver);
        Utils.scrollToElement(driver, this.referenceElement);
    }

    // INSTRUCTORS ACTIONS

    boolean isOurInstructorsHeaderTextVisible() {
        return this.ourInstructorsHeader.isDisplayed();
    }
    String getOurInstructorsHeaderText() {
        return this.ourInstructorsHeader.getText();
    }

    String getFirstInstructorHeaderText() {
        return this.firstInstructorName.getText();
    }

    String getSecondInstructorHeaderText() {
        return this.secondInstructorName.getText();
    }

    String getThirdInstructorHeaderText() {
        return this.thirdInstructorName.getText();
    }

    String getFourthInstructorHeaderText() {
        return this.fourthInstructorName.getText();
    }

    boolean isFirstInstructorTwitterDisplayed() {
        return this.firstInstructorTwitter.isDisplayed();
    }

    boolean isFirstInstructorFacebookDisplayed() {
        return this.firstInstructorFaceBook.isDisplayed();
    }

    boolean isFirstInstructorLinkedInDisplayed() {

        return this.firstInstructorLinkedIn.isDisplayed();
    }

    boolean isFirstInstructorInstagramDisplayed() {
        return this.firstInstructorInstagram.isDisplayed();
    }

    boolean isSecondInstructorTwitterDisplayed() {
        return this.secondInstructorTwitter.isDisplayed();
    }

    boolean isSecondInstructorFacebookDisplayed() {
        return this.secondInstructorFaceBook.isDisplayed();
    }

    boolean isSecondInstructorLinkedInDisplayed() {
        return this.secondInstructorLinkedIn.isDisplayed();
    }

    boolean isSecondInstructorInstagramDisplayed() {
        return this.secondInstructorInstagram.isDisplayed();
    }

    boolean isThirdInstructorTwitterDisplayed() {
        return this.thirdInstructorTwitter.isDisplayed();
    }

    boolean isThirdInstructorFacebookDisplayed() {
        return this.thirdInstructorFaceBook.isDisplayed();
    }

    boolean isThirdInstructorLinkedInDisplayed() {
        return this.thirdInstructorLinkedIn.isDisplayed();
    }

    boolean isThirdInstructorInstagramDisplayed() {
        return this.thirdInstructorInstagram.isDisplayed();
    }

    boolean isFourthInstructorTwitterDisplayed() {
        return this.fourthInstructorTwitter.isDisplayed();
    }

    boolean isFourthInstructorFacebookDisplayed() {
        return this.fourthInstructorFaceBook.isDisplayed();
    }

    boolean isFourthInstructorLinkedInDisplayed() {
        return this.fourthInstructorLinkedIn.isDisplayed();
    }

    public boolean isFourthInstructorInstagramDisplayed() {
        return this.fourthInstructorInstagram.isDisplayed();
    }

    void clickOnFirstInstructorTwitter() {
        this.firstInstructorTwitter.click();
    }

    void clickOnFirstInstructorFacebook() {
        this.firstInstructorFaceBook.click();
    }

    void clickOnFirstInstructorLinkedIn() {
        this.firstInstructorLinkedIn.click();
    }

    void clickOnFirstInstructorInstagram() {
        this.firstInstructorInstagram.click();
    }

    void clickOnSecondInstructorTwitter() {
        this.secondInstructorTwitter.click();
    }

    void clickOnSecondInstructorFacebook() {
        this.secondInstructorFaceBook.click();
    }

    void clickOnSecondInstructorLinkedIn() {
        this.secondInstructorLinkedIn.click();
    }

    void clickOnSecondInstructorInstagram() {
        this.secondInstructorInstagram.click();
    }

    void clickOnThirdInstructorTwitter() {
        this.thirdInstructorTwitter.click();
    }

    void clickOnThirdInstructorFacebook() {
        this.thirdInstructorFaceBook.click();
    }

    void clickOnThirdInstructorLinkedIn() {
        this.thirdInstructorLinkedIn.click();
    }

    void clickOnThirdInstructorInstagram() {
        this.thirdInstructorInstagram.click();
    }

    void clickOnFourthInstructorTwitter() {
        this.fourthInstructorTwitter.click();
    }

    void clickOnFourthInstructorFacebook() {
        this.fourthInstructorFaceBook.click();
    }

    void clickOnFourthInstructorLinkedIn() {
        this.fourthInstructorLinkedIn.click();
    }

    void clickOnFourthInstructorInstagram() {
        this.fourthInstructorInstagram.click();
    }
}

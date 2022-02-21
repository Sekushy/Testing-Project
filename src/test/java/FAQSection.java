import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FAQSection extends HomePage {

    // FAQ ELEMENTS

    @FindBy(xpath = "//*[@id=\"questions\"]")
    private WebElement referenceElement;

    @FindBy(xpath = "//*[@id=\"questions\"]/div/h2")
    private WebElement frequentlyAskedQuestionsHeader;

    @FindBy(xpath = "//*[@id=\"questions\"]/div[1]/h3/button")
    private WebElement firstQuestion;

    @FindBy(xpath = "//*[@id=\"question-one\"]")
    private WebElement firstQuestionText;

    @FindBy(xpath = "//*[@id=\"questions\"]/div[2]/h3/button")
    private WebElement secondQuestion;

    @FindBy(xpath = "//*[@id=\"question-two\"]")
    private WebElement secondQuestionText;

    @FindBy(xpath = "//*[@id=\"questions\"]/div[3]/h3/button")
    private WebElement thirdQuestion;

    @FindBy(xpath = "//*[@id=\"question-three\"]")
    private WebElement thirdQuestionText;

    @FindBy(xpath = "//*[@id=\"questions\"]/div[4]/h3/button")
    private WebElement fourthQuestion;

    @FindBy(xpath = "//*[@id=\"question-four\"]")
    private WebElement fourthQuestionText;

    @FindBy(xpath = "//*[@id=\"questions\"]/div[5]/h3/button")
    private WebElement fifthQuestion;

    @FindBy(xpath = "//*[@id=\"question-five\"]")
    private WebElement fifthQuestionText;

    public FAQSection(WebDriver driver) {
        super(driver);
        Utils.scrollToElement(driver, this.referenceElement);
    }

    // FAQ ACTIONS

    boolean isFrequentlyAskedQuestionsHeaderVisible() {
        return this.frequentlyAskedQuestionsHeader.isDisplayed();
    }

    String getFrequentlyAskedQuestionsHeaderText() {
        return this.frequentlyAskedQuestionsHeader.getText();
    }

    String getFirstQuestionClass() {
        return this.firstQuestionText.getAttribute("class");
    }

    String getSecondQuestionClass() {
        return this.secondQuestionText.getAttribute("class");
    }

    String getThirdQuestionClass() {
        return this.thirdQuestionText.getAttribute("class");
    }

    String getFourthQuestionClass() {
        return this.fourthQuestionText.getAttribute("class");
    }

    String getFifthQuestionClass() {
        return this.fifthQuestionText.getAttribute("class");
    }

    void clickFirstQuestion() {
        this.firstQuestion.click();
        Utils.waitForElementToLoad(1);
    }

    void clickSecondQuestion() {
        this.secondQuestion.click();
        Utils.waitForElementToLoad(1);
    }

    void clickThirdQuestion() {
        this.thirdQuestion.click();
        Utils.waitForElementToLoad(1);
    }

    void clickFourthQuestion() {
        this.fourthQuestion.click();
        Utils.waitForElementToLoad(1);
    }

    void clickFifthQuestion() {
        this.fifthQuestion.click();
        Utils.waitForElementToLoad(1);
    }
}

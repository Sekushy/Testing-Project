import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LearnSection extends HomePage {

    // LEARN ELEMENTS

    @FindBy(xpath = "//*[@id=\"learn-fundamentals\"]")
    private WebElement referenceElement;

    @FindBy(xpath = "//*[@id=\"learn-fundamentals\"]/div/div/div[2]/h2")
    private WebElement learnTheFundamentalsHeader;

    @FindBy(xpath = "//*[@id=\"learn-fundamentals\"]/div/div/div[2]/a")
    private WebElement readMoreFundamentals;

    @FindBy(xpath = "//*[@id=\"learn-selenium\"]/div/div/div[1]/a")
    private WebElement readMoreSelenium;

    public LearnSection(WebDriver driver) {
        super(driver);
        Utils.waitForElementToLoad(2);
        Utils.scrollToElement(driver, this.referenceElement);
    }

    // LEARN ACTIONS

    boolean isLearnTheFundamentalsHeaderTextVisible() {
        return this.learnTheFundamentalsHeader.isDisplayed();
    }

    public String getLearnTheFundamentalsHeaderText() {
        return this.learnTheFundamentalsHeader.getText();
    }

    void clickOnFundamentalsReadMoreButton() {
        this.readMoreFundamentals.click();
    }

    void clickOnSeleniumReadMoreButton() {
        this.readMoreSelenium.click();
    }
}

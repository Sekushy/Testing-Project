import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardDeckSection extends HomePage {

    // CARD DECK ELEMENTS

    @FindBy(xpath = "/html/body/section[1]/div/div/div/h1/span")
    private WebElement referenceElement;

    @FindBy(xpath = "/html/body/section[3]/div/div/div[1]/div/div/a")
    private WebElement readMoreVirtual;

    @FindBy(xpath = "html/body/section[3]/div/div/div[2]/div/div/a")
    private WebElement readMoreHybrid;

    @FindBy(xpath = "/html/body/section[3]/div/div/div[3]/div/div/a")
    private WebElement readMoreInPerson;

    public CardDeckSection(WebDriver driver) {
        super(driver);
        Utils.scrollToElement(driver, this.referenceElement);
    }

    // CARD DECK ACTIONS

    void clickOnVirtualReadMoreButton() {
        this.readMoreVirtual.click();
    }

    void clickOnHybridReadMoreButton() {
        this.readMoreHybrid.click();
    }

    void clickOnInPersonReadMoreButton() {
        this.readMoreInPerson.click();
    }

}

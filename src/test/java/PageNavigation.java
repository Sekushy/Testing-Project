import org.openqa.selenium.WebDriver;

public class PageNavigation extends PageObject {

    public PageNavigation(WebDriver driver) {
        super(driver);
        navigateToHomePage();
    }

    public void switchMyPages(MyPages page) {
        switch (page) {
            case HOME_PAGE -> navigateToHomePage();
            case VIRTUAL_PAGE -> navigateToVirtualPage();
            case HYBRID_PAGE -> navigateToHybridPage();
            case IN_PERSON_PAGE -> navigateToInPersonPage();
            case FUNDAMENTALS_PAGE -> navigateToFundamentalsPage();
            case SELENIUM_PAGE -> navigateToSeleniumPage();
        }
    }

    public void switchMyEnrollmentPage(MyEnrollmentPages page) {
        switch (page) {
            case PERSONAL_INFORMATION -> navigateToPersonalInformationPage();
            case CONTACT_INFORMATION -> navigateToContactInformationPage();
            case COURSE_OPTIONS -> navigateToCourseOptionsPage();
            case PAYMENT_INFORMATION -> navigateToPaymentInformationPage();
            case SUCCESS_PAGE -> navigateToSuccessPage();
        }
    }

    private void navigateToHomePage() {
        driver.get(Utils.BASE_URL);
    }

    private void navigateToPersonalInformationPage() {
        driver.get(Utils.BASE_URL);
        new HomePage(driver).clickOnStartEnrollment();
    }

    private void navigateToVirtualPage() {
        driver.get(Utils.BASE_URL);
        new CardDeckSection(driver).clickOnVirtualReadMoreButton();
    }

    private void navigateToHybridPage() {
        driver.get(Utils.BASE_URL);
        new CardDeckSection(driver).clickOnHybridReadMoreButton();
    }

    private void navigateToInPersonPage() {
        driver.get(Utils.BASE_URL);
        new CardDeckSection(driver).clickOnInPersonReadMoreButton();
    }

    private void navigateToFundamentalsPage() {
        driver.get(Utils.BASE_URL);
        new LearnSection(driver).clickOnFundamentalsReadMoreButton();
    }

    private void navigateToSeleniumPage() {
        driver.get(Utils.BASE_URL);
        new LearnSection(driver).clickOnSeleniumReadMoreButton();
    }

    private void navigateToContactInformationPage() {
        navigateToPersonalInformationPage();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.inputEverything(Constants.GENERAL_INPUT);
        personalInformationPage.clickNextButton();
    }

    private void navigateToCourseOptionsPage() {
        navigateToContactInformationPage();
        ContactInformationPage contactInformationPage = new ContactInformationPage(driver);
        contactInformationPage.inputEverything(Constants.GENERAL_INPUT);
        contactInformationPage.clickNextButton();
    }

    private void navigateToPaymentInformationPage() {
        navigateToCourseOptionsPage();
        new CourseOptionsPage(driver).clickNextButton();
    }

    private void navigateToSuccessPage() {
        navigateToPaymentInformationPage();
        PaymentInformationPage paymentInformationPage = new PaymentInformationPage(driver);
        paymentInformationPage.inputEverything();
        paymentInformationPage.clickNextButton();
    }
}

enum MyPages {
    HOME_PAGE,
    VIRTUAL_PAGE,
    HYBRID_PAGE,
    IN_PERSON_PAGE,
    FUNDAMENTALS_PAGE,
    SELENIUM_PAGE
}

enum MyEnrollmentPages {
    PERSONAL_INFORMATION,
    CONTACT_INFORMATION,
    COURSE_OPTIONS,
    PAYMENT_INFORMATION,
    SUCCESS_PAGE
}

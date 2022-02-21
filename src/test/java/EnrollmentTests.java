import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnrollmentTests {
    protected static final WebDriver driver = new ChromeDriver();

    PageNavigation pageNavigation = new PageNavigation(driver);

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    // PERSONAL INFORMATION TESTS

    @Test(testName = "Test for personal information elements for typos, expected OK")
    public void verifyPersonalInformation() {
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        assertAll(() -> assertEquals(personalInformationPage.getSoftwareTestingSpanText(), Constants.SOFTWARE_TESTING_SPAN),
                () -> assertEquals(personalInformationPage.getPersonalInformationHeaderText(), Constants.PERSONAL_INFO_HEADER),
                () -> assertEquals(personalInformationPage.getFirstNameLabel(), Constants.FIRST_NAME_LABEL),
                () -> assertEquals(personalInformationPage.getLastNameLabel(), Constants.LAST_NAME_LABEL),
                () -> assertEquals(personalInformationPage.getUsernameLabel(), Constants.USERNAME_LABEL),
                () -> assertEquals(personalInformationPage.getPasswordLabel(), Constants.PASSWORD_LABEL),
                () -> assertEquals(personalInformationPage.getConfirmPasswordLabel(), Constants.CONFIRM_PASSWORD_LABEL));
    }

    @Test(testName = "Test for personal information inputs, expected OK")
    public void fillInPersonalInformation() {
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.inputFirstNameToFirstNameField(Constants.POSITIVE_FIRST_NAME);
        personalInformationPage.inputLastNameToLastNameField(Constants.POSITIVE_LAST_NAME);
        personalInformationPage.inputUsernameToUsernameField(Constants.POSITIVE_USERNAME);
        personalInformationPage.inputPasswordToPasswordField(Constants.POSITIVE_PASSWORD);
        personalInformationPage.inputConfirmPasswordToConfirmPasswordField(Constants.POSITIVE_PASSWORD_SECONDARY);
        personalInformationPage.clickNextButton();
        assertEquals(new ContactInformationPage(driver).getContactInformationHeaderText(), Constants.CONTACT_INFO_HEADER);
    }

    @Test(testName = "Test for personal information inputs after switching page, expected OK")
    public void checkPersonalInformationData() {
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.inputFirstNameToFirstNameField(Constants.POSITIVE_FIRST_NAME);
        personalInformationPage.inputLastNameToLastNameField(Constants.POSITIVE_LAST_NAME);
        personalInformationPage.inputUsernameToUsernameField(Constants.POSITIVE_USERNAME);
        personalInformationPage.inputPasswordToPasswordField(Constants.POSITIVE_PASSWORD);
        personalInformationPage.inputConfirmPasswordToConfirmPasswordField(Constants.POSITIVE_PASSWORD);
        personalInformationPage.clickNextButton();
        new ContactInformationPage(driver).clickPreviousButton();
        assertAll(
                () -> assertEquals(personalInformationPage.checkFirstNameFieldText(), Constants.POSITIVE_FIRST_NAME),
                () -> assertEquals(personalInformationPage.checkLastNameFieldText(), Constants.POSITIVE_LAST_NAME),
                () -> assertEquals(personalInformationPage.checkUsernameFieldText(), Constants.POSITIVE_USERNAME),
                () -> assertEquals(personalInformationPage.checkPasswordFieldText(), Constants.POSITIVE_PASSWORD),
                () -> assertEquals(personalInformationPage.checkConfirmPasswordFieldText(), Constants.POSITIVE_PASSWORD));
    }

    // CONTACT INFORMATION TESTS

    @Test(testName = "Test for contact information elements for typos, expected OK")
    public void verifyContactInformation() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.CONTACT_INFORMATION);
        ContactInformationPage contactInformationPage = new ContactInformationPage(driver);
        assertAll(
                () -> assertEquals(contactInformationPage.getContactInformationHeaderText(), Constants.CONTACT_INFO_HEADER),
                () -> assertEquals(contactInformationPage.getEmailLabel(), Constants.EMAIL_LABEL),
                () -> assertEquals(contactInformationPage.getPhoneLabel(), Constants.PHONE_LABEL),
                () -> assertEquals(contactInformationPage.getCountryLabel(), Constants.COUNTRY_LABEL),
                () -> assertEquals(contactInformationPage.getCityLabel(), Constants.CITY_LABEL),
                () -> assertEquals(contactInformationPage.getPostCodeLabel(), Constants.POST_CODE_LABEL));
    }

    @Test(testName = "Test for contact information inputs, expected OK")
    public void fillInContactInformation() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.CONTACT_INFORMATION);
        ContactInformationPage contactInformationPage = new ContactInformationPage(driver);
        contactInformationPage.inputEmailToEmailField(Constants.POSITIVE_EMAIL);
        contactInformationPage.inputPhoneToPhoneField(Constants.POSITIVE_PHONE);
        contactInformationPage.inputCountryToCountryField(Constants.POSITIVE_COUNTRY);
        contactInformationPage.inputCityToCityField(Constants.POSITIVE_CITY);
        contactInformationPage.inputPostCodeToPostCodeField(Constants.POSITIVE_ZIP_CODE);
        contactInformationPage.clickNextButton();
        assertEquals(new CourseOptionsPage(driver).getCourseOptionsHeaderText(), Constants.COURSE_OPTIONS_HEADER);
    }

    @Test(testName = "Test for personal information inputs after switching page, expected OK")
    public void checkContactInformationData() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.CONTACT_INFORMATION);
        ContactInformationPage contactInformationPage = new ContactInformationPage(driver);
        contactInformationPage.inputEmailToEmailField(Constants.POSITIVE_EMAIL);
        contactInformationPage.inputPhoneToPhoneField(Constants.POSITIVE_PHONE);
        contactInformationPage.inputCountryToCountryField(Constants.POSITIVE_COUNTRY);
        contactInformationPage.inputCityToCityField(Constants.POSITIVE_CITY);
        contactInformationPage.inputPostCodeToPostCodeField(Constants.POSITIVE_ZIP_CODE);
        contactInformationPage.clickNextButton();
        new CourseOptionsPage(driver).clickPreviousButton();
        assertAll(
                () -> assertEquals(contactInformationPage.checkEmailFieldText(), Constants.POSITIVE_EMAIL),
                () -> assertEquals(contactInformationPage.checkPhoneFieldText(), Constants.POSITIVE_PHONE),
                () -> assertEquals(contactInformationPage.checkCountryFieldText(), Constants.POSITIVE_COUNTRY),
                () -> assertEquals(contactInformationPage.checkCityFieldText(), Constants.POSITIVE_CITY),
                () -> assertEquals(contactInformationPage.checkPostCodeFieldText(), Constants.POSITIVE_ZIP_CODE));
    }

    // COURSE OPTIONS TESTS

    @Test(testName = "Test for course options elements for typos, expected OK")
    public void verifyCourseOptions() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.COURSE_OPTIONS);
        CourseOptionsPage courseOptionsPage = new CourseOptionsPage(driver);
        assertAll(() -> assertEquals(courseOptionsPage.getCourseOptionsHeaderText(), Constants.COURSE_OPTIONS_HEADER),
                () -> assertEquals(courseOptionsPage.getManualTesterLabelText(), Constants.MANUAL_CERTIFICATE_LABEL),
                () -> assertEquals(courseOptionsPage.getAutomationTesterLabelText(), Constants.AUTOMATION_CERTIFICATE_LABEL),
                () -> assertEquals(courseOptionsPage.getManualAndAutomationTesterLabelText(), Constants.AUTOMATION_AND_MANUAL_CERTIFICATE_LABEL),
                () -> assertEquals(courseOptionsPage.getSecurityTesterLabelText(), Constants.SECURITY_CERTIFICATE_LABEL));
    }

    @Test(testName = "Test for selecting manual tester radio button, expected OK")
    public void selectManualTester() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.COURSE_OPTIONS);
        CourseOptionsPage courseOptionsPage = new CourseOptionsPage(driver);
        courseOptionsPage.clickOnManualTesterRadioButton();
        assertTrue(courseOptionsPage.isManualTesterRadioButtonSelected());
    }

    @Test(testName = "Test for selecting automation tester radio button, expected OK")
    public void selectAutomationTester() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.COURSE_OPTIONS);
        CourseOptionsPage courseOptionsPage = new CourseOptionsPage(driver);
        courseOptionsPage.clickOnAutomationTesterRadioButton();
        assertTrue(courseOptionsPage.isAutomationTesterRadioButtonSelected());
    }

    @Test(testName = "Test for selecting manual and automation tester radio button, expected OK")
    public void selectAutomationAndManualTester() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.COURSE_OPTIONS);
        CourseOptionsPage courseOptionsPage = new CourseOptionsPage(driver);
        courseOptionsPage.clickOnManualAndAutomationRadioButton();
        assertTrue(courseOptionsPage.isManualAndAutomationRadioButtonSelected());
    }

    @Test(testName = "Test for selecting security tester radio button, expected OK")
    public void selectSecurityTester() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.COURSE_OPTIONS);
        CourseOptionsPage courseOptionsPage = new CourseOptionsPage(driver);
        courseOptionsPage.clickOnSecurityTesterRadioButton();
        assertTrue(courseOptionsPage.isSecurityTesterRadioButtonSelected());
    }

    @Test(testName = "Test for selecting all radio buttons, expected OK")
    public void selectAllCourseOptionsTester() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.COURSE_OPTIONS);
        CourseOptionsPage courseOptionsPage = new CourseOptionsPage(driver);
        courseOptionsPage.clickOnManualTesterRadioButton();
        courseOptionsPage.clickOnAutomationTesterRadioButton();
        courseOptionsPage.clickOnManualAndAutomationRadioButton();
        courseOptionsPage.clickOnSecurityTesterRadioButton();
        assertAll(() -> assertTrue(courseOptionsPage.isManualTesterRadioButtonSelected()),
                () -> assertTrue(courseOptionsPage.isAutomationTesterRadioButtonSelected()),
                () -> assertTrue(courseOptionsPage.isManualAndAutomationRadioButtonSelected()),
                () -> assertTrue(courseOptionsPage.isSecurityTesterRadioButtonSelected()));
    }

    // PAYMENT INFORMATION TESTS

    @Test(testName = "Test for payment information elements for typos, expected OK")
    public void verifyPaymentInformation() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.PAYMENT_INFORMATION);
        PaymentInformationPage paymentInformationPage = new PaymentInformationPage(driver);
        assertAll(() -> assertEquals(paymentInformationPage.getPaymentInformationHeaderText(), Constants.PAYMENT_INFO_HEADER),
                () -> assertEquals(paymentInformationPage.getCardHolderNameLabelText(), Constants.CARD_HOLDER_NAME_LABEL),
                () -> assertEquals(paymentInformationPage.getCardNumberLabelText(), Constants.CARD_NUMBER_LABEL),
                () -> assertEquals(paymentInformationPage.getCardVerificationValueLabelText(), Constants.CARD_VERIFICATION_VALUE_LABEL),
                () -> assertEquals(paymentInformationPage.getExpirationDateLabelText(), Constants.EXPIRATION_DATE_LABEL));
    }

    @Test(testName = "Test for payment information inputs, expected OK")
    public void fillInPaymentInformation() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.PAYMENT_INFORMATION);
        PaymentInformationPage paymentInformationPage = new PaymentInformationPage(driver);
        paymentInformationPage.inputCardHolderName(Constants.POSITIVE_CARD_HOLDER_NAME);
        paymentInformationPage.inputCardNumber(Constants.POSITIVE_CARD_NUMBER);
        paymentInformationPage.inputCardVerificationValue(Constants.POSITIVE_CVV);
        paymentInformationPage.selectExpirationMonth(Constants.MONTH_INDEX);
        paymentInformationPage.selectExpirationYear(Constants.YEAR_INDEX);
        paymentInformationPage.clickNextButton();
        assertEquals(new SuccessPage(driver).getSuccessHeaderText(), Constants.SUCCESS_HEADER);
    }

    // SUCCESS PAGE TESTS

    @Test(testName = "Test for success elements for typos, expected OK")
    public void verifySuccess() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.SUCCESS_PAGE);
        SuccessPage successPage = new SuccessPage(driver);
        assertAll(() -> assertEquals(successPage.getSuccessHeaderText(), Constants.SUCCESS_HEADER),
                () -> assertEquals(successPage.getReturnToHomePageButtonText(), Constants.SUCCESS_BUTTON));
    }

    @Test(testName = "Test for covering enrollment flow, expected OK")
    public void coverStartEnrollmentFlow() {
        pageNavigation.switchMyEnrollmentPage(MyEnrollmentPages.SUCCESS_PAGE);
        new SuccessPage(driver).clickReturnToHomePage();
        assertEquals(new HomePage(driver).getCertifiedSoftwareTesterSpanText(), Constants.CERTIFIED_SOFTWARE_TESTER);
    }

    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
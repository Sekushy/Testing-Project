import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTests {
    protected static final WebDriver driver = new ChromeDriver();

    PageNavigation pageNavigation = new PageNavigation(driver);

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    // NAVBAR TESTS

    @Test(testName = "Test with navbar elements typos, expected OK")
    public void verifyNavbar() {
        HomePage homePage = new HomePage(driver);
        assertAll(
                () -> assertEquals(homePage.getSoftwareTestingCourseText(), Constants.SOFTWARE_TESTING_COURSE),
                () -> assertEquals(homePage.getWhatYouWillLearnText(), Constants.WHAT_YOU_WILL_LEARN),
                () -> assertEquals(homePage.getQuestionsText(), Constants.QUESTIONS),
                () -> assertEquals(homePage.getInstructorsText(), Constants.INSTRUCTORS));
    }

    @Test(testName = "Test with navbar software testing course button, expected OK")
    public void verifySoftwareTestingCourseButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSoftwareTestingCourseButton();
        assertAll(
                () -> assertTrue(homePage.isSoftwareTestingCourseTextVisible()),
                () -> assertEquals(homePage.getSoftwareTestingCourseText(), Constants.SOFTWARE_TESTING_COURSE)
        );
    }

    @Test(testName = "Test with navbar what you'll learn button, expected OK")
    public void verifyWhatYouWillLearnButton() {
        LearnSection learnSection = new LearnSection(driver);
        new HomePage(driver).clickOnWhatYouWillLearnButton();
        assertAll(
                () -> assertTrue(learnSection.isLearnTheFundamentalsHeaderTextVisible()),
                () -> assertEquals(learnSection.getLearnTheFundamentalsHeaderText(), Constants.FUNDAMENTALS_HEADER)
        );
    }

    @Test(testName = "Test with navbar questions button, expected OK")
    public void verifyQuestionsButton() {
        FAQSection faqSection = new FAQSection(driver);
        new HomePage(driver).clickOnQuestionsButton();
        assertAll(
                () -> assertTrue(faqSection.isFrequentlyAskedQuestionsHeaderVisible()),
                () -> assertEquals(faqSection.getFrequentlyAskedQuestionsHeaderText(), Constants.FAQ_HEADER)
        );

    }

    @Test(testName = "Test with navbar instructors button, expected OK")
    public void verifyInstructorsButton() {
        HomePage homePage = new HomePage(driver);
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        homePage.clickOnInstructorsButton();
        assertAll(
                () -> assertTrue(instructorsSection.isOurInstructorsHeaderTextVisible()),
                () -> assertEquals(instructorsSection.getOurInstructorsHeaderText(), Constants.INSTRUCTORS_HEADER)
        );

    }

    @Test(testName = "Test with navbar instructors > questions buttons, expected OK")
    public void verifyNavbarClickCombosOne() {

        HomePage homePage = new HomePage(driver);
        FAQSection faqSection = new FAQSection(driver);
        InstructorsSection instructorsSection = new InstructorsSection(driver);

        homePage.clickOnInstructorsButton();
        assertAll(
                () -> assertTrue(instructorsSection.isOurInstructorsHeaderTextVisible()),
                () -> assertEquals(instructorsSection.getOurInstructorsHeaderText(), Constants.INSTRUCTORS_HEADER)
        );

        homePage.clickOnQuestionsButton();
        assertAll(
                () -> assertTrue(faqSection.isFrequentlyAskedQuestionsHeaderVisible()),
                () -> assertEquals(faqSection.getFrequentlyAskedQuestionsHeaderText(), Constants.FAQ_HEADER)
        );
    }

    @Test(testName = "Test with navbar questions > what you'll learn buttons, expected OK")
    public void verifyNavbarClickCombosTwo() {

        HomePage homePage = new HomePage(driver);
        FAQSection faqSection = new FAQSection(driver);
        LearnSection learnSection = new LearnSection(driver);

        homePage.clickOnQuestionsButton();
        assertAll(
                () -> assertTrue(faqSection.isFrequentlyAskedQuestionsHeaderVisible()),
                () -> assertEquals(faqSection.getFrequentlyAskedQuestionsHeaderText(), Constants.FAQ_HEADER)
        );

        homePage.clickOnWhatYouWillLearnButton();
        assertAll(
                () -> assertTrue(learnSection.isLearnTheFundamentalsHeaderTextVisible()),
                () -> assertEquals(learnSection.getLearnTheFundamentalsHeaderText(), Constants.FUNDAMENTALS_HEADER)
        );
    }

    @Test(testName = "Test with navbar what you'll learn > software testing course buttons, expected OK")
    public void verifyNavbarClickCombosThree() {

        HomePage homePage = new HomePage(driver);
        LearnSection learnSection = new LearnSection(driver);

        homePage.clickOnWhatYouWillLearnButton();
        assertAll(
                () -> assertTrue(learnSection.isLearnTheFundamentalsHeaderTextVisible()),
                () -> assertEquals(learnSection.getLearnTheFundamentalsHeaderText(), Constants.FUNDAMENTALS_HEADER)
        );

        homePage.clickOnSoftwareTestingCourseButton();
        assertAll(
                () -> assertTrue(homePage.isSoftwareTestingCourseTextVisible()),
                () -> assertEquals(homePage.getSoftwareTestingCourseText(), Constants.SOFTWARE_TESTING_COURSE)
        );
    }

    @Test(testName = "Test with navbar instructors > what you'll learn buttons, expected OK")
    public void verifyNavbarClickCombosFour() {
        /*
        1. Click Instructors
        2. Click Learn
        */

        HomePage homePage = new HomePage(driver);
        LearnSection learnSection = new LearnSection(driver);
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        homePage.clickOnInstructorsButton();
        assertAll(
                () -> assertTrue(instructorsSection.isOurInstructorsHeaderTextVisible()),
                () -> assertEquals(instructorsSection.getOurInstructorsHeaderText(), Constants.INSTRUCTORS_HEADER)
        );

        homePage.clickOnWhatYouWillLearnButton();
        assertAll(
                () -> assertTrue(learnSection.isLearnTheFundamentalsHeaderTextVisible()),
                () -> assertEquals(learnSection.getLearnTheFundamentalsHeaderText(), Constants.FUNDAMENTALS_HEADER)
        );
    }

    // NEWSLETTER TESTS

    @Test(testName = "Test with newsletter elements typos, expected OK")
    public void verifyNewsletter() {
        NewsletterSection newsletterSection = new NewsletterSection(driver);
        Assertions.assertAll(
                () -> AssertJUnit.assertEquals(newsletterSection.getNewsletterHeaderText(), Constants.NEWSLETTER_HEADER),
                () -> AssertJUnit.assertEquals(newsletterSection.getNewsletterPlaceholderText(), Constants.NEWSLETTER_PLACEHOLDER),
                () -> AssertJUnit.assertEquals(newsletterSection.getSubmitButtonText(), Constants.NEWSLETTER_SUBMIT_BUTTON)
        );
    }

    @Test(testName = "Test with newsletter email field should turn red, expected OK")
    public void clickSubmitButton() {
        NewsletterSection newsletterSection = new NewsletterSection(driver);
        newsletterSection.clickSubmitEmailButton();
        assertTrue(newsletterSection.getErrorBorder().contains(Constants.NEWSLETTER_EMAIL_ERROR_BORDER_CLASS));
    }

    @Test(testName = "Test with newsletter email input, expected OK")
    public void enterEmailAndClickSubmit() {
        NewsletterSection newsletterSection = new NewsletterSection(driver);
        newsletterSection.inputEmailForNewsletter(Constants.NEWSLETTER_POSITIVE_EMAIL_ONE);
        newsletterSection.clickSubmitEmailButton();
        assertTrue(driver.switchTo().alert().getText().contains(Constants.NEWSLETTER_ALERT_MESSAGE));
        driver.switchTo().alert().accept();
    }

    @Test(testName = "Test with newsletter random email input, expected OK")
    public void enterPseudoRandomEmailAndClickSubmit() {
        NewsletterSection newsletterSection = new NewsletterSection(driver);
        newsletterSection.inputEmailForNewsletter(Constants.NEWSLETTER_POSITIVE_EMAIL_PSEUDORANDOM);
        newsletterSection.clickSubmitEmailButton();
        assertTrue(driver.switchTo().alert().getText().contains(Constants.NEWSLETTER_ALERT_MESSAGE));
        driver.switchTo().alert().accept();
    }

    // CARD DECK TESTS

    @Test(testName = "Test with virtual page for typos, expected OK")
    public void verifyVirtualPage() {
        pageNavigation.switchMyPages(MyPages.VIRTUAL_PAGE);
        VirtualPage virtualPage = new VirtualPage(driver);
        assertAll(() -> assertEquals(virtualPage.getVirtualHeaderText(), Constants.VIRTUAL_HEADER),
                () -> assertEquals(virtualPage.getReturnToHomePageButton(), Constants.RETURN_BUTTON));
    }

    @Test(testName = "Test with virtual page returning home, expected OK")
    public void clickReturnFromVirtualPage() {
        pageNavigation.switchMyPages(MyPages.VIRTUAL_PAGE);
        new VirtualPage(driver).clickReturnToHomePageButton();
        assertEquals(new HomePage(driver).getSoftwareTestingCourseText(), Constants.SOFTWARE_TESTING_COURSE);
    }

    @Test(testName = "Test with hybrid page for typos, expected OK")
    public void verifyHybridPage() {
        pageNavigation.switchMyPages(MyPages.HYBRID_PAGE);
        HybridPage hybridPage = new HybridPage(driver);
        assertAll(() -> assertEquals(hybridPage.getHybridHeaderText(), Constants.HYBRID_HEADER),
                () -> assertEquals(hybridPage.getReturnToHomePageButton(), Constants.RETURN_BUTTON));
    }

    @Test(testName = "Test with hybrid page returning home, expected OK")
    public void clickReturnFromHybridPage() {
        pageNavigation.switchMyPages(MyPages.HYBRID_PAGE);
        new HybridPage(driver).clickReturnToHomePageButton();
        Utils.waitForElementToLoad(3);
        assertEquals(new HomePage(driver).getSoftwareTestingCourseText(), Constants.SOFTWARE_TESTING_COURSE);
    }

    @Test(testName = "Test with hybrid page for typos, expected OK")
    public void verifyInPersonPage() {
        pageNavigation.switchMyPages(MyPages.IN_PERSON_PAGE);
        InPersonPage inPersonPage = new InPersonPage(driver);
        assertAll(() -> assertEquals(inPersonPage.getInPersonHeaderText(), Constants.IN_PERSON_HEADER),
                () -> assertEquals(inPersonPage.getReturnToHomePageButton(), Constants.RETURN_BUTTON));
    }

    @Test
    public void clickReturnFromInPersonPage() {
        pageNavigation.switchMyPages(MyPages.IN_PERSON_PAGE);
        new InPersonPage(driver).clickReturnToHomePageButton();
        assertEquals(new HomePage(driver).getSoftwareTestingCourseText(), Constants.SOFTWARE_TESTING_COURSE);
    }

    // LEARN TESTS

    @Test
    public void verifyFundamentalsPage() {
        pageNavigation.switchMyPages(MyPages.FUNDAMENTALS_PAGE);
        FundamentalsPage fundamentalsPage = new FundamentalsPage(driver);
        assertAll(() -> assertEquals(fundamentalsPage.getFundamentalsHeaderText(), Constants.FUNDAMENTALS_PAGE_HEADER),
                () -> assertEquals(fundamentalsPage.getReturnToHomePageButton(), Constants.RETURN_BUTTON));
    }

    @Test
    public void clickReturnFromFundamentalsPage() {
        pageNavigation.switchMyPages(MyPages.FUNDAMENTALS_PAGE);
        new FundamentalsPage(driver).clickReturnToHomePageButton();
        assertEquals(new HomePage(driver).getSoftwareTestingCourseText(), Constants.SOFTWARE_TESTING_COURSE);
    }

    @Test
    public void verifySeleniumPage() {
        pageNavigation.switchMyPages(MyPages.SELENIUM_PAGE);
        SeleniumPage seleniumPage = new SeleniumPage(driver);
        assertAll(() -> assertEquals(seleniumPage.getSeleniumHeaderText(), Constants.SELENIUM_PAGE_HEADER),
                () -> assertEquals(seleniumPage.getReturnToHomePageButton(), Constants.RETURN_BUTTON));
    }

    @Test
    public void clickReturnFromSeleniumPage() {
        pageNavigation.switchMyPages(MyPages.SELENIUM_PAGE);
        new SeleniumPage(driver).clickReturnToHomePageButton();
        assertEquals(new HomePage(driver).getSoftwareTestingCourseText(), Constants.SOFTWARE_TESTING_COURSE);
    }

    // FAQ TESTS

    @Test
    public void expandFirstQuestionBody() {
        FAQSection faqSection = new FAQSection(driver);
        faqSection.clickFirstQuestion();
        assertTrue(faqSection.getFirstQuestionClass().contains(Constants.SHOW_QUESTION_BODY_CLASS));
    }

    @Test
    public void expandSecondQuestionBody() {
        FAQSection faqSection = new FAQSection(driver);
        faqSection.clickSecondQuestion();
        assertTrue(faqSection.getSecondQuestionClass().contains(Constants.SHOW_QUESTION_BODY_CLASS));
    }

    @Test
    public void expandThirdQuestionBody() {
        FAQSection faqSection = new FAQSection(driver);
        faqSection.clickThirdQuestion();
        assertTrue(faqSection.getThirdQuestionClass().contains(Constants.SHOW_QUESTION_BODY_CLASS));
    }

    @Test
    public void expandFourthQuestionBody() {
        FAQSection faqSection = new FAQSection(driver);
        faqSection.clickFourthQuestion();
        assertTrue(faqSection.getFourthQuestionClass().contains(Constants.SHOW_QUESTION_BODY_CLASS));
    }

    @Test
    public void expandFifthQuestionBody() {
        FAQSection faqSection = new FAQSection(driver);
        faqSection.clickFifthQuestion();
        assertTrue(faqSection.getFifthQuestionClass().contains(Constants.SHOW_QUESTION_BODY_CLASS));
    }

    @Test
    public void expandQuestionsComboFiveOne() {
        /*
        1. Question 5
        2. Question 1
         */
        FAQSection faqSection = new FAQSection(driver);
        faqSection.clickFifthQuestion();
        assertTrue(faqSection.getFifthQuestionClass().contains(Constants.SHOW_QUESTION_BODY_CLASS));

        faqSection.clickFirstQuestion();
        assertTrue(faqSection.getFirstQuestionClass().contains(Constants.SHOW_QUESTION_BODY_CLASS));
    }

    @Test
    public void expandQuestionsComboFourTwo() {
        /*
        1. Question 4
        2. Question 2
         */
        FAQSection faqSection = new FAQSection(driver);
        faqSection.clickFourthQuestion();
        assertTrue(faqSection.getFourthQuestionClass().contains(Constants.SHOW_QUESTION_BODY_CLASS));

        faqSection.clickSecondQuestion();
        assertTrue(faqSection.getSecondQuestionClass().contains(Constants.SHOW_QUESTION_BODY_CLASS));
    }

    @Test
    public void expandQuestionsComboThreeOne() {
        FAQSection faqSection = new FAQSection(driver);
        faqSection.clickThirdQuestion();
        assertTrue(faqSection.getThirdQuestionClass().contains(Constants.SHOW_QUESTION_BODY_CLASS));

        faqSection.clickFirstQuestion();
        assertTrue(faqSection.getFirstQuestionClass().contains(Constants.SHOW_QUESTION_BODY_CLASS));
    }

    // INSTRUCTORS TESTS

    @Test
    public void verifyInstructorOne() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        assertAll(() -> assertEquals(instructorsSection.getFirstInstructorHeaderText(), Constants.INSTRUCTOR_ONE_NAME),
                () -> assertTrue(instructorsSection.isFirstInstructorTwitterDisplayed()),
                () -> assertTrue(instructorsSection.isFirstInstructorFacebookDisplayed()),
                () -> assertTrue(instructorsSection.isFirstInstructorLinkedInDisplayed()),
                () -> assertTrue(instructorsSection.isFirstInstructorInstagramDisplayed()));
    }

    @Test
    public void verifyInstructorTwo() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        assertAll(() -> assertEquals(instructorsSection.getSecondInstructorHeaderText(), Constants.INSTRUCTOR_TWO_NAME),
                () -> assertTrue(instructorsSection.isSecondInstructorTwitterDisplayed()),
                () -> assertTrue(instructorsSection.isSecondInstructorFacebookDisplayed()),
                () -> assertTrue(instructorsSection.isSecondInstructorLinkedInDisplayed()),
                () -> assertTrue(instructorsSection.isSecondInstructorInstagramDisplayed()));
    }

    @Test
    public void verifyInstructorThree() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        assertAll(() -> assertEquals(instructorsSection.getThirdInstructorHeaderText(), Constants.INSTRUCTOR_THREE_NAME),
                () -> assertTrue(instructorsSection.isThirdInstructorTwitterDisplayed()),
                () -> assertTrue(instructorsSection.isThirdInstructorFacebookDisplayed()),
                () -> assertTrue(instructorsSection.isThirdInstructorLinkedInDisplayed()),
                () -> assertTrue(instructorsSection.isThirdInstructorInstagramDisplayed()));
    }

    @Test
    public void verifyInstructorFour() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        assertAll(() -> assertEquals(instructorsSection.getFourthInstructorHeaderText(), Constants.INSTRUCTOR_FOUR_NAME),
                () -> assertTrue(instructorsSection.isFourthInstructorTwitterDisplayed()),
                () -> assertTrue(instructorsSection.isFourthInstructorFacebookDisplayed()),
                () -> assertTrue(instructorsSection.isFourthInstructorLinkedInDisplayed()),
                () -> assertTrue(instructorsSection.isFourthInstructorInstagramDisplayed()));
    }

    @Test
    public void clickInstructorOneTwitter() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnFirstInstructorTwitter();
        assertEquals(driver.getCurrentUrl(), Constants.TWITTER_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorOneFacebook() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnFirstInstructorFacebook();
        assertEquals(driver.getCurrentUrl(), Constants.FACEBOOK_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorOneLinkedIn() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnFirstInstructorLinkedIn();
        assertEquals(driver.getCurrentUrl(), Constants.LINKED_IN_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorOneInstagram() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnFirstInstructorInstagram();
        assertEquals(driver.getCurrentUrl(), Constants.INSTAGRAM_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorTwoTwitter() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnSecondInstructorTwitter();
        assertEquals(driver.getCurrentUrl(), Constants.TWITTER_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorTwoFacebook() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnSecondInstructorFacebook();
        assertEquals(driver.getCurrentUrl(), Constants.FACEBOOK_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorTwoLinkedIn() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnSecondInstructorLinkedIn();
        assertEquals(driver.getCurrentUrl(), Constants.LINKED_IN_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorTwoInstagram() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnSecondInstructorInstagram();
        assertEquals(driver.getCurrentUrl(), Constants.INSTAGRAM_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorThreeTwitter() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnThirdInstructorTwitter();
        assertEquals(driver.getCurrentUrl(), Constants.TWITTER_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorThreeFacebook() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnThirdInstructorFacebook();
        assertEquals(driver.getCurrentUrl(), Constants.FACEBOOK_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorThreeLinkedIn() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnThirdInstructorLinkedIn();
        assertEquals(driver.getCurrentUrl(), Constants.LINKED_IN_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorThreeInstagram() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnThirdInstructorInstagram();
        assertEquals(driver.getCurrentUrl(), Constants.INSTAGRAM_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorFourTwitter() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnFourthInstructorTwitter();
        assertEquals(driver.getCurrentUrl(), Constants.TWITTER_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorFourFacebook() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnFourthInstructorFacebook();
        assertEquals(driver.getCurrentUrl(), Constants.FACEBOOK_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorFourLinkedIn() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnFourthInstructorLinkedIn();
        assertEquals(driver.getCurrentUrl(), Constants.LINKED_IN_URL);
        driver.navigate().back();
    }

    @Test
    public void clickInstructorFourInstagram() {
        InstructorsSection instructorsSection = new InstructorsSection(driver);
        instructorsSection.clickOnFourthInstructorInstagram();
        assertEquals(driver.getCurrentUrl(), Constants.INSTAGRAM_URL);
        driver.navigate().back();
    }

    // CONTACT INFO TESTS

    @Test
    public void verifyContactInfo() {
        FooterSection footerSection = new FooterSection(driver);
        assertAll(() -> assertEquals(footerSection.getMainLocationText(), Constants.MAIN_LOCATION_ADDRESS),
                () -> assertEquals(footerSection.getEnrollmentPhoneText(), Constants.ENROLLMENT_PHONE_NUMBER),
                () -> assertEquals(footerSection.getStudentPhoneText(), Constants.STUDENT_PHONE_NUMBER),
                () -> assertEquals(footerSection.getEnrollmentEmailText(), Constants.ENROLLMENT_EMAIL),
                () -> assertEquals(footerSection.getStudentEmailText(), Constants.STUDENT_EMAIL));
    }

    @Test
    public void verifyFooterText() {
        assertEquals(new FooterSection(driver).getCopyrightText(), Constants.COPYRIGHT_TEXT);
    }

    @Test
    public void clickBackToTopButton() {
        new FooterSection(driver).clickOnBackToTopButton();
        assertEquals(new HomePage(driver).getCertifiedSoftwareTesterSpanText(), Constants.CERTIFIED_SOFTWARE_TESTER);
    }

    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

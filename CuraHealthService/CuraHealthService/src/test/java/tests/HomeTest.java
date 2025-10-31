package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {

    @Test
    public void testPage() {
        HomePage page = new HomePage(driver, wait);
        page.selectFacility();
        page.checkBox();
        page.calendar();
        page.comment();
        page.setAppointmentBtn();
        page.setHomePage();
        page.setMenuBar();
        page.setHistoryTab();
        page.setHomePage();

    }
}

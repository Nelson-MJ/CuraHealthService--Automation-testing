package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HamburgerMenuPage;

public class HamburgerMenuTest extends BaseTest {

    @Test
    public void testMenu(){
        HamburgerMenuPage menu = new HamburgerMenuPage(driver,wait);
        menu.setMenuBar();
        menu.setHome();
        menu.setMenuBar();
        menu.setHistoryTab();
        menu.setMenuBar();
        menu.setProfile();
    }
}

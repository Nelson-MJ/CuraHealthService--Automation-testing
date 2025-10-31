package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HamburgerMenuPage {
    WebDriver driver;
    WebDriverWait wait;

    By menuBar = By.id("menu-toggle");
    By home = By.xpath("//a[text()='Home']");
    By historyTab = By.xpath("//a[text() = 'History']");
    By profile = By.xpath("//a[text()='Profile']");

    public HamburgerMenuPage(WebDriver driver,WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void setMenuBar(){
        WebElement MenuBar = driver.findElement(menuBar);
        MenuBar.click();
    }

    public void setHome(){
        WebElement homeMenu = driver.findElement(home);
        homeMenu.click();
    }

    public void setHistoryTab(){
        WebElement history = driver.findElement(historyTab);
        history.click();
    }

    public void setProfile(){
        WebElement profileMenu = driver.findElement(profile);
        profileMenu.click();
    }






}

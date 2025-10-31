package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By makeAppointment = By.id("btn-make-appointment");
    By username = By.id("txt-username");
    By password = By.id("txt-password");
    By loginClick = By.id("btn-login");
    By menuBar = By.id("menu-toggle");
    By logoutClick = By.xpath("//a[text()= 'Logout']");



    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;

    }
    public void openUrl(){
        driver.get(ConfigReader.get("baseUrl"));
        driver.findElement(makeAppointment).click();
    }

    public  void  loginCredentials(){
        WebElement userName = driver.findElement(username);
        userName.sendKeys(ConfigReader.get("email"));

        WebElement passWord = driver.findElement(password);
        passWord.sendKeys(ConfigReader.get("password"));

        driver.findElement(loginClick).click();
    }

    public void logout(){
        WebElement MenuBar = driver.findElement(menuBar);
        MenuBar.click();

        WebElement Logout = driver.findElement(logoutClick);
        Logout.click();
    }




}

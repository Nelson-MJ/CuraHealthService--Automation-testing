package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By facility = By.id("combo_facility");
    By checkBox = By.id("chk_hospotal_readmission");
    By programRadio = By.id("radio_program_medicaid");
    By calendar = By.id("txt_visit_date");
    By comment = By.id("txt_comment");
    By appointmentBtn = By.id("btn-book-appointment");
    By homePage = By.xpath("//a[text()='Go to Homepage']");
    By historyTab = By.xpath("//a[text() = 'History']");
    By menuBar = By.id("menu-toggle");

    public HomePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public void selectFacility(){
        WebElement dropDown = driver.findElement(facility);
        Select select = new Select(dropDown);
        select.selectByVisibleText("Hongkong CURA Healthcare Center");
    }

    public void checkBox(){
        WebElement checkBoxClick = driver.findElement(checkBox);
        checkBoxClick.click();
    }

    public void radioBtn(){
        WebElement program = driver.findElement(programRadio);
        program.click();
    }

    public void calendar(){
        WebElement Calendar = driver.findElement(calendar);
        Calendar.sendKeys("15/05/2024");
    }

    public void comment(){
        WebElement Comment = driver.findElement(comment);
        Comment.sendKeys("This is a comment :-)");
    }

    public void setAppointmentBtn(){
        WebElement bookAppointment = driver.findElement(appointmentBtn);
        bookAppointment.click();
    }

    public void setHomePage(){
        WebElement homePageBtn = driver.findElement(homePage);
        homePageBtn.click();
    }

    public void setHistoryTab(){
        WebElement history = driver.findElement(historyTab);
        history.click();
    }

    public void setMenuBar(){
        WebElement MenuBar = driver.findElement(menuBar);
        MenuBar.click();
    }

}

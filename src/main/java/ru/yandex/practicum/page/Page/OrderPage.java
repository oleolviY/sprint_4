package ru.yandex.practicum.page.Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private final WebDriver webDriver;
    private final By firstNameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInputLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By subwayInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextBtnLocator = By.xpath("//button[text()='Далее']");
    private final By dateInputLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By periodInputLocator = By.xpath("//div[text()='* Срок аренды']");
    private final By periodItemLocator = By.xpath("//div[text()='сутки']");
    private final By colorCheckBoxLocator = By.id("grey");
    private final By commentInputLocator = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By orderBtnLocator = By.xpath("//div[contains(@class, 'Order')]/button[text()='Заказать']");
    private final By confirmBtnLocator = By.xpath("//button[text()='Да']");
    private final By orderSuccessLocator = By.xpath("//div[text()='Заказ оформлен']");

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillCustomerInfo(String firstName, String lastName, String address, String subway, String phone) {
        WebElement firstNameInput = webDriver.findElement(firstNameInputLocator);
        firstNameInput.sendKeys(firstName);
        WebElement lastNameInput = webDriver.findElement(lastNameInputLocator);
        lastNameInput.sendKeys(lastName);
        WebElement addressInput = webDriver.findElement(addressInputLocator);
        addressInput.sendKeys(address);
        WebElement subwayInput = webDriver.findElement(subwayInputLocator);
        subwayInput.click();
        WebElement subwayStation = webDriver.findElement(By.xpath(String.format("//div[text()='%s']", subway)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", subwayStation);
        subwayStation.click();
        WebElement phoneInput = webDriver.findElement(phoneInputLocator);
        phoneInput.sendKeys(phone);
        WebElement nextBtn = webDriver.findElement(nextBtnLocator);
        nextBtn.click();
    }
    public void fillRentalInfo(String date, String comment) {
        WebElement dateInput = webDriver.findElement(dateInputLocator);
        dateInput.sendKeys(date, Keys.ENTER);
        WebElement periodInput = webDriver.findElement(periodInputLocator);
        periodInput.click();
        WebElement periodItem = webDriver.findElement(periodItemLocator);
        periodItem.click();
        WebElement colorCheckBox = webDriver.findElement(colorCheckBoxLocator);
        colorCheckBox.click();
        WebElement commentInput = webDriver.findElement(commentInputLocator);
        commentInput.sendKeys(comment);
        WebElement orderBtn = webDriver.findElement(orderBtnLocator);
        orderBtn.click();
    }
    public void confirm(){
        WebElement confirmBtn = webDriver.findElement(confirmBtnLocator);
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(confirmBtnLocator));
        confirmBtn.click();
    }
    public boolean orderIsSuccess(){
        WebElement element =  webDriver.findElement(orderSuccessLocator);
        return  element.isDisplayed();
    }
}
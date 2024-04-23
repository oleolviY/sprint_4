package ru.yandex.practicum.page.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver webDriver;
    private final By createOrderHeaderBtn = By.xpath("//div[contains(@class, 'Header')]/button[text()='Заказать']");
    private final By createOrderMiddleBtn = By.xpath("//button[contains(@class, 'Middle') and text()='Заказать']");
    private final String questionLocator = "accordion__heading-%s";
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";
    private final By cookiesBtn = By.id("rcc-confirm-button");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void closeCookiesWindow() {
        webDriver.findElement(cookiesBtn).click();
    }

    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement(By.id(String.format(questionLocator, index)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public boolean answerIsDisplayed(String expectedAnswer) {
        WebElement element = webDriver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return element.isDisplayed();
    }

    public void createOrderBtnClick(String button) {
        if (button == "Header") {
            webDriver.findElement(createOrderHeaderBtn).click();
        } else {
            webDriver.findElement(createOrderMiddleBtn).click();
        }
    }

}
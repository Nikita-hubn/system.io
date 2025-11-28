package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FirstPage {
    protected WebDriver driver;
    private By submitButton = By.xpath("//button[.//div[contains(text(), 'I want to receive my copy')]]");
    private By closeButton = By.xpath("//button[@data-testid='popup-close-icon']");
    private By erorText = By.xpath("//p[text()='Please enter a valid email address']");
    private By frame = By.xpath("//iframe[contains(@src, 'systeme.io/public')]");



    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public void submitEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState").equals("complete"));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(frame));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        WebElement receiveButton = wait.until(d -> {
            WebElement button = d.findElement(submitButton);
            return button.isDisplayed() && button.isEnabled() ? button : null;
        });
        receiveButton.click();
    }


    public String checkMessage() {
        String s = "not found";
        if (driver.findElement(closeButton).isDisplayed()) {
            return driver.findElement(erorText).getText();
        } else {
            return s;
        }
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
        driver.switchTo().defaultContent();
    }
}

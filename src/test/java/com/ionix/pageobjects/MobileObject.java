package com.ionix.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MobileObject {

    protected Actions action;

    private final int WAIT_TIMEOUT = 10;

    protected AppiumDriver driver;
    protected TouchAction touchAction;
    private WebDriverWait wait;

    public MobileObject(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        touchAction = new TouchAction((PerformsTouchActions) driver);
        action = new Actions(driver);
    }
    protected void waitFor(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean isChecked(WebElement element) throws IOException {
        List<Integer> color = getColor(element);
        if (color.get(0) == 255) {
            return false;
        }
        return true;
    }

    public List<Integer> getColor(WebElement element) throws IOException {
        Rectangle point = element.getRect();
        int centerx = point.getX();
        int centerY = point.getY();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage image = ImageIO.read(scrFile);
        // Getting pixel color by position x and y
        int clr = image.getRGB(centerx + 35, centerY + 35 + 10);
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;
        //System.out.println("Red Color value = " + red);
        //System.out.println("Green Color value = " + green);
        //System.out.println("Blue Color value = " + blue);
        return Arrays.asList(red, green, blue);
    }

    protected boolean waitElementIsVisible(WebElement element, int time) {
        boolean value = false;
        for (int i = 0; i <= time; i++) {
            try {
                Thread.sleep(1000);
                value = element.isDisplayed();
                break;
            } catch (Exception e) {
                System.out.print(e.toString());
            }
        }
        return value;
    }

    public void screenShot(String fileName) throws IOException {
        String Base_Path = System.getProperty("user.dir");
        Base_Path = Base_Path + "/src/main/screenshot/";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(Base_Path  + "Evidencia_" + fileName + ".jpg"));
    }


    public byte[] screenShot01() throws IOException {
        String Base_Path = System.getProperty("user.dir");
        Base_Path = Base_Path + "/src/main/screenshot/";
        byte[] scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        //FileUtils.copyFile(scrFile, new File(Base_Path + getDay(0) + "_Evidencia_" + fileName + ".jpg"));
        return scrFile;
    }

}

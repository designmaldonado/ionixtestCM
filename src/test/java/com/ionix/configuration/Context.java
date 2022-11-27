package com.ionix.configuration;

import com.ionix.utils.PropertyLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.io.File;

@Configuration
public class Context {

    public static AppiumDriverLocalService service;
    public static AndroidDriver<WebElement> driver;

    @Bean(name = "ionixDriver", destroyMethod = "quit")
    @Lazy(true)
    public AppiumDriver ionixDriver() throws Exception {
        // Carga del fichero de propiedades
        PropertyLoader loadproperty = new PropertyLoader();

        // Recuperación del fichero de propiedades de la ruta y nombre de la aplicación móvil
        String appiumON = System.getProperty("appiumON");
        String device = System.getProperty("device");
        String MainActivity = System.getProperty("MainActivity");

        // Generación de las capabilites a nivel del servicio de Appium
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 2000);


        // Generación de las capabilites a nivel de driver
        DesiredCapabilities clientCapabilities = new DesiredCapabilities();
        clientCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        clientCapabilities.setCapability(MobileCapabilityType.UDID, device);
        clientCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 API 27");

        clientCapabilities.setCapability("appActivity", "MainActivity");
        clientCapabilities.setCapability("autoLaunch", false);
        //clientCapabilities.setCapability("appPackage","com.ionix");
        clientCapabilities.setCapability("automationName", "UiAutomator2");


        //Conexion para pruebas locales
        File app = new File(loadproperty.loadProperties().getProperty("apkDir"), loadproperty.loadProperties().getProperty("apkName"));
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        // Appium service
        AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(desiredCapabilities)
                .withIPAddress(loadproperty.loadProperties().getProperty("AppiumServerIP"))
                .usingAnyFreePort();
        service = builder.build();
        service.start();
        driver = new AndroidDriver(service.getUrl(), clientCapabilities);


        return driver;
    }

}

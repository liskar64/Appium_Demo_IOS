package cucumberJava; /**
 * Created by Ibermatica on 05/05/2017.
 */

import cucumber.annotation.es.Cuando;
import cucumber.annotation.es.Dado;
import cucumber.annotation.es.Entonces;
import cucumber.annotation.es.Y;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class cucumberJava {

    //private AppiumDriver<WebElement> driver;

    private WebDriver driver;

    //private java.util.List<Integer> values;

    //public WebDriverWait wait ;

   // AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
    String size;


    @Dado("que me conecte a la aplicacion$")

    public void openDevices(){


     //   appiumService = AppiumDriverLocalService.buildDefaultService();
     //   appiumService.start();
     //   appiumServiceUrl = appiumService.getUrl().toString();
     //   System.out.println("Appium Service Address : - "+ appiumServiceUrl);


        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("deviceName","IPad Air2");
        capabilities.setCapability("deviceName","iPhone 6s");
        //capabilities.setCapability("udid","07436359a6f86dce57b77a0b941b92d6975e3480");
        capabilities.setCapability("udid","8b56547b24cc5a94c9d74b4c4ceaf4c3a24da2fa");

        //desiredCapabilities.setCapability("udid","2E611BE3-7495-4BFE-A288-EB24BFC828CC");
        //capabilities.setCapability("autoWebview", "true");

        //capabilities.setCapability("platformVersion","10.2.1");
        capabilities.setCapability("platformVersion","11.2.6");
        //capabilities.setCapability("appiumVersion","v1.6.0");
        capabilities.setCapability("platformName","iOS");
        //desiredCapabilities.setCapability("orientation","LANDSCAPE");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("xcodeOrgId","DXKN9UUK5Q");
        capabilities.setCapability("xcodeSigningId","iPhone Developer");
        //desiredCapabilities.setCapability("automationName","UIautomation");
        //requiredcapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.iOS);
        //requiredcapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Innpad Air2 Device");
        //capabilities.setCapability("app","/Users/appium/Documents/AppiumDemo.ipa");
        capabilities.setCapability("app","/opt/AppiumDemoViper.ipa");
        capabilities.setCapability("appPackage", "com.ibermatica.appiumdemoviper");
        capabilities.setCapability("appActivity", "com.ibermatica.appiumdemoviper.MainActivity");
        //capabilities.setCapability("realDeviceLogger","/usr/local/lib/node_modules/deviceconsole/deviceconsole");

        try{

          //  driver = new IOSDriver(new URL(appiumServiceUrl), capabilities);

            driver = new IOSDriver<WebElement>(new URL("http://172.17.0.3:4723/wd/hub"),capabilities);


          driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

      //  wait=new WebDriverWait(driver,60);
    };




    @Cuando("^introduzco el Usuario \"([^\"]*)\" y la Contrasena \"([^\"]*)\"$")
    public void I_enter_Usuario_as_and_Contrasena_as(String arg1, String arg2) throws AWTException {

        System.out.println("===================");
        System.out.println("Usuario = " + arg1);
        System.out.println("Pass    = " + arg2);
        System.out.println("===================");

/*
        WebElement elemento = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]"));
        System.out.println("Elemento = " + elemento);

        WebElement elemento2 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]"));
        System.out.println("Elemento2 = " + elemento2);


        int contador=0;

        List<WebElement> elems = driver.findElements(By.className("UIATextField"));

        //elems.get(0).sendKeys(arg1);
        //elems.get(1).sendKeys(arg2);


        for (WebElement elem : elems) {
            contador++;
            System.out.println("Contador = " + contador);
            System.out.println("Elem = " + elem);


            if(contador==1)
                elem.sendKeys(arg1);
            else
                elem.sendKeys(arg2);
        }
*/
        driver.findElement(By.id("user")).sendKeys(arg1);

        driver.findElement(By.id("pass")).sendKeys(arg2);

        driver.findElement(By.id("btnLogin")).click();

 //       WebElement button = driver.findElement(By.className("UIAButton"));
 //       button.click();

    }




    @Entonces("saldra mensaje de error y no entraremos en la aplicacion$")
    public void login_no_ok() {


        Assert.assertTrue(isElementPresent(By.id("alertMessage")));


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        //driver.quit();



        System.out.println("Stop driver");
        System.out.println("Compruebo que cambio de version en GitHub3");
        driver.quit();
        System.out.println("Stop appium service");
     //   appiumService.stop();




    }

    @Entonces("entraremos en la aplicacion$")
    public void login_ok() {


        Assert.assertFalse(isElementPresent(By.id("alertMessage")));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        //driver.quit();



        System.out.println("Stop driver");
        driver.quit();
        System.out.println("Stop appium service");
     //   appiumService.stop();

    }


    @Y("^pulso en cuenta$")

    public void pulso_cuenta(){

        //Dimension size = driver.findElement(By.id("lblListHeader")).getSize();
        //System.out.println("================");
        //System.out.println("Size = " + size);
        //System.out.println("================");

        //driver.findElement(By.id("lblListHeader")).click();
        //String text = driver.findElement(By.id("lblListHeader")).getText();
        //System.out.println("Text = " + text);

        int contador=0;

        List<WebElement> elems = driver.findElements(By.id("lblListHeader"));

        elems.get(0).click();
        //elems.get(1).sendKeys(arg2);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

    }

    @Y("^pulso en tarjetas$")

    public void pulso_tarjetas(){

        //Dimension size = driver.findElement(By.id("lblListHeader")).getSize();
        //System.out.println("================");
        //System.out.println("Size = " + size);
        //System.out.println("================");

        //driver.findElement(By.id("lblListHeader")).click();
        //String text = driver.findElement(By.id("lblListHeader")).getText();
        //System.out.println("Text = " + text);

        int contador=0;

        List<WebElement> elems = driver.findElements(By.id("lblListHeader"));

        elems.get(1).click();
        //elems.get(1).sendKeys(arg2);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

    }


    @Y("^pulso en prestamos$")

    public void pulso_prestamos(){

        //Dimension size = driver.findElement(By.id("lblListHeader")).getSize();
        //System.out.println("================");
        //System.out.println("Size = " + size);
        //System.out.println("================");

        //driver.findElement(By.id("lblListHeader")).click();
        //String text = driver.findElement(By.id("lblListHeader")).getText();
        //System.out.println("Text = " + text);

        int contador=0;

        List<WebElement> elems = driver.findElements(By.id("lblListHeader"));

        elems.get(2).click();
        //elems.get(1).sendKeys(arg2);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

    }


    @Entonces("veremos el saldo de la cuenta$")
    public void consulta_saldo_cuenta() {

        Assert.assertTrue(isElementPresent(By.id("lblListItem")));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        //driver.quit();



        System.out.println("Stop driver");
        driver.quit();
        System.out.println("Stop appium service");
     //   appiumService.stop();
    }


    @Entonces("veremos el saldo de la tarjeta")
    public void consulta_saldo_tarjeta() {

        Assert.assertTrue(isElementPresent(By.id("lblListItem")));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        //driver.quit();



        System.out.println("Stop driver");
        driver.quit();
        System.out.println("Stop appium service");
    //    appiumService.stop();


    }

    @Entonces("veremos el saldo de los prestamos")
    public void consulta_saldo_prestamos() {

        Assert.assertTrue(isElementPresent(By.id("lblListItem")));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        //driver.quit();



        System.out.println("Stop driver");
        driver.quit();
        System.out.println("Stop appium service");
   //     appiumService.stop();


    }

    public boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }


}

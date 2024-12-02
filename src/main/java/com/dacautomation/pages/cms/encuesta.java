package com.dacautomation.pages.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;

public class encuesta extends cms_base {

    public encuesta(WebDriver _driver) {
        super(_driver);
    }

    public void createSurvey(WebDriver driver, String nombreEncuesta, String opcion1, String opcion2, String opcion3, String test)
            throws IOException {
        try {
            click(driver, btnEncuesta,"CLICK BTN ENCUESTA",test);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            click(driver, btnNuevo,"CLICK BTN NUEVO",test);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(3000);
            sendKeys(driver, tituloAdjunto, nombreEncuesta,"INPUT TITULO ENCUESTA",test);
            sendKeys(driver, inputOpcionesEncuesta, opcion1,"INPUT OPCION 1 ENCUESTA",test);
            driver.findElement(inputOpcionesEncuesta).sendKeys(Keys.ENTER);
            optionEncuesta = By.xpath("//span[text()='" + opcion1 + "']");
            visibilityOf(driver, optionEncuesta,test);
            sendKeys(driver, inputOpcionesEncuesta, opcion2,"INPUT OPCION 2 ENCUESTA",test);
            driver.findElement(inputOpcionesEncuesta).sendKeys(Keys.ENTER);
            optionEncuesta = By.xpath("//span[text()='" + opcion2 + "']");
            sendKeys(driver, inputOpcionesEncuesta, opcion3,"INPUT OPCION 3 ENCUESTA",test);
            driver.findElement(inputOpcionesEncuesta).sendKeys(Keys.ENTER);
            optionEncuesta = By.xpath("//span[text()='" + opcion3 + "']");
            clickJS(driver, btnGrabar,"CLICK BTN GRABAR",test);
            Thread.sleep(3000);
            driver.close();
            driver.switchTo().window(tabs.get(1));
            headerObjeto = setHeaderNote(nombreEncuesta);
            sendKeys(driver, inputFiltrar, nombreEncuesta,"INPUT NOMBRE ENCUESTA",test);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            visibilityOf(driver, headerObjeto,test);
            driver.close();
            driver.switchTo().window(tabs.get(0));
            SELECTCOLOR(test,"[OK]: CREAR ENCUESTA");

        } catch (Exception e) {
            errorColor(driver, "NO SE PUDO CREAR LA ENCUESTA" ,e,test);
        }

    }

    public void deleteSurvey(WebDriver driver, String nombreEncuesta,String url, String test) throws IOException {
        try {

            click(driver, btnEncuesta,"CLICK BTN ENCUESTA",test);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sendKeys(driver, inputFiltrar, nombreEncuesta,"",test);
            setHeaderNote(nombreEncuesta);
            click(driver, headerObjeto,"CLICK HEADER OBJETO",test);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(5000);
            clickJS(driver, btnInfo,"CLICK BTN INFO",test);
            clickJS(driver, btnEliminar,"CLICK BTN ELIMINAR",test);
            clickJS(driver, btnSi,"CLICK BTN SI",test);
            driver.switchTo().window(tabs.get(1));
            sendKeys(driver, inputFiltrar, nombreEncuesta,"INPUT FILTRAR",test);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            visibilityOf(driver, lblNotFound,test);
            driver.close();
            driver.switchTo().window(tabs.get(0));
            SELECTCOLOR(test,"[OK]: BORRAR ENCUESTA");

        } catch (Exception e) {
            errorColor(driver, "NO SE PUDO  BORRAR LA ENCUESTA", e,test);
        }
    }

}

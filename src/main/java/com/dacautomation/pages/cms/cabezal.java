package com.dacautomation.pages.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;

public class cabezal extends cms_base{

    public cabezal(WebDriver _driver) {
        super(_driver);
    }

    public void createHeader(WebDriver driver, String nombreCabezal, String contenido, String url, String archivo,
                             String caracteristicas,String idImagen, String test) throws IOException {
        By inputCuerpoNota = By.xpath("//*[@id='mce_0']/p");

        try {
            click(driver, dropdownHomePortal,"CLICK DROPDOWN HOMEPORTAL",test);
            clickJS(driver, btnCabezales,"CLICK BTN CABEZALES",test);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            click(driver, btnNuevo,"CLICK BTN NUEVO",test);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(3000);
            sendKeys(driver, tituloAdjunto, nombreCabezal,"TITULO ADJUNTO",test);
            driver.switchTo().frame("texto1iframe");
            sendKeys(driver, inputCuerpoNota, contenido,"INPUT CUERPO CABEZAL",test);
            driver.switchTo().parentFrame();
            sendKeys(driver, inputUrlCabezal, url,"INPUT URL CABEZAL",test);
            sendKeys(driver, inputNombreAdjuntoBanner, archivo,"",test);
            Thread.sleep(2000);
            WebElement wElement = driver.findElement(By.xpath("(//input[starts-with(@onclick,'FilesList')])[1]"));
            idImagen = wElement.getAttribute("value");
            checkboxAdjunto = By.xpath("//*[@id='FileList_" + idImagen + "_item']/figure/div/label/input");
            Thread.sleep(2000);
            clickJS(driver, checkboxAdjunto,"CLICK CHECKBOX",test);
            Thread.sleep(2000);
            clickJS(driver, btnRelacionarNota,"CLICK BTN RELACIONAR",test);
            Thread.sleep(2000);
            sendKeys(driver, inputCaracteristicasCabezal, caracteristicas,"",test);
            optionCaracteristicasCabezal = By.xpath("//li//span[text()='" + caracteristicas + "']");
            visibilityOf(driver, optionCaracteristicasCabezal,test);
            clickJS(driver, optionCaracteristicasCabezal,"CLICK",test);
            chipCaracteristicaCabezal = By.xpath("//div[@class='chip__body']//span[text()='" + caracteristicas + "']");
            visibilityOf(driver, chipCaracteristicaCabezal,test);
            clickJS(driver, btnGrabar,"CLICK",test);
            presenceOf(driver, toastGuardado,test);
            driver.navigate().refresh();
            Thread.sleep(3000);
            // VERIFICAR
            chipCaracteristicaCabezal = By.xpath("//span[text()=' " + caracteristicas + " ']");
            checkValueElement(driver, tituloAdjunto, nombreCabezal,test);
            inputCuerpoNota = By.xpath("//*[@id='mce_0']//p[text()='" + contenido + "']");
            driver.switchTo().frame("texto1iframe");
            esClickeable(driver, inputCuerpoNota,test);
            driver.switchTo().parentFrame();
            checkValueElement(driver, inputUrlCabezal, url,test);
            visibilityOf(driver, selectedArchivo,test);
            visibilityOf(driver, chipCaracteristicaCabezal,test);
            driver.close();
            driver.switchTo().window(tabs.get(1));
            sendKeys(driver, inputFiltrar, nombreCabezal,"",test);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            headerObjeto = setHeaderNote(nombreCabezal);
            visibilityOf(driver, headerObjeto,test);
            driver.close();
            driver.switchTo().window(tabs.get(0));
            SELECTCOLOR(test,"[OK]: CREAR CABEZAL");
        } catch (Exception e) {
            errorColor(driver, "NO SE PUDO CREAR EL CABEZAL", e,test);
        }

    }

    public void deleteHeader(WebDriver driver, String nombreCabezal, String url, String test) throws IOException {
        try {

            click(driver, dropdownHomePortal,"CLICK DROPDOWN HOME PORTAL",test);
            click(driver, btnCabezales,"CLICK BTN CABEZALES",test);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sendKeys(driver, inputFiltrar, nombreCabezal,"INPUT FILTRAR",test);
            setHeaderNote(nombreCabezal);
            click(driver, headerObjeto,"CLICK HEADER OBJETO",test);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(5000);
            clickJS(driver, btnInfo,"CLICK BTN INFO",test);
            clickJS(driver, btnEliminar,"CLICK BTN ELIMINAR",test);
            clickJS(driver, btnSi,"CLICK BTN SI",test);
            driver.switchTo().window(tabs.get(1));
            sendKeys(driver, inputFiltrar, nombreCabezal,"INPUT FILTRAR",test);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            visibilityOf(driver, lblNotFound,test);
            driver.close();
            driver.switchTo().window(tabs.get(0));
            SELECTCOLOR(test,"[OK]: BORRAR CABEZAL");

        } catch (Exception e) {
            errorColor(driver, "NO SE PUDO BORRAR EL CABEZAL ", e,test);
        }
    }
}

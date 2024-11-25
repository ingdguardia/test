package com.dacautomation.pages.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;

public class cabezal {

    public void createHeader(WebDriver driver, String nombreCabezal, String contenido, String url, String archivo,
                             String caracteristicas) throws IOException {

        try {
            System.out.println("##############CREAR CABEZAL##############");
            click(driver, dropdownHomePortal);
            clickJS(driver, btnCabezales);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            click(driver, btnNuevo);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(3000);
            sendKeys(driver, tituloAdjunto, nombreCabezal);
            driver.switchTo().frame("texto1iframe");
            sendKeys(driver, inputCuerpoNota, contenido);
            driver.switchTo().parentFrame();
            sendKeys(driver, inputUrlCabezal, url);
            sendKeys(driver, inputNombreAdjuntoBanner, archivo);
            Thread.sleep(2000);
            WebElement wElement = driver.findElement(By.xpath("(//input[starts-with(@onclick,'FilesList')])[1]"));
            idImagen = wElement.getAttribute("value");
            System.out.println("VALOR: " + idImagen);
            checkboxAdjunto = By.xpath("//*[@id='FileList_" + idImagen + "_item']/figure/div/label/input");
            Thread.sleep(2000);
            clickJS(driver, checkboxAdjunto);
            Thread.sleep(2000);
            clickJS(driver, btnRelacionarNota);
            Thread.sleep(2000);
            sendKeys(driver, inputCaracteristicasCabezal, caracteristicas);
            optionCaracteristicasCabezal = By.xpath("//li//span[text()='" + caracteristicas + "']");
            visibiltyOf(driver, optionCaracteristicasCabezal);
            clickJS(driver, optionCaracteristicasCabezal);
            chipCaracteristicaCabezal = By
                    .xpath("//div[@class='chip__body']//span[text()='" + caracteristicas + "']");
            visibiltyOf(driver, chipCaracteristicaCabezal);
            clickJS(driver, btnGrabar);
            presenceOf(driver, alertGuardado);
            driver.navigate().refresh();
            Thread.sleep(3000);
            // VERIFICAR
            chipCaracteristicaCabezal = By
                    .xpath("//span[text()=' " + caracteristicas + " ']");
            checkValueElement(driver, tituloAdjunto, nombreCabezal);
            inputCuerpoNota = By.xpath("//*[@id='mce_0']//p[text()='" + contenido + "']");
            driver.switchTo().frame("texto1iframe");
            elementIsClickable(driver, inputCuerpoNota);
            driver.switchTo().parentFrame();
            checkValueElement(driver, inputUrlCabezal, url);
            visibiltyOf(driver, selectedArchivo);
            visibiltyOf(driver, chipCaracteristicaCabezal);
            driver.close();
            driver.switchTo().window(tabs.get(1));
            sendKeys(driver, inputFiltrar, nombreCabezal);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            headerObjeto = setHeaderNote(nombreCabezal);
            visibiltyOf(driver, headerObjeto);
            driver.close();
            driver.switchTo().window(tabs.get(0));
            System.out.println("##############CREAR CABEZAL OK##############");
        } catch (Exception e) {
            errorColor(driver, "##############NO SE PUDO CREAR EL CABEZAL: " + nombreCabezal + " ERROR: " + e, e);
            screenshot(driver, "ERROR CREAR " + nombreCabezal);

        }

    }

    public void deleteHeader(WebDriver driver, String nombreCabezal) throws IOException {
        try {
            System.out.println("##############BORRANDO CABEZAL##############");
            System.out.println(driver.getCurrentUrl());
            Thread.sleep(5000);
            if (driver.getCurrentUrl().equals(url + "administrator/cabezales")) {
                System.out.println(url + "administrator/cabezales");
                System.out.println("##############SECCION CABEZAL OK##############");
                sendKeys(driver, inputFiltrar, nombreCabezal);
                driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            } else {
                System.out.println("##############CLICK SECCION CABEZAL##############");
                click(driver, dropdownHomePortal);
                click(driver, btnCabezales);
                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                sendKeys(driver, inputFiltrar, nombreCabezal);
                driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            }
            setHeaderNote(nombreCabezal);
            click(driver, headerObjeto);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(5000);
            clickJS(driver, btnInfo);
            clickJS(driver, btnEliminar);
            clickJS(driver, btnSi);
            driver.switchTo().window(tabs.get(1));
            sendKeys(driver, inputFiltrar, nombreCabezal);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            visibiltyOf(driver, lblNotFound);
            driver.close();
            driver.switchTo().window(tabs.get(0));
            System.out.println("##############CABEZAL BORRADO##############");
        } catch (Exception e) {
            errorColor(driver, "ERROR, NO SE PUDO BORRAR EL CABEZAL " + nombreCabezal + " RAZON: " + e, e);
            screenshot(driver, "ERROR BORRAR " + nombreCabezal);
        }
    }
}

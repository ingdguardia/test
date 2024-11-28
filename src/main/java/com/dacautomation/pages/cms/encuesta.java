//package com.dacautomation.pages.cms;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class encuesta extends cms_base {
//
//    public encuesta(WebDriver _driver) {
//        super(_driver);
//    }
//
//    public void createSurvey(WebDriver driver, String nombreEncuesta, String opcion1, String opcion2, String opcion3)
//            throws IOException {
//        try {
//            System.out.println("##############CREAR ENCUESTA##############");
//            click(driver, btnEncuesta);
//            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(1));
//            click(driver, btnNuevo);
//            tabs = new ArrayList<String>(driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(2));
//            Thread.sleep(3000);
//            sendKeys(driver, tituloAdjunto, nombreEncuesta);
//            sendKeys(driver, inputOpcionesEncuesta, opcion1);
//            driver.findElement(inputOpcionesEncuesta).sendKeys(Keys.ENTER);
//            optionEncuesta = By.xpath("//span[text()='" + opcion1 + "']");
//            visibiltyOf(driver, optionEncuesta);
//            sendKeys(driver, inputOpcionesEncuesta, opcion2);
//            driver.findElement(inputOpcionesEncuesta).sendKeys(Keys.ENTER);
//            optionEncuesta = By.xpath("//span[text()='" + opcion2 + "']");
//            sendKeys(driver, inputOpcionesEncuesta, opcion3);
//            driver.findElement(inputOpcionesEncuesta).sendKeys(Keys.ENTER);
//            optionEncuesta = By.xpath("//span[text()='" + opcion3 + "']");
//            clickJS(driver, btnGrabar);
//            Thread.sleep(3000);
//            driver.close();
//            driver.switchTo().window(tabs.get(1));
//            headerObjeto = setHeaderNote(nombreEncuesta);
//            sendKeys(driver, inputFiltrar, nombreEncuesta);
//            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
//            visibiltyOf(driver, headerObjeto);
//            driver.close();
//            driver.switchTo().window(tabs.get(0));
//            System.out.println("##############CREAR ENCUESTA OK##############");
//        } catch (Exception e) {
//            errorColor(driver, "ERROR, NO SE PUDO CREAR LA ENCUESTA " + nombreEncuesta + " RAZON: " + e, e);
//            screenshot(driver, "ERROR CREAR " + nombreEncuesta);
//        }
//
//    }
//
//    public void deleteSurvey(WebDriver driver, String nombreEncuesta) throws IOException {
//        try {
//            System.out.println("##############BORRANDO ENCUESTA##############");
//            System.out.println(driver.getCurrentUrl());
//            Thread.sleep(5000);
//            if (driver.getCurrentUrl().equals(url + "administrator/encuestas")) {
//                System.out.println(url + "administrator/encuestas");
//                System.out.println("##############SECCION ENCUESTA OK##############");
//                sendKeys(driver, inputFiltrar, nombreEncuesta);
//                driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
//            } else {
//                System.out.println("##############CLICK SECCION ENCUESTA##############");
//                click(driver, btnEncuesta);
//                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//                tabs = new ArrayList<String>(driver.getWindowHandles());
//                driver.switchTo().window(tabs.get(1));
//                sendKeys(driver, inputFiltrar, nombreEncuesta);
//                driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
//            }
//            setHeaderNote(nombreEncuesta);
//            click(driver, headerObjeto);
//            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//            tabs = new ArrayList<String>(driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(2));
//            Thread.sleep(5000);
//            clickJS(driver, btnInfo);
//            clickJS(driver, btnEliminar);
//            clickJS(driver, btnSi);
//            driver.switchTo().window(tabs.get(1));
//            sendKeys(driver, inputFiltrar, nombreEncuesta);
//            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
//            visibiltyOf(driver, lblNotFound);
//            driver.close();
//            driver.switchTo().window(tabs.get(0));
//            System.out.println("##############ENCUESTA BORRADA##############");
//        } catch (Exception e) {
//            errorColor(driver, "ERROR, NO SE PUDO  BORRAR LA ENCUESTA " + nombreEncuesta + " RAZON: " + e, e);
//            screenshot(driver, "ERROR BORRAR " + nombreEncuesta);
//        }
//    }
//
//}

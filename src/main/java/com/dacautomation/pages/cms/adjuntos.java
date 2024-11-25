package com.dacautomation.pages.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class adjuntos extends cms_base {
    //ELEMENTOS WEB
    By btnArchivos = By.xpath("//span[text()='Archivos']");
    By btnFile = By.id("uploadFile");
    By dropdownTipoAdjunto = By.xpath("//div[@id='content_idAdjuntoTipo']//div//input[@type='text']");
    By optionTipoAdjunto = By.xpath("(//li//span[text()='Imagen'])[1]");
    By tituloAdjunto = By.id("descripcion");
    By headerImagen = By.xpath("//div[contains(text(), 'TD Automation Imagen')]");

    public adjuntos(WebDriver driver) {
        super(driver);
    }

    public void createAttach(WebDriver driver, String tipo, String link, String nombreAdjunto, String test) {

        try {

//            SELECTCOLOR(test,"[START]: CREAR ADJUNTO");
            click(driver, btnArchivos, "MODULO ARCHIVOS", test);
            ArrayList<String> tabs;
            switchToTabWithTitle(driver,"Archivos", test);
            boolean presenceCardMode = presenceOfReturn(driver, cmsCardMode, test);
            if(presenceCardMode){
                if(driver.getCurrentUrl().contains("staging")){
                    By checkboxContenidoFiltroNota = By.xpath("//span[text()='Último mes']");
                    click(driver,checkboxContenidoFiltroNota,"CLICK CHECKBOX FILTRO ULTIMO MES", test);
                }
                By headerImagen = By.xpath("(//div[contains(text(),'"+nombreAdjunto+"')])[1]");
                verifyIfElementExists(driver, "TD AUTOMATION Imagen", headerImagen, "Archivos", test);
                headerImagen = By.xpath("(//div[contains(text(),'pruebas-evaluacion-1')])[1]");
                verifyIfElementExists(driver, "prueba", headerImagen, "Archivos", test);
                click(driver, btnNuevo, "BOTON NUEVO", test);
                switchToTabWithTitle(driver,"Sin Titulo", test);
                waitSpanElementNameInEditor(driver,"Sin Titulo","Archivos", test);
                optionTipoAdjunto = By.xpath("(//li//span[text()='" + tipo + "'])[1]");
                click(driver, dropdownTipoAdjunto, "DROPDOWN TIPO ADJUNTO", test);
                click(driver, optionTipoAdjunto, "OPTION TIPO ADJUNTO", test);
                driver.findElement(btnFile).sendKeys(link);
                By loadingImg = By.xpath("//*[@id=\"tblPrincipalBlock\"]/div/div/div");
                invisibilityOf(driver,loadingImg,test);
                waitSpanElementNameInEditor(driver,"pruebas-evaluacion-1.png", "Achivos",test);
                By imgPreview = By.xpath("//div[@style=contains(text(),'display')]//img[@id='image_preview']");
                esVisibleTest(driver,imgPreview,test);
                By epigrafe = By.xpath("//div[@id='mce_0']");
                driver.switchTo().frame("epigrafeiframe");
                sendKeys(driver,epigrafe,"epigrafe","epigrafe adjunto",test);
                driver.switchTo().parentFrame();
                sendKeys2(driver, tituloAdjunto, nombreAdjunto, "INPUT TITULO ADJUNTO", test);
                Thread.sleep(2000);
                waitSpanElementNameInEditor(driver,nombreAdjunto,"Archivos", test);
                driver.close();
                switchToTabWithTitle(driver,"Archivos", test);
                sendKeys(driver, inputFiltrar, nombreAdjunto, "BUSCO IMAGEN", test);
                headerImagen = By.xpath("(//div[contains(text(),'"+nombreAdjunto+"')])[1]");
                estaPresenteTest(driver,headerImagen,test);
                driver.close();
                switchToTabWithTitle(driver,"Contenidos", test);
                SELECTCOLOR(test,"[OK]: CREAR ADJUNTO");
            }
        } catch (Exception e) {
            errorColor(driver,"METODO createAttach ", e , test);
        }



    }

    public String createAttach2(WebDriver driver, String tipo, String link, String nombreAdjunto, String idImagenR)
            throws IOException {
        try {

            titleColor(driver, "CREAR ADJUNTO");
            click(driver, btnArchivos);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            By headerImg = By.xpath("//div//div[text()='" + nombreAdjunto + "']");
            WebElement headerImgWE = encontrarElemento(driver, headerImg);
            verifyIfElementExists(driver, nombreAdjunto, headerImg);
            click(driver, btnNuevo);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(3000);
            optionTipoAdjunto = By.xpath("(//li//span[text()='" + tipo + "'])[1]");
            clickJS(driver, dropdownTipoAdjunto);
            clickJS(driver, optionTipoAdjunto);
            // System.out.println("HOME: " + System.getProperty("user.dir"));
            driver.findElement(btnFile).sendKeys(link);
            Thread.sleep(2000);
            sendKeys(driver, tituloAdjunto, nombreAdjunto);
            clickJS(driver, btnGrabar);
            presenceOf(driver, alertGuardado);
            idImagenR = getNoteIdApi(driver.getCurrentUrl()); // TODO CAMBIAR A INT
            System.out.println("ID IMAGEN: " + idImagenR);
            driver.close();
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(4000);
            // System.out.println("VALOR IMAGEN: " + idImagen);
            headerImagen = By.xpath("//article[@id='Result" + idImagenR + "']");
            sendKeys(driver, inputFiltrar, nombreAdjunto);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            visibilityOf(driver, headerImagen);
            driver.close();
            Thread.sleep(1000);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            okColor(driver, "CREAR ADJUNTO");
            endColor(driver, "CREAR ADJUNTO");
            return idImagenR;
        } catch (Exception e) {
            errorColor(driver, "NO SE PUDO CREAR EL ADJUNTO: " + tipo + " ERROR: " + e, e);
            return idImagenR;
        }

    }

    public String createAttach3(WebDriver driver, String tipo, String link, String nombreAdjunto, String idImagenR)
            throws IOException {
        try {

            titleColor(driver, "CREAR ADJUNTO");
            click(driver, btnArchivos);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            By headerImg = By.xpath("//div//div[text()='" + nombreAdjunto + "']");
            WebElement headerImgWE = encontrarElemento(driver, headerImg);
            verifyIfElementExists(driver, nombreAdjunto, headerImg);
            click(driver, btnNuevo);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(3000);
            optionTipoAdjunto = By.xpath("(//li//span[text()='" + tipo + "'])[1]");
            clickJS(driver, dropdownTipoAdjunto);
            clickJS(driver, optionTipoAdjunto);
            // System.out.println("HOME: " + System.getProperty("user.dir"));
            driver.findElement(btnFile).sendKeys(link);
            Thread.sleep(2000);
            sendKeys(driver, tituloAdjunto, nombreAdjunto);
            clickJS(driver, btnGrabar);
            presenceOf(driver, alertGuardado);
            idImagenR = getNoteIdApi(driver.getCurrentUrl()); // TODO CAMBIAR A INT
            System.out.println("ID IMAGEN: " + idImagenR);
            driver.close();
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(4000);
            // System.out.println("VALOR IMAGEN: " + idImagen);
            headerImagen = By.xpath("//article[@id='Result" + idImagenR + "']");
            sendKeys(driver, inputFiltrar, nombreAdjunto);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            visibilityOf(driver, headerImagen);
            driver.close();
            Thread.sleep(1000);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            okColor(driver, "CREAR ADJUNTO");
            endColor(driver, "CREAR ADJUNTO");
            return idImagenR;
        } catch (Exception e) {
            errorColor(driver, "NO SE PUDO CREAR EL ADJUNTO: " + tipo + " ERROR: " + e, e);
            return idImagenR;
        }

    }


    public void deleteAttach(WebDriver driver, String attachName, String test)  {
        try {
//            SELECTCOLOR(test,"[START]: BORRAR ADJUNTO");
            click(driver, btnArchivos, "MODULO ARCHIVOS", test);
            switchToTabWithTitle(driver,"Archivos",test);
            By checkboxContenidoFiltroNota = By.xpath("//span[text()='Último mes']");
            click(driver,checkboxContenidoFiltroNota,"CLICK CHECKBOX FILTRO EN EDICIÓN", test);
            sendKeys2(driver,inputFiltrar,attachName,"INPUT FILTRAR NOMBRE IMAGEN", test);
            boolean presenceCardMode = presenceOfReturn(driver, cmsCardMode, test);
            if(presenceCardMode){
                headerImagen = By.xpath("//div[contains(text(),'"+attachName+"')]");
                By figCaption = By.xpath("(//figure/figcaption)[1]");
                esVisibleTest(driver,figCaption,test);
                clickJS(driver,headerImagen,"HEADER TD AUTOMATION IMAGEN",test);
                switchToTabWithTitle(driver,attachName,test);
                By spanTituloElementoImagen = By.xpath("//div[@class='header-modifier card']//following::span[contains(text(),'" + attachName + "')]");
                boolean BspanTituloElemento = isElementPresent(driver, spanTituloElementoImagen);
                if (BspanTituloElemento) {
                    click(driver, btnInfo, "BOTON INFO EN EDITOR DE NOTAS", test);
                    click(driver, btnEliminar, "BOTON ELIMINAR EN EDITOR DE NOTAS", test);
                    clickJS(driver, btnSi, "BOTON SI", test);
//                    if(esVisibleR(driver,btnSi,test)){
//                        click(driver, btnSi, "BOTON SI", test);
//                    }
                    switchToTabWithTitle(driver, "Archivos", test);
                }
                SELECTCOLOR(test,"[OK]: BORRAR ADJUNTO");
            }
        } catch (Exception e) {
            errorColor(driver,"METODO deleteAttach ", e , test);
        }
    }
}

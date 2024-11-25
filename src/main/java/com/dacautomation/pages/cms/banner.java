package com.dacautomation.pages.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;

public class banner extends cms_base {

    static By btnBanners = By.xpath("//span[text()='Banners']");
    static By dropdownTipoBanner = By.xpath("//div[@id='content_tipo']//input[@class='select-dropdown dropdown-trigger']");
    static By optionDropdownBanner = By.xpath("//span[text()='Script']");
    static By inputScriptBanner = By.xpath("//textarea[@id='script[2]']");
    static By inputSelectedOptionBanner = By.xpath("//li[@class='selected']//span[text()='Script']");
    static By inputNombreAdjuntoBanner = By.id("FileList_input");
    static By optionImgBanner = By.xpath("//figcaption[@data-type='(Imagen)']//span[text()='test']");
    static By inputAnchoBanner = By.id("width");
    static By inputLargoBanner = By.id("height");
    static By valorAnchoBanner = By.xpath("//input[@value='900']");
    static By valorLargoBanner = By.xpath("//input[@value='900']");
    static By valorTagBanner = By.xpath("//span[text()=' td automation tag ']");
    static By valorCategoriaBanner = By.xpath("//input[@value='900']");
    static By headerObjeto = null;

    public banner(WebDriver _driver) {
        super(_driver);
    }

    public static void createBanner(WebDriver driver, String nombreBanner, String tipo, String texto, String ancho, String largo, String tag,
                             String tipoTag, String category,String idImagen, String test) throws IOException {
        try {
            click(driver, btnBanners,"BTN BANNERS",test);
//            switchToTabWithTitle(driver,"Banners",test);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            click(driver, btnNuevo,"CLICK BTN NUEVO",test);
            Thread.sleep(2000);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(3000);
            sendKeys(driver, cms_base.tituloAdjunto, nombreBanner,"TITULO BANNER",test);
            clickJS(driver, dropdownTipoBanner,"CLICK DROPDOWN TIPO BANNER",test);
            optionDropdownBanner = By.xpath("//span[text()='" + tipo + "']");
            clickJS(driver, optionDropdownBanner,"CLICK OPTION DROPDOWN BANNER",test);
            inputSelectedOptionBanner = By.xpath("//li[@class='selected']//span[text()='" + tipo + "']");
            visibilityOf(driver, inputSelectedOptionBanner,test);

            if (tipo.equals("Script")) {
                sendKeys(driver, inputScriptBanner, texto,"INPUT SCRIPT BANNER",test);
                sendKeys(driver, inputAnchoBanner, ancho,"INPUT ANCHO BANNER",test);
                sendKeys(driver, inputLargoBanner, largo,"INPUT LARGO BANNER",test);
                sendKeys(driver, inputAgrupadoresNota, tag,"INPUT AGRUPADORES BANNER",test);
                optionAgrupadores = By.xpath("//li//span[text()='" + tipoTag + " » " + tag + "']");
                clickJS(driver, optionAgrupadores,"CLICK OPTION AGRUPADOR BANNER",test);
                sendKeys(driver, inputCategoriasNota, category,"INPUT CATEGORIAS BANNER",test);
                optionCategorias = By.xpath("//span[text()='" + category + "']");
                clickJS(driver, optionCategorias,"CLICK OPTION CATEGORIA",test);
            } else if (tipo.equals("Archivo")) {
                sendKeys(driver, inputNombreAdjuntoBanner, texto,"INPUT NOMBRE ADJUNTO BANNER",test);
                Thread.sleep(2000);
                optionImgBanner = By.xpath("//figcaption[@data-type='(Imagen)']//span[text()='" + texto + "']");
                // visibiltyOf(driver, optionImgBanner);
                WebElement wElement = driver.findElement(By.xpath("(//input[starts-with(@onclick,'FilesList')])[1]"));
                idImagen = wElement.getAttribute("value");
                System.out.println("VALOR: " + idImagen);
                checkboxAdjunto = By.xpath("//*[@id='FileList_" + idImagen + "_item']/figure/div/label/input");
                Thread.sleep(2000);
                clickJS(driver, checkboxAdjunto,"CLICK CHECKBOX ADJUNTO",test);
                Thread.sleep(2000);
                clickJS(driver, btnRelacionarNota,"CLICK BTN RELACIONAR",test);
                sendKeys(driver, inputAnchoBanner, ancho,"INPUT ANCHO BANNER",test);
                sendKeys(driver, inputLargoBanner, largo,"INPUT LARGO BANNER",test);
                sendKeys(driver, inputAgrupadoresNota, tag,"INPUT ",test);
                optionAgrupadores = By.xpath("//li//span[text()='" + tipoTag + " » " + tag + "']");
                clickJS(driver, optionAgrupadores,"CLICK OPTION AGRUPADORES",test);
                sendKeys(driver, inputCategoriasNota, category,"INPUT CATEGORIAS BANNER",test);
                optionCategorias = By.xpath("//span[text()='" + category + "']");
                clickJS(driver, optionCategorias,"CLICK OPTION CATEGORIA",test);
            }
            // valorLargoBanner = By.xpath("//input[@value='" + largo + "']");
            valorTagBanner = By.xpath("//div[@class='chip__body']//span[text()='" + tag + "']");
            valorCategoriaBanner = By.xpath("//span[text()='" + category + "']");
            Thread.sleep(3000);
            clickJS(driver, btnGrabar,"CLICK BTN GRABAR",test);
            Thread.sleep(3000);
            presenceOf(driver, toastGuardado,test);
            driver.navigate().refresh();
            Thread.sleep(3000);
            System.out.println("VALOR ELEMENT " + driver.findElement(inputAnchoBanner).getAttribute("value"));
            checkValueElement(driver, inputAnchoBanner, ancho,test);
            checkValueElement(driver, inputLargoBanner, largo,test);
            presenceOf(driver, valorTagBanner,test);
            visibilityOf(driver, valorCategoriaBanner,test);
            Thread.sleep(3000);
            driver.close();
            driver.switchTo().window(tabs.get(1));
            headerObjeto = setHeaderNote(nombreBanner);
            sendKeys(driver, inputFiltrar, nombreBanner,"INPUT FILTRAR",test);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            visibilityOf(driver, headerObjeto,test);
            driver.close();
            driver.switchTo().window(tabs.get(0));
            SELECTCOLOR(test,"[OK]: CREAR BANNER");
        } catch (Exception e) {
            errorColor(driver, "NO SE PUDO CREAR EL BANNER" + nombreBanner + " RAZON: ", e,test);
        }

    }



    public void deleteBanner(WebDriver driver, String nombreBanner, String url, String test) throws IOException {
        try {
            click(driver, btnBanners,"CLICK MODULO BANNER",test);
            switchToTabWithTitle(driver,"Banners",test);
            headerObjeto = setHeaderNote(nombreBanner);
            click(driver, headerObjeto,"CLICK HEADER OBJETO",test);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(5000);
            clickJS(driver, btnInfo,"CLICK INFO",test);
            clickJS(driver, btnEliminar,"CLICK ELIMINAR",test);
            clickJS(driver, btnSi,"CLICK SI",test);
            driver.switchTo().window(tabs.get(1));
            sendKeys(driver, inputFiltrar, nombreBanner,"INPUT FILTRAR",test);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            visibilityOf(driver, lblNotFound,test);
            driver.close();
            driver.switchTo().window(tabs.get(0));
            SELECTCOLOR(test,"[OK]: BORRAR BANNER");
        } catch (Exception e) {
            errorColor(driver, "ERROR, NO SE PUDO  BORRAR EL BANNER " + nombreBanner + " RAZON: " + e, e,test);
        }
    }


}

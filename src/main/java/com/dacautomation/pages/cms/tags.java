package com.dacautomation.pages.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class tags extends cms_base{

    //ELEMENTOS WEB
    By dropdownTipoAgrupador = By.xpath("//div[@id='content_idAgrupadorTipo']//div//input[@type='text']");
    By optionTipoAgrupadorTema = By.xpath("(//li//span[text()='Tema'])[1]");
    By btnAgrupadores = By.xpath("//span[text()='Agrupadores']");
    By btnTags = By.xpath("(//span[text()='Tags'])[1]");

    public tags(WebDriver driver) {
        super(driver);
    }

    public void createTag(WebDriver driver, String tagName, String test){
        try {
//                SELECTCOLOR(test,"[START]: CREAR AGRUPADOR");
                String modulo = null;
                clickTag(driver, test);
                WebElement textoModuloTag = driver.findElement(By.xpath("(//a//span)[3]"));
                if(textoModuloTag.getText().contains("tags")){
                    switchToTabWithTitle(driver, "Tags", test);
                    modulo = "Tags";
                }else{
                    switchToTabWithTitle(driver, "Agrupadores", test);
                    modulo = "Agrupadores";
                }
                boolean tagPresente = isElementPresent(driver,cmsListMode);
                if(tagPresente){
                    presenceOf(driver, cmsListMode, test);
                }

                By headerTag = By.xpath("//h2[text()='" + tagName + "']");
                verifyIfElementExists(driver, tagName, headerTag, modulo, test);
                click(driver, btnNuevo, "BOTON NUEVO", test);
                switchToTabWithTitle(driver, "Sin Titulo", test);
                waitSpanElementNameInEditor(driver,"Sin Titulo","Agrupadores",test);
                By inputCuerpo = By.xpath("//*[@id='mce_0']/p");
                driver.switchTo().frame("textoiframe");
                sendKeys(driver,inputCuerpo,"texto agrupador","texto agrupador",test);
                driver.switchTo().parentFrame();
                sendKeys(driver, inputNombreObjeto, tagName, "TEXT BOX NOMBRE TAG", test);
                click(driver, dropdownTipoAgrupador, "BOTON DROPDOWN TIPO TAG", test);
                optionTipoAgrupadorTema = By.xpath("(//div[@id='content_idAgrupadorTipo']//div//ul//li//span)[1]");
                click(driver, optionTipoAgrupadorTema, "OPCION TIPO TAG", test);
                clickJS(driver, btnGrabar, "BOTON GRABAR", test);

                 esperarToast(driver, tagName,"Agrupadores",test);
                driver.close();
                switchToTabWithTitle(driver, "Agrupadores", test);
                sendKeys2(driver, inputFiltrar, tagName, "TEXT BOX NOMBRE TAG", test);
                driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            esVisibleTest(driver, headerTag, test);
                driver.close();
                cambiarPestania(driver, "Contenidos", test);

                SELECTCOLOR(test,"[OK]: CREAR AGRUPADOR");

        } catch (Exception e) {
            errorColor(driver,"METODO createTag ", e , test);

        }
    }

    public void clickTag(WebDriver driver, String test) {
        try {
           WebElement elementoW = esperar2Elementos(driver,test, btnAgrupadores,btnTags,"agrupador");
           elementoW.click();
        } catch (Exception e) {
            errorColor(driver,"METODO clickTag ", e , test);

        }
    }

    public void deleteTag(WebDriver driver, String tagName, String test){
//        SELECTCOLOR(test,"[START]: BORRAR AGRUPADOR");
        try {
            clickTag(driver, test);
            WebElement textoModuloTag = driver.findElement(By.xpath("(//a//span)[3]"));

            if(textoModuloTag.getText().contains("tags")){
                switchToTabWithTitle(driver, "Tags", test);
            }else{
                switchToTabWithTitle(driver, "Agrupadores", test);
            }
                sendKeys(driver, inputFiltrar, tagName, "NOMBRE TAG", test);
                headerObjeto = setHeaderNote(tagName);
                verifyIfElementExists(driver,tituloNota,headerObjeto,"Agrupadores",test);
                driver.close();
                cambiarPestania(driver,"Contenidos",test);
                SELECTCOLOR(test,"[OK]: BORRAR AGRUPADOR");
        } catch (Exception e) {
            errorColor(driver,"METODO deleteTag ", e , test);

        }

    }
}

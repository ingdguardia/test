package com.dacautomation.pages.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class categorias extends cms_base {
    //ELEMENTOS WEB
    By btnCategorias = By.xpath("//span[text()='Categorias']");

    By dropdownPortalCategoria = By.xpath("//div[@id='content_idCMSPortal']//div//input[@type='text']");
    By optionPortalCategoria = By.xpath("(//li//span[text()='Todos'])[1]");

    public categorias(WebDriver driver) {
        super(driver);
    }

    public void createCategory(WebDriver driver, String categoryName, String test) {
//            SELECTCOLOR(test, "[START]: CREAR CATEGORIA");
        try {

            click(driver, btnCategorias, "MODULO CATEGORIA", test);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            esperarModuloCategoria(driver,test);
            presenceOf(driver,cmsListMode, test);
            headerObjeto = setHeaderNote(categoryName);
            verifyIfElementExists(driver, categoryName, headerObjeto, "Categorias", test);
            Thread.sleep(3000);
            click(driver, btnNuevo, "BOTON NUEVO", test);
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            waitSpanElementNameInEditor(driver,"Sin Titulo","Categorias",test);
            sendKeys(driver, inputNombreObjeto, categoryName, "INPUT NOMBRE CATEGORIA", test);
//            clickImplicit(driver, dropdownPortalCategoria, "DROPDOWN PORTAL CATEGORIA");
//            clickImplicit(driver, optionPortalCategoria, "OPTION PORTAL CATEGORIA");
            clickImplicit(driver, btnGrabar, "BOTON GRABAR", test);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Timeout de 10 segundos
            wait.until(cms_base.ultimoSegmentoEsNumerico());
            esperarToast(driver, categoryName,"Categorias",test);
            driver.close();
            driver.switchTo().window(tabs.get(1));
            sendKeys2(driver, inputFiltrar, categoryName, "INPUT FILTRAR", test);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            setHeaderNote(categoryName);
            Thread.sleep(2000);
            esVisibleTest(driver, headerObjeto, test);
            driver.close();
            driver.switchTo().window(tabs.get(0));

                SELECTCOLOR(test, "[OK]: CREAR CATEGORIA");

        } catch (Exception e) {
            errorColor(driver,"METODO createCategory ", e , test);

        }
    }

    public void deleteCategory(WebDriver driver, String categoryName, String test){
        try {
                click(driver, btnCategorias, "MODULO CATEGORIA", test);
                switchToTabWithTitle(driver,"Categorias",test);
                esperarModuloCategoria(driver,test);
                By headerObjeto = setHeaderNote(categoryName);
                verifyIfElementExists(driver,categoryName,headerObjeto,"Categorias",test);
                driver.close();
                switchToTabWithTitle(driver,"Categorias",test);
                SELECTCOLOR(test,"[OK]: BORRAR CATEGORIA");
        } catch (Exception e) {
            errorColor(driver,"METODO deleteCategory ", e , test);

        }
    }
}

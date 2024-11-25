package com.dacautomation.pages.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;

public class persona {


    public void createPerson(WebDriver driver, String nombrePersona, String email, String biografia, String twitter,
                             String facebook, String youtube, String linkedin, String apodo, String imagen) throws IOException {

        try {
            System.out.println("##############CREAR PERSONA##############");
            clickJS(driver, btnPersonas);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            // List<WebElement> obj =
            // driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            // while (obj.get(0).getAttribute("cms:title").equals(nombrePersona)) {
            // System.out.println(obj.get(0).getAttribute("cms:title"));
            // checkAndDelete(driver, nombrePersona, "Personas");
            // obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            // }
            click(driver, btnNuevo);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(3000);
            // CARGAR DATOS
            sendKeys(driver, inputNombreObjeto, nombrePersona);
            sendKeys(driver, inputEmailObjeto, email);
            sendKeys(driver, inputApodoObjeto, apodo);
            sendKeys(driver, inputFacebookObjeto, facebook);
            sendKeys(driver, inputTwitterObjeto, twitter);
            sendKeys(driver, inputYoutubeObjeto, youtube);
            sendKeys(driver, inputLinkedinObjeto, linkedin);
            sendKeys(driver, inputBiografiaObjeto, biografia);
            sendKeys(driver, inputArchivosNota, imagen);
            checkboxAdjunto = By.xpath("//*[@id='FileList_" + idImagen +
                    "_item']/figure/div/label/input");
            Thread.sleep(2000);
            clickJS(driver, checkboxAdjunto);
            clickJS(driver, btnRelacionarNota);
            clickJS(driver, btnGrabar);
            Thread.sleep(1000);
            presenceOf(driver, alertGuardado);
            driver.navigate().refresh();
            // Thread.sleep(3000);
            // VERIFICAR
            checkValueElement(driver, inputNombreObjeto, nombrePersona);
            checkValueElement(driver, inputEmailObjeto, email);
            checkValueElement(driver, inputApodoObjeto, apodo);
            checkValueElement(driver, inputFacebookObjeto, facebook);
            checkValueElement(driver, inputTwitterObjeto, twitter);
            checkValueElement(driver, inputYoutubeObjeto, youtube);
            checkValueElement(driver, inputLinkedinObjeto, linkedin);
            checkTextElement(driver, inputBiografiaObjeto, biografia);
            driver.close();
            driver.switchTo().window(tabs.get(1));
            sendKeys(driver, inputFiltrar, nombrePersona);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            headerObjeto = setHeaderNote(nombrePersona);
            visibiltyOf(driver, headerObjeto);
            driver.close();
            Thread.sleep(1000);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));

            System.out.println("##############CREAR PERSONA OK##############");
        } catch (Exception e) {
            errorColor(driver, "##############NO SE PUDO CREAR LA PERSONA: " + nombrePersona + " ERROR: " + e, e);
            screenshot(driver, "ERROR CREAR " + nombrePersona);

        }

    }

}

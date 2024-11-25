package com.dacautomation.tests.fast;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dacautomation.tests.cms.Elements;

public class Fast_Test extends Elements {

     WebDriver driver;
    WebDriver driver2;
    WebDriver driver3;
    String idImagen;
    List<String> getStringData = new ArrayList<>();
    List<List<String>> listasDivididas = null;
    boolean driverOpen1 = false;
    boolean driverOpen2 = false;
    boolean driverOpen3 = false;
    boolean verificarLogin = false;

    @BeforeTest
    public void initializeVariables() {
        try {
            // TODO METODO PARA DETECTAR LAS URLS Y EJECUTAR LOS TEST EN BASE A ESO
            System.out.println("FAST");
//            titleColor(driver, "BEFORE TEST");
//            endColor(driver, "BEFORE TEST");
        } catch (Exception e) {
//            errorColor2(driver, "NO SE PUDIERON INICIALIZAR VARIABLES: " + ANSI_RESET);
        }

    }

    @Test
    public void fastTest() throws InterruptedException{
//        driver = setup(driver);
//        login.loggear(driver);
//        grilla.crearGrilla(driver);
//        okColor(driver, "TEST FAST LOGIN");
    }

    @AfterTest
    public void cerrar(){
        driver.quit();
    }
}

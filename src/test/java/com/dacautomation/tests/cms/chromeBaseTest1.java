package com.dacautomation.tests.cms;


import com.dacautomation.pages.cms.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static com.dacautomation.pages.cms.cms_base.*;


public class chromeBaseTest1 {

    public static class BaseTest extends Elements {
        WebDriver driver;
        List<String> originalList = new ArrayList<>();
        List<String> listaNueva = null;
        boolean driverOpen1 = false;
        boolean verificarLogin = false;
        boolean error = false;
        String txtCuerpo= "";

        @BeforeTest
        public void initializeVariables(){
            cms_base base_cms = new cms_base(driver);
            try {
                if(System.getProperty("os.name").contains("Mac OS X")) clearDirectory("/Users/dario.guardia/Documents/repos/qaautomation/Screenshots");
                originalList = initializeAWS();
//                System.out.println(originalList);
                List<List<String>> dividedLists = divideListInThree(originalList);
                listaNueva = dividedLists.get(0);
                System.out.println("Numero de portales: "+originalList.size());
                txtCuerpo = base_cms.readFile(System.getProperty("user.dir") + "/src/test/resources/elementos para notas/cuerpo.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Test()
        public void baseTest() {
            if (listaNueva.isEmpty()) {
                Assert.assertTrue(true);
            } else {
                for (int i = 0; i < 1; i++) {

                    try {

                        COLORTEST1("[START]: TEST BASE 1");
                        cms_base base_cms = new cms_base(driver);
                        tags tags = new tags(driver);
                        categorias categorias = new categorias(driver);
                        adjuntos adjuntos = new adjuntos(driver);
                        notas notas = new notas(driver);
                        List<String> trimData;
                        trimData = separarPorEspacios(listaNueva);
                        String separar = trimData.get(i);
                        String[] datos = procesarString(separar);
                        String url = datos[2];
                        String user = datos[1];
                        String pass = datos[0];

                        driverOpen1 = true;
                        driver = setup(driver, "TEST1");
                        verificarLogin = base_cms.login(driver, user, pass, url, verificarLogin, "TEST1");

                        if (!url.isEmpty() && verificarLogin) {
                            tags.createTag(driver, "TD AUTOMATION Tag", "TEST1");
                            categorias.createCategory(driver, "TD AUTOMATION Category", "TEST1");
                            adjuntos.createAttach(driver, "Imagen", System.getProperty("user.dir") + "/src/test/resources/elementos para notas/pruebas-evaluacion-1.png",
                                    "TD AUTOMATION Imagen", "TEST1");
                            notas.createNote(driver, "TD AUTOMATION Nota", "Volanta auto", "Copete auto",
                                    txtCuerpo, "TD AUTOMATION Tag", "TD AUTOMATION Category", "TD AUTOMATION Imagen",
                                    url, user, pass, "TEST1");
                            notas.deleteNote(driver, "TD AUTOMATION Nota", "TEST1");
                            tags.deleteTag(driver, "TD AUTOMATION Tag", "TEST1");
                            categorias.deleteCategory(driver, "TD AUTOMATION Category", "TEST1");
                            adjuntos.deleteAttach(driver, "TD AUTOMATION Imagen", "TEST1");
                            COLORTEST1("[OK]: TEST BASE 1");
                        }
                    } catch (Exception e) {
                        errorColor(driver, "NO SE PUDO REALIZAR EL TEST CORRECTAMENTE ", e, "TEST1");
                    }
                    if (!error) {
                        driver.close();
                    }
                }
            }
        }

        @AfterTest
        public void quit() {
            if (driverOpen1) {
                driver.quit();
            }
        }

    }
}

package com.dacautomation.tests.cms;
import com.dacautomation.pages.cms.*;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.dacautomation.pages.cms.cms_base.*;

public class chromeBaseTest3 {
    WebDriver driver3;
    List<String> originalList = new ArrayList<>();
    boolean driverOpen3 = false;
    boolean error = false;
    boolean verificarLogin = false;
    List<String> listaNueva = null;
    String txtCuerpo= "";



    @BeforeTest
    public void initializeVariables() {
        cms_base base_cms = new cms_base(driver3);
        try {
            originalList = cms_base.initializeAWS();
            List<List<String>> dividedLists = divideListInThree(originalList);
            listaNueva = dividedLists.get(2);
            txtCuerpo = base_cms.readFile(System.getProperty("user.dir") + "/src/test/resources/elementos para notas/cuerpo.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void baseTest3(){
        if (listaNueva.isEmpty()) {
            Assert.assertTrue(true);
        } else {

            for (int i = 0; i < 1; i++) {
                try {
                    COLORTEST3("[START]: TEST BASE");
                    cms_base base_cms = new cms_base(driver3);
                    tags tags = new tags(driver3);
                    categorias categorias = new categorias(driver3);
                    adjuntos adjuntos = new adjuntos(driver3);
                    notas notas = new notas(driver3);

                    List<String> trimData = separarPorEspacios(listaNueva);
                    String separar = trimData.get(i);
                    String[] datos = procesarString(separar);
                    String url = datos[2];
                    String user = datos[1];
                    String pass = datos[0];

                    driverOpen3 = true;
                    driver3 = setup(driver3, "TEST3");
                    verificarLogin = base_cms.login(driver3, user, pass, url, verificarLogin, "TEST3");

                    if (!url.isEmpty() && verificarLogin) {
                        tags.createTag(driver3, "TD AUTOMATION Tag", "TEST3");
                        categorias.createCategory(driver3, "TD AUTOMATION Category", "TEST3");
                        adjuntos.createAttach(driver3, "Imagen", System.getProperty("user.dir") + "/src/test/resources/elementos para notas/pruebas-evaluacion-1.png",
                                "TD AUTOMATION Imagen", "TEST3");
                        notas.createNote(driver3, "TD AUTOMATION Nota", "Volanta auto", "Copete auto",
                                txtCuerpo, "TD AUTOMATION Tag", "TD AUTOMATION Category", "TD AUTOMATION Imagen",
                                url, user, pass, "TEST3");
                        notas.deleteNote(driver3, "TD AUTOMATION Nota", "TEST3");
                        tags.deleteTag(driver3, "TD AUTOMATION Tag", "TEST3");
                        categorias.deleteCategory(driver3, "TD AUTOMATION Category", "TEST3");
                        adjuntos.deleteAttach(driver3, "TD AUTOMATION Imagen", "TEST3");
                        COLORTEST3("[FINISH]: TEST BASE");
                    }

                } catch (Exception e) {
                    e.getMessage();
                }
                if (!error) {
                    driver3.close();
                }
            }
        }
    }

    @AfterTest
    public void quit() {
        if (driverOpen3) {  driver3.quit(); }

    }
}

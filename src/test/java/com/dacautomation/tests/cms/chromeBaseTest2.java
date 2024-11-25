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


public class chromeBaseTest2 {
    WebDriver driver2;
    List<String> originalList = new ArrayList<>();
    boolean driverOpen2 = false;
    boolean verificarLogin = false;
    boolean error = false;
    List<String> listaNueva = null;
    String txtCuerpo= "";


    @BeforeTest
    public void initializeVariables() {
        cms_base base_cms = new cms_base(driver2);
        try {
            originalList = cms_base.initializeAWS();
            List<List<String>> dividedLists = divideListInThree(originalList);
            listaNueva = dividedLists.get(1);
            txtCuerpo = base_cms.readFile(System.getProperty("user.dir") + "/src/test/resources/elementos para notas/cuerpo.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   @Test
    public void baseTest2() {
       if ( listaNueva.isEmpty()) {
           Assert.assertTrue(true);
       } else {

           for (int i = 0; i < 1; i++) {

               try {

                   COLORTEST2("[START]: TEST BASE");
                   cms_base base_cms = new cms_base(driver2);
                   tags tags = new tags(driver2);
                   categorias categorias = new categorias(driver2);
                   adjuntos adjuntos = new adjuntos(driver2);
                   notas notas = new notas(driver2);
                   List<String> trimData = separarPorEspacios(listaNueva);
                   String separar = trimData.get(i);
                   String[] datos = procesarString(separar);
                   String url = datos[2];
                   String user = datos[1];
                   String pass = datos[0];

                   driverOpen2 = true;
                   driver2 = setup(driver2, "TEST2");
                   verificarLogin = base_cms.login(driver2, user, pass, url, verificarLogin, "TEST2");

                   if (!url.isEmpty() && verificarLogin) {
                       tags.createTag(driver2, "TD AUTOMATION Tag", "TEST2");
                       categorias.createCategory(driver2, "TD AUTOMATION Category", "TEST2");
                       adjuntos.createAttach(driver2, "Imagen", System.getProperty("user.dir") + "/src/test/resources/elementos para notas/pruebas-evaluacion-1.png",
                               "TD AUTOMATION Imagen", "TEST2");
                       notas.createNote(driver2, "TD AUTOMATION Nota", "Volanta auto", "Copete auto",
                               txtCuerpo, "TD AUTOMATION Tag", "TD AUTOMATION Category", "TD AUTOMATION Imagen", url, user, pass, "TEST2");
                       notas.deleteNote(driver2, "TD AUTOMATION Nota", "TEST2");
                       tags.deleteTag(driver2, "TD AUTOMATION Tag", "TEST2");
                       categorias.deleteCategory(driver2, "TD AUTOMATION Category", "TEST2");
                       adjuntos.deleteAttach(driver2, "TD AUTOMATION Imagen", "TEST2");
                       COLORTEST2("[FINISH]: TEST BASE");

                   }


               } catch (Exception e) {
                e.getMessage();
               }
               if (!error) {
                   driver2.close();
               }
           }
       }
   }

    @AfterTest
    public void quit() {
        if (driverOpen2) {  driver2.quit();  }

    }
}

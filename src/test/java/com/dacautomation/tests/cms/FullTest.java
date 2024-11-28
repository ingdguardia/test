//package com.dacautomation;
//
//import com.dacautomation.DataProvider.URLDataProvider;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class FullTest extends Elements {
//    String grupos;
//    String urlB;
//    String urlTestApi;
//    WebDriver driver;
//    WebDriver driver2;
//    WebDriver driver3;
//    String texto;
//    String urlApi;
//    String idImagen;
//    String versionCMS;
//    List<String> getStringData = new ArrayList<>();
//    List<List<String>> listasDivididas = null;
//
//    @BeforeTest
//    public void initializeVariables() {
//        try {
//            titleColor(driver, "BEFORE TEST");
//            getStringData = initializeAWS();
//            listasDivididas = dividirLista(getStringData);
//            txtCuerpo = readFile(System.getProperty("user.dir") + "/cuerpo.txt");
//            txtScript = readFile(System.getProperty("user.dir") + "/script.txt");
//            // for (int i = 0; i < listasDivididas.size(); i++) {
//            // System.out.println("Lista " + (i + 1) + ": " + listasDivididas.get(i));
//            // }
//            endColor(driver, "BEFORE TEST");
//
//        } catch (Exception e) {
//            System.out.println(
//                    ANSI_RED_BACKGROUND + "[ERROR]: " + "NO SE PUDIERON INICIALIZAR VARIABLES: " + e + ANSI_RESET);
//        }
//
//    }
//
//    @Test(dataProvider = "data", dataProviderClass = URLDataProvider.class)
//    public void fullTest(String data) throws InterruptedException, IOException {
//        // @Test
//        // public void fullTest() throws InterruptedException, IOException {
//        // String data = "";
//        try {
//            driver = setup(driver);
//            titleColor(driver, "TEST FULL");
//            // System.out.println(
//            // "Ejecutando prueba para data: " + data + " " +
//            // Thread.currentThread().getName());
//            List<String> trimData = new ArrayList<>();
//            trimData = separarPorEspacios(data);
//            String url = trimData.get(2);
//            String user = trimData.get(1);
//            String pass = trimData.get(0);
//            // login(driver, user, pass, url);
//            // filterNote(driver);
//            // createBanner(driver, "TD AUTOMATION BannerS", "Script", txtScript, "900",
//            // "600", "TD AUTOMATION Tag",
//            // "Temas",
//            // "Test Categoria");
////            filterNote(driver);
//            // filterBanner(driver, "TD AUTOMATION BannerS");
//            // filterAttach(driver, "TD AUTOMATION Imagen");
//
//            // createSpreadSheet(driver, "TD AUTOMATION SPREADSHEET");
//            // createTag(driver, "TD AUTOMATION Tag", "Tema");
//            // createCategory(driver, "TD AUTOMATION Category");
//            // deleteAttach(driver, "TD AUTOMATION Imagen Autor");
//            // deleteAttach(driver, "TD AUTOMATION Imagen");
//            // deleteTDElement(driver, "Personas", "TD AUTOMATION Persona");
//            // deleteNote(driver, "TD AUTOMATION Nota");
//            // createAttach(driver, "Autor", System.getProperty("user.dir") +
//            // "/autor.jpeg", "TD AUTOMATION Imagen Autor");
//            // createPerson(driver, "TD AUTOMATION Persona", "email@mail.com", "biografia",
//            // "https://twitter.com", "https://facebook.com",
//            // "https://youtube.com", "https://linkedin.com", "apodo", "TD AUTOMATION Imagen
//            // Autor");
//            // createAttach(driver, "Imagen", System.getProperty("user.dir") +
//            // "/pruebas-evaluacion-1.png", "TD AUTOMATION Imagen");
//            // idImagen = "6249575";
//            // create FreeText(driver, "TD AUTOMATION TEXTO LIBRE", "PRUEBA TEXTO");
//
//            // createNoteFull(driver, "TD AUTOMATION Nota", "Volanta auto", "Copete auto",
//            // txtCuerpo,
//            // "TD AUTOMATION Tag", "Tema",
//            // "TD AUTOMATION Category", "TD AUTOMATION Imagen", "Publicado", "TD AUTOMATION
//            // Persona",
//            // "Subtitulo H2", "Adjuntos", user, pass);
//
//            // deleteNote(driver, "TD AUTOMATION Nota");
//            // deleteTag(driver, "TD AUTOMATION Tag");
//            // deleteCategory(driver, "TD AUTOMATION Category");
//            // deleteAttach(driver, "TD AUTOMATION Imagen Autor");
//            // deleteAttach(driver, "TD AUTOMATION Imagen");
//
//            // createHeader(driver, "TD AUTOMATION Cabezal", txtCuerpo,
//            // "https://www.test.com.ar",
//            // "test", "Categorias");
//            // createBanner(driver, "TD AUTOMATION BannerS", "Script", txtScript, "900",
//            // "600", "TD AUTOMATION Tag",
//            // "Temas",
//            // "Test Categoria");
//            // createBanner(driver, "TD AUTOMATION BannerI", "Archivo", "test", "1280",
//            // "1000", "TD AUTOMATION Tag",
//            // "Temas",
//            // "Test Categoria");
//            // createSurvey(driver, "TD AUTOMATION ENCUESTA", "opcion1", "opcion2",
//            // "opcion3");
//            // deleteSurvey(driver, "TD AUTOMATION ENCUESTA");
//            // deleteBanner(driver, "TD AUTOMATION BannerS");
//            // deleteBanner(driver, "TD AUTOMATION BannerI");
//            // deleteHeader(driver, "TD AUTOMATION Cabezal");
//            // deleteTDElement(driver, "Personas", "TD AUTOMATION Persona");
//            // deleteTDElement(driver, "Texto Libre", "TD AUTOMATION TEXTO LIBRE");
//            // deleteTag(driver, "Agrupador TD AUTOMATION");
//            driver.close();
//            endColor(driver, "TEST FULL");
//        } catch (
//
//        Exception e) {
//            errorColor(driver, "ERROR FULL TEST: " + e, e);
//        }
//
//    }
//
//    // @Test(dataProvider = "data", dataProviderClass = URLDataProvider2.class)
//    public void fullTest2(String data) throws InterruptedException, IOException {
//
//        try {
//            driver2 = setup(driver2);
//            titleColor(driver2, "TEST FULL2");
//            System.out.println(
//                    "Ejecutando prueba para data: " + data + " " + Thread.currentThread().getName());
//
//            List<String> trimData = new ArrayList<>();
//            trimData = separarPorEspacios(data);
//
//            String url = trimData.get(2);
//            String user = trimData.get(1);
//            String pass = trimData.get(0);
//
//            // driver2.get(url);
//            // login(driver2, user, pass, url);
//            // filterNote(driver2, "titulo", "volanta", "copete", "cuerpo");
//            // filterBanner(driver2, "TD AUTOMATION BannerS", "Último año");
//            // filterAttach(driver2);
//            // deleteTag(driver2, "Agrupador TD AUTOMATION");
//            // createSpreadSheet(driver2, "TD AUTOMATION SPREADSHEET");
//            // createTag(driver2, "TD AUTOMATION Tag", "Tema");
//            // createCategory(driver2, "TD AUTOMATION Category");
//            // deleteAttach(driver2, "TD AUTOMATION Imagen Autor");
//            // deleteAttach(driver2, "TD AUTOMATION Imagen");
//            // deleteTDElement(driver2, "Personas", "TD AUTOMATION Persona");
//            // deleteNote(driver2, "TD AUTOMATION Nota");
//            // createAttach(driver2, "Autor", System.getProperty("user.dir") +
//            // "/autor.jpeg", "TD AUTOMATION Imagen Autor");
//            // createPerson(driver2, "TD AUTOMATION Persona", "email@mail.com", "biografia",
//            // "https://twitter.com", "https://facebook.com",
//            // "https://youtube.com", "https://linkedin.com", "apodo", "TD AUTOMATION Imagen
//            // Autor");
//            // createAttach(driver2, "Imagen", System.getProperty("user.dir") +
//            // "/pruebas-evaluacion-1.png", "TD AUTOMATION Imagen");
//            // idImagen = "6249575";
//            // createFreeText(driver2, "TD AUTOMATION TEXTO LIBRE", "PRUEBA TEXTO");
//
//            // createNoteFull(driver2, "TD AUTOMATION Nota", "Volanta auto", "Copete auto",
//            // txtCuerpo,
//            // "TD AUTOMATION Tag", "Tema",
//            // "TD AUTOMATION Category", "TD AUTOMATION Imagen", "Publicado", "TD AUTOMATION
//            // Persona",
//            // "Subtitulo H2", "Adjuntos", user, pass);
//
//            // deleteNote(driver2, "TD AUTOMATION Nota");
//            // deleteTag(driver2, "TD AUTOMATION Tag");
//            // deleteCategory(driver2, "TD AUTOMATION Category");
//            // deleteAttach(driver2, "TD AUTOMATION Imagen Autor");
//            // deleteAttach(driver2, "TD AUTOMATION Imagen");
//
//            // createHeader(driver2, "TD AUTOMATION Cabezal", txtCuerpo,
//            // "https://www.test.com.ar",
//            // "test", "Categorias");
//            // createBanner(driver2, "TD AUTOMATION BannerS", "Script", txtScript, "900",
//            // "600", "TD AUTOMATION Tag",
//            // "Temas",
//            // "Test Categoria");
//            // createBanner(driver2, "TD AUTOMATION BannerI", "Archivo", "test", "1280",
//            // "1000", "TD AUTOMATION Tag",
//            // "Temas",
//            // "Test Categoria");
//            // createSurvey(driver2, "TD AUTOMATION ENCUESTA", "opcion1", "opcion2",
//            // "opcion3");
//            // deleteSurvey(driver2, "TD AUTOMATION ENCUESTA");
//            // deleteBanner(driver2, "TD AUTOMATION BannerS");
//            // deleteBanner(driver2, "TD AUTOMATION BannerI");
//            // deleteHeader(driver2, "TD AUTOMATION Cabezal");
//            // deleteTDElement(driver2, "Personas", "TD AUTOMATION Persona");
//            // deleteTDElement(driver2, "Texto Libre", "TD AUTOMATION TEXTO LIBRE");
//            // deleteTag(driver2, "Agrupador TD AUTOMATION");
//            driver2.close();
//
//        } catch (Exception e) {
//            errorColor(driver2, "ERROR FULL TEST2: " + e, e);
//
//        }
//        endColor(driver2, "TEST FULL2");
//
//    }
//
//    // @Test(dataProvider = "data", dataProviderClass = URLDataProvider3.class)
//    public void fullTest3(String data) throws InterruptedException, IOException {
//
//        try {
//            driver3 = setup(driver3);
//            titleColor(driver3, "TEST FULL3");
//            System.out.println(
//                    "Ejecutando prueba para data: " + data + " " + Thread.currentThread().getName());
//
//            List<String> trimData = new ArrayList<>();
//            trimData = separarPorEspacios(data);
//
//            String url = trimData.get(2);
//            String user = trimData.get(1);
//            String pass = trimData.get(0);
//
//            // driver3.get(url);
//
//            // login(driver3, user, pass, url);
//            // filterNote(driver2, "titulo", "volanta", "copete", "cuerpo");
//            // filterBanner(driver2, "TD AUTOMATION BannerS", "Último año");
//            // filterAttach(driver2);
//            // deleteTag(driver2, "Agrupador TD AUTOMATION");
//            // createSpreadSheet(driver2, "TD AUTOMATION SPREADSHEET");
//            // createTag(driver2, "TD AUTOMATION Tag", "Tema");
//            // createCategory(driver2, "TD AUTOMATION Category");
//            // deleteAttach(driver2, "TD AUTOMATION Imagen Autor");
//            // deleteAttach(driver2, "TD AUTOMATION Imagen");
//            // deleteTDElement(driver2, "Personas", "TD AUTOMATION Persona");
//            // deleteNote(driver2, "TD AUTOMATION Nota");
//            // createAttach(driver2, "Autor", System.getProperty("user.dir") +
//            // "/autor.jpeg", "TD AUTOMATION Imagen Autor");
//            // createPerson(driver2, "TD AUTOMATION Persona", "email@mail.com", "biografia",
//            // "https://twitter.com", "https://facebook.com",
//            // "https://youtube.com", "https://linkedin.com", "apodo", "TD AUTOMATION Imagen
//            // Autor");
//            // createAttach(driver2, "Imagen", System.getProperty("user.dir") +
//            // "/pruebas-evaluacion-1.png", "TD AUTOMATION Imagen");
//            // idImagen = "6249575";
//            // createFreeText(driver2, "TD AUTOMATION TEXTO LIBRE", "PRUEBA TEXTO");
//
//             createNoteFull(driver2, "TD AUTOMATION Nota", "Volanta auto", "Copete auto",
//             txtCuerpo,
//             "TD AUTOMATION Tag", "Tema",
//             "TD AUTOMATION Category", "TD AUTOMATION Imagen", "Publicado", "TD AUTOMATION
//             Persona",
//             "Subtitulo H2", "Adjuntos", user, pass,test);
//
            // deleteNote(driver2, "TD AUTOMATION Nota");
            // deleteTag(driver2, "TD AUTOMATION Tag");
            // deleteCategory(driver2, "TD AUTOMATION Category");
            // deleteAttach(driver2, "TD AUTOMATION Imagen Autor");
            // deleteAttach(driver2, "TD AUTOMATION Imagen");

//            // createHeader(driver2, "TD AUTOMATION Cabezal", txtCuerpo,
//            // "https://www.test.com.ar",
//            // "test", "Categorias");
//            // createBanner(driver2, "TD AUTOMATION BannerS", "Script", txtScript, "900",
//            // "600", "TD AUTOMATION Tag",
//            // "Temas",
//            // "Test Categoria");
//            // createBanner(driver2, "TD AUTOMATION BannerI", "Archivo", "test", "1280",
//            // "1000", "TD AUTOMATION Tag",
//            // "Temas",
//            // "Test Categoria");
//            // createSurvey(driver2, "TD AUTOMATION ENCUESTA", "opcion1", "opcion2",
//            // "opcion3");
//            // deleteSurvey(driver2, "TD AUTOMATION ENCUESTA");
//            // deleteBanner(driver2, "TD AUTOMATION BannerS");
//            // deleteBanner(driver2, "TD AUTOMATION BannerI");
//            // deleteHeader(driver2, "TD AUTOMATION Cabezal");
//            // deleteTDElement(driver2, "Personas", "TD AUTOMATION Persona");
//            // deleteTDElement(driver2, "Texto Libre", "TD AUTOMATION TEXTO LIBRE");
//            // deleteTag(driver2, "Agrupador TD AUTOMATION");
//            driver3.close();
//
//        } catch (Exception e) {
//            errorColor(driver3, "ERROR FULL TEST3: " + e, e);
//        }
//        endColor(driver3, "TEST FULL3");
//
//    }
//
//    @AfterTest
//    public void quit() {
//        // driver.quit();
//        // driver2.quit();
//        // driver3.quit();
//    }
//
//}

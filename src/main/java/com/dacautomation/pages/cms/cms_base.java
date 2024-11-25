package com.dacautomation.pages.cms;
//IMPORTS


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.logging.Level;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.testng.Assert.assertTrue;

public class cms_base {

    public WebDriver driver;

    public cms_base(WebDriver _driver) {
        driver = _driver;
    }

    //VARIABLES

    String tituloNota;
    String idNota;
    boolean ok = false;

    public static boolean hayError = false;
    public static String jobname;
    public static String osName;
    public static final String TEST1 = "\033[42m";   // Fondo verde
    public static final String TEST2 = "\033[44m";    // Fondo azul
    public static final String TEST3 = "\033[45m";  // Fondo púrpura
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";

    //ELEMENTOS WEB
    By headerObjeto;
    static By tituloAdjunto = By.id("descripcion");
    static By toastGuardado = By.xpath("//*[contains(text(),'El contenido ha sido guardado.')]");
    By progressBar = By.xpath("//div[@class='progress']//div[@class='indeterminate']");
    By inputNombreObjeto = By.xpath("//input[@id='nombre']");
    By jsonIdNota = By.xpath("/html/body/pre");
    static By inputFiltrar = By.xpath("//input[@id='text']");
    By btnInfo = By.xpath("//div//span[@class='icon info-publish']");
    By btnEliminar = By.xpath("//a[text()='Eliminar']");
    By btnSi = By.xpath("//*[@id='modalConfirm']/div[4]/a[1]");
    static By btnNuevo = By.id("nuevo");
    By inputLoginUser = By.id("usuario");
    By inputLoginPass = By.id("password");
    By btnLogin = By.xpath("//a[text()='Ingresar']");
    static By calendarMonth = By.xpath("//div[@class='select-wrapper select-month']//input");
    By calendarYear = By.xpath("//div[@class='select-wrapper select-year']//input");
    static By calendarDay = By.xpath("//tr//td//button[@data-day='9']");
    By lblNotFound = By.xpath("//*[text()='No se han encontrado resultados']");
    By lblNotFound2 = By.xpath("//*[text()='No se encontraron resultados para su busqueda']");
    static By btnGrabar = By.xpath("//div[@id='save-button']");
    By cmsListMode = By.xpath("//div[@class=\"cms-note-list list-mode\"]");
    By cmsCardMode = By.xpath("//div[@class=\"cms-attachments card-mode\"]");
    By btnTipoDeTexto = By.xpath("(//button[@title='Párrafo'])[1]");
    By infoWrapper = By.xpath("//div[@class='content']//div[@class='info-wrapper']");
    static By btnRestaurarTodo = By.xpath("//div[@class='restore-abs']");
    static By spanTituloElemento = null;
    By materialIcons = By.xpath("//span[@class='active']//i[@class='material-icons']");
    static By inputAgrupadoresNota = By.xpath("//input[@id='arrAgrupadores_input']");
    static By optionAgrupadores = By.xpath("//li//span[text()='Tema » Test']");
    static By inputCategoriasNota = By.xpath("//input[@id='arrCategorias_input']");
    static By optionCategorias = By.xpath("//span[text()='test']");
    static By checkboxAdjunto = By.xpath("//*[@id='FileList_7162368_item']/figure/div");
    static By btnRelacionarNota = By.xpath("//*[@id='FileList_result_items']/div/div[2]/div[1]/a");
    //METODOS
    public static void click(WebDriver driver, By locator, String nombreElemento, String test) {
        try {
            String scriptJSClick = "arguments[0].click()";
            esVisibleTest(driver,locator,test);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            WebElement wElement = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wElement);
            js.executeScript(scriptJSClick, wElement);
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO CLICK " + nombreElemento, e, test);
        }
    }


    public static void clickJS(WebDriver driver, By locator, String nombreElemento, String test) {
        try {
            String scriptJSClick = "arguments[0].click()";
            estaPresenteTest(driver,locator,test);
            WebElement wElement = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wElement);
            js.executeScript(scriptJSClick, wElement);

        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO CLICKJS " + nombreElemento, e, test);
        }
    }



    public void clickImplicit(WebDriver driver, By locator, String nombreElemento, String test) {
        try {
//
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(locator).click();
//
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO CLICK IMPLICIT " + nombreElemento, e, test);
        }
    }

    public static void sendKeys(WebDriver driver, By locator, String text, String nombreElemento, String test) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            WebElement cuadroTexto = driver.findElement(locator);
            cuadroTexto.clear();
            cuadroTexto.sendKeys(text);
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO SEND KEYS " + nombreElemento, e, test);
        }

    }
    public static void sendKeys2(WebDriver driver, By locator, String text, String nombreElemento, String test) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            WebElement cuadroTexto = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cuadroTexto);
            cuadroTexto.clear();
            cuadroTexto.sendKeys(text);
            cuadroTexto.sendKeys(Keys.ENTER);
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO SEND KEYS2 " + nombreElemento, e, test);
        }

    }

    public static void sendKeys3(WebDriver driver, By locator, String text, String nombreElemento, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement cuadroTexto = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            cuadroTexto.clear();
            cuadroTexto.sendKeys(text);
            cuadroTexto.sendKeys(Keys.ENTER);
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO SEND KEYS3 " + nombreElemento, e, test);
        }

    }

    public void sendKeys4(WebDriver driver, By locator, String text, String nombreElemento, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            WebElement cuadroTexto = driver.findElement(locator);
            wait.until(ExpectedConditions.visibilityOf(cuadroTexto));
            cuadroTexto.clear();
            cuadroTexto.sendKeys(text);
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO SEND KEYS " + nombreElemento, e, test);
        }

    }
    public static void clickF(WebDriver driver, By locator, String nombreElemento, String test) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Boolean wElement = wait.until(ExpectedConditions.or(ExpectedConditions.presenceOfElementLocated(locator),ExpectedConditions.visibilityOfElementLocated(locator),ExpectedConditions.elementToBeClickable(locator),ExpectedConditions.elementToBeSelected(locator)));

            if (wElement) {
                driver.findElement(locator).click();
            }

        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO CLICKF " + nombreElemento, e, test);
        }
    }



    public static void checkTitlePage(WebDriver driver, String title, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.titleContains(title));
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO VER TITULO PAGINA " + title, e, test);
        }

    }


    public static void visibilityOf(WebDriver driver, By locator, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement wElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if (wElement == null) {
                System.out.println("15");
                wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "NO SE PUDO VERIFICAR LA VISIBILIDAD DEL OBJETO " + locator.toString(), e, test);
        }
    }

//    public void esVisible2(WebDriver driver, By locator, String test) {
//
//        try {
//            // Espera inicial de 3 segundos
//            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
//            shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//
//        } catch (TimeoutException e) {
//                // Espera extendida de 15 segundos si no lo encuentra en 3 segundos
//                WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
//                longWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//            }
//        }
//    }


    public static void esClickeable(WebDriver driver, By locator, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "NO SE PUDO VERIFICAR LA VISIBILIDAD DEL OBJETO " + locator.toString(), e, test);
        }
    }

    public static boolean esInvisibleR(WebDriver driver, By locator, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "NO SE PUDO VERIFICAR LA VISIBILIDAD DEL OBJETO " + locator.toString(), e, test);
            return false;
        }
    }

    public static boolean esVisibleR(WebDriver driver, By locator, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(locator)));

        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "NO SE PUDO VERIFICAR LA VISIBILIDAD DEL OBJETO " + locator.toString(), e, test);
            return false;
        }
    }

    public static boolean estaPresenteR(WebDriver driver, By locator, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            return wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(locator)));

        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "NO SE PUDO VERIFICAR LA VISIBILIDAD DEL OBJETO " + locator.toString(), e, test);
            return false;
        }
    }

    public static void esVisible2(WebDriver driver, By locator, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "NO SE PUDO VERIFICAR LA VISIBILIDAD DEL OBJETO " + locator.toString(), e, test);
        }
    }


    public static void visibilityOf2(WebDriver driver, By locator, String test) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement element = driver.findElement(locator);
            if (element == null) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.findElement(locator);
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO VISIBILITYOF2 " + locator.toString(), e, test);
        }
    }

    public static boolean visibilityOfReturn(WebDriver driver, By locator, String test) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement element = driver.findElement(locator);
            if (element.isEnabled()) {
                return true;
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO VISIBILITYOFRETURN " + locator.toString(), e, test);
        }
        return false;
    }


    public static boolean visibilityOfReturn3(WebDriver driver, By locator, String test) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement element = driver.findElement(locator);
            if (element.isEnabled()) {
                return true;
            } else {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                if (elemento.isDisplayed()) {
                    return true;
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO visibilityOfReturn3 " + locator.toString(), e, test);
        }
        return false;
    }


    public static boolean presenceOfReturn(WebDriver driver, By locator, String test) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement element = driver.findElement(locator);
            if (element != null) return true;
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO presenceOfReturn " + locator.toString(), e, test);
        }
        return false;
    }

    public static void presenceOf(WebDriver driver, By locator, String test) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            WebElement element = driver.findElement(locator);
            if (element == null) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.findElement(locator);
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO presenceOf " + locator.toString(), e, test);
        }
    }

    public static void presenceExplicit(WebDriver driver, By locator, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO presenceExplicit " + locator.toString(), e, test);
        }
    }

    public static By setHeaderNote(String titulo) {
        tituloNota = titulo;
        return By.xpath("//h2[contains(text(),'" + titulo + "')]");
    }

    public By setIdNote(String id) {
        idNota = id;
        return By.xpath("//pre[contains(text(), '\"id\":" + id + "')]");
    }

    public String getNoteIdApi(String url) {
        String[] parts = url.split("/");
        return parts[parts.length - 1];
    }


    public void checkTextElement(WebDriver driver, By element, String value, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            if (!driver.findElement(element).getText().contains(value)) {
                wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO checkTextElement " + value, e, test);
        }
    }

    public void checkTextElementWeb(WebDriver driver, WebElement element, String value, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            wait.until(ExpectedConditions.visibilityOf(element));
            if (!element.getText().contains(value)) {
                wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.visibilityOf(element));
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO checkTextElement " + value, e, test);
        }
    }

    public boolean checkTextElement2(WebDriver driver, By element, String value, String test) {
        boolean value2;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            value2 = driver.findElement(element).getText().contains(value);
            return value2;
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {

            errorColor(driver, "METODO checkTextElement2 " + value, e, test);

        }
        return false;
    }


    public static void errorColor(WebDriver driver, String elemento, Exception e, String test) {


        while (!hayError) {
            try {
                System.out.println(ANSI_RED + "[ERROR " + test.toUpperCase() + "]: " + ANSI_RESET);
                System.out.println("ELEMENTO: " + elemento + " RAZON: " + errorCorto(e));
                System.out.println(ANSI_RED);
                printStack(e);
                System.out.println(ANSI_RESET);
                System.out.println("PORTAL DONDE SE DIO EL ERROR: " + driver.getCurrentUrl());
                screenshot(driver, test);
                driver.quit();
                Runtime.getRuntime().exec("pkill -f chrome");
            } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException | IOException error) {
                System.out.println("ERROR: " + error.getMessage());
            }
            hayError = true;
        }

    }

    public static void COLORTEST1(String mensaje) {
        if (!hayError) {
            System.out.println(TEST1 + ANSI_BLACK + "[TEST1]: " + mensaje + ANSI_RESET);
        }
    }

    public static void COLORTEST2(String mensaje) {
        if (!hayError) {
            System.out.println(TEST2 + ANSI_BLACK + "[TEST2]: " + mensaje + ANSI_RESET);
        }
    }

    public static void COLORTEST3(String mensaje) {
        if (!hayError) {
            System.out.println(TEST3 + ANSI_BLACK + "[TEST3]: " + mensaje + ANSI_RESET);
        }
    }

    public static void SELECTCOLOR(String test, String mensaje) {
        if (!hayError) {
            if (test.equals("TEST1")) {
                System.out.println(TEST1 + ANSI_BLACK + "[TEST1]: " + mensaje + ANSI_RESET);
            } else if (test.equals("TEST2")) {
                System.out.println(TEST2 + ANSI_BLACK + "[TEST2]: " + mensaje + ANSI_RESET);
            } else {
                System.out.println(TEST3 + ANSI_BLACK + "[TEST3]: " + mensaje + ANSI_RESET);
            }
        }
    }


    // METODOS

    public static WebDriver setup(WebDriver explorer, String test) {
        try {
            System.setProperty("webdriver.chrome.silentOutput", "true");
            WebDriverManager.chromedriver().setup();
            String chromedriverbinary = System.getenv("CHROMEDRIVER_BINARY");
            if (chromedriverbinary != null) System.setProperty("webdriver.chrome.driver", chromedriverbinary);
            Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-debugging-pipe");
            options.addArguments("--log-level=3");
            options.addArguments("--silent");
            options.addArguments("--guest");
            options.addArguments("--start-maximized");
            String chromebinary = System.getenv("CHROME_BINARY");
            if (chromebinary != null) options.setBinary(chromebinary);
            explorer = new ChromeDriver(options);
            if (System.getProperty("os.name").equals("Mac OS X")) {
                explorer.manage().window().setPosition(new Point(0, 0)); // Ajusta las coordenadas según la resolución de tu pantalla
                explorer.manage().window().setSize(new Dimension(1680, 1050));
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
//            errorColorM(explorer, "NO SE PUDO INICIAR CHROME: ", e, test);
            e.printStackTrace();
        }
        return explorer;
    }


    public void verifyIfElementExists(WebDriver driver, String nombreElemento, By header, String modulo, String test) {
        try {

            //VERIFICO SI HAY OBJETO PRESENTE
            boolean avanzar = false;
            sendKeys(driver, inputFiltrar, nombreElemento, "TEXTBOX FILTRAR", test);
            esVisibleTest(driver,btnNuevo,test);
            WebElement elementoVisible = esperarElementoWeb(driver,test,header,modulo);
            WebElement elementoWebNulo = esperar2Elementos(driver, test, lblNotFound, lblNotFound2, modulo);
            if (elementoWebNulo == null && elementoVisible!=null) {

                if (nombreElemento.contains("Imagen") || nombreElemento.contains("prueba"))
                {
                    esVisibleTest(driver, materialIcons, test);
                    boolean objetoPresente = isElementPresent3(driver, header, test);
                    if (objetoPresente) {
                        avanzar = true;
                    }
                } else if (!nombreElemento.contains("Imagen") || !nombreElemento.contains("prueba")) {
                        esVisibleTest(driver, header, test);
                        boolean infoWrapperW = isElementPresent3(driver, infoWrapper, test);
                        boolean objetoVisible = esVisibleR(driver, header, test);
                            if (objetoVisible && infoWrapperW) {
                                avanzar = true;
                            }
                 } else {
                        esVisibleTest(driver, materialIcons, test);
                        esVisibleTest(driver, header, test);
                        boolean infoWrapperW = isElementPresent3(driver, infoWrapper, test);
                        boolean objetoVisible = esVisibleR(driver, header, test);
                            if (objetoVisible && infoWrapperW) {
                                avanzar = true;
                            }
                }

            }

                //AVANZO SI HAY OBJETO PRESENTE
                if ( avanzar) {
                    String titulo = driver.getTitle();
                    if (titulo.contains(modulo)) {
                        esVisibleTest(driver,btnNuevo,test);
                        By numeroArticulos = By.xpath("//article");
                        int articulos = contarArticulos(driver, numeroArticulos, test);
                        while (articulos != 0) {
                            if(nombreElemento.contains("Imagen") || nombreElemento.contains("prueba")) {
                                clickJS(driver,header,header.toString(),test);
                            }else{
                                click(driver,header,header.toString(),test);

                            }
                                switchToTabWithTitle(driver, nombreElemento, test);
                                By infoSpan = By.xpath("//div[@class='info']//span[contains(text(),'" + nombreElemento + "')]");
                                boolean spanOk = isElementVisible3(driver, infoSpan,test);
                                if (spanOk) {
                                    Set<String> ventanasActuales = driver.getWindowHandles();
                                    int size1 = ventanasActuales.size();
                                    click(driver, btnInfo, "BOTON 3 PUNTOS", test);
                                    click(driver, btnEliminar, "BOTON ELIMINAR", test);
                                    clickJS(driver, btnSi, "BOTON SI", test);
                                    Thread.sleep(3000);
                                    ventanasActuales = driver.getWindowHandles();
                                    int size2 = ventanasActuales.size();
                                    if(size1==size2){
                                        driver.switchTo().frame("card");
                                        By btnAceptarImg = By.xpath("(//div//a[contains(text(),'Aceptar')])[1]");
                                        if(nombreElemento.contains("Imagen") && isElementVisible(driver,btnAceptarImg)){
                                            clickJS(driver,btnAceptarImg,"BOTON ACEPTAR",test);
                                        }
                                    }

                                }
                                switchToTabWithTitle(driver, modulo, test);
                                sendKeys(driver, inputFiltrar, nombreElemento, "TEXTBOX FILTRAR", test);
                                WebElement elementoWeb2 = esperarElementoWeb(driver, test, header, modulo);
                                if (elementoWeb2 == null) {
                                 break;
                                }else{
                                    articulos = contarArticulos(driver, numeroArticulos, test);
                                }
                        }
                    }
                }


        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException | InterruptedException e) {
            errorColor(driver, "METODO verifyIfElementExists " + nombreElemento, e, test);
        }
    }

    private static String definirModulo(WebDriver driver, String modulo) {
        String moduloMain = null;

        if (modulo.contains("Tags")) {
            moduloMain = "Tags";
        } else if (modulo.contains("")) {
            moduloMain = "Archivos";
        } else if (driver.getCurrentUrl().endsWith("backend/administrator/notas")) {
            moduloMain = "Contenidos";
        } else if (driver.getCurrentUrl().endsWith("backend/administrator/agrupadoresContenido")) {
            moduloMain = "Agrupadores";
        } else if (driver.getCurrentUrl().endsWith("backend/administrator/cateogorias")) {
            moduloMain = "Categorias";
        }
        return moduloMain;
    }


    public void cambiarPestania(WebDriver driver, String modulo, String test) {
        try {
            Set<String> allTabs = driver.getWindowHandles();
            List<String> tabList = new ArrayList<>(allTabs);
            int keywordTabIndex = -1;
            for (int i = 0; i < tabList.size(); i++) {
                driver.switchTo().window(tabList.get(i));
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl.contains(modulo)) {
                    keywordTabIndex = i;
                    break;
                }
            }

            if (keywordTabIndex != -1) {
                for (int i = keywordTabIndex + 1; i < tabList.size(); i++) {
                    driver.switchTo().window(tabList.get(i));
                    driver.close();
                }
                driver.switchTo().window(tabList.get(keywordTabIndex));
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO cambiarPestania " + modulo, e, test);
        }

    }

    public static void scrollUp(WebDriver driver, WebElement elemento, String test) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", elemento);

        } catch (Exception e) {
            errorColor(driver, "NO SE PUDO SCROLLEAR HACIA ARRIBA", e, test);
        }
    }



    public static String obtenerEstado(WebElement elemento) {
        String valor = "";
        if (elemento.getText().equals("PUBLICADO")) {
            valor = "Publicado";
        } else if (elemento.getText().equals("EN EDICIÓN")) {
            valor = "En Edición";
        }
        return valor;
    }

    public boolean login(WebDriver driver, String user, String pass, String urlR, boolean okLogin, String test) {
        try {
            String urlCompleta = "https://" + urlR + "/backend/";
            driver.get(urlCompleta);
            if (!okLogin) {
                System.out.println(urlCompleta);


            }
            boolean checkLogin = isElementPresent(driver, inputLoginUser);
            if (checkLogin) {
                sendKeys(driver, inputLoginUser, user, "INPUT USER LOGIN", test);
                Thread.sleep(1500);
                sendKeys(driver, inputLoginPass, pass, "INPUT PASSWORD LOGIN", test);
                click(driver, btnLogin, "BOTON LOGIN", test);
                okLogin = true;
            } else if (!esURLValida(urlR)) {
                okLogin = false;
            }
            return okLogin;
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException | InterruptedException e) {
            errorColor(driver, "METODO LOGIN ", e, test);

            return okLogin;
        }

    }

    public static boolean esURLValida(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            return responseCode >= 200 && responseCode < 300;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public String readFile(String direccion) throws IOException {
        FileInputStream fis = new FileInputStream(direccion);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String everything;
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }
        return everything;
    }

    public static List<String> initializeAWS() {
        ArrayList<Parameter> jobConfig = new ArrayList<>();
        try {
            // El nombre del job viene por variable de ambiente

            osName = System.getenv("HOME");
            if (osName.contains("jenkins")) { jobname = System.getenv("JOB_NAME");}
            else { jobname = "CMS4-Staging/Indalo-Staging";}

            if (jobname == null) {
                System.err.println("ERROR: No se encuentra nombre del job");
                System.exit(2);
            }

            // Creo el cliente de SSM
            Region region = Region.US_EAST_1;
            SsmClient ssmClient = SsmClient.builder().region(region).build();

            // Loop para traer los parametros, por el límite de 10
            String nextToken = null;
            //noinspection LoopConditionNotUpdatedInsideLoop
            while (Boolean.TRUE) {
                GetParametersByPathRequest parameterRequest = GetParametersByPathRequest.builder()
                        .path("/thinkindot/jenkins/job/" + jobname).recursive(Boolean.TRUE).withDecryption(Boolean.TRUE)
                        .nextToken(nextToken).build();
                GetParametersByPathResponse parameterResponse = ssmClient.getParametersByPath(parameterRequest);
                jobConfig.addAll(parameterResponse.parameters());
                nextToken = parameterResponse.nextToken();
                if (nextToken == null)
                    break;
            }
        } catch (ParameterNotFoundException e) {

            // No sé en cuenta el parametro, muestro warning, pero, retorno OK (puede no estar
            // configurado adrede)
            System.err.println("ATENCION: No se encuentra configuracion para el job en Parameter Store");
            System.err.println(e.getMessage());
            System.exit(0);
        } catch (SsmException e) {

            // Una excepcion generica de SSM, retorno INESTABLE para que haya que revisar
            // que paso
            System.out.println("ATENCION: Se ha generado una excepcion de SSM");
            System.exit(2);
        } catch (Exception e) {

            // Una excepcion generica del SDK, retorno INESTABLE para que haya que revisar
            // que paso
            System.out.println("ATENCION: Se ha generado una excepcion de SDK");
            System.exit(2);
        }
        if (jobConfig.isEmpty()) {
            // Se encuentra el parametro en SSM, pero, esta vacio, retorno OK
//            System.err.println("ATENCION: La configuracion para el job en Parameter Store esta vacia, JOBNAME: "+System.getenv("JOB_NAME")+" PATH: "+System.getenv("PATH"));
             System.err.println("ATENCION: La configuracion para el job en Parameter Store esta vacia");
            System.exit(0);
        }
        List<String> urls = new ArrayList<>();
        List<String> names = new ArrayList<>();

        HashMap<String, HashMap<String, HashMap<String, String>>> jobConfigMap = new HashMap<>();
        jobConfig.forEach(
                item -> {
                    ArrayList<String> path = new ArrayList<>(Arrays.asList(item.name().split("/")));
                    String name = path.get(path.size() - 3);
                    String type = path.get(path.size() - 2);
                    String attr = path.get(path.size() - 1);
                    String value = item.value();
                    HashMap<String, HashMap<String, String>> site = jobConfigMap.get(name);
                    if (site == null)
                        site = new HashMap<>();
                    HashMap<String, String> config = site.get(type);
                    if (config == null)
                        config = new HashMap<>();
                    config.put(attr, value);
                    site.put(type, config);
                    jobConfigMap.put(name, site);

                    if (type.equals("back")) {
                        names.add(name);
                    }

                });
        String cadenaOriginal = names.toString();
        // Eliminar corchetes y dividir la cadena en elementos
        String[] elementos = cadenaOriginal.replaceAll("\\[|\\]", "").split(", ");
        Set<String> conjuntoSinDuplicados = new HashSet<>(Arrays.asList(elementos));
        List<String> listaSinDuplicados = new ArrayList<>(conjuntoSinDuplicados);
        for (String elemento : listaSinDuplicados) {
            String datosList = jobConfigMap.get(elemento).toString();
            urls.add(trimUrlAWS2(datosList));
        }

        List<String> filtrados = new ArrayList<>();
        List<String> listaFinal = new ArrayList<>();

        for (String item : urls) {
            if (jobname.contains("GrupoAmerica") && item.contains("a24") || item.contains("diariouno") || item.contains("americatv")) {
                filtrados.add(item);
            }
            else if(jobname.contains("Ladevi")&& item.contains("viajando-argentina.backend.thinkindot.com") || item.equals("viajando.backend.thinkindot.com") || item.contains("ladevi.backend.thinkindot.com") ||
                    item.contains("ladevi_info") || item.contains("argentina_viajando") || item.contains("viajando_travel") ){
                filtrados.add(item);
            }

            if (jobname.contains("GrupoAmerica") || jobname.contains("Ladevi")) {
                listaFinal = filtrados;
            } else {
                listaFinal = urls;
            }
        }

        return listaFinal;

    }

    //            }else if(jobname.contains("Ladevi") && item.contains("ladevi_info") || item.contains("argentina_viajando") || item.contains("viajando_travel") ||
//                    item.contains("ladevi.info") || item.contains("argentina.viajando") || item.contains("viajando.travel"))
//            {
//                filtrados.add(item);
//            }


//        if(jobname.contains("GrupoAmerica") || jobname.contains("Ladevi")){


    public static String trimUrlAWS2(String cadena) {


        // Eliminar caracteres innecesarios y separar en partes según las claves
        String[] partes = cadena.split("(?=\\{)|(?<=\\})");
        StringBuilder back = new StringBuilder();
        StringBuilder front = new StringBuilder();

        for (String parte : partes) {
            if (parte.contains("back")) {
                String[] claveValor = parte.replaceAll("[{}]", "").split(", ");
                for (String par : claveValor) {
                    String[] subPar = par.split("=");
                    if (subPar[0].equals("user") || subPar[0].equals("pass") || subPar[0].equals("url")) {
                        back.append(subPar[1]).append(", ");
                    }
                }
            } else if (parte.contains("front")) {
                String[] claveValor = parte.replaceAll("[{}]", "").split(", ");
                for (String par : claveValor) {
                    String[] subPar = par.split("=");
                    if (subPar[0].equals("user") || subPar[0].equals("pass") || subPar[0].equals("url")) {
                        front.append(subPar[0]).append(", ");
                    }
                }
            }
        }

        // Mostrar los valores de las claves específicas para back y front si hay datos
        if (back.length() < 0) {
            System.out.println("No se encontraron datos para 'back'.");
        }

        String[] valores = back.toString().split(", ");
        return back.toString();

    }

    public static String trimUrlAWS(String data) {
        String input = data;
        // Eliminar caracteres innecesarios y separar en partes según las claves
        String[] partes = input.split("(?=\\{)|(?<=\\})");
        StringBuilder back = new StringBuilder();
        StringBuilder front = new StringBuilder();

        for (String parte : partes) {
            if (parte.contains("back")) {
                String[] claveValor = parte.replaceAll("[{}]", "").split(", ");
                for (String par : claveValor) {
                    String[] subPar = par.split("=");
                    if (subPar[0].equals("user") || subPar[0].equals("pass") || subPar[0].equals("url")) {
                        back.append(subPar[1]).append(", ");
                    }
                }
            } else if (parte.contains("front")) {
                String[] claveValor = parte.replaceAll("[{}]", "").split(", ");
                for (String par : claveValor) {
                    String[] subPar = par.split("=");
                    if (subPar[0].equals("user") || subPar[0].equals("pass") || subPar[0].equals("url")) {
                        front.append(subPar[0]).append(", ");
                    }
                }
            }
        }

        // Mostrar los valores de las claves específicas para back y front si hay datos
        if (back.length() > 0) {
            System.out.println("back=" + back.substring(0, back.length() - 2)); // Eliminar la última coma y espacio
        } else {
            System.out.println("No se encontraron datos para 'back'.");
        }

        if (front.length() > 0) {
            System.out.println("front=" + front.substring(0, front.length() - 2)); // Eliminar la última coma y espacio
        } else {
            System.out.println("No se encontraron datos para 'front'.");
        }
        // Elimina las llaves iniciales y finales
        System.out.println("input: " + input);
        input = input.substring(0, input.length());
        System.out.println("input2: " + input);

        // Divide la cadena en pares clave-valor utilizando comas y espacios como
        // separadores
        String[] keyValuePairs = input.split(",\\s+");

        // Crea un mapa para almacenar los pares clave-valor
        Map<String, String> keyValueMap = new HashMap<>();

        // Itera a través de los pares clave-valor y los almacena en el mapa
        for (String keyValuePair : keyValuePairs) {
            System.out.println("valuepairs: " + keyValuePair);

            String[] parts = keyValuePair.replaceAll("[{}]", "").split("=");

            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                keyValueMap.put(key, value);
            }
        }

        // Accede a los valores individuales por clave
        String url = keyValueMap.get("url");
        String user = keyValueMap.get("user");
        String pass = keyValueMap.get("pass");
        System.out.println("SIZE: " + keyValueMap.size());
        System.out.println("SIZE: " + keyValueMap.keySet());

        System.out.println("user: " + user);
        System.out.println("url: " + url);
        System.out.println("pass: " + pass);
        return url + " " + user + " " + pass;
    }

    public static List<String> separarPorEspacios(List<String> cadena) {
        List<String> extractedValues = new ArrayList<>();
        for (String entry : cadena) {
            String values = Arrays.toString(entry.split(",\\s*"));
            extractedValues.add(values);
        }
        return extractedValues;
    }

    public static boolean encontrarElemento(WebDriver driver, By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            boolean isPresent = isElementPresent(driver, locator);
            if (!isPresent) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.findElement(locator);
            }
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
//            errorColorM(driver, "NO SE PUDO ENCONTRAR EL OBJETO (XPATH): "+locator.toString(), e);
            return false;
        }
    }


    public static boolean encontrarElemento2(WebDriver driver, By locator, String test) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            boolean isPresentAndNotVisible = isElementPresentAndNotVisible(driver, locator);
            if (!isPresentAndNotVisible) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
                driver.findElement(locator);
            }
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "BANNER NOMBRE ELEMENTO: "+locator.toString(), e ,test);
            return false;
        }
    }


//    public static boolean isElementPresent(WebDriver driver, By locator) {
//        try {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//            driver.findElement(locator);
//            return true;
//        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
//            return false;
//        }
//    }

    public static boolean isElementPresent2(WebDriver driver, By locator, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.isDisplayed();

        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO isElementPresent2 " + locator.toString(), e, test);
            return false;
        }
    }

    public void clickBotonSiBorrar(WebDriver driver, String test) {
        boolean btnSiWE = encontrarElemento(driver, btnSi);
        if (btnSiWE) {
            clickImplicit(driver, btnSi, "BOTON SI", test);
        }
    }

    public static void waitSpanElementNameInEditor(WebDriver driver, String nombreElemento, String modulo, String test) {
        try {
            spanTituloElemento = By.xpath("//div[@class='header-modifier card']//following::span[contains(text(),'" + nombreElemento + "')]");
            boolean BspanTituloElemento = encontrarElemento2(driver, spanTituloElemento,test);
            if(BspanTituloElemento){
                assertTrue(true);
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "NO SE VERIFICAR EL NOMBRE EN EL BANNER (XPATH): " + spanTituloElemento.toString(), e, test);
        }
    }


    public static List<List<String>> divideListInThree(List<String> originalList) {
        int totalSize = originalList.size();
        int partSize = totalSize / 3;
        int remainder = totalSize % 3;
        List<List<String>> dividedLists = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            dividedLists.add(new ArrayList<>());
        }
        int currentIndex = 0;
        for (int i = 0; i < 3; i++) {
            int currentPartSize = partSize + (remainder > 0 ? 1 : 0);
            remainder--;

            for (int j = 0; j < currentPartSize; j++) {
                dividedLists.get(i).add(originalList.get(currentIndex++));
            }
        }

        return dividedLists;
    }

    public static String[] procesarString(String input) {
        String sinCorchetes = input.substring(1, input.length() - 1);
        return sinCorchetes.split(", ");
    }

    public static void esperarToast(WebDriver driver,String nombreElemento, String modulo, String test) {
        try {
         waitSpanElementNameInEditor(driver,nombreElemento,modulo, test);
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(cms_base.ultimoSegmentoEsNumerico());
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException  e) {
            errorColor(driver, "METODO esperarToast ", e, test);
        }
    }

    public static void clearDirectory(String directoryPath) { //test2
        Path path = Paths.get(directoryPath);
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (Path filePath : directoryStream) {
                Files.delete(filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isElementPresentAndNotVisible(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return !element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static void invisibilityOf(WebDriver driver, By locator, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            errorColor(driver, "NO SE PUDO DETECTAR SI EL ELEMENTO ESTA INVISIBLE",e,test);
        }
    }

    public static int contarArticulos(WebDriver driver, By locator, String test) {
        try {
            return driver.findElements(locator).size();
        } catch (Exception e) {
            errorColor(driver, "METODO contarArticulos ", e, test);
        }
        return 0;

    }

    private static void printStack(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement elemento : stackTrace) {
            if (elemento.getClassName().startsWith("com.dacautomation")) {
                System.out.println(elemento);
            }
        }
    }

    public static String errorCorto(Exception e) {
        String mensajeCompleto = e.toString();
        return mensajeCompleto.split("\n")[0];
    }

    public static void pestaniaTriple(WebDriver driver, String test) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            if (tabs.size() == 3) {
                driver.switchTo().window(tabs.get(2));
                driver.close();
                tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
            }
        } catch (Exception e) {
//            errorColorM(driver, "NO SE PUDO CAMBIAR DE PESTAÑA ", e, test);

        }
    }

    public static boolean visibilityOfReturn4(WebDriver driver, By locator, String test) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement element = driver.findElement(locator);
            if (element.isEnabled()) {
                return true;
            } else {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                if (elemento.isDisplayed()) {
                    return true;
                }
            }
        } catch (Exception e) {
//            errorColorM(driver, "NO SE PUDO DETERMINAR LA VISIBILIDAD DEL OBJETO (XPATH): " + locator.toString(), e, test);
        }
        return false;
    }

    public static void cleanScreenshots(boolean testOk) {

        if (testOk) {
            if (!System.getProperty("os.name").contains("Mac OS X")) {
                String portalName = System.getenv("JOB_NAME");
                File directory = new File(portalName + "/Screenshots/");

                if (directory.exists()) {
                    File[] files = directory.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (file.isFile()) {
                                file.delete();
                            }
                        }
                    }
                }
            }

        }
    }

    public static String clickNoEncontrado(String nombreElemento, By locator) {
        return "NO SE PUDO CLICKEAR EL ELEMENTO " + nombreElemento.toUpperCase() + " " + locator.toString();
    }

    public static String textoNoEncontrado(String nombreElemento, String text, By locator) {
        return "NO SE PUDO ENVIAR EL TEXTO " + text + " AL ELEMENTO " + nombreElemento.toUpperCase() + " " + locator.toString();
    }

    public void esperarModuloCategoria(WebDriver driver, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
            wait.until(ExpectedConditions.visibilityOfElementLocated(btnNuevo));
        } catch (Exception e) {
            errorColor(driver, "METODO esperarModuloCategoria ", e, test);
        }
    }

    public static void screenshot(WebDriver driver, String test) {
        try {
            String filePath = "";
            if (System.getProperty("os.name").equals("Mac OS X")) {
                filePath = "Screenshots/" + test + ".png";
            } else if (System.getProperty("os.name").equals("Linux")) {
                filePath = System.getenv("SCREENSHOT_PATH") + "/" + System.getenv("JOB_NAME") + "/" + System.getenv("BUILD_NUMBER") + "/" + "screen.png";
            }

            File screenshotFile = new File(filePath);
            File screenshotDir = screenshotFile.getParentFile(); // Obtener la carpeta de destino

//            Robot robot = new Robot();
//            // Obtener el tamaño de la pantalla
//            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
//            // Capturar la pantalla completa
//            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
//
//            ImageIO.write(screenFullImage, "png", new File(filePath));
//
//            System.out.println("LA CAPTURA SE GUARDO EN: " + filePath);

//             Crear las carpetas si no existen
            if (!screenshotDir.exists()) {
                if (!screenshotDir.mkdirs()) {
                    System.out.println("No se pudo crear el directorio " + screenshotDir.getAbsolutePath());
                    return;
                }
            }

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileHandler.copy(screenshot, screenshotFile);
                System.out.println("LA CAPTURA SE GUARDO EN: " + filePath);
            } catch (IOException e) {
                System.out.println("NO SE PUDO GUARDIAR LA CAPTURA: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void encontrarPestaniaCorrecta(WebDriver driver, String test, String modulo) {
        try {
            String originalTab = driver.getWindowHandle();
            Set<String> allTabs = driver.getWindowHandles();
            for (String tab : allTabs) {
                driver.switchTo().window(tab);
                String currentUrl = driver.getCurrentUrl();
                if (!currentUrl.endsWith("/backend/administrator/" + modulo.toLowerCase())) {
                    driver.close();
                }
            }
            if (driver.getWindowHandles().contains(originalTab)) {
                driver.switchTo().window(originalTab);
            } else {
                for (String tab : driver.getWindowHandles()) {
                    driver.switchTo().window(tab);
                    break;
                }
            }

        } catch (Exception e) {
            errorColor(driver, "METODO encontrarPestañaCorrecta ", e, test);
        }
    }

    public static boolean isElementVisible(WebDriver driver, By locator, String test) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(locator)));
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            errorColor(driver, "METODO isElementVisible ", e, test);
            return false;
        }
    }

    public static boolean isElementVisible3(WebDriver driver, By locator,String test) {
        try {
            // Esperar hasta que el elemento esté presente en el DOM y sea visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(locator),ExpectedConditions.visibilityOfElementLocated(locator)));
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            // Si no se encuentra el elemento o se referencia un elemento obsoleto, devolvemos false
            return false;
        }
    }

    public static boolean isElementPresent3(WebDriver driver, By locator, String test) {
        try {
            // Esperar hasta que el elemento esté presente en el DOM y sea visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            return wait.until(ExpectedConditions.or(ExpectedConditions.presenceOfElementLocated(locator)));
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            // Si no se encuentra el elemento o se referencia un elemento obsoleto, devolvemos false
            return false;
        }
    }


    public static WebElement esperar2Elementos(WebDriver driver, String test, By locator1, By locator2, String modulo) {
        WebElement elementoWeb = null;
        try {
            try {
                boolean elementoVisible = isElementVisible3(driver, locator1,test);
                if (elementoVisible) {
                    elementoWeb = driver.findElement(locator1);
                    return elementoWeb;
                } else {
                    boolean elementoVisible2 = isElementVisible3(driver, locator2,test);
                    if (elementoVisible2) {
                        elementoWeb = driver.findElement(locator2);
                        return elementoWeb;
                    } else {
                        if (modulo.contains("Adjunto") || modulo.contains("Archivo")) {
                            boolean elementoVisible3 = isElementPresent3(driver, locator2,test);
                            if (elementoVisible3) {
                                elementoWeb = driver.findElement(locator2);
                                return elementoWeb;
                            }
                        }
                    }
                }
            } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
                errorColor(driver, "esperar2Elementos ", e, test);
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException err) {
            errorColor(driver, "NO SE PUDO DETERMINAR SI ESTABA VISIBLE UN ELEMENTO U OTRO ", err, test);
        }
        return elementoWeb;
    }

    public static WebElement esperarElementoWeb(WebDriver driver, String test, By locator1,String modulo) {
        WebElement elementoWeb = null;
        try {
                boolean elementoVisible = isElementVisible3(driver, locator1,test);
                if (elementoVisible) {
                    elementoWeb = driver.findElement(locator1);
                    return elementoWeb;
                }else  if (modulo.contains("Adjunto") || modulo.contains("Archivo")) {
                    boolean elementoVisible3 = isElementPresent3(driver, locator1,test);
                    if (elementoVisible3) {
                        elementoWeb = driver.findElement(locator1);
                        return elementoWeb;
                    }
                }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException err) {
            errorColor(driver, "NO SE PUDO ESPERAR AL ELEMENTO WEB ", err, test);
        }
        return elementoWeb;
    }

    public static void cambiarFiltroEstadoNota(WebDriver driver, String estado, boolean activo, String test) {
        try {
            String elemento = null;
            if (estado.equals("En Edición")) {
                elemento = "idCMSEstado-2";
            } else if (estado.equals("Publicado")) {
                elemento = "idCMSEstado-0";
            }
            WebElement checkbox = driver.findElement(By.id(elemento));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            boolean isChecked = (boolean) jsExecutor.executeScript("return arguments[0].checked;", checkbox);
            By checkboxContenidoFiltroNota;
            if (activo) {
                if (!isChecked) {
                    checkboxContenidoFiltroNota = By.xpath("//span[text()='"+estado+"']");
                    click(driver, checkboxContenidoFiltroNota, "checkbox" ,test);
                }
            } else {
                if (isChecked) {
                    checkboxContenidoFiltroNota = By.xpath("//span[text()='"+estado+"']");
                    click(driver, checkboxContenidoFiltroNota, "CLICK CHECKBOX "+estado.toUpperCase(), test);
                }
            }


        } catch (Exception e) {
            errorColor(driver, "NO SE PUDO CAMBIAR EL ESTADO EN EL FILTRO DE NOTAS", e, test);
        }

    }

    public void switchToTabWithTitle( WebDriver driver, String expectedTitle, String test) {
        try{
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                driver.switchTo().window(windowHandle);
                String actualTitle = driver.getTitle();
                if (actualTitle.contains(expectedTitle)) {
                    break;
                }
            }
        }catch (Exception e){
            errorColor(driver,"CAMBIAR PESTAÑA: "+expectedTitle,e,test);
        }

    }

    public static void buscarValorTexto(WebDriver driver, List<WebElement> elementos, String texto,String test){
        try{
            for (WebElement elemento : elementos) {
                if (elemento.getText().contains(texto)) {
                    break;
                }
            }
        }catch (Exception e){
            errorColor(driver,"NO SE PUDO ENCONTRAR EL VALOR DEL TEXTO "+texto,e,test);
        }

    }

        public static void filtrarFecha(WebDriver driver, String test) {
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaHabilAnterior = retrocederAlPrimerDiaHabilAnterior(fechaActual);

            // Obtener el día, mes y año
            int dia = fechaHabilAnterior.getDayOfMonth();

//            String mes = fechaHabilAnterior.getMonth().toString().substring(0, 3).toLowerCase();

//            int año = fechaHabilAnterior.getYear();

            //CHECKEAR FECHA
            //FECHA DESDE

            By checkboxContenidoFiltroNota = By.xpath("//span[text()='Definir']");
            click(driver, checkboxContenidoFiltroNota, "CHECKBOX FILTRO DEFINIR FECHA",test);
            By lblFechaDesde = By.xpath("(//div[@class='datepicker-date-display']//div[contains(text(),'Fecha Desde')])[1]");
            esVisibleTest(driver,lblFechaDesde,test);

//            By lblAñoDesde = By.xpath("//div[@class='datepicker-date-display']//span[contains(text(),'"+año+"')]");
//            esVisibleTest(driver,lblAñoDesde,test);
//            esVisibleTest(driver,calendarYear,test);
//            click(driver, calendarYear, "CALENDARIO AÑO DESDE",test);
//            calendarValue = By.xpath("//li//span[text()='"+año+"']");
//            esVisibleTest(driver,calendarValue,test);
//            click(driver, calendarValue, "CALENDARIO AÑO "+año,test);
//            esVisibleTest(driver,lblAñoDesde,test);
            String mesAbreviado = "";
            if(dia==31 || dia ==30){
                Locale locale = new Locale("es", "ES");
                DateTimeFormatter formatoMes = DateTimeFormatter.ofPattern("MMM", locale);
                mesAbreviado = fechaHabilAnterior.format(formatoMes).toLowerCase().substring(0, 3);
                Thread.sleep(2000);
                calendarMonth = By.xpath("(//*[@class='datepicker-controls']/div/div[1]/input)[1]");
                Thread.sleep(2000);
                click(driver, calendarMonth,"CALENDARIO MES DESDE", test);
                Thread.sleep(2000);
                By calendarValue = By.xpath("(//li//span[text()='" + mesAbreviado + "'])[1]");
                Thread.sleep(2000);
                esVisibleTest(driver,calendarValue,test);
                Thread.sleep(2000);
                click(driver, calendarValue, "CALENDAR MES DESDE", test);
                Thread.sleep(2000);
            }
            calendarDay = By.xpath("//tr//td//button[@data-day='"+dia+"']");
            esVisibleTest(driver,calendarDay,test);
            click(driver, calendarDay, "CALENDARIO DIA DESDE", test);

            //FECHA HASTA
            By lblFechaHasta= By.xpath("(//div[@class='datepicker-date-display']//div[contains(text(),'Fecha Hasta')])[2]");
            esVisibleTest(driver,lblFechaHasta,test);

//            By lblAñoHasta = By.xpath("(//div[@class='datepicker-date-display']//span[contains(text(),'"+año+"')])[2]");
//            calendarYear = By.xpath("(//*[@class='datepicker-controls']/div/div[2]/input)[2]");
//            esVisibleTest(driver,lblAñoHasta,test);
//            esVisibleTest(driver,calendarYear,test);
//            click(driver, calendarYear, "CALENDARIO AÑO HASTA", test);
//            calendarValue = By.xpath("(//li//span[text()='" + año + "'])[2]");
//            visibilityOf(driver,calendarValue,test);
//            click(driver, calendarValue, "CALENDAR YEAR VALUE 2", test);
            if(dia==31 || dia ==30){
                Thread.sleep(2000);
                calendarMonth = By.xpath("(//*[@class='datepicker-controls']/div/div[1]/input)[2]");
                Thread.sleep(2000);
                click(driver, calendarMonth,"CALENDARIO MES HASTA", test);
                Thread.sleep(2000);
                By calendarValue = By.xpath("(//li//span[text()='" + mesAbreviado + "'])[2]");
                Thread.sleep(2000);
                esVisibleTest(driver,calendarValue,test);
                Thread.sleep(2000);
                click(driver, calendarValue, "CALENDAR MES HASTA", test);
                Thread.sleep(2000);
            }
            calendarDay = By.xpath("(//tr//td//button[@data-day='" + dia + "'])[2]");
            esVisibleTest(driver,calendarDay,test);
            click(driver, calendarDay, "CALENDAR DAY 2",test);


        } catch (Exception e) {
            errorColor(driver, "filtrar fecha ", e,test);
        }
    }

    public static LocalDate retrocederAlPrimerDiaHabilAnterior(LocalDate fecha) {
        // Retroceder un día para asegurarse de que no sea el día actual
        fecha = fecha.minusDays(1);

        // Continuar retrocediendo hasta que no sea fin de semana
        while (esFinDeSemana(fecha)) {
            fecha = fecha.minusDays(1);
        }

        return fecha;
    }

    public static boolean esFinDeSemana(LocalDate fecha) {
        DayOfWeek diaSemana = fecha.getDayOfWeek();
        return diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY;
    }

    public static ExpectedCondition<Boolean> ultimoSegmentoEsNumerico() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                // Obtener la URL actual
                String currentUrl = driver.getCurrentUrl();

                // Patrón para detectar números en el último segmento
                Pattern pattern = Pattern.compile(".*/(\\d+)$");
                Matcher matcher = pattern.matcher(currentUrl);

                // Retorna true si el último segmento contiene solo números
                return matcher.find();
            }
        };
    }

    public static void esVisibleTest(WebDriver driver, By locator, String test) {
        try {
            // Primer intento: espera de 3 segundos
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(1));
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (TimeoutException e) {
            // Si no es visible en 3 segundos, intenta esperar 15 segundos más
            try {
                WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
                longWait.until(ExpectedConditions.presenceOfElementLocated(locator));
                longWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (TimeoutException ex) {
                errorColor(driver, "NO SE PUDO VERIFICAR LA VISIBILIDAD DEL OBJETO " + locator.toString(), ex, test);
            }
        }
//        try{
//            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(1));
//            WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
//            WebElement element = waitForElementVisibility(driver,locator);
//            // Esperar por la presencia del elemento antes de verificar la visibilidad
//            if (longWait.until(ExpectedConditions.presenceOfElementLocated(locator)) != null) {
//                // Si el elemento está presente, verificamos su visibilidad
//                boolean isVisible = shortWait.until(ExpectedConditions.visibilityOf(element)) != null;
//                if (!isVisible) {
//                    // Espera extendida de 15 segundos si no lo encuentra visible en los primeros 3 segundos
//                    isVisible = longWait.until(ExpectedConditions.visibilityOf(element)) != null;
//                }
//                if(isVisible){
//                    assertTrue(true);
//                }
//            }
//        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e){
//            errorColor(driver, " TEST NO SE PUDO VERIFICAR LA VISIBILIDAD DEL OBJETO " + locator.toString(), e, test);
//        }
    }

    public static void estaPresenteTest(WebDriver driver, By locator, String test) {
        try {
            // Primer intento: espera de 3 segundos
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            shortWait.until(ExpectedConditions.presenceOfElementLocated(locator));

        } catch (TimeoutException e) {
            // Si no es visible en 3 segundos, intenta esperar 15 segundos más
            try {
                WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
                longWait.until(ExpectedConditions.presenceOfElementLocated(locator));
            } catch (TimeoutException ex) {
                errorColor(driver, "No se pudo verificar si el elemento esta presente:  "+locator.toString(), ex,test);
            }
        }
    }

    public static WebElement waitForElementVisibility(WebDriver driver, By locator) {
        WebElement element = null;

        try {
            // Esperar 3 segundos por la visibilidad del elemento
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(1));
            System.out.println("espero 1");
            element = shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("espero 15");
            // Si no se encuentra en 3 segundos, esperar 15 segundos adicionales
            WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            try {
                element = longWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (Exception ex) {
                e.printStackTrace();
            }
        }

        return element;
    }

    public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(WebDriver driver, By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("ELEMENTO VISIBLE");
            return true;
        } catch (Exception e) {
            System.out.println("ELEMENTO NO VISIBLE");
            return false;
        }
    }

    public void changeTextType(WebDriver driver, String option, String test) throws InterruptedException {
        clickJS(driver, btnTipoDeTexto,"BOTON TIPO DE TEXTO",test);
        By optionTipoTexto = By.xpath("//*[text()='" + option + "']");
        clickJS(driver, optionTipoTexto,"OPCION TIPO DE TEXTO",test);
    }



    public void deleteTDElement(WebDriver driver, String seccion, String nombreObjeto) throws IOException {
        try {
            System.out.println("##############BORRANDO " + seccion.toUpperCase() + "##############");
            System.out.println(driver.getCurrentUrl());
            Thread.sleep(5000);
            By btnObjeto = By.xpath("//span[text()='" + seccion + "']");
            if (driver.getCurrentUrl().equals(url + "administrator/cabezales")) {
                System.out.println(url + "administrator/cabezales");
                System.out.println("##############SECCION CABEZAL OK##############");
                sendKeys(driver, inputFiltrar, nombreObjeto);
                driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            } else {
                System.out.println("##############CLICK SECCION CABEZAL##############");
                click(driver, dropdownHomePortal);
                click(driver, btnObjeto);
                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                sendKeys(driver, inputFiltrar, nombreObjeto);
                driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            }
            // goToSection(driver, seccion);
            setHeaderNote(nombreObjeto);
            click(driver, headerObjeto);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(3000);
            clickJS(driver, btnInfo);
            clickJS(driver, btnEliminar);
            clickJS(driver, btnSi);
            driver.switchTo().window(tabs.get(1));
            sendKeys(driver, inputFiltrar, nombreObjeto);
            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
            visibiltyOf(driver, lblNotFound);
            driver.close();
            driver.switchTo().window(tabs.get(0));
            System.out.println("##############" + seccion.toUpperCase() + " BORRADO##############");
        } catch (Exception e) {
            errorColor(driver, "ERROR, NO SE PUDO BORRAR EL ELEMENTO" + nombreObjeto + " RAZON: " + e, e);
            screenshot(driver, "ERROR BORRAR " + nombreObjeto);
        }
    }



    public void checkAndDelete(WebDriver driver, String element, String seccion)
            throws IOException, InterruptedException {
        sendKeys(driver, inputFiltrar, element);
        driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
        headerObjeto = setHeaderNote(element);
        visibiltyOf(driver, headerObjeto);
        click(driver, headerObjeto);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        Thread.sleep(5000);
        clickJS(driver, btnInfo);
        clickJS(driver, btnEliminar);
        clickJS(driver, btnSi);
        driver.switchTo().window(tabs.get(1));
        sendKeys(driver, inputFiltrar, element);
        driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
        visibiltyOf(driver, lblNotFound);
    }

    public boolean isAlertPresent(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            new Actions(driver)
                    .sendKeys(Keys.ENTER)
                    .perform();
            return true;
        } catch (NoAlertPresentException Ex) {
            Exception e;
            errorColor(driver, ANSI_RED_BACKGROUND + Ex, e);
            return false;
        }
    }


    public void filterNote(WebDriver driver) {
        try {
            // CHECKEAR POR TITULO Y CAMBIAR
            // TODO TEXTO TITULO
            Thread.sleep(1000);
            headerObjeto = setHeaderNote("titulo modificado");
            verifyIfElementExists(driver, "titulo modificado", headerObjeto);
            headerObjeto = setHeaderNote("titulo");
            verifyIfElementExists(driver, "titulo", headerObjeto);
            clickJS(driver, btnNuevo, "BOTON NUEVO");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            checkTitlePage(driver, "Sin Titulo");
            Thread.sleep(7000);
            driver.switchTo().frame("cuerpoiframe");
            sendKeys(driver, inputCuerpoNota, "cuerpo", "INPUT CUERPO");
            driver.switchTo().parentFrame();
            sendKeys(driver, inputVolantaNota, "volanta", "INPUT VOLANTA");
            sendKeys(driver, inputTituloNota, "titulo", "INPUT TITULO");
            WebElement copeteComun = encontrarElemento(driver, inputCopeteNota);
            WebElement copeteEnriquecido = encontrarElemento(driver, inputCuerpoNota);

            if (copeteComun != null) {
                sendKeys(driver, inputCopeteNota, "copete", "INPUT COPETE");
            } else if (copeteEnriquecido != null) {
                driver.switchTo().frame("copeteiframe");
                System.out.println("switch copete iframe");
                sendKeys(driver, inputCuerpoNota, "copete", "INPUT CUERPO");
                driver.switchTo().parentFrame();
                System.out.println("switch parent frame");
            }

            clickJS(driver, btnGrabar, "BOTON GRABAR");
            presenceOf(driver, alertGuardado);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.close();
            driver.switchTo().window(tabs.get(0));
            visibiltyOf(driver, btnNuevo);
            List<WebElement> obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            // obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            // By tituloNotaExtraida = By.xpath("(//h2[@class='title'])[1]");
            // WebElement textoTitulo = encontrarElemento(driver, tituloNotaExtraida);
            // String titulo = textoTitulo.getText();
            headerObjeto = setHeaderNote("titulo");
            sendKeys(driver, inputFiltrar, "titulo", "INPUT TITULO");
            click(driver, headerObjeto, "HEADER NOTA");
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(4000);
            checkValueElement(driver, inputTituloNota, "titulo");
            Thread.sleep(4000);

            sendKeys(driver, inputTituloNota, "titulo modificado", "INPUT TITULO");
            clickJS(driver, btnGrabar, "BOTON GRABAR");
            presenceOf(driver, alertGuardado);
            driver.close();
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            sendKeys(driver, inputFiltrar, "titulo modificado", "INPUT FILTRAR");
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            headerObjeto = setHeaderNote("titulo modificado");
            click(driver, headerObjeto, "HEADER NOTA");
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(4000);
            checkValueElement(driver, inputTituloNota, "titulo modificado");
            driver.close();
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            checkboxContenidoFiltroNota = By.xpath("//label[@class='checkbox']//span[text()='Titulo']");
            clickJS(driver, checkboxContenidoFiltroNota, "CHECKBOX CONTENIDO");
            // Thread.sleep(2000);
            filtrarFecha(driver, "titulo modificado");
            filtrarEstado(driver);
            filtrarContenido(driver);

        } catch (Exception e) {
            errorColor(driver, "TEST FILTRAR CHECKBOX", e);
        }

    }

    public void filterAttach(WebDriver driver, String titulo) {
        try {
            clickJS(driver, btnArchivos);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            checkboxContenidoFiltroNota = By.xpath("//label//span[contains(text(),'Último año')]");
            WebElement anio1 = encontrarElemento(driver, checkboxContenidoFiltroNota);
            if (anio1 != null) {
                clickJS(driver, checkboxContenidoFiltroNota);
                Thread.sleep(1000);
            } else {
                checkboxContenidoFiltroNota = By.xpath("//label//span[contains(text(),'Último Año')]");
                clickJS(driver, checkboxContenidoFiltroNota);
                Thread.sleep(1000);
            }

            checkboxContenidoFiltroNota = By.xpath("//label//span[text()='Imagen']");
            clickJS(driver, checkboxContenidoFiltroNota);
            Thread.sleep(2000);
            sendKeys(driver, inputFiltrar, "TD AUTOMATION Imagen");// ARREGLAR
            Thread.sleep(2000);
            By obj = By.xpath("//div[@id='cms-results']//article");
            // visibiltyOf(driver, obj);
            WebElement buscar = encontrarElemento(driver, obj);
            if (buscar != null) {
                visibiltyOf(driver, obj);
            } else {
                visibiltyOf(driver, lblNotFound);
            }
            clickJS(driver, checkboxContenidoFiltroNota);
            Thread.sleep(1000);
            checkboxContenidoFiltroNota = By.xpath("//label//span[text()='Agrupador']");
            clickJS(driver, checkboxContenidoFiltroNota);
            Thread.sleep(2000);
            sendKeys(driver, inputFiltrar, "Chayanne");
            Thread.sleep(2000);
            obj = By.xpath("//div[@id='cms-results']//article");
            visibiltyOf(driver, obj);
            clickJS(driver, checkboxContenidoFiltroNota);
            Thread.sleep(1000);
            checkboxContenidoFiltroNota = By.xpath("//label//span[text()='Audio']");
            clickJS(driver, checkboxContenidoFiltroNota);
            Thread.sleep(2000);
            sendKeys(driver, inputFiltrar, "relacionar");
            Thread.sleep(2000);
            obj = By.xpath("//div[@id='cms-results']//article");
            visibiltyOf(driver, obj);
            clickJS(driver, checkboxContenidoFiltroNota);
            Thread.sleep(1000);
            checkboxContenidoFiltroNota = By.xpath("//label//span[text()='Autor']");
            clickJS(driver, checkboxContenidoFiltroNota);
            Thread.sleep(2000);
            sendKeys(driver, inputFiltrar, "automation");
            Thread.sleep(2000);
            obj = By.xpath("//div[@id='cms-results']//article");
            visibiltyOf(driver, obj);
            clickJS(driver, checkboxContenidoFiltroNota);
            Thread.sleep(1000);
            checkboxContenidoFiltroNota = By.xpath("//label//span[text()='Background']");
            clickJS(driver, checkboxContenidoFiltroNota);
            Thread.sleep(2000);
            sendKeys(driver, inputFiltrar, "background");
            Thread.sleep(2000);
            obj = By.xpath("//div[@id='cms-results']//article");
            visibiltyOf(driver, obj);
            filtrarFecha(driver, titulo);
        } catch (Exception e) {
            errorColor(driver, "TEST FILTRAR ADJUNTO", e);
        }
    }

    public void filterBanner(WebDriver driver, String titulo) {
        try {
            clickJS(driver, btnBanners);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            filtrarFecha(driver, titulo);
            driver.close();
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
        } catch (Exception e) {
            errorColor(driver, "Filtro Banner", e);
        }

    }



    public void filterDates(WebDriver driver, String filtro1, String titulo) throws IOException, InterruptedException {
        checkboxContenidoFiltroNota = By.xpath("//label//span[text()='" + filtro1 + "']");
        clickJS(driver, checkboxContenidoFiltroNota);
        sendKeys(driver, inputFiltrar, titulo);
        Thread.sleep(1000);
        List<WebElement> obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
        obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
        headerObjeto = setHeaderNote(titulo);
        // visibiltyOf(driver, headerObjeto);
        visibleElementOnFilter(driver, headerObjeto, titulo);
        clickJS(driver, checkboxContenidoFiltroNota);
        checkboxContenidoFiltroNota = By.xpath("//label//span[text()='Definir']");
        clickJS(driver, checkboxContenidoFiltroNota);
        Thread.sleep(2000);
        clickJS2(driver, calendarMonth);
        By calendarValue = By.xpath("//li//span[text()='sep']");
        clickJS(driver, calendarValue);
        Thread.sleep(1000);
        clickJS(driver, calendarYear);
        calendarValue = By.xpath("//li//span[text()='2023']");
        clickJS(driver, calendarValue);
        Thread.sleep(1000);
        calendarDay = By.xpath("//tr//td//button[@data-day='1']");
        clickJS(driver, calendarDay);
        Thread.sleep(3000);
        calendarMonth = By.xpath("(//*[@class='datepicker-controls']/div/div[1]/input)[2]");
        clickJS(driver, calendarMonth);
        calendarValue = By.xpath("(//li//span[text()='oct'])[2]");
        clickJS(driver, calendarValue);
        Thread.sleep(1000);
        calendarYear = By.xpath("(//*[@class='datepicker-controls']/div/div[2]/input)[2]");
        clickJS(driver, calendarYear);
        calendarValue = By.xpath("(//li//span[text()='2023'])[2]");
        clickJS(driver, calendarValue);
        Thread.sleep(1000);
        calendarDay = By.xpath("(//tr//td//button[@data-day='17'])[2]");
        Thread.sleep(1000);
        clickJS(driver, calendarDay);
        Thread.sleep(2000);
        visibleElementOnFilter(driver, headerObjeto, titulo);
        checkboxContenidoFiltroNota = By.xpath("//label//span[text()='" + filtro1 + "']");
        clickJS(driver, checkboxContenidoFiltroNota);
    }



    public void filtrarNota(WebDriver driver, String tituloNota) {
        try {
            List<WebElement> obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            // ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            sendKeys(driver, inputFiltrar, tituloNota);
            Thread.sleep(1000);
            // List<WebElement> obj =
            // driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            headerObjeto = setHeaderNote(tituloNota);
            click(driver, headerObjeto);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(4000);
            checkValueElement(driver, inputTituloNota, tituloNota);
            sendKeys(driver, inputTituloNota, "titulo modificado");
            clickJS(driver, btnGrabar);
            presenceOf(driver, alertGuardado);
            driver.close();
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            sendKeys(driver, inputFiltrar, "titulo modificado");
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            headerObjeto = setHeaderNote(tituloNota);
            click(driver, headerObjeto);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(4000);
            checkValueElement(driver, inputTituloNota, "titulo modificado");
            driver.close();
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            checkboxContenidoFiltroNota = By.xpath("//label[@class='checkbox']//span[text()='Titulo']");
            clickJS(driver, checkboxContenidoFiltroNota);
        } catch (Exception e) {
            errorColor(driver, "FILTRAR NOTA", e);
        }
    }

    public static void checkValueElement(WebDriver driver, By locator, String valor, String test) {
        try{
            WebElement webElement = driver.findElement(locator);
            String value = webElement.getAttribute("value");
            if(value.equals(valor)) {
                Assert.assertTrue(driver.findElement(locator).isDisplayed());
            }
        }catch (Exception e) {
            errorColor(driver,"CHECK VALUE ELEMENT: "+locator.toString(),e,test);
        }

    }

    public void filtrarFecha2(WebDriver driver, String titulo) {
        try {
            LocalDate fechaActual = LocalDate.now();

            // Obtener el día, mes y año
            int dia = fechaActual.getDayOfMonth();
            String mes = fechaActual.getMonth().toString().substring(0, 3).toLowerCase();
            int año = fechaActual.getYear();

            // Formatear el mes a tres letras minúsculas
            Locale locale = new Locale("es", "ES");
            DateTimeFormatter formatoMes = DateTimeFormatter.ofPattern("MMM", locale);
            String mesAbreviado = fechaActual.format(formatoMes).toLowerCase();

            // List<WebElement> obj =
            // driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            // ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            // CHECKEAR FECHA
            checkboxContenidoFiltroNota = By.xpath("//span[text()='Último Mes']");
            // WebElement checkBoxMes1 =
            // encontrarElemento(driver,checkboxContenidoFiltroNota);

            clickJS(driver, checkboxContenidoFiltroNota);
            sendKeys(driver, inputFiltrar, titulo);
            Thread.sleep(3000);
            WebElement nullSearch = encontrarElemento(driver, lblNotFound);
            if (nullSearch != null) {
                headerObjeto = lblNotFound;
                visibiltyOf(driver, headerObjeto);
            } else {

                List<WebElement> obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
                obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
                headerObjeto = setHeaderNote(titulo);
                visibiltyOf(driver, headerObjeto);
            }

            clickJS(driver, checkboxContenidoFiltroNota);
            checkboxContenidoFiltroNota = By.xpath("//span[text()='Definir']");
            clickJS(driver, checkboxContenidoFiltroNota);
            Thread.sleep(2000);
            clickJS2(driver, calendarMonth);
            By calendarValue = By.xpath("//li//span[text()='sep']");
            clickJS(driver, calendarValue);
            Thread.sleep(1000);
            clickJS(driver, calendarYear);
            calendarValue = By.xpath("//li//span[text()='2023']");
            clickJS(driver, calendarValue);
            Thread.sleep(1000);
            calendarDay = By.xpath("//tr//td//button[@data-day='1']");
            clickJS(driver, calendarDay);
            Thread.sleep(3000);
            calendarMonth = By.xpath("(//*[@class='datepicker-controls']/div/div[1]/input)[2]");
            clickJS(driver, calendarMonth);
            calendarValue = By.xpath("(//li//span[text()='" + mesAbreviado + "'])[2]");
            clickJS(driver, calendarValue);
            Thread.sleep(1000);
            calendarYear = By.xpath("(//*[@class='datepicker-controls']/div/div[2]/input)[2]");
            clickJS(driver, calendarYear);
            calendarValue = By.xpath("(//li//span[text()='" + año + "'])[2]");
            clickJS(driver, calendarValue);
            Thread.sleep(1000);
            calendarDay = By.xpath("(//tr//td//button[@data-day='" + dia + "'])[2]");
            Thread.sleep(1000);
            clickJS(driver, calendarDay);
            Thread.sleep(2000);
            visibiltyOf(driver, headerObjeto);

            checkboxContenidoFiltroNota = By.xpath("//span[text()='Último Mes']");
            clickJS(driver, checkboxContenidoFiltroNota);
        } catch (Exception e) {
            errorColor(driver, "filtrar fecha", e);
        }
    }

    public void filtrarEstado(WebDriver driver) {
        try {
            List<WebElement> obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            // CHECKEAR ESTADO
            checkboxContenidoFiltroNota = By.xpath("//label[@class='checkbox']//span[text()='En Edición']");
            clickJS(driver, checkboxContenidoFiltroNota);
            Thread.sleep(4000);
            System.out.println("aaaaaaaa");
            sendKeys(driver, inputFiltrar, "titulo modificado");
            Thread.sleep(1000);
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            headerObjeto = setHeaderNote("titulo modificado");
            visibiltyOf(driver, headerObjeto);
            click(driver, headerObjeto);
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(4000);
            clickJS(driver, notaEstado);
            optionNotaEstado = By.xpath("//div[@class='status-card']//div//span[text()='Publicado']");
            clickJS(driver, optionNotaEstado);
            clickJS(driver, btnGrabar);
            presenceOf(driver, alertGuardado);
            driver.close();
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            Thread.sleep(3000);
            checkboxContenidoFiltroNota = By.xpath("//label[@class='checkbox']//span[text()='Publicado']");
            clickJS(driver, checkboxContenidoFiltroNota);
            sendKeys(driver, inputFiltrar, "titulo modificado");
            Thread.sleep(3000);
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            headerObjeto = setHeaderNote("titulo modificado");
            visibiltyOf(driver, headerObjeto);
            clickJS(driver, checkboxContenidoFiltroNota);
            checkboxContenidoFiltroNota = By.xpath("//label[@class='checkbox']//span[text()='En Edición']");
            clickJS(driver, checkboxContenidoFiltroNota);
        } catch (Exception e) {
            errorColor(driver, "filtrar estado", e);
        }
    }

    public void filtrarContenido(WebDriver driver) throws InterruptedException {
        List<WebElement> obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // CHECKEAR CONTENIDO
        checkboxContenidoFiltroNota = By.xpath("//label[@class='checkbox']//span[text()='Nota']");
        clickJS(driver, checkboxContenidoFiltroNota);
        // sendKeys(driver, inputFiltrar, "titulo modificado");
        Thread.sleep(3000);
        obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
        headerObjeto = setHeaderNote("titulo modificado");
        visibiltyOf(driver, headerObjeto);
        click(driver, headerObjeto);
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(4000);
        clickJS(driver, dropdownTipoContenidoNota);
        optionTipoContenidoNota = By
                .xpath("//div[@id='content_idCMSTipoContenido']//ul//li//span[text()='Nota Web']");
        WebElement option1 = encontrarElemento(driver, optionTipoContenidoNota);
        if (option1 != null) {
            clickJS(driver, optionTipoContenidoNota);
            clickJS(driver, btnGrabar);
            presenceOf(driver, alertGuardado);
        } else {
            optionTipoContenidoNota = By
                    .xpath("//div[@id='content_idCMSTipoContenido']//ul//li//span[text()='Nota LiveBlog']");
            clickJS(driver, optionTipoContenidoNota);
            clickJS(driver, btnGrabar);
            presenceOf(driver, alertGuardado);

        }
        driver.close();
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        checkboxContenidoFiltroNota = By.xpath("//label[@class='checkbox']//span[text()='Nota Web']");
        WebElement encontrar1 = encontrarElemento(driver, checkboxContenidoFiltroNota);
        if (encontrar1 != null) {
            clickJS(driver, checkboxContenidoFiltroNota);
            sendKeys(driver, inputFiltrar, "titulo modificado");
            Thread.sleep(1000);
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            headerObjeto = setHeaderNote("titulo modificado");
            visibiltyOf(driver, headerObjeto);
            clickJS(driver, checkboxContenidoFiltroNota);
        } else {

            checkboxContenidoFiltroNota = By.xpath("//label[@class='checkbox']//span[text()='Nota LiveBlog']");

            clickJS(driver, checkboxContenidoFiltroNota);
            sendKeys(driver, inputFiltrar, "titulo modificado");
            Thread.sleep(1000);
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            headerObjeto = setHeaderNote("titulo modificado");
            visibiltyOf(driver, headerObjeto);
            clickJS(driver, checkboxContenidoFiltroNota);
        }
    }

}







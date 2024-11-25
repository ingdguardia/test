package com.dacautomation.pages.cms;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class notas extends cms_base {
    //ELEMENTOS WEB
    By checkboxContenidoFiltroNota = By.xpath("//label[@class='checkbox']//span[text()='Titulo']");
    By headerObjeto;
    By inputVolantaNota = By.id("volanta");
    By inputTituloNota = By.id("titulo");
    By inputCopeteNota = By.xpath("//div[@id='textarea_copete']//div//textarea[@id='copete']");
    By inputCuerpoNota = By.xpath("//*[@id='mce_0']/p");
    By jsonTituloNota = By.xpath("/html/body/pre");
    By jsonCopeteNota = By.xpath("/html/body/pre");
    By jsonVolantaNota = By.xpath("/html/body/pre");
    By jsonCuerpoNota = By.xpath("/html/body/pre");
    By inputArchivosNota = By.id("FileList_input");
//    By checkboxAdjunto = By.xpath("//*[@id='FileList_7162368_item']/figure/div");
//    By btnRelacionarNota = By.xpath("//*[@id='FileList_result_items']/div/div[2]/div[1]/a");
    By inputContenidosRelacionados = By.id("ContentList_input");
    By checkBoxNota;
    By notaAdjTitulo;
//    By inputAgrupadoresNota = By.xpath("//input[@id='arrAgrupadores_input']");
//    By optionAgrupadores = By.xpath("//li//span[text()='Tema » Test']");
//    By inputCategoriasNota = By.xpath("//input[@id='arrCategorias_input']");
//    By optionCategorias = By.xpath("//span[text()='test']");
    By infoWrapper = By.xpath("//div[@class='content']//div[@class='info-wrapper']");
    By dropdownEstado = By.xpath("//label[@for='estadoContent']//preceding-sibling::div//input");
    By inputNombreBtnTagNota = By.xpath("//input[@id='nombre']");
    By btnNuevoAgrupadorNota = By.xpath("//a[@id='Nuevo Agrupador']");
    By btnContinuarAgrupadorNota = By.xpath("//a[@id='continue']");
    By dropdownCategoriaTagNota = By.xpath("//*[@id='tag-no-encontrado']/div[1]/div/input");
    By optionCategoriaTagNota = By.xpath("(//li//span[text()='Temas'])[2]");
    By btnFinalizarTagNota = By.xpath("//a[@id='finalizar-btn']");
    //    By dropdownEstado = By.xpath("//*[@id='ContentList_row-input']/div[3]/div/div/input");
    By btnRelacionarNota2 = By.xpath("//*[@id='FileSearch_result_items']/div[2]/div[1]/a");
    By optionArchivosNota = By.xpath("//span[contains(text(), 'Test Auto')]");
    By articleAdjunto = By.xpath("//article[starts-with(@id,'Result')]");
    By moduloConfiguracion = By.xpath("//a[text()='Configuración']");
    By btnMetatags = By.xpath("//div[text()='Metatags']");
    By btnOgtags = By.xpath("//div[text()='OG tags']");
    By btnTwitter = By.xpath("//div[text()='Twitter']");
    By btnCrawlers = By.xpath("//div[text()='Crawlers']");
    By inputMetatagTitulo = By.xpath("//textarea[@id='metadata[title]']");
    By inputMetatagDescripcion = By.xpath("//textarea[@id='metadata[property][description]']");
    By inputMetatagItemDropName = By.xpath("//textarea[@id='metadata[itemprop][name]']");
    By inputMetatagItemDropHeadline = By.xpath("//textarea[@id='metadata[itemprop][headline]']");
    By inputMetatagItemDropDescripcion = By.xpath("//textarea[@id='metadata[itemprop][description]']");
    By inputMetatagLenguaje = By.xpath("//textarea[@id='metadata[content-language]']");
    By inputMetatagRefresh = By.xpath("//textarea[@id='metadata[refresh]']");
    By inputOGTagTitulo = By.xpath("//textarea[@id='metadata[property][og:title]']");
    By inputOGTagImagen = By.xpath("//textarea[@id='metadata[property][og:image]']");
    By inputOGTagImagenAncho = By.xpath("//textarea[@id='metadata[property][og:image:width]']");
    By inputOGTagImagenAlto = By.xpath("//textarea[@id='metadata[property][og:image:height]']");
    By inputTwitterTitulo = By.xpath("//textarea[@id='metadata[name][twitter:title]']");
    By inputTwitterDescripcion = By.xpath("//textarea[@id='metadata[name][twitter:description]']");
    By inputTwitterImagen = By.xpath("//textarea[@id='metadata[name][twitter:image]']");
    By inputCrawlerCanonicalLink = By.xpath("//textarea[@id='metadata[canonical]']");
    By inputCrawlerRobots = By.xpath("//textarea[@id='metadata[robots]']");
    By moduloContenido = By.xpath("//a[text()='Contenido']");
    By inputAutorNota = By.id("arrPersona_input");
    By optionAutorNota;
    By btnTipoDeTexto = By.xpath("(//button[@title='Párrafo'])[1]");
    By btnNegritaNota = By.xpath("//button[@title='Negrita']");
    By btnItalicaNota = By.xpath("//button[@title='Itálica']");
    By btnEditorLinksNota = By.xpath("//button[@title='Agregar nota en bajada']");
    By inputLinkUrl = By.id("link-url");
    By inputLinkUrlTexto = By.id("link-text");
    By inputLinkTitulo = By.id("link-title");
    By dropdownLinkRelacion = By.id("content_link-relation");
    By optionLinkRelacion = By.xpath("//li//span[text()='No Follow']");
    By inputLinkNotasRelacionadas = By.id("RelatedLinks_input");
    By dropdownLinkDestino = By.id("content_link-target");
    By optionLinkDestino = By.xpath("//li//span[text()='Ventana actual']");
    By btnGrabarLink = By.xpath("//a//span[text()='Grabar']");
    By btnEmbedNota = By.xpath("//button[@title='Incrustado']");
    By btnTagNota = By.xpath("//button[@title='Agrupador']");
    By btnCitaNota = By.xpath("//button[@title='Cita']");
    By btnEnfasisNota = By.xpath("//button[@title='Enfasis']");
    By dropdownEmbedTipo = By.xpath("//div[@id='content_tipoembed']//div");
    By optionEmbedTipo = By.xpath("//li//span[contains(text(),'Adjuntos')]");
    By inputEmbedArchivo = By.xpath("//div//input[@id='FileSearch_input']");
    By inputEmbed = By.xpath("//div//textarea[@id='embed_text']");
    String embedPrueba = "<blockquote class='twitter-tweet'><p lang='es' dir='ltr'>hoy si nos hemos dado la mano <a href='https://t.co/rDCzimBuCx'>pic.twitter.com/rDCzimBuCx</a></p>&mdash; Ibai (@IbaiLlanos) <a href='https://twitter.com/IbaiLlanos/status/1424155728856682496?ref_src=twsrc%5Etfw'>August 7, 2021</a></blockquote> <script async src='https://platform.twitter.com/widgets.js' charset='utf-8'></script>";





    boolean notaCreada1 = false;
    boolean notaCreada2 = false;
    public notas(WebDriver driver) {
        super(driver);
    }

    public void createNote(WebDriver driver, String nombreNota, String volanta, String copete, String cuerpo, String tag,
                           String category, String archivo, String url, String user, String pass, String test) throws InterruptedException {

        try {
            checkboxContenidoFiltroNota = By.xpath("//span[text()='Último mes']");
            click(driver,checkboxContenidoFiltroNota,"CLICK CHECKBOX FILTRO ULTIMO MES", test);
            headerObjeto = setHeaderNote(nombreNota);
            verifyIfElementExists(driver, nombreNota, headerObjeto, "Contenidos", test);
            sendKeys(driver, inputFiltrar, "", "LIMPIAR TEXT BOX DE FILTRAR", test);
            if(url.contains("staging")) {
                headerObjeto = setHeaderNote("TD AUTOMATION PRUEBA UNO");
                verifyIfElementExists(driver, "TD AUTOMATION PRUEBA UNO", headerObjeto, "Contenidos", test);
                headerObjeto = setHeaderNote("INJECTION DOS");
                verifyIfElementExists(driver, "INJECTION DOS", headerObjeto, "Contenidos", test);
                sendKeys(driver, inputFiltrar, "", "LIMPIAR TEXT BOX DE FILTRAR", test);
            }
            cambiarFiltroEstadoNota(driver,"En Edición",false,test);
            cambiarFiltroEstadoNota(driver,"Publicado",true,test);

            filtrarFecha(driver,test);
            Thread.sleep(3000);
            //VERIFICAR QUE EXISTAN AL MENOS 2 NOTAS PARA RELACIONARLAS Y SI NO, CREA 2 NOTAS

            if(driver.getCurrentUrl().contains("staging")) {
                cambiarFiltroEstadoNota(driver,"Publicado",false,test);
            }
            esVisibleTest(driver,btnNuevo,test);

            By numeroArticulos = By.xpath("//div[@id='cms-results']//article//h2");
            int articulos = contarArticulos(driver,numeroArticulos , test);

            if(articulos<2){
                crear2notas(driver,test);
                notaCreada1 = true;
                notaCreada2 = true;
                headerObjeto = setHeaderNote("INJECTION DOS");
                cambiarFiltroEstadoNota(driver,"En Edición",true,test);
                checkboxContenidoFiltroNota = By.xpath("//span[text()='Última semana']");
                click(driver,checkboxContenidoFiltroNota,"CLICK CHECKBOX FILTRO ULTIMA SEMANA", test);
                Thread.sleep(2000);
                esVisibleTest(driver,headerObjeto,test);
            }
            headerObjeto = setHeaderNote(nombreNota);
            presenceOf(driver, infoWrapper, test);

            if(notaCreada1 || notaCreada2){
                cambiarFiltroEstadoNota(driver,"En Edición",true,test);
                cambiarFiltroEstadoNota(driver,"Publicado",false,test);
                esVisibleTest(driver,btnNuevo,test);
            }
            //OBTENER TITULO, ID y ESTADO DE NOTA PARA RELACIONAR
            cambiarFiltroEstadoNota(driver,"Publicado",true,test);
            Thread.sleep(3000);
            List<WebElement> obj = driver.findElements(By.xpath("//div[@id='cms-results']//article//h2"));
            String nota1 = obj.get(0).getText();
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            String idNotaAdj1 = obj.get(0).getAttribute("cms:value");
            By headerNota1 = By.xpath("//h2[text()='" + nota1 + "']");
            click(driver, headerNota1, "HEADER PRIMERA NOTA", test);
            switchToTabWithTitle(driver, nota1, test);
            By estadoNota = By.xpath("//div[@class='status-button']//div//span");
            boolean BtextoEstadoNota1 = visibilityOfReturn(driver, estadoNota,test);
            WebElement textoEstadoNota1 = null;
            if(BtextoEstadoNota1){
                textoEstadoNota1 = driver.findElement(estadoNota);
            }
            String estadoNota1 = obtenerEstado(textoEstadoNota1);

            driver.close();
            switchToTabWithTitle(driver, "Contenidos", test);
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article//h2"));
            String nota2 = obj.get(1).getText();
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            String idNotaAdj2 = obj.get(1).getAttribute("cms:value");
            By headerNota2 = By.xpath("//h2[text()='" + nota2 + "']");
            click(driver, headerNota2, "HEADER SEGUNDA NOTA", test);
            switchToTabWithTitle(driver, nota2, test);
            estadoNota = By.xpath("//div[@class='status-button']//div//span");
            boolean BtextoEstadoNota2 = encontrarElemento(driver, estadoNota);
            WebElement textoEstadoNota2 = null;
            if(BtextoEstadoNota2){
                textoEstadoNota2= driver.findElement(estadoNota);
            }
            String estadoNota2 = obtenerEstado(textoEstadoNota2);
            driver.close();
            switchToTabWithTitle(driver, "Contenidos", test);
            //CREAR NUEVA NOTA
            click(driver, btnNuevo, "CLICK BOTON NUEVO", test);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            checkTitlePage(driver, "Sin Titulo", test);
            waitSpanElementNameInEditor(driver,"Sin Titulo","Contenidos",test);
            driver.switchTo().frame("cuerpoiframe");
            //COMPLETAR VOLANTA, COPETE, TITULO y CUERPO
            sendKeys2(driver, inputCuerpoNota, cuerpo, "CUERPO DE NOTA", test);
            Thread.sleep(1000);
            driver.switchTo().parentFrame();
            sendKeys2(driver, inputVolantaNota, volanta, "VOLANTA NOTA", test);
            Thread.sleep(1000);
            sendKeys2(driver, inputTituloNota, nombreNota, "TITULO NOTA", test);
            Thread.sleep(1000);
            By iframeCopete = By.xpath("//iframe[@id='copeteiframe']");
            boolean copeteIframe = encontrarElemento(driver, iframeCopete);
            if (!copeteIframe) {
                sendKeys2(driver, inputCopeteNota, copete, "COPETE NOTA", test);
            } else {
                driver.switchTo().frame("copeteiframe");
                sendKeys2(driver, inputCuerpoNota, copete, "COPETE NOTA", test);
                driver.switchTo().parentFrame();
            }

            //RELACIONAR UN ARCHIVO ADJUNTO
            sendKeys2(driver, inputArchivosNota, archivo, "ADJUNTAR ARCHIVO NOTA", test);
            checkboxAdjunto = By.xpath("(//div[@class='check-img']//input)[1]");
            clickJS(driver, checkboxAdjunto, "CLICK CHECKBOX ADJUNTO NOTA", test);
            btnRelacionarNota = By.xpath("//*[@id='FileList_result_items']/div/div[2]/div[1]//a[contains(text(), '')]");
            boolean relacionar = encontrarElemento(driver, btnRelacionarNota);
            if (relacionar) {
                click(driver, btnRelacionarNota, "BOTON RELACIONAR NOTA", test);
            } else {
                driver.findElement(btnRelacionarNota).click();
            }

            //RELACIONAR 2 NOTAS

                boolean dropdownEstado1 = encontrarElemento(driver, dropdownEstado);
                By dropdownEstadoV = By.xpath("//*[@id='ContentList']/div[2]/div[3]/div/div/input");
                boolean dropdownEstado2 = encontrarElemento(driver, dropdownEstadoV);
                if (dropdownEstado1) {
                    click(driver, dropdownEstado, "DROPDOWN ESTADO NOTA RELACIONADA 1", test);
                } else if (dropdownEstado2) {
                    click(driver, dropdownEstadoV,"DROPDOWN ESTADO NOTA RELACIONADA 1", test);
                }

                By optionEstado = By.xpath("//li//span[text()='" + estadoNota1 + "']");
                click(driver, optionEstado, "SELECCIONAR ESTADO NOTA RELACIONADA 1", test);
                if(!nota1.contains("N/D")){
                    sendKeys(driver, inputContenidosRelacionados, nota1, "TITULO NOTA RELACIONADA 1", test);
                    driver.findElement(inputContenidosRelacionados).sendKeys(" ");
                }
                By notFoundNota = By.xpath("//h4[contains(text(),'No se encontraron contenidos')]");
                boolean notFoundB = isElementVisible3(driver,notFoundNota,test);
                if(!notFoundB && driver.getCurrentUrl().contains("staging")){
                    checkBoxNota = By.xpath("//label//div//input[@value='" + idNotaAdj1 + "']");
                    presenceExplicit(driver,checkBoxNota,test);
                    clickJS(driver, checkBoxNota, "CHECKBOX NOTA RELACIONADA 1", test);
                    btnRelacionarNota = By.xpath("//*[contains(text(),'RELACIONAR')]");
                    clickJS(driver, btnRelacionarNota, "BOTON RELACIONAR NOTA 1", test);
                    notaAdjTitulo = By.xpath("//*[@id='ContentList_"+idNotaAdj1+"_item']/div[1]/div[1]");
                    esVisibleTest(driver,notaAdjTitulo,test);
                    if (dropdownEstado1) {
                        click(driver, dropdownEstado, "DROPDOWN ESTADO NOTA RELACIONADA 2", test);
                    } else if (dropdownEstado2) {
                        click(driver, dropdownEstadoV, "DROPDOWN ESTADO NOTA RELACIONADA 2", test);
                    }
                    optionEstado = By.xpath("//li//span[text()='" +estadoNota2 + "']");
                    click(driver, optionEstado, "SELECCIONAR ESTADO NOTA RELACIONADA 2", test);
                    if(!nota2.contains("N/D")){
                        sendKeys2(driver, inputContenidosRelacionados, nota2, "TITULO NOTA RELACIONADA 2", test);
                        driver.findElement(inputContenidosRelacionados).sendKeys(" ");
                        checkBoxNota = By.xpath("//label//div//input[@value='" + idNotaAdj2 + "']");
                        presenceExplicit(driver,checkBoxNota,test);
                        clickJS(driver, checkBoxNota, "CHECKBOX NOTA RELACIONADA 2", test);
                        btnRelacionarNota = By.xpath("//*[contains(text(),'RELACIONAR')]");
                        click(driver, btnRelacionarNota, "BOTON RELACIONAR NOTA 2", test);
                        notaAdjTitulo = By.xpath("//*[@id='ContentList_"+idNotaAdj2+"_item']/div[1]/div[1]");
                        esVisibleTest(driver,notaAdjTitulo,test);
                    }
                }



            //RELACIONAR UN TAG
            WebElement testS = driver.findElement(By.xpath("//*[@id=\"arrCategorias_parent\"]/div/div[1]/div/a[1]/i/span"));
            scrollUp(driver,testS,test);
            click(driver,inputCategoriasNota,"INPUT CATEGORIAS NOTA",test);
            sendKeys2(driver, inputAgrupadoresNota, tag, "TITULO TAG RELACIONADO", test);
            optionAgrupadores = By.xpath("//li//span[contains(text(),' » "+tag+"')]");
            click(driver, optionAgrupadores, "OPCION TAG RELACIONADO", test);
            //RELACIONAR UNA CATEGORIA
            sendKeys2(driver, inputCategoriasNota, category, "TITULO CATEGORIA RELACIONADA", test);
            optionCategorias = By.xpath("//span[text()='" + category + "']");
            click(driver, optionCategorias, "OPCION CATEGORIA RELACIONADA", test);
            WebElement webElement2 = driver.findElement(By.xpath("//input[@id='volanta']"));
            String valorVolanta = webElement2.getAttribute("value");
            //GRABAR NOTA
            click(driver, btnGrabar, "BOTON GRABAR NOTA", test);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Timeout de 10 segundos
            wait.until(cms_base.ultimoSegmentoEsNumerico());
            esperarToast(driver, "TD AUTOMATION Nota","Contenidos",test);
            Thread.sleep(2000);
            By tituloSpan = By.xpath("//span[@class='title']");
            if (!checkTextElement2(driver, tituloSpan, nombreNota, test)) {
                sendKeys2(driver, inputTituloNota, nombreNota, "INPUT TITULO NOTA", test);
                clickImplicit(driver, btnGrabar, "BOTON GRABAR", test);
                esperarToast(driver, "TD AUTOMATION Nota","Contenidos",test);
            }
            String idApi = getNoteIdApi(driver.getCurrentUrl());
            Thread.sleep(1000);
            driver.close();
            switchToTabWithTitle(driver,"Contenidos",test);
            if(!driver.getCurrentUrl().contains("staging")){
                cambiarFiltroEstadoNota(driver,"En Edición",true,test);
            }
            checkboxContenidoFiltroNota = By.xpath("//span[text()='Última semana']");
            click(driver,checkboxContenidoFiltroNota,"CLICK CHECKBOX FILTRO ULTIMA SEMANA", test);
            Thread.sleep(2000);
            presenceOf(driver,infoWrapper,test);
            sendKeys2(driver,inputFiltrar,"TD AUTOMATION Nota","INPUT FILTRAR -> TD AUTOMATION Nota",test);
            headerObjeto = setHeaderNote(nombreNota);
            esVisibleTest(driver,btnNuevo,test);


            // VERIFICAR API
            String testApi = "https://" + url + "/2.0/public/articles/" + idApi;
            driver.get(testApi);
            List<WebElement> listaCopeteCuerpo = driver.findElements(By.xpath("//div[@class='article-body mce-content-body mce-edit-focus']//p"));

                //VERIFICAR QUE FUNCIONE LA API
                String cuerpoSinSalto = cuerpo.replace("\n", "");
                jsonTituloNota =By.xpath("//pre[contains(text(), '\"title\":\""+nombreNota+"\"')]");
                jsonVolantaNota = By.xpath("//pre[contains(text(), '\"homeCaption\":\"\",\"shortTitle\":\""+valorVolanta+"\"')]");
                jsonCuerpoNota = By.xpath("//pre[contains(text(), '\"body\":\"<p>"+cuerpoSinSalto+"<\\/p> <p> <\\/p> <p> <\\/p> <p> ')]");
                By jsonCopete = By.xpath("//pre[contains(text(),'"+copete+"')]");

                jsonIdNota = setIdNote(idApi);
                checkTextElement(driver, jsonIdNota, idApi, test);
                checkTextElement(driver, jsonTituloNota, nombreNota, test);
                buscarValorTexto(driver,listaCopeteCuerpo,copete,test);
                checkTextElement(driver, jsonVolantaNota, valorVolanta, test);
                buscarValorTexto(driver,listaCopeteCuerpo,cuerpoSinSalto,test);
                login(driver, user, pass, url, ok, test);
                SELECTCOLOR(test,"[OK]: CREAR NOTA");


        } catch (Exception e) {
            errorColor(driver,"METODO createNote ", e , test);

        }
    }

    public void
    crear2notas(WebDriver driver, String test) throws InterruptedException {
        click(driver, btnNuevo, "BOTON NUEVA NOTA", test);
        switchToTabWithTitle(driver, "Sin Titulo", test);
        waitSpanElementNameInEditor(driver,"Sin Titulo","Contenidos",test);
        driver.switchTo().parentFrame();
        sendKeys2(driver, inputVolantaNota, "TD AUTOMATION VOLANTA PRUEBA UNO", "VOLANTA NOTA RELACIONADA 1", test);
        Thread.sleep(1000);
        sendKeys2(driver, inputTituloNota, "TD AUTOMATION PRUEBA UNO", "TITULO NOTA RELACIONADA 1", test);
        click(driver, btnGrabar, "BOTON GRABAR NOTA", test);
        esperarToast(driver, "TD AUTOMATION PRUEBA UNO","Contenidos",test);
        By tituloSpan = By.xpath("//span[@class='title']");
        if (!checkTextElement2(driver, tituloSpan, "TD AUTOMATION PRUEBA UNO", test)) {
            sendKeys2(driver, inputTituloNota, "TD AUTOMATION PRUEBA UNO", "INPUT TITULO NOTA", test);
            click(driver, btnGrabar, "BOTON GRABAR", test);
            esperarToast(driver, "TD AUTOMATION PRUEBA UNO","Contenidos",test);
        }

        driver.close();
        switchToTabWithTitle(driver, "Contenidos", test);
        switchToTabWithTitle(driver, "Contenidos", test);
        click(driver, btnNuevo, "BOTON NUEVA NOTA", test);
        switchToTabWithTitle(driver, "Sin Titulo", test);
        waitSpanElementNameInEditor(driver,"Sin Titulo","Contenidos",test);
        driver.switchTo().parentFrame();
        sendKeys4(driver, inputVolantaNota, "TD AUTOMATION VOLANTA PRUEBA 2", "VOLANTA NOTA RELACIONADA 2", test);
        sendKeys4(driver, inputTituloNota, "INJECTION DOS","TITULO NOTA RELACIONADA 2", test);
        click(driver, btnGrabar, "BOTON GRABAR NOTA", test);
        esperarToast(driver, "INJECTION DOS", "Contenidos",test);
        tituloSpan = By.xpath("//span[@class='title']");
        if (!checkTextElement2(driver, tituloSpan, "INJECTION DOS", test)) {
            sendKeys(driver, inputTituloNota, "INJECTION DOS", "INPUT TITULO NOTA", test);
            clickImplicit(driver, btnGrabar, "BOTON GRABAR", test);
            esperarToast(driver, "INJECTION DOS", "Contenidos",test);
        }
        driver.close();
        switchToTabWithTitle(driver, "Contenidos", test);
        sendKeys2(driver, inputFiltrar, "","TEXT BOX FILTRAR NOTA", test);
    }

    public void deleteNote(WebDriver driver, String tituloNota, String test)  {
//        SELECTCOLOR(test,"[START]: BORRAR NOTA");
        try {
            //FILTROS  NOTA

            checkboxContenidoFiltroNota = By.xpath("//span[text()='En Edición']");
            click(driver,checkboxContenidoFiltroNota, "CHECKBOX CONTENIDO FILTRO", test);
            if(driver.getCurrentUrl().contains("staging")){
                checkboxContenidoFiltroNota = By.xpath("//span[text()='Último mes']");
                click(driver,checkboxContenidoFiltroNota,"CLICK CHECKBOX FILTRO ULTIMO MES", test);
            }else{
                checkboxContenidoFiltroNota = By.xpath("//span[text()='Última semana']");
                click(driver,checkboxContenidoFiltroNota,"CLICK CHECKBOX FILTRO ULTIMA SEMANA", test);

            }
            headerObjeto = setHeaderNote(tituloNota);
//            verifyIfElementExists(driver,tituloNota,headerObjeto,"Contenidos",test);
//            List<String> pestañas = new ArrayList<>(driver.getWindowHandles());
//            if (pestañas.size() > 3) {
//                driver.switchTo().window(pestañas.get(pestañas.size() - 1)).close();
//                driver.switchTo().window(pestañas.get(1));
//            }
            click(driver,headerObjeto,tituloNota,test);
            cambiarPestania(driver,tituloNota,test);
            waitSpanElementNameInEditor(driver,tituloNota,"Contenidos",test);
            click(driver, btnInfo, "BOTON 3 PUNTOS", test);
            click(driver, btnEliminar, "BOTON ELIMINAR", test);
            click(driver, btnSi, "BOTON SI", test);
            switchToTabWithTitle(driver, "Contenidos", test);
            esVisibleTest(driver,btnNuevo,test);
            sendKeys2(driver, inputFiltrar, tituloNota, "INPUT FILTRAR", test);
            boolean notaBorrada = esInvisibleR(driver,headerObjeto,test);
            if(notaBorrada){
                sendKeys2(driver, inputFiltrar, "", "INPUT FILTRAR", test);
                headerObjeto = setHeaderNote("TD AUTOMATION PRUEBA UNO");
                verifyIfElementExists(driver,"TD AUTOMATION PRUEBA UNO",headerObjeto,"Contenidos", test);
                esVisibleTest(driver,btnNuevo,test);
                headerObjeto = setHeaderNote("INJECTION DOS");
                verifyIfElementExists(driver,"INJECTION DOS",headerObjeto,"Contenidos", test);
                esVisibleTest(driver,btnNuevo,test);
                SELECTCOLOR(test,"[OK]: BORRAR NOTA");
            }

        } catch (Exception e) {
            errorColor(driver,"METODO deleteNote ", e , test);


        }
    }

    public void createNoteFull(WebDriver driver, String nombreNota, String volanta, String copete, String cuerpo, String tag, String tipoTag, String category,
                               String archivo,String idImagen,String url, String estadoNotaRelacionada, String autor, String optionTexto, String tipoEmbed, String user, String pass, String test) throws IOException {
        try {
            checkboxContenidoFiltroNota = By.xpath("//span[text()='Último mes']");
            click(driver,checkboxContenidoFiltroNota,"CLICK CHECKBOX FILTRO ULTIMO MES", test);

            headerObjeto = setHeaderNote(nombreNota);
            verifyIfElementExists(driver, nombreNota, headerObjeto, "Contenidos", test);
            sendKeys(driver, inputFiltrar, "", "LIMPIAR TEXT BOX DE FILTRAR", test);
            if(driver.getCurrentUrl().contains("staging")) {
                headerObjeto = setHeaderNote("TD AUTOMATION PRUEBA UNO");
                verifyIfElementExists(driver, "TD AUTOMATION PRUEBA UNO", headerObjeto, "Contenidos", test);
                headerObjeto = setHeaderNote("INJECTION DOS");
                verifyIfElementExists(driver, "INJECTION DOS", headerObjeto, "Contenidos", test);
                sendKeys(driver, inputFiltrar, "", "LIMPIAR TEXT BOX DE FILTRAR", test);
            }
            cambiarFiltroEstadoNota(driver,"En Edición",false,test);
            cambiarFiltroEstadoNota(driver,"Publicado",true,test);

            filtrarFecha(driver,test);
            Thread.sleep(3000);
            //VERIFICAR QUE EXISTAN AL MENOS 2 NOTAS PARA RELACIONARLAS Y SI NO, CREA 2 NOTAS

            if(driver.getCurrentUrl().contains("staging")) {
                cambiarFiltroEstadoNota(driver,"Publicado",false,test);
            }
            esVisibleTest(driver,btnNuevo,test);

            By numeroArticulos = By.xpath("//div[@id='cms-results']//article//h2");
            int articulos = contarArticulos(driver,numeroArticulos , test);

            if(articulos<2){
                crear2notas(driver,test);
                notaCreada1 = true;
                notaCreada2 = true;
                headerObjeto = setHeaderNote("INJECTION DOS");
                cambiarFiltroEstadoNota(driver,"En Edición",true,test);
                checkboxContenidoFiltroNota = By.xpath("//span[text()='Última semana']");
                click(driver,checkboxContenidoFiltroNota,"CLICK CHECKBOX FILTRO ULTIMA SEMANA", test);
                Thread.sleep(2000);
                esVisibleTest(driver,headerObjeto,test);
            }
            headerObjeto = setHeaderNote(nombreNota);
            presenceOf(driver, infoWrapper, test);

            if(notaCreada1 || notaCreada2){
                cambiarFiltroEstadoNota(driver,"En Edición",true,test);
                cambiarFiltroEstadoNota(driver,"Publicado",false,test);
                esVisibleTest(driver,btnNuevo,test);
            }
            //OBTENER TITULO, ID y ESTADO DE NOTA PARA RELACIONAR
            cambiarFiltroEstadoNota(driver,"Publicado",true,test);
            Thread.sleep(3000);
            List<WebElement> obj = driver.findElements(By.xpath("//div[@id='cms-results']//article//h2"));
            String nota1 = obj.get(0).getText();
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            String idNotaAdj1 = obj.get(0).getAttribute("cms:value");
            By headerNota1 = By.xpath("//h2[text()='" + nota1 + "']");
            click(driver, headerNota1, "HEADER PRIMERA NOTA", test);
            switchToTabWithTitle(driver, nota1, test);
            By estadoNota = By.xpath("//div[@class='status-button']//div//span");
            boolean BtextoEstadoNota1 = visibilityOfReturn(driver, estadoNota,test);
            WebElement textoEstadoNota1 = null;
            if(BtextoEstadoNota1){
                textoEstadoNota1 = driver.findElement(estadoNota);
            }
            String estadoNota1 = obtenerEstado(textoEstadoNota1);

            driver.close();
            switchToTabWithTitle(driver, "Contenidos", test);
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article//h2"));
            String nota2 = obj.get(1).getText();
            obj = driver.findElements(By.xpath("//div[@id='cms-results']//article"));
            String idNotaAdj2 = obj.get(1).getAttribute("cms:value");
            By headerNota2 = By.xpath("//h2[text()='" + nota2 + "']");
            click(driver, headerNota2, "HEADER SEGUNDA NOTA", test);
            switchToTabWithTitle(driver, nota2, test);
            estadoNota = By.xpath("//div[@class='status-button']//div//span");
            boolean BtextoEstadoNota2 = encontrarElemento(driver, estadoNota);
            WebElement textoEstadoNota2 = null;
            if(BtextoEstadoNota2){
                textoEstadoNota2= driver.findElement(estadoNota);
            }
            String estadoNota2 = obtenerEstado(textoEstadoNota2);
            driver.close();
            switchToTabWithTitle(driver, "Contenidos", test);
            //CREAR NUEVA NOTA
            click(driver, btnNuevo, "CLICK BOTON NUEVO", test);


            click(driver, btnNuevo, "BOTON NUEVA NOTA",test);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            checkTitlePage(driver, "Sin Titulo",test);
            Thread.sleep(5000);

            // CARGAR TAG DESDE CUERPO
            driver.switchTo().frame("cuerpoiframe");
            driver.findElement(inputCuerpoNota).sendKeys("Agrupador TD AUTOMATION");
            WebElement elementCuerpo = driver.findElement(inputCuerpoNota);
            Thread.sleep(1000);
            elementCuerpo.sendKeys(Keys.SHIFT, Keys.HOME);
            // elementCuerpo.sendKeys(Keys.COMMAND + "A");
            clickJS(driver, btnTagNota, "Click tag dentro de nota",test);
            driver.switchTo().parentFrame();
            driver.switchTo().frame("subEditorIframe");
//            WebElement webElement = driver.findElement(By.xpath("//input[@id='volanta']"));
//            String valorBtnTagNota = webElement2.getAttribute("value");
//            checkValueElement(driver, inputNombreBtnTagNota, "Agrupador TD AUTOMATION",test);
            checkTextElement(driver,inputNombreBtnTagNota,"Agrupador TD AUTOMATION",test);
            Thread.sleep(1000);
            clickJS(driver, btnNuevoAgrupadorNota, "BOTON NUEVO AGRUPADOR EN EDITOR DE NOTA",test);
            Thread.sleep(1000);
            clickJS(driver, btnContinuarAgrupadorNota, "BOTON CONTINUAR AGRUPADOR EN EDITOR DE NOTA",test );
            Thread.sleep(1000);
            clickJS(driver, dropdownCategoriaTagNota, "BOTON TIPO AGRUPADOR EN EDITOR DE NOTA",test);
            Thread.sleep(1000);
            clickJS(driver, optionCategoriaTagNota, "OPTION AGRUPADOR EN EDITOR DE NOTA",test);
            Thread.sleep(1000);
            clickJS(driver, btnContinuarAgrupadorNota, "BOTON CONTINUAR AGRUPADOR EN EDITOR DE NOTA",test);
            Thread.sleep(1000);
            clickJS(driver, btnContinuarAgrupadorNota, "BOTON CONTINUAR AGRUPADOR EN EDITOR DE NOTA",test);
            Thread.sleep(5000);
            // visibiltyOf(driver, lblExcelenteNota);
            clickJS(driver, btnFinalizarTagNota, "BOTON FINALIZAR CREAR AGRUPADOR EN EDITOR DE NOTA",test);
            driver.switchTo().parentFrame();
            driver.switchTo().frame("cuerpoiframe");
            elementCuerpo.sendKeys(Keys.ENTER);
            // ENFASIS, CITA
            driver.findElement(inputCuerpoNota).sendKeys("cita TD AUTOMATION");
            Thread.sleep(1000);
            elementCuerpo.sendKeys(Keys.SHIFT, Keys.HOME);
            clickJS(driver, btnCitaNota, "BOTON INGRESAR CITA",test);
            elementCuerpo.sendKeys(Keys.ENTER);
            driver.findElement(inputCuerpoNota).sendKeys("enfasis TD AUTOMATION");
            Thread.sleep(1000);
            elementCuerpo.sendKeys(Keys.SHIFT, Keys.HOME);
            clickJS(driver, btnEnfasisNota, "BOTON ENFASIS NOTA",test);
            elementCuerpo.sendKeys(Keys.ENTER);
            clickJS(driver, btnEnfasisNota, "BOTON ENFASIS NOTA",test);
            clickJS(driver, btnNegritaNota, "BOTON NEGRITA NOTA",test);
            driver.findElement(inputCuerpoNota).sendKeys("Negrita" + Keys.ENTER);
            clickJS(driver, btnNegritaNota, "BOTON NEGRITA NOTA",test);
            clickJS(driver, btnItalicaNota, "BOTON ITALICA NOTA",test);
            driver.findElement(inputCuerpoNota).sendKeys("Italica" + Keys.ENTER);
            clickJS(driver, btnItalicaNota, "BOTON ITALICA NOTA",test);
            driver.findElement(inputCuerpoNota).sendKeys("Subtitulo H2" + Keys.ENTER);
            changeTextType(driver, "Subtitulo H2",test);
            clickJS(driver, btnEditorLinksNota, "BOTON INSERTAR LINK NOTA",test);
            driver.switchTo().parentFrame();
            driver.switchTo().frame("subEditorIframe");
            By tituloInsertarLinks = By.xpath("//div[contains(text(),'Insertar links')]");
            visibilityOf(driver, tituloInsertarLinks,test);
            sendKeys(driver, inputLinkUrl, "https://www.url.com", "INPUT URL NOTA",test);
            sendKeys(driver, inputLinkUrl, "TD AUTOMATION LINK URL", "INPUT LINK URL",test);
            sendKeys(driver, inputLinkTitulo, "TD AUTOMATION LINK URL", "INPUT LINK TITULO",test);
            clickJS(driver, dropdownLinkRelacion, "DROPDOWN LINK RELACION",test);
            clickJS(driver, optionLinkRelacion, "OPTION LINK RELACION",test);
            clickJS(driver, dropdownLinkDestino, "DROPDOWN LINK DESTINO",test);
            clickJS(driver, optionLinkDestino, "OPTION LINK DESTION",test);
            sendKeys(driver, inputLinkNotasRelacionadas, nota1, "INPUT LINK NOTAS RELACIONADAS",test);
            By checkboxLink = By.xpath("//div//input[@value='" + idNotaAdj1 + "']");
            clickJS(driver, checkboxLink, "CHECKBOX NOTA RELACIONADA 1",test);
            sendKeys(driver, inputLinkNotasRelacionadas, nota2, "INPUT LINK NOTA RELACIONADA",test);
            checkboxLink = By.xpath("//div//input[@value='" + idNotaAdj2 + "']");
            clickJS(driver, checkboxLink,"CHECKBOX LINK RELACIONADO",test ); // TODO ESPERAR FIX DEV
            clickJS(driver, btnGrabarLink, "BOTON GRABAR LINK",test);
            Thread.sleep(1000);
            driver.switchTo().parentFrame();
            driver.switchTo().frame("cuerpoiframe");
            clickJS(driver, btnEmbedNota, "BOTON EMBED NOTA",test);
            driver.switchTo().parentFrame();
            driver.switchTo().frame("subEditorIframe");
            clickJS(driver, dropdownEmbedTipo, "DROPDOWN EMBED NOTA",test);
            optionEmbedTipo = By.xpath("//li//span[contains(text(),'" + tipoEmbed + "')]");
            clickJS(driver, optionEmbedTipo, "OPTION EMBED TIPO",test);
            if (tipoEmbed.equals("Adjuntos")) {
                sendKeys(driver, inputEmbedArchivo, archivo, "INPUT EMBED ARCHIVO",test);
                checkboxAdjunto = By
                        .xpath("//*[@id='FileSearch_" + idImagen + "_item']/div/div/a/figure/div/label/input");
                clickJS(driver, checkboxAdjunto, "CHECKBOX ADJUNTO",test);
                clickJS(driver, btnRelacionarNota2, "BOTON RELACIONAR NOTA",test);
                // By btnCerrar = By.xpath("//a//span[contains(text(),'Cerrar')]");
                // clickJS(driver, btnCerrar);
            } else if (tipoEmbed.equals("Embed")) {
                sendKeys(driver, inputEmbed, embedPrueba, "INPUT EMBED",test);
                clickJS(driver, btnGrabarLink, "BOTON GRABAR LINK",test);
            }
            Thread.sleep(1000);
            // RELLENAR VOLANTA, TITULO, ETC
            sendKeys2(driver, inputCuerpoNota, cuerpo, "CUERPO DE NOTA", test);
            Thread.sleep(1000);
            driver.switchTo().parentFrame();
            sendKeys2(driver, inputVolantaNota, volanta, "VOLANTA NOTA", test);
            Thread.sleep(1000);
            sendKeys2(driver, inputTituloNota, nombreNota, "TITULO NOTA", test);
            Thread.sleep(1000);
            By iframeCopete = By.xpath("//iframe[@id='copeteiframe']");
            boolean copeteIframe = encontrarElemento(driver, iframeCopete);
            if (!copeteIframe) {
                sendKeys2(driver, inputCopeteNota, copete, "COPETE NOTA", test);
            } else {
                driver.switchTo().frame("copeteiframe");
                sendKeys2(driver, inputCuerpoNota, copete, "COPETE NOTA", test);
                driver.switchTo().parentFrame();
            }

            sendKeys(driver, inputArchivosNota, archivo, "INPUT ARCHIVO NOTA",test);
            checkboxAdjunto = By.xpath("//*[@id='FileList_" + idImagen +
                    "_item']/figure/div/label/input");
            Thread.sleep(2000);
            clickJS(driver, checkboxAdjunto, "CHECKBOX ADJUNTO",test);
            clickJS(driver, btnRelacionarNota, "BOTON RELACIONAR NOTA",test);
            Thread.sleep(3000);
            clickJS(driver, dropdownEstado, "DROPDOWN ESTADO NOTA RELACIONADA",test);
            By optionEstado = By.xpath("(//li//span[text()='" + estadoNotaRelacionada + "'])[2]");
            int indexEstado = 0;
            if (estadoNotaRelacionada.equals("Todos")) {
                indexEstado = 0;
            } else if (estadoNotaRelacionada.equals("Publicado")) {
                indexEstado = 1;
            } else if (estadoNotaRelacionada.equals("Pendiente")) {
                indexEstado = 2;
            } else if (estadoNotaRelacionada.equals("En Edición")) {
                indexEstado = 3;
            } else if (estadoNotaRelacionada.equals("Pendiente Validacion")) {
                indexEstado = 4;
            } else {
                System.exit(1);
            }
            List<WebElement> objEstado = driver
                    .findElements(By.xpath("//*[@id='ContentList_row-input']/div[3]/div/div/ul/li"));
            String idOption = objEstado.get(indexEstado).getAttribute("id");
            System.out.println(indexEstado);
            System.out.println(idOption);
            optionEstado = By.xpath("//*[@id='" + idOption + "']");
            clickJS(driver, optionEstado, "OPTION ESTADO",test);
            Thread.sleep(2000);
            sendKeys(driver, inputContenidosRelacionados, nota1, "INPUT CONTENIDOS RELACIONADOS",test);
            // By notaAdjVisible = By.xpath("//p[contains(text(),'" + nota1 + "')]");
            // visibiltyOf(driver, notaAdjVisible);
            checkBoxNota = By.xpath("//div[@class='checkbox-wrapper']//input[@value='" + idNotaAdj1 + "']");
            clickJS(driver, checkBoxNota, "CHECKBOX NOTA",test);
            Thread.sleep(2000);
            btnRelacionarNota = By.xpath("//*[contains(text(),'RELACIONAR')]");
            clickJS(driver, btnRelacionarNota, "BOTON RELACIONAR NOTA",test);
            Thread.sleep(1000);
            notaAdjTitulo = By.xpath("//div[@class='relatedItem__content']//div[contains(text(),'" + nota1 + "')]");
            visibilityOf(driver, notaAdjTitulo,test);
            sendKeys(driver, inputContenidosRelacionados, nota2, "INPUT NOTA RELACIONADA 2",test);
            // notaAdjVisible = By.xpath("//p[contains(text(),'" + nota2 + "')]");
            // visibiltyOf(driver, notaAdjVisible);
            checkBoxNota = By.xpath("//div[@class='checkbox-wrapper']//input[@value='" + idNotaAdj2 + "']");
            clickJS(driver, checkBoxNota, "CHECKBOX NOTA",test);
            Thread.sleep(2000);
            btnRelacionarNota = By.xpath("//*[contains(text(),'RELACIONAR')]");
            clickJS(driver, btnRelacionarNota, "BOTON RELACIONAR NOTA",test);
            Thread.sleep(1000);
            notaAdjTitulo = By.xpath("//div[@class='relatedItem__content']//div[contains(text(),'" + nota2 + "')]");
            visibilityOf(driver, notaAdjTitulo,test);

            sendKeys(driver, inputAgrupadoresNota, tag, "INPUT AGRUPADOR NOTA",test);
            optionAgrupadores = By.xpath("//li//span[text()='" + tipoTag + " » " + tag + "']");
            clickJS(driver, optionAgrupadores, "OPTION AGRUPADOR",test);
            sendKeys(driver, inputCategoriasNota, category, "INPUT CATEGORIA NOTA",test);
            optionCategorias = By.xpath("//span[text()='" + category + "']");
            clickJS(driver, optionCategorias, "OPTION CATEGORIA",test);
            sendKeys(driver, inputAutorNota, autor, "INPUT AUTOR NOTA",test);
            Thread.sleep(1000);
            optionAutorNota = By.xpath("//li//span[text()='" + autor + "']");
            clickJS(driver, optionAutorNota, "OPTION AUTOR ",test);
            WebElement webElement2 = driver.findElement(By.xpath("//input[@id='volanta']"));
            String valorVolanta = webElement2.getAttribute("value");

            clickJS(driver, moduloConfiguracion,"MODULO CONFIGURACION",test);
            clickJS(driver, btnMetatags, "BTN METATAGS",test);
            sendKeys(driver, inputMetatagTitulo, "metatitulo","input metatagtitulo",test);
            sendKeys(driver, inputMetatagDescripcion, "metadescripcion","input metatagdescripcion",test);
            sendKeys(driver, inputMetatagItemDropName, "metaitemdropname","input metatagitemdropname",test);
            sendKeys(driver, inputMetatagItemDropHeadline, "metaitemdropheadline","input metatagdropheadline",test);
            sendKeys(driver, inputMetatagItemDropDescripcion, "metaitemdropdescripcion","input metatagitemdropdescripcion",test);
            sendKeys(driver, inputMetatagLenguaje, "metalenguaje","input metataglenguaje",test);
            sendKeys(driver, inputMetatagRefresh, "metarefresh","input metatagrefresh",test);
            clickJS(driver, btnMetatags, "BTN METATAGS",test);
            clickJS(driver, btnOgtags, "BTN OGTAGS",test);
            Thread.sleep(2000);
            sendKeys(driver, inputOGTagTitulo, "ogtagtitulo","input ogtagtitulo",test);
            sendKeys(driver, inputOGTagImagen, "ogtagimagen","input ogtagimagen",test);
            sendKeys(driver, inputOGTagImagenAncho, "ogtagancho","input ogtagancho",test);
            sendKeys(driver, inputOGTagImagenAlto, "ogtagalto","input ogtagalto",test);
            clickJS(driver, btnOgtags, "BTN OGTAGS",test);
            clickJS(driver, btnTwitter,"BTN TWITTER",test);
            sendKeys(driver, inputTwitterTitulo, "twittertitulo","input twittertitulo",test);
            sendKeys(driver, inputTwitterDescripcion, "twitterdescripcion","input twitterdrescripcion",test);
            sendKeys(driver, inputTwitterImagen, "twitterimagen","input twitterimagen",test);
            clickJS(driver, btnTwitter,"BTN TWITTER",test);
            clickJS(driver, btnCrawlers,"BTN CRAWLERS",test);
            sendKeys(driver, inputCrawlerCanonicalLink, "crawlercanonical","input crawler canonicallink",test);
            sendKeys(driver, inputCrawlerRobots, "crawlerrobots","input crawler robots",test);
            clickJS(driver, btnCrawlers,"BTN CRAWLERS",test);
            clickJS(driver, btnGrabar,"BTN GRABAR",test);
            clickJS(driver, btnGrabar,"BTN GRABAR",test);
            clickJS(driver, btnGrabar,"BTN GRABAR",test);
            Thread.sleep(1000);
            String idApi = getNoteIdApi(driver.getCurrentUrl());
            // REFRESH + VERIFICAR CONFIGURACION
            driver.navigate().refresh();
            driver.switchTo().alert().accept();
            Thread.sleep(1000);
            By btnRecuperarCambios = By.xpath("//div//a//img[@alt='Recuperar cambios']");
            By btnAceptarCambios = By.xpath("(//*[contains(text(), 'Aceptar')])[4]");
            WebElement wRecuperar = driver.findElement(btnRecuperarCambios);
            if (wRecuperar.isDisplayed()) {
                clickJS(driver, btnRecuperarCambios,"BTN RECUPERAR CAMBIOS",test);
                Thread.sleep(1000);
                clickJS(driver, btnAceptarCambios,"BTN ACEPTAR CAMBIOS",test);
            }

            clickJS(driver, moduloConfiguracion,"MODULO CONFIGURACION",test);
            clickJS(driver, btnMetatags,"BTN METATAGS",test);
            checkTextElement(driver, inputMetatagTitulo, "metatitulo",test);
            checkTextElement(driver, inputMetatagDescripcion, "metadescripcion",test);
            checkTextElement(driver, inputMetatagItemDropName, "metaitemdropname",test);
            checkTextElement(driver, inputMetatagItemDropHeadline, "metaitemdropheadline",test);
            checkTextElement(driver, inputMetatagItemDropDescripcion, "metaitemdropdescripcion",test);
            checkTextElement(driver, inputMetatagLenguaje, "metalenguaje",test);
            checkTextElement(driver, inputMetatagRefresh, "metarefresh",test);
            clickJS(driver, btnMetatags,"BTN METATAGS",test);
            clickJS(driver, btnOgtags, "BTN OGTAGS",test);
            Thread.sleep(2000);
            checkTextElement(driver, inputOGTagTitulo, "ogtagtitulo",test);
            checkTextElement(driver, inputOGTagImagen, "ogtagimagen",test);
            checkTextElement(driver, inputOGTagImagenAncho, "ogtagancho",test);
            checkTextElement(driver, inputOGTagImagenAlto, "ogtagalto",test);
            clickJS(driver, btnOgtags, "BTN OGTAGS",test);
            clickJS(driver, btnTwitter,"BTN TWITTER",test);
            checkTextElement(driver, inputTwitterTitulo, "twittertitulo",test);
            checkTextElement(driver, inputTwitterDescripcion, "twitterdescripcion",test);
            checkTextElement(driver, inputTwitterImagen, "twitterimagen",test);
            clickJS(driver, btnTwitter,"BTN TWITTER",test);
            clickJS(driver, btnCrawlers,"BTN CRAWLERS",test);
            checkTextElement(driver, inputCrawlerCanonicalLink, "crawlercanonical",test);
            checkTextElement(driver, inputCrawlerRobots, "crawlerrobots",test);
            clickJS(driver, btnCrawlers,"BTN CRAWLERS",test);
            driver.close();
            driver.switchTo().window(tabs.get(0));
            headerObjeto = setHeaderNote(nombreNota);
            System.out.println("HEADER NOTA: " + headerObjeto.toString());
            visibilityOf(driver, headerObjeto,test);
            // VERIFICAR API
            String testApi = "https://" + url + "/2.0/public/articles/" + idApi;
            driver.get(testApi);
            List<WebElement> listaCopeteCuerpo = driver.findElements(By.xpath("//div[@class='article-body mce-content-body mce-edit-focus']//p"));

            //VERIFICAR QUE FUNCIONE LA API
            String cuerpoSinSalto = cuerpo.replace("\n", "");
            jsonTituloNota =By.xpath("//pre[contains(text(), '\"title\":\""+nombreNota+"\"')]");
            jsonVolantaNota = By.xpath("//pre[contains(text(), '\"homeCaption\":\"\",\"shortTitle\":\""+valorVolanta+"\"')]");
            jsonCuerpoNota = By.xpath("//pre[contains(text(), '\"body\":\"<p>"+cuerpoSinSalto+"<\\/p> <p> <\\/p> <p> <\\/p> <p> ')]");
            By jsonCopete = By.xpath("//pre[contains(text(),'"+copete+"')]");

            jsonIdNota = setIdNote(idApi);
            checkTextElement(driver, jsonIdNota, idApi, test);
            checkTextElement(driver, jsonTituloNota, nombreNota, test);
            buscarValorTexto(driver,listaCopeteCuerpo,copete,test);
            checkTextElement(driver, jsonVolantaNota, valorVolanta, test);
            buscarValorTexto(driver,listaCopeteCuerpo,cuerpoSinSalto,test);
            if (optionTexto.equals("Subtitulo H2")) {
                WebElement text = driver.findElement(jsonCopeteNota);
                System.out.println(text.getText());
                checkTextElement(driver, jsonCuerpoNota, "<h2>",test);
                // checkTextElement(driver, jsonCuerpoNota, "<h2>" + cuerpo + "</h2> <p> </p>");
            } else {
                checkTextElement(driver, jsonCuerpoNota, "<p>" + cuerpo + "</p> <p> </p> <p> </p>",test);
            }
            checkTextElement(driver, jsonCuerpoNota, "embed_cont type_imagen",test);
            checkTextElement(driver, jsonCuerpoNota, "id=\'" + idImagen + "'",test);
            checkTextElement(driver, jsonCuerpoNota, "Agrupador TD AUTOMATION",test);
            checkTextElement(driver, jsonCuerpoNota, "saysCMSEmphasis",test);
            checkTextElement(driver, jsonCuerpoNota, "enfasis TD AUTOMATION",test);
            String testApiArticulos = testApi + "?selectors=articlesRelated";
            // VERIFICAR ESTO
            driver.get(testApiArticulos);
            String testApiAutores = testApi + "?selectors=authors";
            driver.get(testApiAutores);
            By jsonCheck = By.xpath("/html/body/pre");
            checkTextElement(driver, jsonCheck, autor,test);
            checkTextElement(driver, jsonCheck, ".jpeg",test);
            login(driver, user, pass, url, ok, test);
            SELECTCOLOR(test,"[OK]: CREAR NOTA");

        } catch (Exception e) {
            errorColor(driver, "CREAR NOTA ERROR: " + e, e,test);

        }

    }

}

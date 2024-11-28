//package com.dacautomation.pages.cms;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//
//import java.util.ArrayList;
//
//
//
//
//public class texto_libre extends cms_base {
//    public texto_libre(WebDriver _driver) {
//        super(_driver);
//    }
//
//
//    By inputNombreBtnTagNota = By.xpath("//input[@id='nombre']");
//    By btnNuevoAgrupadorNota = By.xpath("//a[@id='Nuevo Agrupador']");
//    By btnContinuarAgrupadorNota = By.xpath("//a[@id='continue']");
//    By lblExcelenteNota = By.xpath("//*[@id='greetings-screen']/i");
//    By dropdownCategoriaTagNota = By.xpath("//*[@id='tag-no-encontrado']/div[1]/div/input");
//    By optionCategoriaTagNota = By.xpath("(//li//span[text()='Temas'])[2]");
//    By btnFinalizarTagNota = By.xpath("//a[@id='finalizar-btn']");
//    By btnCategorias = By.xpath("//span[text()='Categorias']");
//
//    By chipCategoriasTag = By.xpath("//div[@class='chip__body']/span[text()='test']");
//
//
//
//    By btnEncuesta = By.xpath("//span[text()='Encuestas']");
//    By inputOpcionesEncuesta = By.id("opciones_input");
//    By optionEncuesta = By.xpath("//span[text()='messi']");
//    By btnBanners = By.xpath("//span[text()='Banners']");
//    By dropdownTipoBanner = By.xpath("//div[@id='content_tipo']//input[@class='select-dropdown dropdown-trigger']");
//    By optionDropdownBanner = By.xpath("//span[text()='Script']");
//    By inputScriptBanner = By.xpath("//textarea[@id='script[2]']");
//    By inputSelectedOptionBanner = By.xpath("//li[@class='selected']//span[text()='Script']");
//    By inputNombreAdjuntoBanner = By.id("FileList_input");
//    By optionImgBanner = By.xpath("//figcaption[@data-type='(Imagen)']//span[text()='test']");
//    By inputAnchoBanner = By.id("width");
//    By inputLargoBanner = By.id("height");
//    By valorAnchoBanner = By.xpath("//input[@value='900']");
//    By valorLargoBanner = By.xpath("//input[@value='900']");
//    By valorTagBanner = By.xpath("//span[text()=' td automation tag ']");
//    By valorCategoriaBanner = By.xpath("//input[@value='900']");
//    By dropdownHomePortal = By.xpath("//a[@class='dropdown-trigger']//i[@class='material-icons']");
//    By btnCabezales = By.xpath("(//span[text()='Cabezales'])[2]");
//    By inputUrlCabezal = By.id("linkExterno");
//    By inputCaracteristicasCabezal = By.id("arrCaracteristicas_input");
//    By optionCaracteristicasCabezal = By.xpath("//li//span[text()='Categorias']");
//    By chipCaracteristicaCabezal = By.xpath("//div[@class='chip__body']//span[text()='Categorias']");
//    By selectedArchivo = By.xpath("//h4//span[text()='1']");
//    By btnPersonas = By.xpath("//span[text()='Personas']");
//    By inputEmailObjeto = By.xpath("//input[@id='email']");
//    By inputFacebookObjeto = By.xpath("//input[@id='facebook']");
//    By inputYoutubeObjeto = By.xpath("//input[@id='youtube']");
//    By inputLinkedinObjeto = By.xpath("//input[@id='linkedin']");
//    By inputBiografiaObjeto = By.xpath("//textarea[@id='texto3']");
//    By inputTwitterObjeto = By.xpath("//input[@id='twitter']");
//    By inputApodoObjeto = By.xpath("//input[@id='apodo']");
//
//
//
//
//    //    By dropdownEstado = By.xpath("//*[@id='ContentList_row-input']/div[3]/div/div/input");
//    By btnRelacionarNota2 = By.xpath("//*[@id='FileSearch_result_items']/div[2]/div[1]/a");
//    By optionArchivosNota = By.xpath("//span[contains(text(), 'Test Auto')]");
//    By articleAdjunto = By.xpath("//article[starts-with(@id,'Result')]");
//    By moduloConfiguracion = By.xpath("//a[text()='Configuración']");
//    By btnMetatags = By.xpath("//div[text()='Metatags']");
//    By btnOgtags = By.xpath("//div[text()='OG tags']");
//    By btnTwitter = By.xpath("//div[text()='Twitter']");
//    By btnCrawlers = By.xpath("//div[text()='Crawlers']");
//    By inputMetatagTitulo = By.xpath("//textarea[@id='metadata[title]']");
//    By inputMetatagDescripcion = By.xpath("//textarea[@id='metadata[property][description]']");
//    By inputMetatagItemDropName = By.xpath("//textarea[@id='metadata[itemprop][name]']");
//    By inputMetatagItemDropHeadline = By.xpath("//textarea[@id='metadata[itemprop][headline]']");
//    By inputMetatagItemDropDescripcion = By.xpath("//textarea[@id='metadata[itemprop][description]']");
//    By inputMetatagLenguaje = By.xpath("//textarea[@id='metadata[content-language]']");
//    By inputMetatagRefresh = By.xpath("//textarea[@id='metadata[refresh]']");
//    By inputOGTagTitulo = By.xpath("//textarea[@id='metadata[property][og:title]']");
//    By inputOGTagImagen = By.xpath("//textarea[@id='metadata[property][og:image]']");
//    By inputOGTagImagenAncho = By.xpath("//textarea[@id='metadata[property][og:image:width]']");
//    By inputOGTagImagenAlto = By.xpath("//textarea[@id='metadata[property][og:image:height]']");
//    By inputTwitterTitulo = By.xpath("//textarea[@id='metadata[name][twitter:title]']");
//    By inputTwitterDescripcion = By.xpath("//textarea[@id='metadata[name][twitter:description]']");
//    By inputTwitterImagen = By.xpath("//textarea[@id='metadata[name][twitter:image]']");
//    By inputCrawlerCanonicalLink = By.xpath("//textarea[@id='metadata[canonical]']");
//    By inputCrawlerRobots = By.xpath("//textarea[@id='metadata[robots]']");
//    By moduloContenido = By.xpath("//a[text()='Contenido']");
//    By inputAutorNota = By.id("arrPersona_input");
//    By optionAutorNota;
//    By btnTipoDeTexto = By.xpath("(//button[@title='Párrafo'])[1]");
//    By btnNegritaNota = By.xpath("//button[@title='Negrita']");
//    By btnItalicaNota = By.xpath("//button[@title='Itálica']");
//    By btnEditorLinksNota = By.xpath("//button[@title='Agregar nota en bajada']");
//    By inputLinkUrl = By.id("link-url");
//    By inputLinkUrlTexto = By.id("link-text");
//    By inputLinkTitulo = By.id("link-title");
//    By dropdownLinkRelacion = By.id("content_link-relation");
//    By optionLinkRelacion = By.xpath("//li//span[text()='No Follow']");
//    By inputLinkNotasRelacionadas = By.id("RelatedLinks_input");
//    By dropdownLinkDestino = By.id("content_link-target");
//    By optionLinkDestino = By.xpath("//li//span[text()='Ventana actual']");
//    By btnGrabarLink = By.xpath("//a//span[text()='Grabar']");
//    By btnEmbedNota = By.xpath("//button[@title='Incrustado']");
//    By btnTagNota = By.xpath("//button[@title='Agrupador']");
//    By btnCitaNota = By.xpath("//button[@title='Cita']");
//    By btnEnfasisNota = By.xpath("//button[@title='Enfasis']");
//    By dropdownEmbedTipo = By.xpath("//div[@id='content_tipoembed']//div");
//    By optionEmbedTipo = By.xpath("//li//span[contains(text(),'Adjuntos')]");
//    By inputEmbedArchivo = By.xpath("//div//input[@id='FileSearch_input']");
//    By inputEmbed = By.xpath("//div//textarea[@id='embed_text']");
//    String embedPrueba = "<blockquote class='twitter-tweet'><p lang='es' dir='ltr'>hoy si nos hemos dado la mano <a href='https://t.co/rDCzimBuCx'>pic.twitter.com/rDCzimBuCx</a></p>&mdash; Ibai (@IbaiLlanos) <a href='https://twitter.com/IbaiLlanos/status/1424155728856682496?ref_src=twsrc%5Etfw'>August 7, 2021</a></blockquote> <script async src='https://platform.twitter.com/widgets.js' charset='utf-8'></script>";
//    By btnTextoLibre = By.xpath("//span[text()='Texto Libre']");
//    By cuerpoToolbar = By.xpath("//div[@class='tox-toolbar']");
//    By calendarMonth = By.xpath("//div[@class='datepicker-controls']//div//div[@class='select-wrapper select-month']");
//    By calendarYear = By.xpath("//div[@class='datepicker-controls']//div//div[@class='select-wrapper select-year']");
//    By calendarDay = By.xpath("//tr//td//button[@data-day='9']");
//    By notaEstado = By.xpath("//div[@class='status-button']//div//span[text()='En Edición']");
//    By optionNotaEstado = By.xpath("//div[@class='status-card']//div//span[text()='Publicado']");
//    By dropdownTipoContenidoNota = By.xpath("//div[@id='content_idCMSTipoContenido']//div//input");
//    By optionTipoContenidoNota = By.xpath("//div[@id='content_idCMSTipoContenido']//ul//li//span[text()='Nota']");
//
//    By lblSEO = By.xpath("//div[@id='seo-meter']//p[contains(text(),'SEO')]");
//
//    public void createFreeText(WebDriver driver, String descripcion, String texto) {
//        try {
//            System.out.println("##############CREAR TEXTO LIBRE##############");
//            click(driver, btnTextoLibre);
//            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(1));
//            click(driver, btnNuevo);
//            tabs = new ArrayList<String>(driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(2));
//            Thread.sleep(5000);
//            driver.switchTo().frame("textoiframe");
//            visibiltyOf(driver, cuerpoToolbar);
//            sendKeys(driver, inputCuerpoNota, texto + Keys.ENTER);
//            driver.switchTo().parentFrame();
//            sendKeys(driver, tituloAdjunto, descripcion);
//            clickJS(driver, btnGrabar);
//            presenceOf(driver, alertGuardado);
//            driver.navigate().refresh();
//            checkValueElement(driver, tituloAdjunto, descripcion);
//            driver.switchTo().frame("textoiframe");
//            checkTextElement(driver, inputCuerpoNota, texto);
//            driver.switchTo().parentFrame();
//            driver.close();
//            driver.switchTo().window(tabs.get(1));
//            Thread.sleep(2000);
//            setHeaderNote(descripcion);
//            sendKeys(driver, inputFiltrar, descripcion);
//            driver.findElement(inputFiltrar).sendKeys(Keys.ENTER);
//            visibiltyOf(driver, headerObjeto);
//            driver.close();
//            Thread.sleep(1000);
//            System.out.println("SIZE: " + tabs.size());
//            tabs = new ArrayList<String>(driver.getWindowHandles());
//            System.out.println("SIZE: " + tabs.size());
//            driver.switchTo().window(tabs.get(0));
//            System.out.println("##############CREAR ADJUNTO OK##############");
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//
//    }
//}

//package com.dacautomation.pages.fast;
//
//import org.openqa.selenium.WebDriver;
//
//public class grilla extends fast_base {
//
//    static String visibleGrilla = "document.querySelector(\"#root > fast-main > fast-grid-admin\").shadowRoot.querySelector(\"main > td-aside > div.flex.justify-center > button\")";
//    static String inputNombreGrilla = "document.querySelector(\"#root > fast-main > fast-grid-admin\").shadowRoot.querySelector(\"fast-modal\").shadowRoot.querySelector(\"dile-modal > div > div > main > create-grid\").shadowRoot.querySelector(\"#name\")";
//    static String Spinner = "document.querySelector(\"#loaderContainer > td-spinner\").shadowRoot.querySelector(\"div > div\")";
//    static String btnGuardarGrilla = "document.querySelector(\"#root > fast-main > fast-grid-admin\").shadowRoot.querySelector(\"fast-modal\").shadowRoot.querySelector(\"dile-modal > div > div > main > create-grid\").shadowRoot.querySelector(\"form > div.td-form-group.gap-2.flex.items-center.justify-end > button\")";
//
//    public static void crearGrilla(WebDriver driver) throws InterruptedException{
//
//        fast_base.shadowClick(driver, visibleGrilla);
//        fast_base.shadowNotVisibleElement(driver, Spinner, "Spinner");
//        fast_base.shadowSendKeys2(driver, inputNombreGrilla, "FAST AUTOMATION PRUEBA GRILLA");
//        fast_base.shadowClickableElement(driver, btnGuardarGrilla, "Boton Guardar Grilla");
//        fast_base.shadowClick(driver, btnGuardarGrilla);
//        Thread.sleep(5000);
//    }
//
//}

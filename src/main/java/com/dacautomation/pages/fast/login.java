//package com.dacautomation.pages.fast;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class login  {
//
//
//    static By inputUser = By.id("username");
//    static By btnIngresar = By.id("submit");
//    static String ingresarJSPath = "document.querySelector('#root > fast-user-login').shadowRoot.querySelector('#loginForm > div.text-center.mt-10 > button')";
//    static String visibleGrilla = "document.querySelector(\"#root > fast-main > fast-grid-admin\").shadowRoot.querySelector(\"main > td-aside > div.flex.justify-center > button\")";
//
//    public static void loggear(WebDriver driver) throws InterruptedException{
//
//        // driver = base.setup(driver);
//        driver.get("https://staging-backend.fast.thinkindot.com/vod");
//        fast_base.shadowSendKeys(driver,"fast-user-login","username","medcomgo");
//        fast_base.shadowSendKeys(driver,"fast-user-login","password","medcomgodac");
//        // Thread.sleep(2000);
//        fast_base.shadowClick(driver, ingresarJSPath);
//        fast_base.shadowVisibleElement(driver, visibleGrilla, "Boton Nueva Grilla");
//
//    }
//}

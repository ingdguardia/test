//package com.dacautomation.pages.fast;
//import java.time.Duration;
//import java.util.NoSuchElementException;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.dacautomation.tests.cms.Elements;
//
//public class fast_base extends Elements {
//
//    public static void shadowSendKeys(WebDriver driver, String componente, String elementoWeb, String texto){
//     // Use JavaScript to find the desired element within the Shadow DOM
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement shadowElement = (WebElement) js.executeScript(
//            // "return document.querySelector('fast-user-login').shadowRoot.querySelector('#username')"
//            "return document.querySelector('"+componente+"').shadowRoot.querySelector('#"+elementoWeb+"')"
//        );
//        // Perform actions on the Shadow DOM element
//        shadowElement.sendKeys(texto);
//    }
//
//    public static void shadowSendKeys2(WebDriver driver, String elementoWeb, String texto){
//        // Use JavaScript to find the desired element within the Shadow DOM
//           JavascriptExecutor js = (JavascriptExecutor) driver;
//           WebElement shadowElement = (WebElement) js.executeScript(
//               // "return document.querySelector('fast-user-login').shadowRoot.querySelector('#username')"
//               "return "+elementoWeb
//           );
//           // Perform actions on the Shadow DOM element
//           shadowElement.sendKeys(texto);
//       }
//
//    public static void shadowClick(WebDriver driver, String elementoWeb){
//        // Use JavaScript to find the desired element within the Shadow DOM
//           JavascriptExecutor js = (JavascriptExecutor) driver;
//           WebElement shadowElement = (WebElement) js.executeScript(elementoWeb+".click();");
//           // Perform actions on the Shadow DOM element
//        //    shadowElement.click();
//        System.out.println("click");
//       }
//
//    public static void shadowVisibleElement(WebDriver driver, String elementoWeb, String nombreElemento){
//
//        try {
//            WebElement shadowRootElement = (WebElement) ((JavascriptExecutor) driver)
//            .executeScript("return document.querySelector('your-shadow-root-selector')");
//
//    ExpectedCondition<Boolean> shadowElementVisible = new ExpectedCondition<Boolean>() {
//        @Override
//        public Boolean apply(WebDriver driver) throws StaleElementReferenceException {
//            try {
//                WebElement shadowElement = (WebElement) ((JavascriptExecutor) driver)
//                        .executeScript("return "+elementoWeb, shadowRootElement);
//                return shadowElement != null && shadowElement.isDisplayed();
//            } catch (NoSuchElementException | WebDriverException e) {
//                return false;
//            }
//        }
//
//        @Override
//        public String toString() {
//            return "visibility of shadow element";
//        }
//    };
//
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    wait.until(shadowElementVisible);
//
//    WebElement shadowElement = (WebElement) ((JavascriptExecutor) driver)
//            .executeScript("return "+elementoWeb, shadowRootElement);
//
//    System.out.println(shadowElement.isDisplayed());
//
//        } catch (Exception e) {
//            errorColor(driver, "CMS-005: " + nombreElemento + " RAZON: " + e, e);
//        }
//    }
//
//    public static void shadowNotVisibleElement(WebDriver driver, String elementoWeb, String nombreElemento){
//        try {
//            WebElement shadowRootElement = (WebElement) ((JavascriptExecutor) driver)
//            .executeScript("return document.querySelector('your-shadow-root-selector')");
//
//    ExpectedCondition<Boolean> shadowElementVisible = new ExpectedCondition<Boolean>() {
//        @Override
//        public Boolean apply(WebDriver driver) throws StaleElementReferenceException {
//            try {
//                WebElement shadowElement = (WebElement) ((JavascriptExecutor) driver)
//                        .executeScript("return "+elementoWeb, shadowRootElement);
//                return shadowElement == null || !shadowElement.isDisplayed();
//            } catch (NoSuchElementException | WebDriverException e) {
//                return false;
//            }
//        }
//
//        @Override
//        public String toString() {
//            return "invisibility of shadow element";
//        }
//    };
//
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    wait.until(shadowElementVisible);
//    WebElement shadowElement = (WebElement) ((JavascriptExecutor) driver)
//            .executeScript("return "+elementoWeb, shadowRootElement);
//    System.out.println(shadowElement.isDisplayed());
//
//        } catch (Exception e) {
//            errorColor(driver, "CMS-005: " + nombreElemento + "RAZON: " + e, e);
//        }
//
//}
//
//    public static void shadowClickableElement(WebDriver driver, String elementoWeb, String nombreElemento){
//
//        try {
//            WebElement shadowRootElement = (WebElement) ((JavascriptExecutor) driver)
//            .executeScript("return document.querySelector('your-shadow-root-selector')");
//
//    // Define a custom ExpectedCondition for visibility of the shadow element
//    ExpectedCondition<Boolean> shadowElementVisible = new ExpectedCondition<Boolean>() {
//        @Override
//        public Boolean apply(WebDriver driver) throws StaleElementReferenceException {
//            try {
//                // Check if the shadow element is visible
//                WebElement shadowElement = (WebElement) ((JavascriptExecutor) driver)
//                        .executeScript("return "+elementoWeb, shadowRootElement);
//                return shadowElement != null && shadowElement.isEnabled();
//            } catch (NoSuchElementException | WebDriverException e) {
//                // Return false if the element is not found or there's any exception
//                return false;
//            }
//        }
//
//        @Override
//        public String toString() {
//            return "visibility of shadow element";
//        }
//    };
//
//    // Wait for the shadow element to be visible
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    wait.until(shadowElementVisible);
//
//    // Now, interact with the visible shadow element
//    WebElement shadowElement = (WebElement) ((JavascriptExecutor) driver)
//            .executeScript("return "+elementoWeb, shadowRootElement);
//
//    // For example, you can get the text of the shadow element
//    System.out.println(shadowElement.isDisplayed());
//
//        } catch (Exception e) {
//            errorColor(driver, "CMS-005: " + nombreElemento + "RAZON: " + e, e);
//        }
//
//
//
//
//    }
//}

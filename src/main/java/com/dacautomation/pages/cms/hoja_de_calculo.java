//package com.dacautomation.pages.cms;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import java.io.IOException;
//import java.util.List;
//
//public class hoja_de_calculo {
//
//
//    public void createSpreadSheet(WebDriver driver, String nombreElemento) throws IOException, InterruptedException {
//        titleColor(driver, "TEST SPREADSHEET");
//        try {
//            goToSection(driver, "Spreadsheet", nombreElemento);
//            waitFrame(driver, "spreadsheetContent");
//            Thread.sleep(2000);
//            List<WebElement> rowsNumber = driver
//                    .findElements(By.xpath("//*[@id='spreadsheetData']/div[4]/div/div/div/table/tbody/tr"));
//            int rowCount = rowsNumber.size();
//            System.out.println("No of rows in this table : " + rowCount);
//            List<WebElement> columnsNumber = driver
//                    .findElements(By.xpath("//*[@id='spreadsheetData']/div[1]/div/div/div/table/thead/tr/th"));
//            int columnCount = columnsNumber.size();
//            System.out.println("No of columns in this table : " + columnCount);
//
//            for (int i = 1; i < 10; i++) {
//                for (int j = 1; j < 10; j++) {
//                    System.out.println("Fila: " + i + ", Columna: " + j);
//                    // By celda = By
//                    // .xpath("//*[@id='spreadsheetData']/div[1]/div/div/div/table/tbody/tr[" + i +
//                    // "]/td[" + j
//                    // + "]");
//                    By celda = By.xpath("(//table[@class='htCore'])[1]/tbody/tr[" + i + "]/td[" + j + "]");
//                    // clickJS(driver, celda);
//                    visibiltyOf(driver, celda);
//                    System.out.println(celda.toString());
//                    click(driver, celda);
//                    String celdaT = "f: " + i + " c: " + j;
//                    sendKeys2(driver, celda, celdaT);
//                }
//            }
//            driver.switchTo().parentFrame();
//            sendKeys(driver, tituloAdjunto2, nombreElemento);
//            clickJS(driver, btnGrabar);
//            Thread.sleep(500);
//            presenceOf(driver, alertGuardado);
//            driver.navigate().refresh();
//            checkValueElement(driver, tituloAdjunto2, nombreElemento);
//            waitFrame(driver, "spreadsheetContent");
//
//            for (int i = 1; i < 10; i++) {
//                for (int j = 1; j < 10; j++) {
//                    By celda = By.xpath("(//table[@class='htCore'])[1]/tbody/tr[" + i + "]/td[" + j + "]");
//                    String celdaT = "f: " + i + " c: " + j;
//                    checkTextElement(driver, celda, celdaT);
//                }
//            }
//            okColor(driver, "TEST SPREADSHEET");
//
//        } catch (Exception e) {
//            errorColor(driver, "TEST SPREADSHEET" + e.toString(), e);
//        }
//        endColor(driver, "TEST SPREADSHEET");
//
//    }
//
//}

//package com.dacautomation.DataProvider;
//
//import org.testng.annotations.Test;
//
//import com.dacautomation.tests.cms.Elements;
//
//public class ParallelTests extends Elements {
//
//    @Test(dataProvider = "data", dataProviderClass = URLDataProvider.class)
//    // public void testWithUrl(List<String> url) {
//    public void testWithUrl(String data) {
//
//        // Coloca tu lógica de prueba que utilice la URL
//        // Puedes utilizar la URL pasada como parámetro en cada prueba
//        System.out.println("Ejecutando prueba para data: " + data);
//
//    }
//}
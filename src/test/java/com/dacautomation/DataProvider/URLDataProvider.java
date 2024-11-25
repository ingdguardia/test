//package com.dacautomation.DataProvider;
//import com.dacautomation.tests.cms.Elements;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.dacautomation.pages.cms.cms_base;
//import org.testng.annotations.DataProvider;
//
//
//
//
//public class URLDataProvider {
//
//    @DataProvider(name = "data")
//    public static Object[][] getDataAsDataProvider() {
//
//        List<String> data = URLProvider.getData();
//
////        List<List<String>> listasDivididas = cms_base.dividirLista(data);
//
////        List<String> datosExtraidos = listasDivididas.get(0);
//
//        System.out.println("Data RAW: "+data);
//
//        List<String> data1 = new ArrayList<>();
//        for (int i = 0; i < data.size(); i+=3) {
//            data1.add(data.get(i));
//        }
////        Object[][] dataObjects = new Object[listasDivididas.get(0).size()][];
//
//        for (int i = 0; i < data1.size(); i++) {
////            dataObjects[i] = new Object[] { data1.get(i) };
//        }
//
////        return dataObjects;
//
//
//

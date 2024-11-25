//package com.dacautomation.DataProvider;
//
//import com.dacautomation.pages.cms.cms_base;
//import org.testng.annotations.DataProvider;
//
//import com.dacautomation.tests.cms.Elements;
//
//import java.util.List;
//
//public class URLDataProvider2 {
//
//    @DataProvider(name = "data")
//    public static Object[][] getDataAsDataProvider() {
//
//        List<String> data = URLProvider.getData();
//
//        List<List<String>> listasDivididas = cms_base.dividirLista(data);
//
//        List<String> datosExtraidos = listasDivididas.get(1);
//        System.out.println("datos extraidos: "+datosExtraidos);
//
//        Object[][] dataObjects = new Object[listasDivididas.get(1).size()][];
//
//        for (int i = 0; i < datosExtraidos.size(); i++) {
//            dataObjects[i] = new Object[] { datosExtraidos.get(i) };
//        }
//
//        return dataObjects;
//
//    }
//}

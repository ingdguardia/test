package com.dacautomation.DataProvider;

import com.dacautomation.pages.cms.cms_base;

import java.util.ArrayList;
import java.util.List;


public class URLProvider {
    public static List<String> getData() {
        // Lógica para extraer las URLs y almacenarlas en una lista
        List<String> data = new ArrayList<>();
         data = cms_base.initializeAWS();
//        System.out.println("DATA: "+data);
        return data;
    }
}
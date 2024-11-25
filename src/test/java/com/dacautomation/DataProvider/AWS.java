package com.dacautomation.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParametersByPathRequest;
import software.amazon.awssdk.services.ssm.model.GetParametersByPathResponse;
import software.amazon.awssdk.services.ssm.model.Parameter;
import software.amazon.awssdk.services.ssm.model.ParameterNotFoundException;
import software.amazon.awssdk.services.ssm.model.SsmException;


public class AWS {
    public static void main(String[] args) {

         // Aqui guardo todos los parametros configurados
    ArrayList<Parameter> jobConfig = new ArrayList<>();
    
        // Los busco
        try {
    
          // El nombre del job viene por variable de ambiente
          String jobname = System.getenv("JOB_NAME");
          
          if (jobname == null) {
            System.err.println("ERROR: No se encuentra nombre del job");
            System.exit(2);
          }
    
          // Creo el cliente de SSM
          Region region = Region.US_EAST_1;
          SsmClient ssmClient = SsmClient.builder().region(region).build();
    
          // Loop para traer los parametros, por el limite de 10
          String nextToken = null;
          while (Boolean.TRUE) {
            GetParametersByPathRequest parameterRequest = GetParametersByPathRequest.builder().path("/thinkindot/jenkins/job/" + jobname).recursive(Boolean.TRUE).withDecryption(Boolean.TRUE).nextToken(nextToken).build();
            GetParametersByPathResponse parameterResponse = ssmClient.getParametersByPath(parameterRequest);
            jobConfig.addAll(parameterResponse.parameters());
            nextToken = parameterResponse.nextToken();
            if (nextToken == null) break;
          }
        } catch (ParameterNotFoundException e) {

          // No se encuenta el parametro, muestro warning pero retorno OK (puede no estar configurado adrede)
          System.err.println("ATENCION: No se encuentra configuracion para el job en Parameter Store");
          System.err.println(e.getMessage());
          System.exit(0);
        } catch (SsmException e) {
          // Una excepcion generica de SSM, retorno INESTABLE para que haya que revisar que paso
          System.err.println("ATENCION: Se ha generado una excepcion de SSM");
          System.err.println(e.getMessage());
          System.exit(2);
        } catch (Exception e) {

          // Una excepcion generica del SDK, retorno INESTABLE para que haya que revisar que paso
          System.err.println("ATENCION: Se ha generado una excepcion del SDK");
          System.err.println(e);
          System.exit(2);
        }
        if (jobConfig.size() == 0) {
    
          // Se encuentra el parametro en SSM pero esta vacio, retorno OK
          System.err.println("ATENCION: La configuracion para el job en Parameter Store esta vacia");
          System.exit(0);
        }
    
        // Transformo a algo usable
        
        List<String> urls = new ArrayList<>();
        List<String> names = new ArrayList<>();
        HashMap<String, HashMap<String, HashMap<String, String>>> jobConfigMap = new HashMap<>();
        jobConfig.forEach(
          (item) -> {
            ArrayList<String> path = new ArrayList<String>(Arrays.asList(item.name().split("/")));
            String name = path.get(path.size() - 3);
            String type = path.get(path.size() - 2);
            String attr = path.get(path.size() - 1);
            String value = item.value();
            HashMap<String, HashMap<String, String>> site = jobConfigMap.get(name);
            if (site == null) site = new HashMap<>();
            HashMap<String, String> config = site.get(type);
            if (config == null) config = new HashMap<>();
            config.put(attr, value);
            site.put(type, config);
            jobConfigMap.put(name, site);
            names.add(type);

          }
        );
    
        // Imprimo
        System.err.println(jobConfigMap);
      }

}

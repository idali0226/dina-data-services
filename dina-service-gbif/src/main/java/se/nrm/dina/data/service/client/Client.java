/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.data.service.client;
  
import javax.ws.rs.core.Response;  
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
 

/**
 *
 * @author idali
 */
public class Client {
     
    private static final String BASE_LOCAL_URL = "http://localhost:8080/dina-rest/gbif";
    
    private static ResteasyClient client;
    private static ResteasyWebTarget target;
    
    public static void main(String[] args) {
        client = new ResteasyClientBuilder().build(); 
        
        testDarwinCoreData();
    }

    private static void testDarwinCoreData() {

        String startDate = "2012-10-10";
        String endDate = "2012-10-12";
        int id = 0;

        String url = BASE_LOCAL_URL + "/" + startDate + "/" + endDate + "/" + id;

        target = client.target(url);
        Response response = target.request().get();
        String json = response.readEntity(String.class);  
        
//        String result = response.getEntity();
        System.out.println("result : " + json);
    }
}

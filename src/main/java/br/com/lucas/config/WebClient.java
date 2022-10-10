package br.com.lucas.config;

import br.com.lucas.model.Brand;
import br.com.lucas.repository.exception.ExceptionHandler;
import com.google.gson.Gson;
import java.io.File;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class WebClient {

    public  static String baseUrl = "http://localhost:8081/api/v1";

    public <T> Object get(Class<T> t,String url){

        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(baseUrl+url);
        Response response = target.request().get();


        ExceptionHandler.check(response.getStatus());

        String json = response.readEntity(String.class);

        out.println("Response:"+json);

      return  this.gsonNow().fromJson(json,t);
    }



    public String getJson( String url){
        out.println(url);
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(baseUrl+url);
        Response response = target.request().get();

        ExceptionHandler.check(response.getStatus());

        String json = response.readEntity(String.class);

        out.println("Response:"+json);

     return json;


    }

    public String post(Object t,String url){
        var json = this.gsonNow().toJson(t);
        out.println(json);
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(baseUrl+url);
        Response response = target.request().post(Entity.json(json));

        ExceptionHandler.check(response.getStatus());
        String jsonResponse = response.readEntity(String.class);
        out.println("Response:"+jsonResponse);


        return  jsonResponse;
    }
  
    

    public void put(Object t,String url){
        var json = this.gsonNow().toJson(t);
        out.println(json);
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(baseUrl+url);
        Response response = target.request().put(Entity.json(json));

        ExceptionHandler.check(response.getStatus());

        out.println("Response:"+response.readEntity(String.class));

    }
      public void put(String url){
        
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(baseUrl+url);
        Response response = target.request().put(Entity.json(""));

        ExceptionHandler.check(response.getStatus());

        out.println("Response:"+response.readEntity(String.class));

    }

    

    public void delete(String url){

        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(baseUrl+url);
        Response response = target.request().delete();

        ExceptionHandler.check(response.getStatus());

        out.println("Status:"+response.getStatus());
    }

    public Gson gsonNow(){
        return new Gson();
    }

    public static WebClient now(){
        return  new WebClient();
    }

}

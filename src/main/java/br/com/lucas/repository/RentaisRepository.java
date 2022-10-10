package br.com.lucas.repository;

import br.com.lucas.config.WebClient;
import br.com.lucas.dto.CheckAvailabilityRentais;
import br.com.lucas.dto.CheckById;
import br.com.lucas.dto.RentaisNew;
import br.com.lucas.model.Rentais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentaisRepository {
    public static String url= "/rentais";

    public Rentais findById(Integer id){
        Rentais rentais= (Rentais) WebClient.now().get(Rentais.class,url+"/find?id="+id);
        return rentais;
    }
    
    public CheckById checkById(Integer id){
        String json = WebClient.now().getJson(url+"/check?id="+id);
          
        return WebClient.now().gsonNow().fromJson(json, CheckById.class);
    }
    
    public List<Rentais> findAll(){
        String json = WebClient.now().getJson(url);
        var gson = WebClient.now().gsonNow();
        Rentais[] list = gson.fromJson(json,Rentais[].class);


        return new ArrayList<Rentais>(Arrays.asList(list));
    }


    public Rentais post(RentaisNew rentaisNew){


    var json =    WebClient.now().post(rentaisNew,url);


    return WebClient.now().gsonNow().fromJson(json,Rentais.class);

    }
    public void checkAvailability(CheckAvailabilityRentais checkAvailabilityRentais){


        WebClient.now().post(checkAvailabilityRentais,url+"/checkAvailability");


     

    }
    public void extend_period(Integer rentai_id,Integer plus_days){
        
         WebClient.now().put(url+"/extend-period?rentai_id="+rentai_id+"&plus_days="+plus_days);
        
    }

    public void delete(Integer id){
        WebClient.now().delete(url+"?id="+id);
    }


}

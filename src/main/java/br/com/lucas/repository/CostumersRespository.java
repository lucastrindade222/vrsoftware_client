package br.com.lucas.repository;

import br.com.lucas.config.WebClient;
import br.com.lucas.dto.CostumersNew;
import br.com.lucas.model.Costumers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CostumersRespository {
    public static String url= "/costumers";

    public Costumers findById(Integer id){
        Costumers  costumers = (Costumers) WebClient.now().get(Costumers.class,url+"/find?id="+id);
        return  costumers;
    }
    public List<Costumers> findAll(){
        String json = WebClient.now().getJson(url);
        var gson = WebClient.now().gsonNow();
        Costumers[] list = gson.fromJson(json,Costumers[].class);


        return new ArrayList<Costumers>(Arrays.asList(list));
    }
    public void post(CostumersNew costumers){

        WebClient.now().post(costumers,url);

    }

    public void put(Costumers costumers){

        WebClient.now().put(costumers,url);

    }
    public void delete(Integer id){
        WebClient.now().delete(url+"?id="+id);
    }
}

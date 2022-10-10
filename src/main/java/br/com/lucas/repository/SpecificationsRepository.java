package br.com.lucas.repository;

import br.com.lucas.config.WebClient;
import br.com.lucas.model.Category;
import br.com.lucas.model.Specifications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecificationsRepository {

    public static String url= "/specifications";

    public Specifications findById(Integer id){
        Specifications specifications= (Specifications) WebClient.now().get(Specifications.class,url+"/find?id="+id);
        return specifications;
    }
    public List<Specifications> findAll(){
        String json = WebClient.now().getJson(url);
        var gson = WebClient.now().gsonNow();
        Specifications[] list = gson.fromJson(json,Specifications[].class);


        return new ArrayList<Specifications>(Arrays.asList(list));
    }
    public Specifications post(Specifications specifications){
        specifications.setId(null);

    var json =    WebClient.now().post(specifications,url);

    return WebClient.now().gsonNow().fromJson(json, Specifications.class);
    }

    public void delete(Integer id){
        WebClient.now().delete(url+"?id="+id);
    }
}

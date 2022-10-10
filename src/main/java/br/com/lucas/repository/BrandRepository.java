package br.com.lucas.repository;

import br.com.lucas.config.WebClient;
import br.com.lucas.model.Brand;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrandRepository {

    public static String url= "/brand";

    public Brand findById(Integer id){
      Brand brand= (Brand) WebClient.now().get(Brand.class,url+"/find?id="+id);
        return brand;
    }
    public List<Brand> findAll(){
        String json = WebClient.now().getJson(url);
        var gson = WebClient.now().gsonNow();
        Brand[] list = gson.fromJson(json,Brand[].class);


       return new ArrayList<Brand>(Arrays.asList(list));
    }
    public Brand post(String name){
        var brand = new Brand(null,name,null,null);

     var json =   WebClient.now().post(brand,url);

     return WebClient.now().gsonNow().fromJson(json,Brand.class);

    }

    public void delete(Integer id){
        WebClient.now().delete(url+"?id="+id);
    }


}

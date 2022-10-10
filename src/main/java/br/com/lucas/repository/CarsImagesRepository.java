/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lucas.repository;

import br.com.lucas.config.WebClient;
import br.com.lucas.dto.CarsImagesNew;
import br.com.lucas.model.Brand;
import br.com.lucas.model.CarsImages;
import static br.com.lucas.repository.BrandRepository.url;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lucas
 */
public class CarsImagesRepository {
    

 public static String url= "/cars-images";

    public CarsImages findById(Integer id){
      CarsImages carsImages= (CarsImages) WebClient.now().get(Brand.class,url+"/find?id="+id);
        return carsImages;
    }
    public List<CarsImages> findAll(){
        String json = WebClient.now().getJson(url);
        var gson = WebClient.now().gsonNow();
        CarsImages[] list = gson.fromJson(json,CarsImages[].class);


       return new ArrayList<CarsImages>(Arrays.asList(list));
    }
   public CarsImages post(byte[] file,Integer id){
        CarsImagesNew  carsImagesNew= new CarsImagesNew(id, file);

     var json =   WebClient.now().post(carsImagesNew,url);

     return WebClient.now().gsonNow().fromJson(json,CarsImages.class);

    }

    public void delete(Integer id){
        WebClient.now().delete(url+"?id="+id);
    }

}

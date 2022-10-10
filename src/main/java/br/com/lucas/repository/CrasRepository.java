package br.com.lucas.repository;

import br.com.lucas.config.WebClient;
import br.com.lucas.dto.CheckAvailability;
import br.com.lucas.dto.ConsultTotal;
import br.com.lucas.dto.CrasNew;
import br.com.lucas.model.Cras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrasRepository {
    public static String url= "/cras";

    public Cras findById(Integer id){
        Cras cras= (Cras) WebClient.now().get(Cras.class,url+"/find?id="+id);
        return cras;
    }
    public List<Cras> findAll(){
        String json = WebClient.now().getJson(url);
        var gson = WebClient.now().gsonNow();
        Cras[] list = gson.fromJson(json,Cras[].class);


        return new ArrayList<Cras>(Arrays.asList(list));
    }
    public ConsultTotal consultTotalValue(Integer car_id, Long days){
        var consultTotal= (ConsultTotal) WebClient.now().get(ConsultTotal.class,url+"/consult?car_id="+car_id+"&days="+days);
        return  consultTotal;
    }
    public void post(CrasNew crasNew){


        WebClient.now().post(crasNew,url);

    }

    public List<Cras> check(CheckAvailability checkAvailability){


       String json = WebClient.now().post(checkAvailability,url+"/check");

        var gson = WebClient.now().gsonNow();
        Cras[] list = gson.fromJson(json,Cras[].class);


        return new ArrayList<Cras>(Arrays.asList(list));

    }


    public void delete(Integer id){
        WebClient.now().delete(url+"?id="+id);
    }
}

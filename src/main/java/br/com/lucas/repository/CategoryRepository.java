package br.com.lucas.repository;

import br.com.lucas.config.WebClient;
import br.com.lucas.model.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryRepository {

    public static String url= "/category";

    public Category findById(Integer id){
        Category category= (Category) WebClient.now().get(Category.class,url+"/find?id="+id);
        return category;
    }
    public List<Category> findAll(){
        String json = WebClient.now().getJson(url);
        var gson = WebClient.now().gsonNow();
        Category[] list = gson.fromJson(json,Category[].class);


        return new ArrayList<Category>(Arrays.asList(list));
    }
    public void post(Category category){
        category.setId(null);

     var json =   WebClient.now().post(category,url);
        System.out.println(json);
    }

    public void delete(Integer id){
        System.out.println(id);
        WebClient.now().delete(url+"?id="+id);
    }

}

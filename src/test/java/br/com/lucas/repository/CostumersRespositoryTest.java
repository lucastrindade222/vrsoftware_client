package br.com.lucas.repository;

import br.com.lucas.dto.CostumersNew;
import br.com.lucas.model.Costumers;
import br.com.lucas.model.Specifications;
import lombok.Data;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

public class CostumersRespositoryTest {
    public CostumersRespository costumersRespository;

    @Test
    public void findById(){
        Integer id = 1;
        Costumers costumers = this.costumersRespository.findById(id);

        Assert.assertNotNull("Erro. Objeto não pode ser null",costumers);
        Assert.assertEquals(id,costumers.getId());
    }
    @Test
    public void findByIdErro(){
        Integer id = 200;
        try {
            Costumers costumers = this.costumersRespository.findById(id);
            Assert.fail("Erro.");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),"Erro. Não encontrado");
        };



    }
    @Test
    public void findAll(){
        List<Costumers> list=  this.costumersRespository.findAll();
        list.forEach((e)-> System.out.println(e.toString()));
        Assert.assertNotNull(list);
    }

    @Test
    public void post(){
        var costumers = new CostumersNew("lucas trindade","24/11/1998","lucasDevJava@gmail.com","761950772510","adress","(81)9 812322-7979" );
         this.costumersRespository.post(costumers);

    }
    @Test
    public void put(){
        var costumers = new Costumers();
        costumers.setId(1);
        costumers.setName("lucas silva & silva");
        this.costumersRespository.put(costumers);

    }

    @Test
    public void delete(){
        Integer id = 4;
        this.costumersRespository.delete(id);
    }


    @Before
    public void before(){

        this.costumersRespository = new CostumersRespository();
    }
}

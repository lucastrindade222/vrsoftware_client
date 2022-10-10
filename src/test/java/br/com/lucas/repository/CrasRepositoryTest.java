package br.com.lucas.repository;

import br.com.lucas.dto.CheckAvailability;
import br.com.lucas.dto.CrasNew;
import br.com.lucas.model.Brand;
import br.com.lucas.model.Cras;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class CrasRepositoryTest {
    public CrasRepository crasRepository;

    @Test
    public void findById(){
        Integer id = 4;
        Cras cras = this.crasRepository.findById(id);

        Assert.assertNotNull("Erro. Objeto não pode ser null",cras);
        Assert.assertEquals(id,cras.getId());
    }
    @Test
    public void findByIdErro(){
        Integer id = 1;
        try {
            Cras cras = this.crasRepository.findById(id);
            Assert.fail("Erro.");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),"Erro. Não encontrado");
        };



    }
    @Test
    public void findAll(){
        List<Cras> list=  this.crasRepository.findAll();
        list.forEach((e)-> System.out.println(e.toString()));
        Assert.assertNotNull(list);
    }

    @Test
    public void post(){


              String name="F34";
              String description ="Esportivo, clássico e voltado para o futuro: o lançamento do BMW F30 em 14 de outubro de 2011 na fábrica da BMW em Munique.";
              String color="Res";
              String license_plate= "NAY-2083";
              var daily_rate = new BigDecimal("800.00");
              Integer category=2;
              Integer brand =4;


        var crasNew = new CrasNew(name,description,daily_rate,license_plate,brand,category,color);
        this.crasRepository.post(crasNew);

    }

    @Test
    public void check(){

        var  checkAvailability= new CheckAvailability("11/08/2022",1l);

        this.crasRepository.check(checkAvailability);

    }

    @Test
    public void delete(){
        Integer id = 7;
        this.crasRepository.delete(id);
    }


    @Before
    public void before(){

        this.crasRepository = new CrasRepository();
    }


}

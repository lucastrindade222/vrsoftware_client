package br.com.lucas.repository;

import br.com.lucas.dto.RentaisNew;
import br.com.lucas.model.Brand;
import br.com.lucas.model.Rentais;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RentaisRepositoryTest {




        public RentaisRepository rentaisRepository;

        @Test
        public void findById(){
        Integer id = 1;
        Rentais rentais = this.rentaisRepository.findById(id);

        Assert.assertNotNull("Erro. Objeto não pode ser null",rentais);
        Assert.assertEquals(id,rentais.getId());
    }
        @Test
        public void findByIdErro(){
        Integer id = 78;
        try {
            Rentais rentais = this.rentaisRepository.findById(id);
            Assert.fail("Erro.");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),"Erro. Não encontrado");
        };



    }
        @Test
        public void findAll(){
        List<Rentais> list=  this.rentaisRepository.findAll();
        list.forEach((e)-> System.out.println(e.toString()));
        Assert.assertNotNull(list);
    }

        @Test
        public void post(){
        var rentais = new RentaisNew(2,2,"11/11/2030",5);

        this.rentaisRepository.post(rentais);

    }
        @Test
        public void delete(){
        Integer id = 9;
        this.rentaisRepository.delete(id);
    }


        @Before
        public void before(){

        this.rentaisRepository = new RentaisRepository();
    }




    }

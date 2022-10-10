package br.com.lucas.repository;


import br.com.lucas.model.Specifications;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SpecificationsRepositoryTest {
    public SpecificationsRepository specificationsRepository;

    @Test
    public void findById(){
        Integer id = 3;
        Specifications specifications = this.specificationsRepository.findById(id);

        Assert.assertNotNull("Erro. Objeto não pode ser null",specifications);
        Assert.assertEquals(id,specifications.getId());
    }
    @Test
    public void findByIdErro(){
        Integer id = 1;
        try {
            Specifications specifications = this.specificationsRepository.findById(id);
            Assert.fail("Erro.");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),"Erro. Não encontrado");
        };



    }
    @Test
    public void findAll(){
        List<Specifications> list=  this.specificationsRepository.findAll();
        list.forEach((e)-> System.out.println(e.toString()));
        Assert.assertNotNull(list);
    }

    @Test
    public void post(){
        var specifications = new Specifications();
        specifications.setName("Hatch médio");
        specifications.setDescription("Uma das principais dúvidas de quem vai comprar seu primeiro automóvel — ou trocar o antigo — é se vale a pena investir seu dinheiro em um modelo hatch.");
        this.specificationsRepository.post(specifications);

    }
    @Test
    public void delete(){
        Integer id = 3;
        this.specificationsRepository.delete(id);
    }


    @Before
    public void before(){

        this.specificationsRepository = new SpecificationsRepository();
    }

}

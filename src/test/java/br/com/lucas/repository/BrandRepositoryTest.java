package br.com.lucas.repository;

import br.com.lucas.model.Brand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

public class BrandRepositoryTest {

    public BrandRepository brandRepository;

@Test
public void findById(){
    Integer id = 4;
    Brand brand = this.brandRepository.findById(id);

    Assert.assertNotNull("Erro. Objeto não pode ser null",brand);
    Assert.assertEquals(id,brand.getId());
}
    @Test
    public void findByIdErro(){
        Integer id = 1;
        try {
            Brand brand = this.brandRepository.findById(id);
            Assert.fail("Erro.");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),"Erro. Não encontrado");
        };



    }
@Test
public void findAll(){
    List<Brand> list=  this.brandRepository.findAll();
    list.forEach((e)-> System.out.println(e.toString()));
    Assert.assertNotNull(list);
}

@Test
public void post(){

    this.brandRepository.post("Ferrari");

}
@Test
public void delete(){
    Integer id = 7;
    this.brandRepository.delete(id);
}


@Before
public void before(){

    this.brandRepository = new BrandRepository();
}



}

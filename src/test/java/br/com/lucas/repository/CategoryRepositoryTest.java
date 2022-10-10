package br.com.lucas.repository;

import br.com.lucas.model.Brand;
import br.com.lucas.model.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CategoryRepositoryTest {
    public CategoryRepository categoryRepository;

    @Test
    public void findById(){
        Integer id = 2;
        Category category = this.categoryRepository.findById(id);

        Assert.assertNotNull("Erro. Objeto não pode ser null",category);
        Assert.assertEquals(id,category.getId());
    }
    @Test
    public void findByIdErro(){
        Integer id = 1;
        try {
            Category category = this.categoryRepository.findById(id);
            Assert.fail("Erro.");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),"Erro. Não encontrado");
        };



    }
    @Test
    public void findAll(){
        List<Category> list=  this.categoryRepository.findAll();
        list.forEach((e)-> System.out.println(e.toString()));
        Assert.assertNotNull(list);
    }

    @Test
    public void post(){
        var category = new Category();
        category.setName("Hatch médio");
        category.setDiscretion("Uma das principais dúvidas de quem vai comprar seu primeiro automóvel — ou trocar o antigo — é se vale a pena investir seu dinheiro em um modelo hatch.");
        this.categoryRepository.post(category);

    }
    @Test
    public void delete(){
        Integer id = 3;
        this.categoryRepository.delete(id);
    }


    @Before
    public void before(){

        this.categoryRepository = new CategoryRepository();
    }

}

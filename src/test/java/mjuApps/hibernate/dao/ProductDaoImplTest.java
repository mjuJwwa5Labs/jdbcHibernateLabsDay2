package mjuApps.hibernate.dao;

import mjuApps.hibernate.entity.Product;
import mjuApps.hibernate.exception.DatabaseException;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.List;

import static org.junit.Assert.*;

public class ProductDaoImplTest {

    ProductDao productDao;

    @Test
    public void findByIdWhenPresent() throws DatabaseException {
        //given
        productDao = new ProductDaoImpl();
        //when
        Product product = productDao.findById(3);
        //then
        Assert.assertEquals("Name should be equals \"Koszula\"", "Koszula", product.getName());

    }

    @Test
    public void findByNameWhenPresent() throws DatabaseException {
        //given
        productDao = new ProductDaoImpl();
        //when
        List<Product> productList = productDao.findByName("usza");
        //then
        Assert.assertEquals("Expeected size of products list should be 2", 2,productList.size());
    }

    @Test
    public void findByCategoryWhenPresent() throws DatabaseException {
        //given
        productDao = new ProductDaoImpl();
        //when
        List<Product> productList = productDao.findByCategory("Alkohole");
        //then
        Assert.assertTrue("Size of products list should be greater than 1", productList.size()>1);
    }

    @Test
    public void findAllProductsWhenMoreThenOneProductInDb() throws DatabaseException {
        //given
        productDao = new ProductDaoImpl();
        //when
        List<Product> productList = productDao.findAllProducts();
        //then
        Assert.assertTrue("Size of products list is greater than 1", productList.size()>1);

    }

}
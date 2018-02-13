package mjuApps.hibernate.dao;

import mjuApps.hibernate.entity.Product;
import mjuApps.hibernate.exception.DatabaseException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductDaoImplTest {

    ProductDao productDao;

    @Test
    public void findById() throws DatabaseException {
        //given
        productDao = new ProductDaoImpl();

        //when
        Product product = productDao.findById(3);

        //then
        Assert.assertEquals("Name should be equals \"Koszula\"", "Koszula", product.getName());

    }
}
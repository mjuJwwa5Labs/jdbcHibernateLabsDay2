package mjuApps.hibernate.dao;

import mjuApps.hibernate.entity.Product;
import mjuApps.hibernate.exception.DatabaseException;

import java.util.List;

public interface ProductDao {

    public Product findById(Integer id) throws DatabaseException;

    public List<Product> findByName(String name) throws DatabaseException;

    public List<Product> findByCategory(String category) throws DatabaseException;

}

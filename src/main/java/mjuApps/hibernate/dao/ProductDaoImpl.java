package mjuApps.hibernate.dao;

import mjuApps.hibernate.config.HibernateConfigurationLoader;
import mjuApps.hibernate.entity.Product;
import mjuApps.hibernate.exception.DatabaseException;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private Logger logger = Logger.getLogger(ProductDaoImpl.class);
    SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();

    @Override
    public Product findById(Integer id) throws DatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Product product = session.find(Product.class, id);
            return product;
        } catch (HibernateException e) {
            logger.error("Error while finding product with id = " + id, e);
            throw new DatabaseException("Error while finding product with id = " + id, e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Product> findByName(String name) throws DatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = (Criteria) session.createFilter(Product.class,name);
            //todo to dokonczyc

        } catch (HibernateException e) {

        } finally {
            session.close();
        }

        return null;
    }

    @Override
    public List<Product> findByCategory(String category) throws DatabaseException {
        return null;
    }
}

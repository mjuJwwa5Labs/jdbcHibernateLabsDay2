package mjuApps.hibernate.dao;

import mjuApps.hibernate.config.HibernateConfigurationLoader;
import mjuApps.hibernate.entity.Product;
import mjuApps.hibernate.exception.DatabaseException;
import org.apache.log4j.Logger;
import org.hibernate.*;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

            String condition = "%"+name+"%";
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);

            Root<Product> from = criteriaQuery.from(Product.class);

            criteriaQuery
                    .select(from)
                    .where(criteriaBuilder
                            .like(from.get("name"),condition));

            TypedQuery<Product> typedQuery = session.createQuery(criteriaQuery);
            List<Product> result = typedQuery.getResultList();
            return result;
        } catch (HibernateException e) {
            logger.error("Error while finding products containing String = " + name, e);
            throw new DatabaseException("Error while finding products containing String = " + name, e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Product> findByCategory(String category) throws DatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
            Root<Product> from = criteriaQuery.from(Product.class);
            criteriaQuery
                    .select(from)
                    .where(criteriaBuilder
                            .like(from.get("category"),category));
            TypedQuery<Product> typedQuery = session.createQuery(criteriaQuery);
            List<Product> result = typedQuery.getResultList();
            return result;
        } catch (HibernateException e) {
            logger.error("Error while finding products with category String = " + category, e);
            throw new DatabaseException("Error while finding products with category String = " + category, e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Product> findAllProducts() throws DatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
            Root<Product> from = criteriaQuery.from(Product.class);

            CriteriaQuery<Product> select = criteriaQuery.select(from);
            TypedQuery<Product> typedQuery = session.createQuery(select);
            List<Product> result = typedQuery.getResultList();
            return result;
        } catch (HibernateException e) {
            logger.error("Error while finding all products", e);
            throw new DatabaseException("Error while finding all products", e);
        } finally {
            session.close();
        }
    }
}

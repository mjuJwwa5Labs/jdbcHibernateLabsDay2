package mjuApps.hibernate.dao;

import mjuApps.hibernate.config.HibernateConfigurationLoader;
import mjuApps.hibernate.entity.Order;
import mjuApps.hibernate.exception.DatabaseException;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.exception.SQLGrammarException;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private Logger logger = Logger.getLogger(OrderDaoImpl.class);
    SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();

    @Override
    public Order findById(Integer id) throws DatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
            Root<Order> from = criteriaQuery.from(Order.class);
            criteriaQuery.select(from).where(criteriaBuilder.equal(from.get("id"),id));
            TypedQuery<Order> typedQuery = session.createQuery(criteriaQuery);

            Order order = typedQuery.getSingleResult();
            return order;
        } catch (SQLGrammarException e) {
            logger.error("Error with Your SQL query while getting order" + id, e);
            throw new DatabaseException("Error with Your SQL query while getting order" + id, e);
        } catch (HibernateException e) {
            logger.error("Error while finding order with id = " + id, e);
            throw new DatabaseException("Error while finding order with id = " + id, e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Order> findCustomerById(Integer id) throws DatabaseException {
        return null;
    }

    @Override
    public void insertNewOrder(Order order) throws DatabaseException {

    }

    @Override
    public void saveOrder(Order order) throws DatabaseException {

    }
}

package mjuApps.hibernate.dao;

import mjuApps.hibernate.config.HibernateConfigurationLoader;
import mjuApps.hibernate.entity.Order;
import mjuApps.hibernate.exception.DatabaseException;
import org.apache.log4j.Logger;
import org.hibernate.*;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private Logger logger = Logger.getLogger(OrderDaoImpl.class);
    SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();

    @Override
    public Order findById(Integer id) throws DatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Order order = session.find(Order.class, id);
            return order;
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

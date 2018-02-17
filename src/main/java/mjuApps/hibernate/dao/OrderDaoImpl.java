package mjuApps.hibernate.dao;

import mjuApps.hibernate.config.HibernateConfigurationLoader;
import mjuApps.hibernate.entity.Order;
import mjuApps.hibernate.exception.DatabaseException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
            logger.error("Error while finding product with id = " + id, e);
            throw new DatabaseException("Error while finding product with id = " + id, e);
        } finally {
            session.close();
        }
    }

    @Override
    public Integer insert(Order order) throws DatabaseException {

        Session session = null;

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Integer newOrderId = (Integer) session.save(order);
            transaction.commit();
            return newOrderId;
        } catch (HibernateException e) {
            logger.error("Problem with inserting order = " + order.getId(), e);
            throw new DatabaseException("Problem with inserting order = " + order.getId(), e);
        } finally {
            session.close();
        }
    }

    @Override
    public void save(Order order) throws DatabaseException {

        Session session = null;

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(order);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Problem with inserting order = " + order.getId(), e);
            throw new DatabaseException("Problem with inserting order = " + order.getId(), e);
        } finally {
            session.close();
        }
    }

    @Override
    public Order findByIdWithItems(Integer id) throws DatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Order> orderQuery = session.createNamedQuery("orderWithItems",Order.class);
            orderQuery.setParameter("id", id);
            return orderQuery.getSingleResult();
        } catch (HibernateException e) {
            logger.error("Error while finding product with id = " + id, e);
            throw new DatabaseException("Error while finding product with id = " + id, e);
        } finally {
            session.close();
        }
    }
}

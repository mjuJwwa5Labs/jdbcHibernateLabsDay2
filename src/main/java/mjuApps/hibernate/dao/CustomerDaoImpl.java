package mjuApps.hibernate.dao;

import mjuApps.hibernate.config.HibernateConfigurationLoader;
import mjuApps.hibernate.entity.Customer;
import mjuApps.hibernate.exception.DatabaseException;
import org.apache.log4j.Logger;
import org.hibernate.*;


public class CustomerDaoImpl implements CustomerDao {

    private Logger logger = Logger.getLogger(CustomerDaoImpl.class);
    SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();

    @Override
    public Customer findById(Integer id) throws DatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Customer customer = session.find(Customer.class, id);
            return customer;
        } catch (HibernateException e) {
            logger.error("Problem with getting customer with id = " + id, e);
            throw new DatabaseException("Problem with getting customer with id = " + id, e);
        } finally {
            session.close();
        }
    }

    @Override
    public void insert(Customer customer) throws DatabaseException {

        Session session = null;

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Problem with inserting customer = " + customer.getId(), e);
            throw new DatabaseException("Problem with inserting customer = " + customer.getId(), e);
        } finally {
            session.close();
        }
    }

    @Override
    public void save(Customer customer) throws DatabaseException {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Problem with saving customer = " + customer.getId(), e);
            throw new DatabaseException("Problem with saving customer = " + customer.getId(), e);
        } finally {
            session.close();
        }
    }
}

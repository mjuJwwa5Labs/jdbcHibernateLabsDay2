package mjuApps.hibernate.dao;

import mjuApps.hibernate.config.HibernateConfigurationLoader;
import mjuApps.hibernate.entity.OrderItem;
import mjuApps.hibernate.entity.Product;
import mjuApps.hibernate.exception.DatabaseException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {

    private Logger logger = Logger.getLogger(OrderItemDaoImpl.class);
    private SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();

    @Override
    public List<OrderItem> findAllOrdersWithItems() throws DatabaseException {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<OrderItem> criteriaQuery = criteriaBuilder.createQuery(OrderItem.class);
            Root<OrderItem> from = criteriaQuery.from(OrderItem.class);

            CriteriaQuery<OrderItem> select = criteriaQuery.select(from);
            TypedQuery<OrderItem> typedQuery = session.createQuery(select);
            List<OrderItem> result = typedQuery.getResultList();
            return result;
        } catch (HibernateException e) {
            logger.error("Problem with fetching all order items", e);
            throw new DatabaseException("Problem with fetching all order items", e);
        } finally {
            session.close();
        }
    }
}

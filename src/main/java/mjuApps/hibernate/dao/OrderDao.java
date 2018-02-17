package mjuApps.hibernate.dao;

import mjuApps.hibernate.entity.Order;
import mjuApps.hibernate.exception.DatabaseException;

public interface OrderDao {

    public Order findById(Integer id) throws DatabaseException;

    public Integer insert(Order order) throws DatabaseException;

    public void save(Order order) throws  DatabaseException;

    public Order findByIdWithItems(Integer id) throws DatabaseException;
}

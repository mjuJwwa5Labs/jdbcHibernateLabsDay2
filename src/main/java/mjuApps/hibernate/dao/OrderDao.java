package mjuApps.hibernate.dao;

import mjuApps.hibernate.entity.Order;
import mjuApps.hibernate.exception.DatabaseException;

import java.util.List;

public interface OrderDao {

    public Order findById(Integer id) throws DatabaseException;

    public List<Order> findCustomerById(Integer id) throws DatabaseException;

    public void insertNewOrder(Order order) throws DatabaseException;

    public void saveOrder(Order order) throws DatabaseException;

}

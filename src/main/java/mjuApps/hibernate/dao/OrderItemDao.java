package mjuApps.hibernate.dao;

import mjuApps.hibernate.entity.OrderItem;
import mjuApps.hibernate.exception.DatabaseException;

import java.util.List;

public interface OrderItemDao {

    public List<OrderItem> findAllOrdersWithItems() throws DatabaseException;

}

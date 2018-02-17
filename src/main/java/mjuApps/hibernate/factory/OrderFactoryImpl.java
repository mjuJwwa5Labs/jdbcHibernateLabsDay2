package mjuApps.hibernate.factory;

import mjuApps.hibernate.entity.Customer;
import mjuApps.hibernate.entity.Order;
import mjuApps.hibernate.entity.OrderStatus;

import java.util.Date;

public class OrderFactoryImpl implements OrderFactory {

    @Override
    public Order createNewOrder(Customer customer) {
        return new Order(customer, OrderStatus.NEW, new Date());
    }
}

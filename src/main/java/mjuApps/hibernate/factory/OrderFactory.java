package mjuApps.hibernate.factory;

import mjuApps.hibernate.entity.Customer;
import mjuApps.hibernate.entity.Order;

public interface OrderFactory {

    public Order createNewOrder(Customer customer);

}

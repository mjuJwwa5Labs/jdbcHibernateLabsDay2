package mjuApps.hibernate.dao;

import mjuApps.hibernate.entity.*;
import mjuApps.hibernate.exception.DatabaseException;
import mjuApps.hibernate.factory.OrderFactory;
import mjuApps.hibernate.factory.OrderFactoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    private OrderDao orderDao;
    private ProductDao productDao;
    private CustomerDao customerDao;
    private OrderFactory orderFactory;

    @Before
    public void initialize() {
        orderDao = new OrderDaoImpl();
        productDao = new ProductDaoImpl();
        customerDao = new CustomerDaoImpl();
        orderFactory = new OrderFactoryImpl();
    }

    @Test
    public void findById() throws DatabaseException {
        //when
        Order order = orderDao.findById(1);
        //then
        Assert.assertEquals("Order with id = 1 should have satus NEW", OrderStatus.NEW,order.getStatus());
        //todo assert object dla zamowienia
        Assert.assertEquals("Customer address city is Warszawa", "Warszawa", order.getCustomer().getAddress().getCity());
    }

    @Test
    public void insert() throws DatabaseException{
        //given
        Customer customer = customerDao.findById(1);
        Order order = orderFactory.createNewOrder(customer);
        Product bread = productDao.findById(1);
        Product water = productDao.findById(2);
        order.addItem(bread,2);
        order.addItem(water,3);

        //when
        Integer newOrderId = orderDao.insert(order);

        //then
        Order insertedOrder = orderDao.findById(newOrderId);
        Assert.assertEquals("Expected order id should be 2", Integer.valueOf(2), insertedOrder.getId());
        Assert.assertEquals("Expected customer name should be Johny", "Johny", insertedOrder.getCustomer().getFirstName());
        Assert.assertEquals("Expected status should be NEW", OrderStatus.NEW,insertedOrder.getStatus());
    }

    @Test
    public void shouldFindOrderWithItems() throws DatabaseException {
        Order order = orderDao.findByIdWithItems(1);
        Assert.assertEquals("Should have two items in order items list", 2, order.getItems().size());
    }

    @Test
    public void shouldUpdateExistingOrder() throws DatabaseException {
        //given
        Order order = orderDao.findByIdWithItems(1);
        List<OrderItem> orderItems = order.getItems();
        orderItems.remove(0);
        Product bread = productDao.findById(1);
        //Product water = productDao.findById(2);
        order.addItem(bread,3);
        //order.addItem(water,5);

        //when
        order.confirm();
        orderDao.save(order);
        Order updateOrder = orderDao.findByIdWithItems(1);
        //then
        Assert.assertEquals("Updated order should be CONFIRMED", OrderStatus.CONFIRMED, updateOrder.getStatus());
        Assert.assertEquals("Order should contain 2 items", 2, order.getItems().size());
    }
}
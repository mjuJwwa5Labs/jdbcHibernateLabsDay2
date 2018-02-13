package mjuApps.hibernate.dao;

import mjuApps.hibernate.entity.Order;
import mjuApps.hibernate.exception.DatabaseException;
import org.junit.Ignore;
import org.junit.Test;

public class OrderDaoImplTest {

    private OrderDao orderDaoImpl;

    @Test
    public void findByOrderIdWhenPresent() throws DatabaseException{
        //given
        orderDaoImpl = new OrderDaoImpl();

        //when
        Order order = orderDaoImpl.findById(3);

        //then


    }

    @Test
    @Ignore
    public void findByCustomerId() {
    }

    @Test
    @Ignore
    public void insertNewOrder() {
    }

    @Test
    @Ignore
    public void saveOrder() {
    }
}
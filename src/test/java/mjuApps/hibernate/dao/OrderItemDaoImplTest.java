package mjuApps.hibernate.dao;

import mjuApps.hibernate.entity.OrderItem;
import mjuApps.hibernate.exception.DatabaseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    OrderItemDaoImpl orderItemDao;

    @Test
    public void findAllOrdersWithItems() throws DatabaseException {
        //given
        orderItemDao = new OrderItemDaoImpl();
        //when
        List<OrderItem> orderItemList = orderItemDao.findAllOrdersWithItems();
        //then
        Assert.assertTrue("Size of the order items list is greater than 1", orderItemList.size()>1);
    }
}
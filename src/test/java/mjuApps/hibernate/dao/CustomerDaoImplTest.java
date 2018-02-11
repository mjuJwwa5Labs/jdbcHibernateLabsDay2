package mjuApps.hibernate.dao;

import mjuApps.hibernate.entity.Customer;
import mjuApps.hibernate.entity.CustomerType;
import mjuApps.hibernate.exception.DatabaseException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerDaoImplTest {

    @Test
    public void shouldFindByIdWhenPresent() throws DatabaseException {
        //given
        CustomerDao customerDao = new CustomerDaoImpl();
        //when
        Customer customer = customerDao.findById(1);
        //then
        Assert.assertEquals("First name should be equal", "piesek",customer.getFirstName());
    }

    @Test
    public void shouldFindByIdThrowExceptionWhenAbsent() throws DatabaseException {
        //given
        CustomerDao customerDao = new CustomerDaoImpl();
        //when
        Customer customer = customerDao.findById(-1);
        //then
        Assert.assertNull("Customer object should be null", customer);
    }

    @Test
    public void insertWithPositiveResult() throws DatabaseException {
        //given
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = new Customer("Tomasz","Tomkowy","tomasztomkowy", CustomerType.REGULAR);
        //when
        customerDao.insert(customer);
        //then
    }

    @Test
    public void saveWhenNotPresent() throws DatabaseException {
        //given
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = customerDao.findById(1);
        customer.setFirstName("Psiulek");

        //when
        customerDao.save(customer);

        //then
        Customer customerAfterUpdate = customerDao.findById(1);
        Assert.assertEquals("Name should be Psiulek", customer.getFirstName(),customerAfterUpdate.getFirstName());
    }
}
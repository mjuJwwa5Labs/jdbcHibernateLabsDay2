package mjuApps.hibernate.dao;

import mjuApps.hibernate.entity.Customer;
import mjuApps.hibernate.exception.DatabaseException;

public interface CustomerDao {

    public Customer findById(Integer id) throws DatabaseException;

    public void insert(Customer customer) throws DatabaseException;

    public void save(Customer customer) throws DatabaseException;

}

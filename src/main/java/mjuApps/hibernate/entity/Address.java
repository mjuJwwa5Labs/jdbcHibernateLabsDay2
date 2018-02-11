package mjuApps.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;

    private String city;

    private String postal;

    public Address() {
    }

    public String getCity() {
        return city;
    }
}

package mjuApps.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CustomerType type;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String login, CustomerType type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public CustomerType getType() {
        return type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

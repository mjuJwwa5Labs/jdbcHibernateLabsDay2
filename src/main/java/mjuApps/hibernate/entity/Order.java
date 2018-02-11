package mjuApps.hibernate.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name="creation_date")
    private Date creationDate;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    public Order() {}
}

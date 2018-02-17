package mjuApps.hibernate.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "\"order\"")
@NamedQueries(
        @NamedQuery(name="orderWithItems", query = " from Order o left join fetch o.items where o.id=:id")
)
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

    @OneToMany (mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;

    @Transient
    private BigDecimal totalCost;

    public Order(Customer customer, OrderStatus status, Date creationDate) {
        this.customer = customer;
        this.status = status;
        this.creationDate = creationDate;
    }

    public Order() {}

    public void addItem(Product product, Integer quantity) {
        if (items==null) {
            items = new ArrayList<>();
        }
        OrderItem orderItem = new OrderItem(this, product, quantity);
        items.add(orderItem);
    }

    public void confirm(){
        this.status = OrderStatus.CONFIRMED;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Integer getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}

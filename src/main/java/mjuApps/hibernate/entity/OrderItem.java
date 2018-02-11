package mjuApps.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="order_item")
public class OrderItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    public OrderItem() {}
}

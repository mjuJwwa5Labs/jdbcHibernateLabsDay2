package mjuApps.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="order_item")
public class OrderItem implements Serializable {

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

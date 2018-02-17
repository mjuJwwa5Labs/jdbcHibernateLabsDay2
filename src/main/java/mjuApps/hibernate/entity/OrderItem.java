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
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    private Integer quantity;

    public OrderItem() {}

    public OrderItem(Order order, Product product, Integer quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }
}

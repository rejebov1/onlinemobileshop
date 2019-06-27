package org.myproject.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "goodinorder")
public class GoodInOrder {

    @EmbeddedId
    private GoodInOrderPk id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",insertable = false, updatable = false, nullable = false)
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantityOfGoodsInTheOrder")
    private Integer quantityOfGoodsInTheOrder;

    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    @EqualsAndHashCode
    public static class GoodInOrderPk implements Serializable {
        protected Long order_id ;
        protected Long product_id ;
    }
}
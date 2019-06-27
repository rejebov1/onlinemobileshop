package org.myproject.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myproject.repository.entity.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "d_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Temporal(value = TemporalType.DATE)
    @Column(name = "dateOfOrder",nullable = false)
    private LocalDate dateOfOrder;

    //@Temporal(value = TemporalType.DATE)
    @Column(name = "deliveryDate",nullable = false)
    private LocalDate deliveryDate;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "status",columnDefinition = "enum",nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private List<GoodInOrder> goodInOrder = new ArrayList<>();

}

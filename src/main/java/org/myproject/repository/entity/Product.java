package org.myproject.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phonemodel",nullable = false)
    private String phoneModel;

    //@Temporal(value = TemporalType.DATE)
    @Column(name = "dateofissue",nullable = false)
    private LocalDate dateOfIssue;

    @Column(name = "productcharacteristic",nullable = false)
    private String productCharacteristic;

    @Column(name = "price",nullable = false)
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
}
package com.wakefit.ecommerce.entity;

import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "images")
    private String images;
    
    @Column(name = "stock_quantity")
    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Feedback> feedbacks;
   
    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;
}

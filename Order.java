package com.wakefit.ecommerce.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "order_status")
    private String orderStatus;

    @OneToMany(mappedBy = "billingaddress")
    private List<Address> billingOrders;
    
    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private Address shippingaddress;

    @ManyToOne
    @JoinColumn(name = "billing_address_id")
    private Address billingaddress;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToMany(mappedBy = "order")
    private List<Payment> payments;
}

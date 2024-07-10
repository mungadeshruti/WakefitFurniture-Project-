package com.wakefit.ecommerce.entity;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "billing_address_id")
    private Order billingaddress;

    @OneToMany(mappedBy = "shippingaddress")
    private List<Order> shippingOrders;

    @OneToMany(mappedBy = "billingaddress")
    private List<Order> billingOrders;
}

package com.wakefit.ecommerce.entity;

import lombok.*;

import jakarta.persistence.*;


@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {
    
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
}

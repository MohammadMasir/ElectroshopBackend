package com.zapter.zapter_backend.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "delivery_address")
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String pincode;

    private String city;

    private String district;

    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User daUser;

}

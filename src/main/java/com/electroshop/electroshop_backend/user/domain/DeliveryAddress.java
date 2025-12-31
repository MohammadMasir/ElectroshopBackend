package com.electroshop.electroshop_backend.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "DeliveryAddress")
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String address;

    @Column
    private String pincode;

    @Column
    private String city;

    @Column
    private String district;

    @Column
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User daUser;

}

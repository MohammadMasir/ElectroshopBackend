package com.electroshop.electroshop_backend.user.domain;

import com.electroshop.electroshop_backend.user.enums.SAStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "super_admin", nullable = false)
    private SAStatus superAdmin = SAStatus.NO;

}

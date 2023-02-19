package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "state")
    private String state;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;


}

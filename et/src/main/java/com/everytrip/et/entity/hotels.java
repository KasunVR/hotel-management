package com.everytrip.et.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotels")
public class hotels 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotel_id;

    @Column(name = "hotel_name" , nullable =false)
    private String hotel_name;

    @Column(name = "hotel_address" , nullable =false)
    private String hotel_address;

    @Column(name = "hotel_city" , nullable =false)
    private String hotel_city;

    @Column(name = "hotel_state" , nullable =false)
    private String hotel_state;

    @Column(name = "hotel_country")
    private String hotel_country;

    @Column(name = "hotel_phone", nullable =false, length=10)
    private String hotel_phone;

    @Column(name = "hotel_website")
    private String hotel_website;

    @Column(name = "hotel_price" , nullable =false)
    private String hotel_price;

    @Column(name = "hotel_rating" , nullable =false , length=1)
    private String hotel_rating;

    @Column(name = "hotel_description", nullable =true)
    private String hotel_description;

    @Column(name = "hotel_image" , nullable =false) 
    private String hotel_image;
}

package com.everytrip.et.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class hotelsdto 
{
    private Long hotel_id;
    private String hotel_name;
    private String hotel_address;
    private String hotel_city;
    private String hotel_state;
    private String hotel_country;
    private String hotel_phone;
    private String hotel_website;
    private String hotel_price;
    private String hotel_rating;
    private String hotel_description;
    private String hotel_image; 
}

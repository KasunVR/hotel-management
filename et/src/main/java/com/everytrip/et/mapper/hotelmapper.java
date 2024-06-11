package com.everytrip.et.mapper;

import com.everytrip.et.dto.hotelsdto;
import com.everytrip.et.entity.hotels;

public class hotelmapper 
{
    public static hotelsdto toDto(hotels hotel)
    {
        return new hotelsdto
        (
            hotel.getHotel_id(),
            hotel.getHotel_name(),
            hotel.getHotel_address(),
            hotel.getHotel_city(),
            hotel.getHotel_state(),
            hotel.getHotel_country(),
            hotel.getHotel_phone(),
            hotel.getHotel_website(),
            hotel.getHotel_price(),
            hotel.getHotel_rating(),
            hotel.getHotel_description(),
            hotel.getHotel_image()
        );
    }
    public static hotels toEntity(hotelsdto hoteldto)
    {
        return new hotels
        (
            hoteldto.getHotel_id(),
            hoteldto.getHotel_name(),
            hoteldto.getHotel_address(),
            hoteldto.getHotel_city(),
            hoteldto.getHotel_state(),
            hoteldto.getHotel_country(),
            hoteldto.getHotel_phone(),
            hoteldto.getHotel_website(),
            hoteldto.getHotel_price(),
            hoteldto.getHotel_rating(),
            hoteldto.getHotel_description(),
            hoteldto.getHotel_image()
        );
    }
}

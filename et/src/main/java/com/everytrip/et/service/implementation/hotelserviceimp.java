package com.everytrip.et.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.everytrip.et.dto.districtdto;
import com.everytrip.et.dto.hotelsdto;
import com.everytrip.et.entity.district;
import com.everytrip.et.entity.hotels;
import com.everytrip.et.mapper.districtmapper;
import com.everytrip.et.mapper.hotelmapper;
import com.everytrip.et.repository.districtResporitory;
import com.everytrip.et.repository.hotelsResporitory;
import com.everytrip.et.service.hotelservice;
import com.everytrip.et.exception.nodatafound;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class hotelserviceimp implements hotelservice {
    private hotelsResporitory hotelsResporitory;
    private districtResporitory districtResporitory;

    @Override
    public hotelsdto addhotel(hotelsdto hoteldto) {
        hotels hotel = hotelmapper.toEntity(hoteldto);
        hotels saved = hotelsResporitory.save(hotel);
        return hotelmapper.toDto(saved);
    }

    @Override
    public hotelsdto gethotelbyid(long hotel_id) {
        hotels hotel = hotelsResporitory.findById(hotel_id)
                .orElseThrow(() -> new nodatafound("No hotels found with given id : " + hotel_id));
        return hotelmapper.toDto(hotel);
    }

    @Override
    public List<hotelsdto> getallhotels() {
        List<hotels> hotels = hotelsResporitory.findAll();
        return hotels.stream().map((hotel) -> hotelmapper.toDto(hotel)).collect(Collectors.toList());
    }

    @Override
    public hotelsdto updatehotel (long hotel_id, hotelsdto updatedhotel)
    {
        hotels hotel = hotelsResporitory.findById(hotel_id).orElseThrow(() -> new nodatafound("No hotels found with given id : " + hotel_id));
        
        hotel.setHotel_name(updatedhotel.getHotel_name());
        hotel.setHotel_address(updatedhotel.getHotel_address());
        hotel.setHotel_city(updatedhotel.getHotel_city());
        hotel.setHotel_state(updatedhotel.getHotel_state());
        hotel.setHotel_country(updatedhotel.getHotel_country());
        hotel.setHotel_rating(updatedhotel.getHotel_rating());
        hotel.setHotel_image(updatedhotel.getHotel_image());
        hotel.setHotel_price(updatedhotel.getHotel_price());
        hotel.setHotel_website(updatedhotel.getHotel_website());
        hotel.setHotel_description(updatedhotel.getHotel_description());

        hotels updatehotelobj = hotelsResporitory.save(hotel);

        return hotelmapper.toDto(updatehotelobj);
    }

    @Override
    public void deletehotel(long hotel_id) 
    {
        hotels hotel = hotelsResporitory.findById(hotel_id).orElseThrow(() -> new nodatafound("No hotels found with given id : " + hotel_id));
        hotelsResporitory.deleteById(hotel_id);
    }

    @Override
    public List<districtdto> getalldistrict() 
    {
        List<district> districts = districtResporitory.findAll();
        return districts.stream().map((district) -> districtmapper.todistrictDto(district)).collect(Collectors.toList());
    }
}

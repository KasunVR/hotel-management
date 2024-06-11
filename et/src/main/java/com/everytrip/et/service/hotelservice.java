package com.everytrip.et.service;

import java.util.List;

import com.everytrip.et.dto.hotelsdto;
import com.everytrip.et.dto.districtdto;

public interface hotelservice 
{
    hotelsdto addhotel (hotelsdto hoteldto);
    hotelsdto gethotelbyid (long hotel_id);
    List<hotelsdto> getallhotels();
    hotelsdto updatehotel (long hotel_id, hotelsdto updatedhotel);
    void deletehotel (long hotel_id);
    List<districtdto> getalldistrict();
}

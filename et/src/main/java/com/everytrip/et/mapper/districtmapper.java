package com.everytrip.et.mapper;

import com.everytrip.et.dto.districtdto;
import com.everytrip.et.entity.district;

public class districtmapper 
{
    public static districtdto todistrictDto(district district)
    {
        return new districtdto
        (
            district.getId(),
            district.getName_en(),
            district.getName_si(),
            district.getName_ta(),
            district.getProvince_id(),
            district.getDimg()
        );
    }
    public static district todistrict(districtdto districtdto)
    {
        return new district
        (
            districtdto.getId(),
            districtdto.getProvince_id(),
            districtdto.getName_si(),
            districtdto.getName_ta(),
            districtdto.getName_en(),
            districtdto.getDimg()
        );
    }
}

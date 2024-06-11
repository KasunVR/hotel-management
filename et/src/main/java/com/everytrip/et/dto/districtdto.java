package com.everytrip.et.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class districtdto {
    private Integer id;
    private String name_en;
    private String name_si;
    private String name_ta;
    private Integer province_id;
    private String dimg;
}

package com.everytrip.et.controller;


import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everytrip.et.dto.districtdto;
import com.everytrip.et.service.hotelservice;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/district")
public class districtcontroller 
{
    private hotelservice hotelservice;

    @GetMapping
    public ResponseEntity<List<districtdto>> getalldistrict() 
    {
        List<districtdto> districts = hotelservice.getalldistrict();
        return ResponseEntity.ok(districts);
    }

}

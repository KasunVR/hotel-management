package com.everytrip.et.controller;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everytrip.et.dto.hotelsdto;
import com.everytrip.et.service.hotelservice;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/hotels")
public class hotelcontroller {
    private hotelservice hotelservice;

    @PostMapping
    public ResponseEntity<hotelsdto> addhotel(@RequestBody hotelsdto hoteldto) {
        hotelsdto savedto = hotelservice.addhotel(hoteldto);
        return new ResponseEntity<>(savedto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<hotelsdto> gethotelbyid(@PathVariable("id") long hotel_id) {
        hotelsdto hoteldto = hotelservice.gethotelbyid(hotel_id);
        return ResponseEntity.ok(hoteldto);
    }

    @GetMapping
    public ResponseEntity<List<hotelsdto>> getallhotels() 
    {
        List<hotelsdto> hotels = hotelservice.getallhotels();
        return ResponseEntity.ok(hotels);
    }

    @PutMapping("{id}")
    public ResponseEntity<hotelsdto> updaupdatehotel(@PathVariable("id") long hotel_id, @RequestBody hotelsdto updatedhotel) {
        hotelsdto hoteldto = hotelservice.updatehotel(hotel_id,updatedhotel);
        return ResponseEntity.ok(hoteldto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletehotel(@PathVariable("id") long hotel_id) {
        hotelservice.deletehotel(hotel_id);
        return ResponseEntity.ok("Hotel delete successfully !");
    }
}

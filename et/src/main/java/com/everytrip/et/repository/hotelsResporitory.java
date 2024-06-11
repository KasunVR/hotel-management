package com.everytrip.et.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everytrip.et.entity.hotels;


public interface hotelsResporitory extends JpaRepository<hotels, Long> 
{

}

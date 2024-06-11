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
@Table(name = "district")
public class district 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "province_id" , nullable =false)
    private int province_id;

    @Column(name = "name_en" , nullable =false)
    private String name_en;

    @Column(name = "name_si" , nullable =false)
    private String name_si;

    @Column(name = "name_ta" , nullable =false)
    private String name_ta;

    @Column(name = "dimg")
    private String dimg;
}

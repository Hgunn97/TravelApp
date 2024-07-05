package com.travel.cab_fare.controller;

import com.travel.cab_fare.bean.CabFare;
import com.travel.cab_fare.service.CabFareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("/cabfare")
public class CabFareController {

    @Autowired
    CabFareService cabFareService;

    @GetMapping(value = "/findAllCabs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CabFare> findAllCabs(){
        return cabFareService.findAllCabs();
    }

    @PostMapping(value = "/storeCabFare", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String storeCabFare(@RequestBody CabFare cabFare){
        return cabFareService.storeCabFare(cabFare);
    }

    @GetMapping(value = "/findCabFare/{fromLocation}/{toLocation}/{typeOfCab}")
    public float findCabFare(@PathVariable("fromLocation") String fromLocation,
                             @PathVariable("toLocation") String toLocation,
                             @PathVariable("typeOfCab") String typeOfCab) {
        return cabFareService.findCabFare(fromLocation, toLocation, typeOfCab);
    }
}

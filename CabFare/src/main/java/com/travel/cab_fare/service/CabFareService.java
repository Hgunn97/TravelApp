package com.travel.cab_fare.service;

import com.travel.cab_fare.bean.CabFare;
import com.travel.cab_fare.dao.CabFareDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabFareService {
    @Autowired
    CabFareDao cabFareDao;

    public List<CabFare> findAllCabs() {
        return cabFareDao.findAll();
    }

    public String storeCabFare(CabFare cabFare){
        cabFareDao.save(cabFare);
        return "success";
    }

    public float findCabFare (String fromLocation, String toLocation, String typeOfCab) {
        try {
            return cabFareDao.findCabFare(fromLocation, toLocation, typeOfCab);
        }catch (Exception e){
            return 0;
        }
    }
}

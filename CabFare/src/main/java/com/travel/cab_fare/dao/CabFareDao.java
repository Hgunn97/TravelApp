package com.travel.cab_fare.dao;

import com.travel.cab_fare.bean.CabFare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CabFareDao extends JpaRepository<CabFare, Integer> {
    @Query("SELECT  cf.amount FROM CabFare cf WHERE cf.fromLocation = :fromLocation AND cf.toLocation = :toLocation AND cf.typeOfCab = :typeOfCab")
    float findCabFare(@Param("fromLocation") String fromLocation, @Param("toLocation") String toLocation, @Param("typeOfCab") String typeOfCab);
}

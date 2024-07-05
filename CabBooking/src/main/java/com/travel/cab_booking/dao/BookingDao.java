package com.travel.cab_booking.dao;

import com.travel.cab_booking.bean.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {
}

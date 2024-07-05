package com.travel.cab_booking.service;

import com.travel.cab_booking.bean.Booking;
import com.travel.cab_booking.dao.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingDao bookingDao;

    @Autowired
    RestTemplate restTemplate;

    private static final String CAB_FARE_SERVICE_URL = "http://localhost:8282/cabfare";


    public String bookCab(Booking booking){
        Float amount = retrieveCabFare(booking.getFromLocation(), booking.getToLocation(), booking.getTypeOfCab());

        if (amount == null ||amount == 0){
            return "No cab available, please try again later";
        }
        else{
            booking.setAmount(amount);
            bookingDao.save(booking);
            return "Cab booked";
        }
    }

    public Float retrieveCabFare(String fromLocation, String toLocation, String typeOfCab){
        String fareUrl = String.format("%s/findCabFare/%s/%s/%s", CAB_FARE_SERVICE_URL, fromLocation, toLocation, typeOfCab);

        return restTemplate.getForObject(fareUrl, Float.class);
    }

    public List<Booking> getAllBookings(){
        return bookingDao.findAll();
    }

    public String deleteBooking(int bookingId){
        Optional<Booking> result = bookingDao.findById(bookingId);
        if(result.isPresent()){
            Booking b = result.get();
            bookingDao.delete(b);
            return "Booking deleted";
        }else{
            return "Booking not found";
        }
    }

    public String updateBooking(int bookingId, Booking booking){
        Optional<Booking> result = bookingDao.findById(bookingId);
        if(result.isPresent()){
            Booking b = result.get();
            b.setFromLocation(booking.getFromLocation());
            b.setToLocation(booking.getToLocation());
            b.setTypeOfCab(booking.getTypeOfCab());
            bookingDao.save(b);
            return "Booking updated";
        }
        else {
            return "Booking not found";
        }
    }

    public Booking searchBookingById(int bookingId){
        Optional<Booking> result = bookingDao.findById(bookingId);
        return result.orElse(null);
    }

    public Float getCabFare(String fromLocation, String toLocation, String typeOfCab){
        return retrieveCabFare(fromLocation, toLocation, typeOfCab);
    }
}

package com.travel.cab_booking.service;

import com.travel.cab_booking.bean.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.travel.cab_booking.dao.BookingDao;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    @Mock
    private BookingDao bookingDao;
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BookingService bookingService;

    private List<Booking> bookings;
    private Booking booking;
    private String fromLocation;
    private String toLocation;
    private String typeOfCab;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        bookings = Arrays.asList(new Booking(), new Booking());
        booking = new Booking();
        booking.setBookingId(1);
        fromLocation = "home";
        toLocation = "work";
        typeOfCab = "small";

        booking.setFromLocation(fromLocation);
        booking.setToLocation(toLocation);
        booking.setTypeOfCab(typeOfCab);
    }

    @Test
    void searchBookingById_AllOkay_ReturnBooking(){
        when(bookingDao.findById(1)).thenReturn(Optional.of(booking));

        Booking actualBooking = bookingService.searchBookingById(1);

        assertEquals(booking, actualBooking);
    }

    @Test
    void updateBooking_AllOkay_ShouldUpdateBooking(){
        when(bookingDao.findById(1)).thenReturn(Optional.of(booking));

        String results = bookingService.updateBooking(1, booking);

        assertEquals("Booking updated", results);
    }

    @Test
    void deleteBooking_AllOkay_ShouldDeleteBooking(){
        when(bookingDao.findById(1)).thenReturn(Optional.of(booking));

        String results = bookingService.deleteBooking(1);

        assertEquals("Booking deleted", results);
    }

    @Test
    void getAllBookings_AllOkay_ShouldReturnListOfBookings(){
        when(bookingDao.findAll()).thenReturn(bookings);

        List<Booking> results = bookingService.getAllBookings();

        assertEquals(bookings, results);
    }
}
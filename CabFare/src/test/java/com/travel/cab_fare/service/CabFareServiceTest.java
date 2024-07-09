package com.travel.cab_fare.service;

import com.travel.cab_fare.bean.CabFare;
import com.travel.cab_fare.dao.CabFareDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CabFareServiceTest {

    @Mock
    private CabFareDao cabFareDao;

    @InjectMocks
    private CabFareService cabFareService;

    private List<CabFare> cabFareList;
    private CabFare cabFare;
    private String fromLocation;
    private String toLocation;
    private String typeOfCab;
    private float expectedFare;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cabFareList = Arrays.asList(new CabFare(), new CabFare(), new CabFare());
        cabFare = new CabFare();
        fromLocation = "home";
        toLocation = "work";
        typeOfCab = "small";
        expectedFare = 50;
    }

    @Test
    void findAllCab_AllOkay_ReturnCab(){
        when(cabFareDao.findAll()).thenReturn(cabFareList);

        List<CabFare> actualCabs = cabFareService.findAllCabs();

        assertEquals(cabFareList, actualCabs);
        verify(cabFareDao, times(1)).findAll();
    }

    @Test
    void testStoreCabFare() {
        String result = cabFareService.storeCabFare(cabFare);

        assertEquals("success", result);
        verify(cabFareDao, times(1)).save(cabFare);
    }

    @Test
    void testFindCabFare() {
        when(cabFareDao.findCabFare(fromLocation, toLocation, typeOfCab)).thenReturn(expectedFare);

        float actualFare = cabFareService.findCabFare(fromLocation, toLocation, typeOfCab);

        assertEquals(expectedFare, actualFare, 0.001);
        verify(cabFareDao, times(1)).findCabFare(fromLocation, toLocation, typeOfCab);
    }

    @Test
    void testFindCabFare_Exception() {
        when(cabFareDao.findCabFare(fromLocation, toLocation, typeOfCab)).thenThrow(new RuntimeException());

        float actualFare = cabFareService.findCabFare(fromLocation, toLocation, typeOfCab);

        assertEquals(0, actualFare, 0.001);
        verify(cabFareDao, times(1)).findCabFare(fromLocation, toLocation, typeOfCab);
    }

}
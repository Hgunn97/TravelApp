package com.travel.cab_booking.controller;

import com.travel.cab_booking.bean.Booking;
import com.travel.cab_booking.service.BookingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/")
    public String openIndex() {
        return "index";
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String addBookingPage(Booking booking, Model model) {
        model.addAttribute("b", booking);
        return "BookCab";
    }

    @RequestMapping(value = "addCalculateFare",method = RequestMethod.GET)
    public String addCalculateFarePage() {
        return "CalculateFare";
    }

    @RequestMapping(value = "bookCab",method = RequestMethod.POST)
    public String addBookingUsingHttpServlet(HttpServletRequest req, Booking booking, Model model) { //DI

        String email = req.getParameter("emailId");
        String from = req.getParameter("fromLocation");
        String to = req.getParameter("toLocation");
        String typeOfCab = req.getParameter("typeOfCab");

        booking.setEmailId(email);
        booking.setFromLocation(from);
        booking.setToLocation(to);
        booking.setTypeOfCab(typeOfCab);

        String result = bookingService.bookCab(booking);
        model.addAttribute("msg", result);			// req.setAttribute("msg",result);
        model.addAttribute("b", booking);
        System.out.println(result);

        return "BookCab";
    }

    @RequestMapping(value = "calculateFare", method = RequestMethod.POST)
    public void calculateFare(HttpServletRequest req, Model model) {
        String from = req.getParameter("fromLocation");
        String to = req.getParameter("toLocation");
        String typeOfCab = req.getParameter("typeOfCab");

        Float fare = bookingService.getCabFare(from, to, typeOfCab);
        model.addAttribute("fare", fare);
    }
}

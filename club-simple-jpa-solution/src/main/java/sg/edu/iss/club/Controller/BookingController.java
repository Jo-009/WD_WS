package sg.edu.iss.club.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.club.domain.Booking;
import sg.edu.iss.club.repo.BookingRepo;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingRepo brepo;
	
	@RequestMapping("/all")
	public String findAllBookings(Model model) {
		ArrayList<Booking> all = new ArrayList<Booking>();
		all.addAll(brepo.findAll());
		//naming convention for attribute --> bookings
		model.addAttribute("bookings", all);
		return "blisting";
	}
	
	@RequestMapping("/load")
	public String loadBookingForm(Model model) {
		Booking booking = new Booking();
		//naming convention for attribute --> booking
		model.addAttribute("booking", booking);
		return "bform";
	}
	
	@PostMapping("/addbooking")
	public String addBooking(@ModelAttribute("booking") Booking booking) {
		brepo.saveAndFlush(booking);
		return "forward:/booking/all";
		
	}
	
	@RequestMapping("/editload/{id}")
	public String loadEditBookingForm(@PathVariable("id") Integer id, Model model) {
		Booking b=brepo.findById(id).get();
		model.addAttribute("booking", b);
		return "bform";
	}
	
	@RequestMapping("/deletebooking/{id}")
	public String deleteBooking(@PathVariable("id") Integer id, Model model) {
		Booking b=brepo.findById(id).get();
		brepo.delete(b);
		return "forward:/booking/all";
	}

}

package sg.edu.iss.club.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.club.domain.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{
	
	//use bookingid
	@Query("SELECT b FROM Booking b where b.bookingId = :Id")
	Booking readBookingById(@Param("Id") Integer d);	

	ArrayList<Booking> readByMember_FirstnameLike(String n);
	
}

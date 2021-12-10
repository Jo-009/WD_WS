package sg.edu.iss.club.service;

import java.util.Date;

import sg.edu.iss.club.domain.Facility;
import sg.edu.iss.club.domain.Member;

public interface BookingService {

	int createBooking(Facility f, Member m, Date fdate, Date tdate);
}

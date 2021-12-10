package sg.edu.iss.club.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sg.edu.iss.club.domain.Facility;
import sg.edu.iss.club.domain.Member;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {

	//need booking attributes also?
	@Override
	public int createBooking(Facility f, Member m, Date fdate, Date tdate) {
		return 0;
	}
	
}

package sg.edu.iss.club.bookingTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sg.edu.iss.club.ClubSimpleJpaSolutionApplication;
import sg.edu.iss.club.domain.Booking;
import sg.edu.iss.club.domain.Facility;
import sg.edu.iss.club.domain.Member;
import sg.edu.iss.club.repo.BookingRepo;
import sg.edu.iss.club.repo.FacilityRepo;
import sg.edu.iss.club.repo.MemberRepo;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ClubSimpleJpaSolutionApplication.class)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookingUnitTestCase {

	@Autowired
	BookingRepo brepo;	
	@Autowired
	FacilityRepo frepo;
	@Autowired 
	MemberRepo mrepo;
		
	@Test
	@Order(1)
	public void testfindAllBookings() throws ParseException {
		brepo.deleteAll(); 
		frepo.deleteAll();
		mrepo.deleteAll();
		Member m = new Member("Madeline", "Gry");
		Member m1 = new Member("Bob", "Gee");
		Member m2 = new Member("Jessica", "Goh");
		Member m3 = new Member("Kaitlyn", "Gay");
		ArrayList<Member> mlist = new ArrayList<Member>();
		mlist.add(m);mlist.add(m1);mlist.add(m2);mlist.add(m3);
		mrepo.saveAllAndFlush(mlist);
		
		Facility f = new Facility("Gym", "Fitness Center");
		Facility f1 = new Facility("Study Room", "ISS");
		ArrayList<Facility> flist = new ArrayList<Facility>();
		flist.add(f);flist.add(f1);
		frepo.saveAllAndFlush(flist);
		
		SimpleDateFormat ssf = new SimpleDateFormat("dd/MM/yyyy");
		String date1 = "01/01/2022"; String date2 = "05/01/2022";
		String date3 = "10/02/2022"; String date4 = "12/02/2022";
		Date from = ssf.parse(date1); Date to = ssf.parse(date2);
		Date from1 = ssf.parse(date3); Date to1 = ssf.parse(date4);

		Booking b = new Booking(f, m, from, to);
		Booking b1 = new Booking(f1, m1, from, to);
		Booking b2 = new Booking(f, m2, from1, to1);
		Booking b3 = new Booking(f1, m3, from1, to1);
	
		ArrayList<Booking> blist = new ArrayList<Booking>();
		blist.add(b);blist.add(b1);blist.add(b2);blist.add(b3);
		brepo.saveAllAndFlush(blist);

		ArrayList<Booking> bblist = (ArrayList) brepo.findAll();
		for (Booking current : bblist) {
			System.out.println(current.toString());
		}
		assertEquals(blist.size(), 4);

	}

	@Test
	@Order(2)
	public void testreadBookingById() throws ParseException {
		brepo.deleteAll(); 
		frepo.deleteAll();
		mrepo.deleteAll();
		Member m = new Member("Madeline", "Gry");
		Member m1 = new Member("Bob", "Gee");
		Member m2 = new Member("Jessica", "Goh");
		Member m3 = new Member("Kaitlyn", "Gay");
		ArrayList<Member> mlist = new ArrayList<Member>();
		mlist.add(m);mlist.add(m1);mlist.add(m2);mlist.add(m3);
		mrepo.saveAllAndFlush(mlist);
		
		Facility f = new Facility("Gym", "Fitness Center");
		Facility f1 = new Facility("Study Room", "ISS");
		ArrayList<Facility> flist = new ArrayList<Facility>();
		flist.add(f);flist.add(f1);
		frepo.saveAllAndFlush(flist);
		
		SimpleDateFormat ssf = new SimpleDateFormat("dd/MM/yyyy");
		String date1 = "01/01/2022"; String date2 = "05/01/2022";
		String date3 = "10/02/2022"; String date4 = "12/02/2022";
		Date from = ssf.parse(date1); Date to = ssf.parse(date2);
		Date from1 = ssf.parse(date3); Date to1 = ssf.parse(date4);

		Booking b = new Booking(f, m, from, to);
		Booking b1 = new Booking(f1, m1, from, to);
		Booking b2 = new Booking(f, m2, from1, to1);
		Booking b3 = new Booking(f1, m3, from1, to1);
	
		ArrayList<Booking> blist = new ArrayList<Booking>();
		blist.add(b);blist.add(b1);blist.add(b2);blist.add(b3);
		brepo.saveAllAndFlush(blist);
		
		Booking result = brepo.	readBookingById(b1.getBookingId());
		assertEquals(b1, result, "Test Case Failure");
	}

	@Test
	@Order(3)
	public void testreadBookingByMemberName() throws ParseException {
		brepo.deleteAll(); 
		frepo.deleteAll();
		mrepo.deleteAll();
		
		Member m = new Member("Madeline", "Gry");
		Member m1 = new Member("Bob", "Gee");
		
		ArrayList<Member> mlist = new ArrayList<Member>();
		mlist.add(m);mlist.add(m1);
		mrepo.saveAllAndFlush(mlist);
		
		Facility f = new Facility("Gym", "Fitness Center");
		Facility f1 = new Facility("Study Room", "ISS");
		ArrayList<Facility> flist = new ArrayList<Facility>();
		flist.add(f);flist.add(f1);
		frepo.saveAllAndFlush(flist);
		
		SimpleDateFormat ssf = new SimpleDateFormat("dd/MM/yyyy");
		String date1 = "01/01/2022"; String date2 = "05/01/2022";
		String date3 = "10/02/2022"; String date4 = "12/02/2022";
		Date from = ssf.parse(date1); Date to = ssf.parse(date2);
		Date from1 = ssf.parse(date3); Date to1 = ssf.parse(date4);

		Booking b = new Booking(f, m, from, to);
		Booking b1 = new Booking(f1, m1, from, to);
		Booking b2 = new Booking(f, m1, from1, to1);
		Booking b3 = new Booking(f1, m1, from1, to1);
	
		ArrayList<Booking> blist = new ArrayList<Booking>();
		blist.add(b);blist.add(b1);blist.add(b2);blist.add(b3);
		brepo.saveAllAndFlush(blist);
		
		ArrayList<Booking> result = brepo.readByMember_FirstnameLike("Bob");
		for (Booking booking : result) {
			System.out.println(booking.toString());
		}
		assertEquals(result.size(), 3);
	}
	
	
}

package sg.edu.iss.club;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.edu.iss.club.domain.Booking;
import sg.edu.iss.club.domain.Facility;
import sg.edu.iss.club.domain.Member;
import sg.edu.iss.club.repo.BookingRepo;
import sg.edu.iss.club.repo.FacilityRepo;
import sg.edu.iss.club.repo.MemberRepo;

@SpringBootApplication
public class ClubSimpleJpaSolutionApplication {

	@Autowired
	FacilityRepo frepo;
	@Autowired
	MemberRepo mrepo;
	@Autowired
	BookingRepo brepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ClubSimpleJpaSolutionApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner1() {
		return args -> {
			
			Member m = new Member("Xue", "Ling");
			Member m1 = new Member("Bob", "Cat");
			Facility f = new Facility("Creative Impact", "ISS Solutions");
			Facility f1 = new Facility("Solution Design", "ISS Design");
			mrepo.saveAndFlush(m);mrepo.saveAndFlush(m1);
			frepo.saveAndFlush(f);frepo.saveAndFlush(f1);
			ArrayList<Facility> flist = (ArrayList) frepo.findAll();
			for (Facility current : flist) {
				System.out.println(current.toString());
			}
			ArrayList<Member> mlist = (ArrayList) mrepo.findAll();
			for (Member current : mlist) {
				System.out.println(current.toString());	
			}
			
			SimpleDateFormat ssf = new SimpleDateFormat("dd/MM/yyyy");
			String date1 = "01/01/2022";
			String date2 = "05/01/2022";
			Date from = ssf.parse(date1); Date to = ssf.parse(date2);

			Booking b = new Booking(f, m, from, to);
			Booking b1 = new Booking(f1, m1, from, to);
			brepo.saveAndFlush(b); brepo.saveAndFlush(b1);
			ArrayList<Booking> blist = (ArrayList) brepo.findAll();
			for (Booking current : blist) {
				System.out.println(current.toString());
			}
			

		};
	}
	
}

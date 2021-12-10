package sg.edu.iss.club.facilityTestCase;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sg.edu.iss.club.ClubSimpleJpaSolutionApplication;
import sg.edu.iss.club.domain.Facility;
import sg.edu.iss.club.repo.FacilityRepo;

//Annotations
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ClubSimpleJpaSolutionApplication.class)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FacilityUnitTestCase {
	@Autowired
	FacilityRepo frepo;
	
//	Add individual unit test tests for the Facility CRUD methods namely 
//	findById(...), save(..), findAll(), and delete(...).
	
	@Test
	@Order(1) 
	public void testFindAllFacility() {
		frepo.deleteAll();
		Facility f = new Facility("Room1", "In ISS Building");
		Facility f1 = new Facility("Art Studio", "Arts Building");
		Facility f2 = new Facility("Multi-purpose Room", "HQ");
		Facility f3 = new Facility("Dance Studio", "Arts Building");
		ArrayList<Facility> flist = new ArrayList<Facility>();
		flist.add(f);flist.add(f1);flist.add(f2);flist.add(f3);
		frepo.saveAllAndFlush(flist);
		ArrayList<Facility> toprintlist = (ArrayList) frepo.findAll();
		for (Facility current : toprintlist) {
			System.out.println(current.toString());
		}
		assertEquals(toprintlist.size(), 4);
	}
	
	@Test
	@Order(2)
	public void testFindByFacilityName() {
		frepo.deleteAll();
		Facility f = new Facility("Room1", "In ISS Building");
		Facility f1 = new Facility("Art Studio", "Arts Building");
		Facility f2 = new Facility("Multi-purpose Room", "HQ");
		Facility f3 = new Facility("Dance Studio", "Arts Building");
		ArrayList<Facility> flist = new ArrayList<Facility>();
		flist.add(f);flist.add(f1);flist.add(f2);flist.add(f3);
		frepo.saveAllAndFlush(flist);
		Facility result = frepo.findFacilityByName("Dance Studio");
		//compare two objects: (obj created, obj persisted, if not the same print sth)
		assertEquals(f3, result, "Test Case Failure");
		
	}
}

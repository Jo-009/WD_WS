package sg.edu.iss.club.memberTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sg.edu.iss.club.ClubSimpleJpaSolutionApplication;
import sg.edu.iss.club.domain.Member;
import sg.edu.iss.club.repo.MemberRepo;

//Annotations
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ClubSimpleJpaSolutionApplication.class)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberUnitTestCase {
	@Autowired
	MemberRepo mrepo;
	
//	Add individual unit test tests for the Facility CRUD methods namely 
//	findById(...), save(..), findAll(), and delete(...).
	
	@Test
	@Order(1) 
	public void testFindAllMembers() {
		mrepo.deleteAll();
		Member m = new Member("Teresa", "Sng");
		Member m1 = new Member("Terence", "Smoot");
		Member m2 = new Member("Nono", "Butter");
		Member m3 = new Member("Ben", "Jacob");
		ArrayList<Member> mlist = new ArrayList<Member>();
		mlist.add(m);mlist.add(m1);mlist.add(m2);mlist.add(m3);
		mrepo.saveAllAndFlush(mlist);
		ArrayList<Member> toprintlist = (ArrayList) mrepo.findAll();
		for (Member current : toprintlist) {
			System.out.println(current.toString());
		}
		assertEquals(toprintlist.size(), 4);
	}
	
	@Test
	@Order(2)
	public void testReadAndSortByfirstname() {
		mrepo.deleteAll();
		Member m = new Member("Teresa", "Sng");
		Member m1 = new Member("Nono", "Smoot");
		Member m2 = new Member("Nono", "Butter");
		Member m3 = new Member("Ben", "Jacob");
		ArrayList<Member> mlist = new ArrayList<Member>();
		mlist.add(m);mlist.add(m1);mlist.add(m2);mlist.add(m3);
		mrepo.saveAllAndFlush(mlist);
																//declare params(direction ascneding/descending), no limit so can add how many params you want
		ArrayList<Member> result = mrepo.readMemberSortedByfirstname("Nono", Sort.by(Direction.ASC, "secondname"));
		for (Member member : result) {
			System.out.println(member.toString());
		}
		assertEquals(result.size(), 2);
		
	}
}

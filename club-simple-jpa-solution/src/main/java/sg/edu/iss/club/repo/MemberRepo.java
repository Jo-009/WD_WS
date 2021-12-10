package sg.edu.iss.club.repo;

import java.util.ArrayList;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.club.domain.Member;

public interface MemberRepo extends JpaRepository<Member, Integer> {
	ArrayList<Member> findMembersByfirstname(String firstname);	

	@Query("Select m from Member m where m.firstname like :firstname")
	ArrayList<Member> readMemberSortedByfirstname(@Param("firstname") String n, Sort sort);
}

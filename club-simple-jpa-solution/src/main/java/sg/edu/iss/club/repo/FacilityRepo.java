package sg.edu.iss.club.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.club.domain.Facility;

public interface FacilityRepo extends JpaRepository<Facility, Integer> {
	//testcase1
//	ArrayList<Facility> findFacilityByName(String name);
	//testcase2
	@Query("Select f from Facility f where f.name = :name")
	Facility findFacilityByName(@Param("name") String n);

	
}

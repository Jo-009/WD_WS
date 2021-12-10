package sg.edu.iss.club.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="facility")
public class Facility {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer facilityId;
	private String name;
	private String description;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Collection<Booking> bookings = new HashSet<Booking>();
	
	
	public Facility() {
		super();
	}
	public Facility(String name, String description) {
		super();
		this.name=name;
		this.description=description;		
	}

	
	
//--------------------------------------------------------------------	
	public Integer getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(Collection<Booking> bookings) {
		this.bookings = bookings;
	}
	@Override
	public int hashCode() {
		return Objects.hash(facilityId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facility other = (Facility) obj;
		return Objects.equals(facilityId, other.facilityId);
	}
	@Override
	public String toString() {
		return "Facility [facilityId=" + facilityId + ", name=" + name + ", description=" + description + "]";
	}
//--------------------------------------------------------------------

}

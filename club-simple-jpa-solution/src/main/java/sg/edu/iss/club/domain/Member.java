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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberId;
	private String firstname;
	private String secondname;
	private String username;
	private String password;
	
	//to override lazy loading, when member load
	//corresponding bookings will load too
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Collection<Booking> bookings = new HashSet<Booking>();

	
	public Member() {
		super();
	}
	public Member(String firstname, String secondname) {
		super();
		this.firstname = firstname;
		this.secondname = secondname;
	}
	public Member(String firstname, HashSet<Booking> booking) {
		super();
		this.firstname = firstname;
		this.bookings=booking;
	}

	
	
//	----------------------------------------------------------	
	public Integer getMemberId() {
		return memberId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Collection<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(Collection<Booking> bookings) {
		this.bookings = bookings;
	}
	@Override
	public int hashCode() {
		return Objects.hash(memberId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(memberId, other.memberId);
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", firstname=" + firstname + ", secondname=" + secondname
				+ ", username=" + username + ", password=" + password + "]";
	}
//	--------------------------------------------------------------------	
}

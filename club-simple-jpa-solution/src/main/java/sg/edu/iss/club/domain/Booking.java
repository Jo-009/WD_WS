package sg.edu.iss.club.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name ="booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bookingid")
	private Integer bookingId;

	@ManyToOne(optional=true)
	private Facility facility;

	@ManyToOne(optional=true)
	private Member member;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fromdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "todate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date toDate;

	@Column(name="description")
	private String description;

	public Booking() {}
	public Booking(Facility facility, Member member, Date fromDate, 
			Date toDate) {
		super();
		this.facility = facility;
		this.member = member;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	
	//no lombok thats why...
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookingId, other.bookingId);
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", facility=" + facility + ", member=" + member + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", description=" + description + "]";
	}
	
}

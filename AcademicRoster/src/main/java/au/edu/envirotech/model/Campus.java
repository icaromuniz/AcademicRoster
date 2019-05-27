package au.edu.envirotech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import au.edu.envirotech.architecture.AbstractEntity;

/**
 * The persistent class for the campus database table.
 * 
 */
@Entity
@Table(name = "campus")
@NamedQuery(name = "Campus.findAll", query = "SELECT c FROM Campus c")
public class Campus extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CAMPUS_ID_GENERATOR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAMPUS_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(nullable = false, length = 10)
	private String number;

	@Column(nullable = false, length = 4)
	private String postcode;

	@Column(nullable = false, length = 100)
	private String street;

	// bi-directional many-to-one association to Room
	@OneToMany(mappedBy = "campus")
	private List<Room> roomList = new ArrayList<>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public Room addRoom(Room room) {
		getRoomList().add(room);
		room.setCampus(this);

		return room;
	}

	public Room removeRoom(Room room) {
		getRoomList().remove(room);
		room.setCampus(null);

		return room;
	}
}
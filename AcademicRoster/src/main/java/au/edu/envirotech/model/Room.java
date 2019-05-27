package au.edu.envirotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the room database table.
 * 
 */
@Entity
@Table(name = "room")
@NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
public class Room extends au.edu.envirotech.architecture.AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ROOM_ID_GENERATOR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private Integer id;

	private Integer capacity;

	@Column(length = 100)
	private String comment;

	@Column(length = 5)
	private String number;

	// bi-directional many-to-one association to Campus
	@ManyToOne
	@JoinColumn(name = "campus_id", nullable = false)
	private Campus campus;

	public Room() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Campus getCampus() {
		return this.campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

}
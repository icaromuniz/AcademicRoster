package au.edu.envirotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import au.edu.envirotech.architecture.AbstractEntity;

@Entity
@Table(name="UNIT_OF_COMPETENCY")
public class UnitOfCompetency extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "UNIT_OF_COMPETENCY_ID_GENERATOR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNIT_OF_COMPETENCY_ID_GENERATOR")
	private int id;

	@Length(max=10)
	@Column(nullable = false, length = 10)
	private String code;
	
	@Column(name = "UNIT_SECTOR", nullable = false) 
	private String unitSector;

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUnitSector() {
		return unitSector;
	}

	public void setUnitSector(String unitSector) {
		this.unitSector = unitSector;
	}

}

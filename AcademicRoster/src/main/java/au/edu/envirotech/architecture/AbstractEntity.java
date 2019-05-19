package au.edu.envirotech.architecture;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Version
	@Column(nullable=false)
	private Integer versao;

	public abstract void setId(int id);
	public abstract int getId();
}

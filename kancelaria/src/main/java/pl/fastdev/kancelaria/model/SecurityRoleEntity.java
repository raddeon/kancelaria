package pl.fastdev.kancelaria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class SecurityRoleEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Long userId;
	
	@Column
	private String rola;
	

	public SecurityRoleEntity() {
	}

	public SecurityRoleEntity(Long id, String rola) {
		this.userId = id;
		this.rola = rola;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRola() {
		return rola;
	}

	public void setRole(String role) {
		this.rola = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof SecurityRoleEntity) {
			SecurityRoleEntity rola = (SecurityRoleEntity) o;
			return rola.getRola().equalsIgnoreCase(getRola()) && rola.getUserId().equals(getUserId());
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return id.intValue();
	}
}

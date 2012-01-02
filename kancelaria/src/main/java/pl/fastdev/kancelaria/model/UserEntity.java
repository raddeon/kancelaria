package pl.fastdev.kancelaria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="userEntity")
public class UserEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true)
	@NotEmpty
	private String username;
	
	@Column
	@NotEmpty
	private String password;
	
	@Column
	private boolean enabled;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private List<SecurityRoleEntity> roles;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public boolean equals(Object o) {
		if (o != null && o instanceof UserEntity && getUsername() != null) {
			UserEntity u = (UserEntity)o;
			return getUsername().equalsIgnoreCase(u.getUsername());
		} else {
			return false;
		}
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<SecurityRoleEntity> getRoles() {
//		List<SecurityRoleEntity> hardcode = new ArrayList<SecurityRoleEntity>();
//		hardcode.add(new SecurityRoleEntity("aaa", "rola1"));
//		hardcode.add(new SecurityRoleEntity("aaa", "rola2"));
//		
		return roles;
	}

	public void setRoles(List<SecurityRoleEntity> roles) {
		this.roles = roles;
	}
	
	
}

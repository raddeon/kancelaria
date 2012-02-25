package pl.fastdev.kancelaria.bean.logowanie;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.fastdev.kancelaria.model.UserEntity;

@Component("login")
@RequestScoped
public class Logowanie {

	private UserEntity user = new UserEntity();
	
	private Rola rola;
	
	private String succ;
	
	@Autowired
	private UserDao userDao;
	
	public void save() {
		try {
			userDao.save(user);
		} catch (DuplicateEntityException ex) {
			succ = ex.getPrzyczyna().name();
		}
	}
	
	public void addRole() {
		try {
			int x =0;
			userDao.addRoleToUser(user, rola);
		} catch (DuplicateEntityException ex) {
			succ = ex.getPrzyczyna().name();
		}
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getSucc() {
		return succ;
	}

	public Rola getRola() {
		return rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setSucc(String succ) {
		this.succ = succ;
	}
}

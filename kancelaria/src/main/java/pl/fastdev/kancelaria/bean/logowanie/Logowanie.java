package pl.fastdev.kancelaria.bean.logowanie;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
		} catch (UserModificationException ex) {
			succ = ex.getPrzyczyna().name();
		}
	}
	
	public void addRole() {
		try {
			userDao.addRoleToUser(user, rola);
		} catch (UserModificationException ex) {
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
}

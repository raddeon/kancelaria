package pl.fastdev.kancelaria.bean.logowanie;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.fastdev.kancelaria.model.SecurityRoleEntity;
import pl.fastdev.kancelaria.model.UserEntity;

@Component
public class UserDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(UserEntity user) throws UserModificationException {
		UserEntity newUser = new UserEntity();
		
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		
		
		if (!exists(newUser)) {
			em.persist(newUser);
		} else {
			throw new UserModificationException(PrzyczynaBleduModyfikacji.JEST_JUZ_USER_O_TEJ_NAZWIE);
		}
	}
	
	@Transactional
	public void addRoleToUser(UserEntity user, Rola rola) throws UserModificationException {
		UserEntity u = findByName(user.getUsername());
		
		SecurityRoleEntity dodawanaRola = new SecurityRoleEntity(u.getId(), rola.name());
		if (!u.getRoles().contains(dodawanaRola)) {
			u.getRoles().add(new SecurityRoleEntity(u.getId(), rola.name()));
			em.merge(u);
		} else {
			throw new UserModificationException(PrzyczynaBleduModyfikacji.WYBRANY_USER_MA_JUZ_TA_ROLE);
		}
	}
	
	@Transactional
	public UserEntity findByName(String username) throws UserModificationException {
		UserEntity result = (UserEntity)em.createQuery("from userEntity where username = :username")
		.setParameter("username", username).getSingleResult();
		if (result != null) {
			return em.find(UserEntity.class, result.getId());
		} else {
			throw new UserModificationException(PrzyczynaBleduModyfikacji.NIE_MA_USERA_O_TAKIM_USERNAME);
		}
	}
	
	private boolean exists(UserEntity user) {
		if (user != null) {
			List<UserEntity> result = em.createQuery("from userEntity where username = :username")
			.setParameter("username", user.getUsername()).getResultList();
			
			if (result != null && result.size() > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Transactional
	public boolean login(UserEntity user) {
		if (user != null) {
			List<UserEntity> result = em.createQuery("from userEntity where username = :username and password = :password")
			.setParameter("username", user.getUsername()).setParameter("password", user.getPassword()).getResultList();
			
			if (result != null && result.size() == 1) {
				System.out.println("zalogowac");
				return true;
			} else {
				System.out.println("nie logowac 1");
				return false;
			}
		} else {
			System.out.println("from User where username=:username" + user.getUsername() + " and password=:password" + user.getPassword() + "nie logowac 2");
			return false;
		}
	}

}

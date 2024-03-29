package pl.fastdev.kancelaria.bean.logowanie;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.fastdev.kancelaria.model.SecurityRoleEntity;
import pl.fastdev.kancelaria.model.UserEntity;

@Component
public class UserDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(UserEntity user) throws DuplicateEntityException {
		UserEntity newUser = new UserEntity();
		
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		
		
		if (!exists(newUser)) {
			boolean done = false;
			try {
				em.persist(newUser);
				done = true;
			} finally {
				if (done) {
					em.close();
				}
			}
		} else {
			throw new DuplicateEntityException(PrzyczynaBleduModyfikacji.JEST_JUZ_USER_O_TEJ_NAZWIE);
		}
	}
	
	@Transactional(propagation=Propagation.NESTED)
	public void addRoleToUser(UserEntity user, Rola rola) throws DuplicateEntityException {
		UserEntity u = findByName(user.getUsername());
		
		SecurityRoleEntity dodawanaRola = new SecurityRoleEntity(u.getId(), rola.name());
		if (!u.getRoles().contains(dodawanaRola)) {
			u.getRoles().add(new SecurityRoleEntity(u.getId(), rola.name()));
			em.merge(u);
		} else {
			throw new DuplicateEntityException(PrzyczynaBleduModyfikacji.WYBRANY_USER_MA_JUZ_TA_ROLE);
		}
	}
	
	@Transactional
	public UserEntity findByName(String username) throws DuplicateEntityException {
		try {
			UserEntity result = (UserEntity)em.createQuery("from userEntity where username = :username")
			.setParameter("username", username).getSingleResult();
			return em.find(UserEntity.class, result.getId());
		} catch (NoResultException ex) {
			throw new DuplicateEntityException(PrzyczynaBleduModyfikacji.NIE_MA_USERA_O_TAKIM_USERNAME);
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
}

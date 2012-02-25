package pl.fastdev.kancelaria.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.fastdev.kancelaria.bean.logowanie.DuplicateEntityException;
import pl.fastdev.kancelaria.bean.logowanie.PrzyczynaBleduModyfikacji;

@Component
public class KlientDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void dodajKlienta(Klient klient) throws DuplicateEntityException {
		if (!exists(klient)) {
			try {
				em.persist(klient);
				em.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			throw new DuplicateEntityException(PrzyczynaBleduModyfikacji.JEST_JUZ_USER_O_TEJ_NAZWIE);
		}
	}
	
	private boolean exists(Klient user) {
		if (user != null) {
			List<Klient> result = em.createQuery("from Klient where nazwa = :nazwa")
			.setParameter("nazwa", user.getNazwa()).getResultList();
			
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

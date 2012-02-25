package pl.fastdev.kancelaria.bean.logowanie;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import pl.fastdev.kancelaria.model.Klient;
import pl.fastdev.kancelaria.model.KlientDao;

@Component("crud")
@SessionScoped
public class CRUDBean {
	
	@Autowired
	KlientDao klientDao;
	
	private String message;
	
	private Klient klient = new Klient();
	
	public void dodajKlienta() {
		try {
			klientDao.dodajKlienta(klient);
		} catch (DuplicateEntityException e) {
			message = e.getPrzyczyna().name();
		}
	}

	public KlientDao getKlientDao() {
		System.out.println("jesteś szalona");
		return klientDao;
	}

	public void setKlientDao(KlientDao klientDao) {
		this.klientDao = klientDao;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}
}

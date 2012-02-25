package pl.fastdev.kancelaria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import pl.fastdev.kancelaria.model.wspolne.StanSprawy;

@Entity
public class Sprawa implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private List<UserEntity> przypisaniPracownicy;
	
	@OneToOne
	private Klient klient;
	
	@OneToOne
	private Klient podKlient;
	
	@OneToOne
	private Przeciwnik przeciwnik;
	
	@OneToOne
	private Sad sad;
	
	@Column
	private String opisSprawy;
	
	@OneToMany
	private List<Notatka> notatki;
	
	@OneToMany
	private List<Alert> alerty;
	
	@OneToMany
	private List<Czynnosc> czynnosci; 
	
	@Enumerated
	private StanSprawy stanSprawy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<UserEntity> getPrzypisaniPracownicy() {
		return przypisaniPracownicy;
	}

	public void setPrzypisaniPracownicy(List<UserEntity> przypisaniPracownicy) {
		this.przypisaniPracownicy = przypisaniPracownicy;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public Klient getPodKlient() {
		return podKlient;
	}

	public void setPodKlient(Klient podKlient) {
		this.podKlient = podKlient;
	}

	public Przeciwnik getPrzeciwnik() {
		return przeciwnik;
	}

	public void setPrzeciwnik(Przeciwnik przeciwnik) {
		this.przeciwnik = przeciwnik;
	}

	public Sad getSad() {
		return sad;
	}

	public void setSad(Sad sad) {
		this.sad = sad;
	}

	public String getOpisSprawy() {
		return opisSprawy;
	}

	public void setOpisSprawy(String opisSprawy) {
		this.opisSprawy = opisSprawy;
	}

	public List<Notatka> getNotatki() {
		return notatki;
	}

	public void setNotatki(List<Notatka> notatki) {
		this.notatki = notatki;
	}

	public List<Alert> getAlerty() {
		return alerty;
	}

	public void setAlerty(List<Alert> alerty) {
		this.alerty = alerty;
	}

	public List<Czynnosc> getCzynnosci() {
		return czynnosci;
	}

	public void setCzynnosci(List<Czynnosc> czynnosci) {
		this.czynnosci = czynnosci;
	}

	public StanSprawy getStanSprawy() {
		return stanSprawy;
	}

	public void setStanSprawy(StanSprawy stanSprawy) {
		this.stanSprawy = stanSprawy;
	}
}

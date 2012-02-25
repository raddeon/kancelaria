package pl.fastdev.kancelaria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

import pl.fastdev.kancelaria.model.wspolne.Adres;
import pl.fastdev.kancelaria.model.wspolne.RodzajPodmiotu;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class StronaSprawy implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated
	private RodzajPodmiotu rodzajPodmiotu;
	
	@Column
	private String nazwa;

	@Column
	private String nazwaPelna;

	@Embedded
	private Adres adres;
	
	@Column
	private String telefon;

	@Column
	private String krs;

	@Column
	private String nip;

	@Column
	private String pesel;

	@Column
	private String regon;

	public RodzajPodmiotu getRodzajPodmiotu() {
		return rodzajPodmiotu;
	}

	public void setRodzajPodmiotu(RodzajPodmiotu rodzajPodmiotu) {
		this.rodzajPodmiotu = rodzajPodmiotu;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public String getNazwaPelna() {
		return nazwaPelna;
	}

	public void setNazwaPelna(String nazwaPelna) {
		this.nazwaPelna = nazwaPelna;
	}

	public String getKrs() {
		return krs;
	}

	public void setKrs(String krs) {
		this.krs = krs;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getRegon() {
		return regon;
	}

	public void setRegon(String regon) {
		this.regon = regon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StronaSprawy) {
			StronaSprawy s = (StronaSprawy) obj;
			return s.getId().equals(this.getId());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "ID: " + getId() + " nazwa: " + getNazwa() + " nazwaPelna: " + getNazwaPelna() + " NIP: " + getNip() 
		+ " PESEL: " + getPesel() + " REGON: " + getRegon() + " KRS: " + getKrs();
	}
}

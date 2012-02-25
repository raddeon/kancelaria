package pl.fastdev.kancelaria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Czynnosc implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String dataWykonania;

	@Column
	private String opis;

	@Column
	private int czasWykonywania;

	@OneToOne
	private UserEntity pracownik;

	public String getDataWykonania() {
		return dataWykonania;
	}

	public void setDataWykonania(String dataWykonania) {
		this.dataWykonania = dataWykonania;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getCzasWykonywania() {
		return czasWykonywania;
	}

	public void setCzasWykonywania(int czasWykonywania) {
		this.czasWykonywania = czasWykonywania;
	}

	public UserEntity getPracownik() {
		return pracownik;
	}

	public void setPracownik(UserEntity pracownik) {
		this.pracownik = pracownik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

package pl.fastdev.kancelaria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Alert extends Notatka implements Serializable {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataWykonania;

	@Column
	private UserEntity wykonawca;

	@Column
	private boolean czyWykonana;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public Date getDataWykonania() {
		return dataWykonania;
	}

	public void setDataWykonania(Date dataWykonania) {
		this.dataWykonania = dataWykonania;
	}

	public UserEntity getWykonawca() {
		return wykonawca;
	}

	public void setWykonawca(UserEntity wykonawca) {
		this.wykonawca = wykonawca;
	}

	public boolean isCzyWykonana() {
		return czyWykonana;
	}

	public void setCzyWykonana(boolean czyWykonana) {
		this.czyWykonana = czyWykonana;
	}
}

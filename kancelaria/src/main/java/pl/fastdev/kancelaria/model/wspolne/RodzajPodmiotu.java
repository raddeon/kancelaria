package pl.fastdev.kancelaria.model.wspolne;

public enum RodzajPodmiotu {
	
	OSOBA_FIZYCZNA("Osoba fizyczna"),
	
	OSOBA_FIZYCZNA_PROWADZACA_DZIALALNOSC("Osoba fizyczna prowadz¹ca dzia³alnoœæ"),
	
	OSOBA_PRAWNA("Osoba prawna"),
	
	JEDNOSTKA_ORGANIZACYJNA("Jednostka organizacyjna");
	
	private String nazwa;

	private RodzajPodmiotu(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getNazwa() {
		return nazwa;
	}
}

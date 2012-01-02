package pl.fastdev.kancelaria.bean.logowanie;

public enum Rola {
	
	ADMIN("Administrator"),
	
	PRACOWNIK("Pracownik"),
	
	ANALITYK("Analityk");
	
	private String nazwa;

	private Rola(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getNazwa() {
		return nazwa;
	}
}

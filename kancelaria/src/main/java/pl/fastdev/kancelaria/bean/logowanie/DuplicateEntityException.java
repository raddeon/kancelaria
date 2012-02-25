package pl.fastdev.kancelaria.bean.logowanie;

public class DuplicateEntityException extends Exception {
	
	private PrzyczynaBleduModyfikacji cause;

	public DuplicateEntityException(PrzyczynaBleduModyfikacji cause) {
		this.cause = cause;
	}

	public PrzyczynaBleduModyfikacji getPrzyczyna() {
		return cause;
	}

}

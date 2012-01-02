package pl.fastdev.kancelaria.bean.logowanie;

public class UserModificationException extends Exception {
	
	private PrzyczynaBleduModyfikacji cause;

	public UserModificationException(PrzyczynaBleduModyfikacji cause) {
		this.cause = cause;
	}

	public PrzyczynaBleduModyfikacji getPrzyczyna() {
		return cause;
	}

}

package pl.fastdev.kancelaria.bean.slowniki;

import org.springframework.stereotype.Component;

import pl.fastdev.kancelaria.bean.logowanie.Rola;

@Component
public class SlownikiEnum {
	
	public Rola[] getRole(){
		return Rola.values();
	}

}

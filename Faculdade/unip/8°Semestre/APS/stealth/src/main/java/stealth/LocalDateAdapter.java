package stealth;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	public String marshal(LocalDate argumento) throws Exception {
		return argumento.toString();
	}

	public LocalDate unmarshal(String argumento) throws Exception {
		return LocalDate.parse(argumento);
	}

}

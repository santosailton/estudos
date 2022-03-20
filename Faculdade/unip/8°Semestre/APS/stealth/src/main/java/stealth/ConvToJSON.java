package stealth;

import org.springframework.boot.jackson.JsonObjectSerializer;

public class ConvToJSON {

	public JsonObjectSerializer<Previsao> getPrevisaoJson(){
		return JsonObjectSerializer<Previsao>;
	}
}

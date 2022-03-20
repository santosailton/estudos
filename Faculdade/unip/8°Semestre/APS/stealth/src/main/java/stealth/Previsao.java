package stealth;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = {"dia", "tempo", "tempMaxima", "tempMinima", "indiceUV"})
public class Previsao {
	LocalDate dia;
	String tempo;
	Integer tempMaxima;
	Integer tempMinima;
	Double indiceUV;
	
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@XmlElement(name = "dia")
	public void setDia(LocalDate dia) {
		this.dia = dia;
	}
	
	@XmlElement(name = "tempo")
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	
	@XmlElement(name = "maxima")
	public void setTempMaxima(Integer tempMaxima) {
		this.tempMaxima = tempMaxima;
	}
	
	@XmlElement(name = "minima")
	public void setTempMinima(Integer tempMinima) {
		this.tempMinima = tempMinima;
	}
	
	@XmlElement(name = "iuv")
	public void setIndiceUV(Double indiceUV) {
		this.indiceUV = indiceUV;
	}

	public LocalDate getDia() {
		return dia;
	}

	public String getTempo() {
		return tempo;
	}

	public Integer getTempMaxima() {
		return tempMaxima;
	}

	public Integer getTempMinima() {
		return tempMinima;
	}

	public Double getIndiceUV() {
		return indiceUV;
	}
	
	
}

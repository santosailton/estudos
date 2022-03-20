package stealth;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Cidade {
	String nome;
	String uf;
	LocalDate atualizacao;
	List<Previsao> previsao;

	@XmlElement(name = "nome")
	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlElement(name = "uf")
	public void setUf(String uf) {
		this.uf = uf;
	}

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@XmlElement(name = "atualizacao")
	public void setAtualizacao(LocalDate atualizacao) {
		this.atualizacao = atualizacao;
	}

	@XmlElement(name = "previsao")
	public void setPrevisao(List<Previsao> previsao) {
		this.previsao = previsao;
	}

	public String getNome() {
		return nome;
	}

	public String getUf() {
		return uf;
	}

	public LocalDate getAtualizacao() {
		return atualizacao;
	}

	public List<Previsao> getPrevisao() {
		return previsao;
	}

}

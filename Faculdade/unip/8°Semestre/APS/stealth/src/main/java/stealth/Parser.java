package stealth;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Parser {

	public static Cidade getPrevisao() throws JAXBException {
		try (CloseableHttpClient cli = HttpClients.createDefault();
				CloseableHttpResponse resp = cli
						.execute(new HttpGet("http://servicos.cptec.inpe.br/XML/cidade/586/previsao.xml"))) {

			HttpEntity entity = resp.getEntity();
			String resposta = EntityUtils.toString(entity);
			Path pathXMLFile = Paths.get("previsao.xml");
			Files.write(pathXMLFile, resposta.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.APPEND,
					StandardOpenOption.CREATE);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		File fileXml = new File("previsao.xml");
		JAXBContext jaxb = JAXBContext.newInstance(Cidade.class);

		Unmarshaller unmarshaller = jaxb.createUnmarshaller();
		Cidade cidade = (Cidade) unmarshaller.unmarshal(fileXml);
		fileXml.delete();

		return cidade;

	}

	public static Previsao getPrevisaoDeHoje() throws JAXBException {
		List<Previsao> previsoes = getPrevisao().previsao;
		Previsao previsaoDeHoje = null;
		for (Previsao previsao : previsoes) {
			if (LocalDateDayComparisor.isToday(previsao.getDia()))
				previsaoDeHoje = previsao;
		}

		return previsaoDeHoje;
	}

}

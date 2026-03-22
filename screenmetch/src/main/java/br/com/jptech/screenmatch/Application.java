package br.com.jptech.screenmatch;

import br.com.jptech.screenmatch.model.DadosEpisodio;
import br.com.jptech.screenmatch.model.DadosSerie;
import br.com.jptech.screenmatch.service.ConsumoApi;
import br.com.jptech.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=friends&apikey=8baae057");
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(json);
		System.out.println(dados);
		json = consumoApi.obterDados
				("https://www.omdbapi.com/?t=friends&Season=1&episode=8&apikey=8baae057");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);

	}

}

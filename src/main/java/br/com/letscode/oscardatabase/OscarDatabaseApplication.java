package br.com.letscode.oscardatabase;

import br.com.letscode.oscardatabase.artistas.Artista;
import br.com.letscode.oscardatabase.artistas.ArtistaRepository;
import br.com.letscode.oscardatabase.artistas.SexoEnum;
import br.com.letscode.oscardatabase.premiacao.Premiacao;
import br.com.letscode.oscardatabase.premiacao.PremiacaoRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OscarDatabaseApplication implements CommandLineRunner {

    private final ArtistaRepository artistaRepository;
    private final PremiacaoRepository premiacaoRepository;

    public OscarDatabaseApplication(
        ArtistaRepository artistaRepository,
        PremiacaoRepository premiacaoRepository) {
        this.artistaRepository = artistaRepository;
        this.premiacaoRepository = premiacaoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OscarDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Artista artista = new Artista(1, "Emil Jannings", 44, SexoEnum.M);
        Premiacao premiacao = new Premiacao(1, 1928, "The Last Command, The Way of All Flesh", artista);
        this.artistaRepository.save(artista);
        this.premiacaoRepository.save(premiacao);
        List<Premiacao> resultList = this.premiacaoRepository.findAll();
        resultList.forEach(System.out::println);
    }
}

package br.com.letscode.oscardatabase;

import br.com.letscode.oscardatabase.artistas.Artista;
import br.com.letscode.oscardatabase.artistas.ArtistaRepository;
import br.com.letscode.oscardatabase.data.BootstrapData;
import br.com.letscode.oscardatabase.premiacao.Premiacao;
import br.com.letscode.oscardatabase.premiacao.PremiacaoArtista;
import br.com.letscode.oscardatabase.premiacao.PremiacaoArtistaRepository;
import br.com.letscode.oscardatabase.premiacao.PremiacaoRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OscarDatabaseApplication implements CommandLineRunner {

    private final ArtistaRepository artistaRepository;
    private final PremiacaoRepository premiacaoRepository;
    private final PremiacaoArtistaRepository premiacaoArtistaRepository;

    public OscarDatabaseApplication(ArtistaRepository artistaRepository,
        PremiacaoRepository premiacaoRepository, PremiacaoArtistaRepository premiacaoArtistaRepository) {
        this.artistaRepository = artistaRepository;
        this.premiacaoRepository = premiacaoRepository;
        this.premiacaoArtistaRepository = premiacaoArtistaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OscarDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Premiacao> premiacaoList = BootstrapData.buildPremiacoes();
        List<Artista> artistaList = premiacaoList.stream()
            .map(Premiacao::getArtista)
            .distinct()
            .collect(Collectors.toList());
        this.artistaRepository.saveAll(artistaList);
        //Para cada Premiacao em premiacaoList
        //1 - recupere o Artista no banco de dados -> artistaBd
        //2 - substitua o atributo Premiacao.artista por artistaBd
        //3 - salve a Premiacao

        Map<String, Integer> idades = BootstrapData.getIdades();

        for (Premiacao premiacao : premiacaoList) {
            Artista artistaBd = this.artistaRepository.findOneByNome(premiacao.getArtista().getNome()).orElseThrow();
            premiacao.setArtista(artistaBd);
            Premiacao premiacaoBd = this.premiacaoRepository.save(premiacao);
            PremiacaoArtista pa = new PremiacaoArtista(idades.get(artistaBd.getNome()), premiacaoBd, artistaBd);
            this.premiacaoArtistaRepository.save(pa);
        }

    }
}

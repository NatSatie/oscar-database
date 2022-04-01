package br.com.letscode.oscardatabase.premiacao;

import br.com.letscode.oscardatabase.artistas.Artista;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PremiacaoArtista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int artistaIdade;

    @ManyToOne
    @JoinColumn(name = "premiacao_id", nullable = false)
    private Premiacao premiacao;

    @ManyToOne
    @JoinColumn(name = "artista_id", nullable = false)
    private Artista artista;

    public PremiacaoArtista(int artistaIdade, Premiacao premiacao, Artista artista) {
        this.artistaIdade = artistaIdade;
        this.premiacao = premiacao;
        this.artista = artista;
    }
}

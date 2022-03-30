package br.com.letscode.oscardatabase.premiacao;

import br.com.letscode.oscardatabase.artistas.Artista;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Premiacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int ano;
    @Column(nullable = false)
    private String nomeFilme;

    @ManyToOne
    @JoinColumn(name = "artista_id", nullable = false)
    //constraint artista_fk foreign key (artista) references artista(id)
    private Artista artista;

}

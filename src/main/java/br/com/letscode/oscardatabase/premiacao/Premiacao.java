package br.com.letscode.oscardatabase.premiacao;

import br.com.letscode.oscardatabase.atores.Artista;
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
public class Premiacao {

    private int id;
    private int ano;
    private Artista artista;
    private String nomeFilme;

}

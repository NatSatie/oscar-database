package br.com.letscode.oscardatabase.artistas;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;

    public Artista(String nome, SexoEnum sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Artista artista = (Artista) o;
        return nome.equals(artista.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}

package br.com.letscode.oscardatabase.artistas;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {

    Optional<Artista> findOneByNome(String nome);

}

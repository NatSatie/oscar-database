package br.com.letscode.oscardatabase.premiacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiacaoArtistaRepository extends JpaRepository<PremiacaoArtista, Integer> {

}

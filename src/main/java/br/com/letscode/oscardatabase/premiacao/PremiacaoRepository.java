package br.com.letscode.oscardatabase.premiacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiacaoRepository extends JpaRepository<Premiacao, Integer> {

}

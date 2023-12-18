package br.unigoias.canil.repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import br.unigoias.canil.model.Raca;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Long>{

}

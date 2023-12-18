package br.unigoias.canil.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unigoias.canil.model.Cao;
import br.unigoias.canil.model.Raca;

@Repository
public interface CaoRepository extends JpaRepository<Cao, Long>{

	List<Cao> findByRaca(Raca raca);
}

package org.serratec.cadastro.repository;


import java.util.List;

import org.serratec.cadastro.model.Candidato;
import org.serratec.cadastro.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>{
	List<Candidato> findByNomeIgnoreCase(String nome);
	List<Candidato> findByVagaDesejada(Vaga vagaDesejada);
	


}

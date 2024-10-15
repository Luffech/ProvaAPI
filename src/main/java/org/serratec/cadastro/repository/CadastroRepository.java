package org.serratec.cadastro.repository;


import java.util.List;

import org.serratec.cadastro.model.Cadastrar;
import org.serratec.cadastro.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastrar, Long>{
	List<Cadastrar> findByNomeIgnoreCase(String nome);
	List<Cadastrar> findByVagaDesejada(Vaga vagaDesejada);
	


}

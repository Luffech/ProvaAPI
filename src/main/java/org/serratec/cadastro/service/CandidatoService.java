package org.serratec.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.serratec.cadastro.dto.CandidatoDto;
import org.serratec.cadastro.model.Candidato;
import org.serratec.cadastro.model.Vaga;
import org.serratec.cadastro.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {
	@Autowired
	private CandidatoRepository repositorio;
	
	public List<CandidatoDto>	obterTodos(){
		return repositorio.findAll().stream().map(c -> CandidatoDto.toDto(c)).toList();
	}
	
	public Optional<CandidatoDto> obterPorId(Long id){
		if(!repositorio.existsById(id)) {
		    return Optional.empty();	
	}
	return Optional.of(CandidatoDto.toDto(repositorio.findById(id).get()));
}
	public CandidatoDto salvarCadastro(CandidatoDto dto) {
        Candidato cadastroEntity = repositorio.save(dto.toEntity()); 
        return CandidatoDto.toDto(cadastroEntity);
        
    }
	
	public boolean apagarPedido(Long id) {
		if(!repositorio.existsById(id)) {
            return false;
        }
        repositorio.deleteById(id);
        return true;
    }
	
	public Optional<CandidatoDto> alterarCadastro(Long id, CandidatoDto dto){
			if(!repositorio.existsById(id)) {
            return Optional.empty();
        }
        Candidato cadastroEntity = dto.toEntity();
        cadastroEntity.setId(id);
        repositorio.save(cadastroEntity);
        return Optional.of(CandidatoDto.toDto(cadastroEntity));
    
	}

	public List<CandidatoDto> buscarPorNome(String nome) {
		List<Candidato> cadastrar = repositorio.findByNomeIgnoreCase(nome);
				return cadastrar.stream().map(c->CandidatoDto.toDto(c)).toList();
	}

	public List<CandidatoDto> buscarPorVaga(Vaga vagaDesejada) {
		List<Candidato> cadastrar = repositorio.findByVagaDesejada(vagaDesejada);
		return cadastrar.stream().map(v->CandidatoDto.toDto(v)).toList();
	}
	
}


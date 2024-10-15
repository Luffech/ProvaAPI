package org.serratec.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.serratec.cadastro.dto.CadastroDto;
import org.serratec.cadastro.model.Cadastrar;
import org.serratec.cadastro.model.Vaga;
import org.serratec.cadastro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {
	@Autowired
	private CadastroRepository repositorio;
	
	public List<CadastroDto>	obterTodos(){
		return repositorio.findAll().stream().map(c -> CadastroDto.toDto(c)).toList();
	}
	
	public Optional<CadastroDto> obterPorId(Long id){
		if(!repositorio.existsById(id)) {
		    return Optional.empty();	
	}
	return Optional.of(CadastroDto.toDto(repositorio.findById(id).get()));
}
	public CadastroDto salvarCadastro(CadastroDto dto) {
        Cadastrar cadastroEntity = repositorio.save(dto.toEntity()); 
        return CadastroDto.toDto(cadastroEntity);
        
    }
	
	public boolean apagarPedido(Long id) {
		if(!repositorio.existsById(id)) {
            return false;
        }
        repositorio.deleteById(id);
        return true;
    }
	
	public Optional<CadastroDto> alterarCadastro(Long id, CadastroDto dto){
			if(!repositorio.existsById(id)) {
            return Optional.empty();
        }
        Cadastrar cadastroEntity = dto.toEntity();
        cadastroEntity.setId(id);
        repositorio.save(cadastroEntity);
        return Optional.of(CadastroDto.toDto(cadastroEntity));
    
	}

	public List<CadastroDto> buscarPorNome(String nome) {
		List<Cadastrar> cadastrar = repositorio.findByNomeIgnoreCase(nome);
				return cadastrar.stream().map(c->CadastroDto.toDto(c)).toList();
	}

	public List<CadastroDto> buscarPorVaga(Vaga vagaDesejada) {
		List<Cadastrar> cadastrar = repositorio.findByVagaDesejada(vagaDesejada);
		return cadastrar.stream().map(v->CadastroDto.toDto(v)).toList();
	}
	
}


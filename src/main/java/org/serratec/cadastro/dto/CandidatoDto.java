package org.serratec.cadastro.dto;

import java.time.LocalDate;

import org.serratec.cadastro.model.Candidato;
import org.serratec.cadastro.model.Escolaridade;
import org.serratec.cadastro.model.Status;
import org.serratec.cadastro.model.Vaga;

public record CandidatoDto(
		Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        Escolaridade escolaridade,
        Vaga vagaDesejada,
        Status statusCurriculo) {
	
	
	public Candidato toEntity() {
		Candidato cadastrar = new Candidato();
		cadastrar.setId(this.id);
		cadastrar.setNome(this.nome);
		cadastrar.setCpf(this.cpf);
		cadastrar.setDataNascimento(this.dataNascimento);
		cadastrar.setEscolaridade(this.escolaridade);
		cadastrar.setVagaDesejada(this.vagaDesejada);
		cadastrar.setStatusCurriculo(this.statusCurriculo);
        return cadastrar;
        
	}
	
	public static CandidatoDto toDto(Candidato cadastrar) {
		return new CandidatoDto( 
				cadastrar.getId(),
				cadastrar.getNome(), 
				cadastrar.getCpf(), 
				cadastrar.getDataNascimento(), 
				cadastrar.getEscolaridade(), 
				cadastrar.getVagaDesejada(),
				cadastrar.getStatusCurriculo());
	}

}

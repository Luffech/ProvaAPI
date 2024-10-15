package org.serratec.cadastro.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.cadastro.dto.CadastroDto;
import org.serratec.cadastro.model.Vaga;
import org.serratec.cadastro.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastrar")
public class CadastroController {
	@Autowired
	private CadastroService servico;

	@GetMapping
	public List<CadastroDto> obterTodos() {
		return servico.obterTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CadastroDto> obterPorId(@PathVariable Long id) {
		Optional<CadastroDto> dto = servico.obterPorId(id);
		if (!dto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dto.get());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CadastroDto salvarCadastro(@RequestBody CadastroDto dto) {
		return servico.salvarCadastro(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagarCadastro(@PathVariable Long id) {
		if (!servico.apagarPedido(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<CadastroDto> alterarCadastro(@PathVariable Long id, @RequestBody CadastroDto dto) {
		Optional<CadastroDto> cadastroAlterado = servico.alterarCadastro(id, dto);
		if (!cadastroAlterado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cadastroAlterado.get());

	}
	
	@GetMapping("/nome/{nome}")
	public List<CadastroDto> obterPorId(@PathVariable String nome) {
		return servico.buscarPorNome(nome);
	}
	@GetMapping("/vaga/{vaga}")
	public List<CadastroDto> obterPorId(@PathVariable("vaga") Vaga vagaDesejada) {
		return servico.buscarPorVaga(vagaDesejada);
	}

}

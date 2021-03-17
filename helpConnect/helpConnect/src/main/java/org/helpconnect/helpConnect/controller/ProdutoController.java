package org.helpconnect.helpConnect.controller;

import java.util.List;

import org.helpconnect.helpConnect.model.Produto;
import org.helpconnect.helpConnect.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	// trazendo todos os produtos cadastrados no DB
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll() {
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	// filtrando produtos por ID
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetById(@PathVariable long id){
		
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// filtrando produtos por TITULO
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Produto>> GetByTitulo(@PathVariable String titulo){
		
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	// filtrando produtos por DESCRICAO
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Produto>> GetByDescricao(@PathVariable String descricao) {
		
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	// filtrando produtos por PRECO
	/*@GetMapping("/preco/{preco}")
	public ResponseEntity<List<Produto>> GetByDescricao(@PathVariable double preco) {
		
		return ResponseEntity.ok(repository.findAllByPrecoContainingIgnoreCase(preco));
	}*/

}

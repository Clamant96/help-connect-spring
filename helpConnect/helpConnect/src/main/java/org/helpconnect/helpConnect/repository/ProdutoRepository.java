package org.helpconnect.helpConnect.repository;

import java.util.List;

import org.helpconnect.helpConnect.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	// consulta os produtos por seus titulos que contem os caracteres informados pelo usuario
	public List<Produto> findAllByTituloContainingIgnoreCase (String titulo);
	
	// consulta os produtos por suas descricoes que contem os caracteres informados pelo usuario
	public List<Produto> findAllByDescricaoContainingIgnoreCase (String descricao);

}

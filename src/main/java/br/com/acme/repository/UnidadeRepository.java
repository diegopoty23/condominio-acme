package br.com.acme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.acme.unidade.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long>{

	@Query("SELECT u.numeroUnidade, u.blocoUnidade FROM Unidade u, Multa m WHERE u.codigo = m.unidadeMulta")
	List<Unidade>pesquisarUnidadeComMulta();
	
	@Query("SELECT u.numeroUnidade, u.blocoUnidade FROM Unidade u WHERE u.codigo NOT IN (SELECT m.unidadeMulta FROM Multa m)")
	List<Unidade>pesquisarUnidadeSemMulta();
}

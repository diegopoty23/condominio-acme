package br.com.acme.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.acme.repository.UnidadeRepository;
import br.com.acme.unidade.Unidade;

@Service
public class UnidadeService {
	
	@Autowired
	private UnidadeRepository repository;
	
	@Transactional(readOnly=true)
	public List<Unidade> pesquisarUnidadesComMulta(){
		return this.repository.pesquisarUnidadeComMulta();
	}
	
	@Transactional(readOnly=true)
	public List<Unidade> pesquisarUnidadesSemMulta(){
		return this.repository.pesquisarUnidadeSemMulta();
	}
	
	@Transactional
	public void save(Unidade unidade) {
		this.repository.save(unidade);
	}
	
	@Transactional(readOnly=true)
	public Optional<Unidade> getById(Long id) {
		return this.repository.findById(id);
	}

	
	
}

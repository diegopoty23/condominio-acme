package br.com.acme.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.acme.aviso.Aviso;
import br.com.acme.repository.AvisoRepository;

@Service
public class AvisoService {

	@Autowired
	private AvisoRepository repository;
	
	@Transactional(readOnly=true)
	public List<Aviso> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Aviso aviso) {
		this.repository.save(aviso);
	}
}

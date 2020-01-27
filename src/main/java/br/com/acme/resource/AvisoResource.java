package br.com.acme.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.acme.aviso.Aviso;
import br.com.acme.service.AvisoService;
import br.com.acme.service.UnidadeService;
import br.com.acme.unidade.Unidade;

@RestController
@RequestMapping("/api")
public class AvisoResource {
	
	private AvisoService service;

	private UnidadeService serviceU;

	@Autowired
	public AvisoResource(AvisoService service, UnidadeService serviceU) {
		this.service = service;
		this.serviceU = serviceU;
	}

	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/avisos/{id}")
	public ResponseEntity<Aviso> enviarAvisosParaUnidade(@RequestBody Aviso aviso, @PathVariable Long id) {
		Optional<Unidade> unidade = this.serviceU.getById(id);
		if (unidade.isPresent()) {
			aviso.setUnidadeAviso(unidade.get());
			this.service.save(aviso);
			return new ResponseEntity<Aviso>(aviso, HttpStatus.CREATED);
		}

		return ResponseEntity.noContent().build();
	}

}

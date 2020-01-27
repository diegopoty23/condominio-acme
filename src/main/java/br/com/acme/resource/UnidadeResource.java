package br.com.acme.resource;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.acme.service.UnidadeService;
import br.com.acme.unidade.Unidade;


@RestController
@RequestMapping("/api")
public class UnidadeResource {
	
	private UnidadeService service;

	@Autowired
	public UnidadeResource(UnidadeService service) {
		this.service = service;
	}

	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/unidades")
	public ResponseEntity<Unidade> save(@RequestBody Unidade unidade) {
		this.service.save(unidade);
		return new ResponseEntity<Unidade>(unidade, HttpStatus.CREATED);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/unidadesComMulta")
	public ResponseEntity<List<Unidade>> listUnidadeComMulta() {
		return ResponseEntity.ok(this.service.pesquisarUnidadesComMulta());
		
	}
	
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/unidadesSemMulta")
	public ResponseEntity<List<Unidade>> listUnidadeSemMulta() {
		return ResponseEntity.ok(this.service.pesquisarUnidadesSemMulta());
		
	}
	

	

}

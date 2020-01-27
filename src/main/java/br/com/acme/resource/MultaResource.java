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
import br.com.acme.multas.Multa;
import br.com.acme.service.MultaService;
import br.com.acme.service.UnidadeService;
import br.com.acme.unidade.Unidade;

@RestController
@RequestMapping("/api")
public class MultaResource {

	private MultaService service;

	private UnidadeService serviceU;

	@Autowired
	public MultaResource(MultaService service, UnidadeService serviceU) {
		this.service = service;
		this.serviceU = serviceU;
	}

	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/multas/{id}")
	public ResponseEntity<Multa> enviarMultasParaUnidade(@RequestBody Multa multa, @PathVariable Long id) {
		Optional<Unidade> unidade = this.serviceU.getById(id);
		if (unidade.isPresent()) {
			multa.setUnidadeMulta(unidade.get());
			this.service.save(multa);
			return new ResponseEntity<Multa>(multa, HttpStatus.CREATED);
		}

		return ResponseEntity.noContent().build();
	}

}

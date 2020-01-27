/**
 * 
 */
package br.com.acme.unidade;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.hateoas.ResourceSupport;

import br.com.acme.aviso.Aviso;
import br.com.acme.multas.Multa;
import br.com.acme.responsavel.Responsavel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author carlosfilho
 *
 */
@Entity
@Getter
@Setter
@Table(name = "tb_unidade")
public class Unidade extends ResourceSupport {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_responsavel")
	private Responsavel responsavelUnidade;
	
	private String numeroUnidade;
	
	private String blocoUnidade;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeMulta")
	private Set<Multa> multasUnidade;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeAviso")
	private Set<Aviso> avisosUnidade;
	
}

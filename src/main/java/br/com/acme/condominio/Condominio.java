/**
 * 
 */
package br.com.acme.condominio;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.hateoas.ResourceSupport;
import br.com.acme.aviso.Aviso;
import br.com.acme.multas.Multa;
import lombok.Getter;
import lombok.Setter;

/**
 * @author carlosfilho
 *
 */
@Entity
@Getter
@Setter
@Table(name = "tb_condominio")
public class Condominio extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	private String nome;

	private String email;

	private String telefone;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "condominoMulta")
	private Set<Multa> multasAplicadas;

	@OneToMany
	private Set<Aviso> avisos;

}

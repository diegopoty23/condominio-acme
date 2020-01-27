/**
 * 
 */
package br.com.acme.aviso;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.hateoas.ResourceSupport;
import br.com.acme.unidade.Unidade;
import lombok.Getter;
import lombok.Setter;

/**
 * @author carlosfilho
 *
 */
@Entity
@Getter
@Setter
@Table(name = "tb_avisos")
public class Aviso extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	private String descricaoAviso;
	
	@ManyToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidadeAviso;

//	@ManyToOne
//	@JoinColumn(name = "id_condominio")
//	private Condominio condominoAvisos;
	
	
}

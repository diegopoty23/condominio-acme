/**
 * 
 */
package br.com.acme.multas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.hateoas.ResourceSupport;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.acme.condominio.Condominio;
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
@Table(name = "tb_multas")
public class Multa extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	private String descricaoMulta;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dataMulta;
	
	@ManyToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidadeMulta;
	
	@ManyToOne
	@JoinColumn(name = "id_condominio")
	private Condominio condominoMulta;
	
	private BigDecimal valorMulta;
}

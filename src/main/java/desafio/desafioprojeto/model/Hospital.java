package desafio.desafioprojeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String NomeHospital;
	@ManyToOne
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeHospital() {
		return NomeHospital;
	}

	public void setNomeHospital(String NomeHospital) {
		this.NomeHospital = NomeHospital;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}

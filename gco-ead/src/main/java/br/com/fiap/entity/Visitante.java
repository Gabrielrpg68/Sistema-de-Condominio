package br.com.fiap.entity;

import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_visitante")
public class Visitante {
	
	@Id
	@Column(name = "id_visitante")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_visitante;
	@Column(name="nm_visitante", length = 40, nullable = false)
	private String nm_visitante;
	@Column(name="dt_nasc")
	private Calendar dataNascimento;
	@Column(name = "nr_cpf",length = 14)
	private String cpf;
	@Column(name = "nr_rg",length = 12)
	private String rg;
	@Column(name="dt_cadastro")
	private Calendar dataCadastro;
	
	public Visitante() {
		
	}
	
	public Visitante(String nm_visitante, Calendar dataNascimento, String cpf, String rg, Calendar dataCadastro) {
		super();
		this.nm_visitante = nm_visitante;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.dataCadastro = dataCadastro;
	}

	public Integer getId_visitante() {
		return id_visitante;
	}

	public void setId_visitante(Integer id_visitante) {
		this.id_visitante = id_visitante;
	}

	public String getNm_visitante() {
		return nm_visitante;
	}

	public void setNm_visitante(String nm_visitante) {
		this.nm_visitante = nm_visitante;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataCadastro, dataNascimento, id_visitante, nm_visitante, rg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitante other = (Visitante) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(id_visitante, other.id_visitante) && Objects.equals(nm_visitante, other.nm_visitante)
				&& Objects.equals(rg, other.rg);
	}
	
	
	
	
}

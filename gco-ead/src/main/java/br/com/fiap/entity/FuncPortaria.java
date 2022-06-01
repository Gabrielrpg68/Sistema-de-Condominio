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
@Table(name = "t_gco_func_portaria")
public class FuncPortaria {
	
	@Id
	@Column(name="id_func_portaria")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_funcionario", nullable = false, length = 70)
	private String nome;
	
	@Column(name="dt_nasc")
	private Calendar dataNascimento;
	
	@Column(name = "nr_cpf",length = 14)
	private String cpf;
	
	@Column(name = "nr_rg",length = 12)
	private String rg;
	
	@Column(name = "dt_cadastro", nullable = false)
	private Calendar dataCadastro;

	public FuncPortaria() {
		super();
	}

	public FuncPortaria(Integer codigo, String nome, Calendar dataNascimento, String cpf, String rg,
			Calendar dataCadastro) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.dataCadastro = dataCadastro;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return Objects.hash(codigo, cpf, dataCadastro, dataNascimento, nome, rg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncPortaria other = (FuncPortaria) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(nome, other.nome)
				&& Objects.equals(rg, other.rg);
	}
	
	

}

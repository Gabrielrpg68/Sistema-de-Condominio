package br.com.fiap.entity;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_condominio")
public class Condominio {

	@Id
	@Column(name="id_condominio")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "func")
	private Integer codigo;
	
	@Column(name = "nr_cnpj",length = 18)
	private String cnpj;
	
	@Column(name="ds_razao_social", length = 100)
	private String dsRazaoSocial;
	
	@Column(name="nm_fantasia", length = 40)
	private String nomeFantasia;
	
	@Column(name="dt_fundacao")
	private Calendar dataFundacao;

	
	public Condominio() {
		
	}
	
	public Condominio(String cnpj, String dsRazaoSocial, String nomeFantasia, Calendar dataFundacao) {
		super();
		this.cnpj = cnpj;
		this.dsRazaoSocial = dsRazaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.dataFundacao = dataFundacao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDsRazaoSocial() {
		return dsRazaoSocial;
	}

	public void setDsRazaoSocial(String dsRazaoSocial) {
		this.dsRazaoSocial = dsRazaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, codigo, dataFundacao, dsRazaoSocial, nomeFantasia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condominio other = (Condominio) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(dataFundacao, other.dataFundacao)
				&& Objects.equals(dsRazaoSocial, other.dsRazaoSocial)
				&& Objects.equals(nomeFantasia, other.nomeFantasia);
	}
	
	
	
}

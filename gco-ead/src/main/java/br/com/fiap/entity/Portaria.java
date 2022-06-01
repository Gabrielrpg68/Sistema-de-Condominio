package br.com.fiap.entity;

import java.util.GregorianCalendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_portaria")
public class Portaria {
	
	@Id
	@Column(name="id_portaria")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@OneToOne
	private Condominio condominio;
	
	@Column(name = "nr_portaria", length = 3)
	private Integer nrPortaria;
	
	@Column(name="nm_portaria", nullable = false, length = 70)
	private String nomePortaria;
	
	@Column(name = "st_status",length = 1)
	private String status;
	
	@Column(name = "dt_inicio", nullable = false)
	private GregorianCalendar inicio;
	
	@Column(name = "dt_termino")
	private GregorianCalendar termino;

	public Portaria() {

	}

	public Portaria(Condominio condominio, Integer nrPortaria, String nomePortaria, String status,
			GregorianCalendar inicio, GregorianCalendar termino) {
		super();
		this.condominio = condominio;
		this.nrPortaria = nrPortaria;
		this.nomePortaria = nomePortaria;
		this.status = status;
		this.inicio = inicio;
		this.termino = termino;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public Integer getNrPortaria() {
		return nrPortaria;
	}

	public void setNrPortaria(Integer nrPortaria) {
		this.nrPortaria = nrPortaria;
	}

	public String getNomePortaria() {
		return nomePortaria;
	}

	public void setNomePortaria(String nomePortaria) {
		this.nomePortaria = nomePortaria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public GregorianCalendar getInicio() {
		return inicio;
	}

	public void setInicio(GregorianCalendar inicio) {
		this.inicio = inicio;
	}

	public GregorianCalendar getTermino() {
		return termino;
	}

	public void setTermino(GregorianCalendar termino) {
		this.termino = termino;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, condominio, inicio, nomePortaria, nrPortaria, status, termino);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portaria other = (Portaria) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(condominio, other.condominio)
				&& Objects.equals(inicio, other.inicio) && Objects.equals(nomePortaria, other.nomePortaria)
				&& Objects.equals(nrPortaria, other.nrPortaria) && Objects.equals(status, other.status)
				&& Objects.equals(termino, other.termino);
	}
	
	
}

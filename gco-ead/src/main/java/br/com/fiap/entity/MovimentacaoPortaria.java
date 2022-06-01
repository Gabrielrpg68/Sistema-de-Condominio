package br.com.fiap.entity;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_movimentacao_portaria")
public class MovimentacaoPortaria {

	@Id
	@Column(name = "id_movimentacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "func")
	private Integer codigo;

	@ManyToOne
	@JoinColumn(name="cod_portaria")
	private Portaria portaria;

	@ManyToMany
	@JoinTable(name = "TAB_FUNCIONARIO_CONDOMINIO", joinColumns = @JoinColumn(name = "id_movimentacao"), inverseJoinColumns = @JoinColumn(name = "cod_funcionario_portaria"))
	private List<FuncPortaria> funcionarioPort;

	@ManyToMany
	@JoinTable(name = "TAB_VISITANTE_CONDOMINIO", joinColumns = @JoinColumn(name = "id_movimentacao"), inverseJoinColumns = @JoinColumn(name = "cod_visitante_condominio"))
	private List<Visitante> visitante;

	@Column(name = "tp_movimentacao", length = 50)
	private String tipoMovimentacao;

	@Column(name = "dt_movimentacao")
	private Calendar dataMovimentacao;

	public MovimentacaoPortaria() {

	}

	public MovimentacaoPortaria(Portaria portaria, List<FuncPortaria> funcionarioPort, List<Visitante> visitante,
			String tipoMovimentacao, Calendar dataMovimentacao) {
		super();
		this.portaria = portaria;
		this.funcionarioPort = funcionarioPort;
		this.visitante = visitante;
		this.tipoMovimentacao = tipoMovimentacao;
		this.dataMovimentacao = dataMovimentacao;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Portaria getPortaria() {
		return portaria;
	}

	public void setPortaria(Portaria portaria) {
		this.portaria = portaria;
	}

	public List<FuncPortaria> getFuncionarioPort() {
		return funcionarioPort;
	}

	public void setFuncionarioPort(List<FuncPortaria> funcionarioPort) {
		this.funcionarioPort = funcionarioPort;
	}

	public List<Visitante> getVisitante() {
		return visitante;
	}

	public void setVisitante(List<Visitante> visitante) {
		this.visitante = visitante;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Calendar getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Calendar dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, dataMovimentacao, funcionarioPort, portaria, tipoMovimentacao, visitante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentacaoPortaria other = (MovimentacaoPortaria) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(dataMovimentacao, other.dataMovimentacao)
				&& Objects.equals(funcionarioPort, other.funcionarioPort) && Objects.equals(portaria, other.portaria)
				&& Objects.equals(tipoMovimentacao, other.tipoMovimentacao)
				&& Objects.equals(visitante, other.visitante);
	}

	
}

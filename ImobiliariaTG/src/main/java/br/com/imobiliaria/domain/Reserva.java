package br.com.imobiliaria.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Reserva extends GenericDomain {
	
	@ManyToOne //um usuário pode ter mais de uma reserva
	@JoinColumn(nullable = false)
	private Usuario usuarioLocador;
	
	@ManyToOne //um imóvel pode estar em várias reservas, mas não na mesma data da reserva ???
	@JoinColumn(nullable = false)
	private Imovel imovel;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE) //criar o campo do tipo data
	private Date dataSolicitacao;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE) //criar o campo do tipo data
	private Date dataInicioReserva;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE) //criar o campo do tipo data
	private Date dataFinalReserva;
	
	@Column(nullable = false, precision = 7, scale = 2) //precision é a quantidade de casas decimais, scale é qtd de casas depois da vírgula
	private BigDecimal valorTotal;
	
	@Column(nullable = false)
	private String status;

	public Usuario getUsuarioLocador() {
		return usuarioLocador;
	}

	public void setUsuarioLocador(Usuario usuarioLocador) {
		this.usuarioLocador = usuarioLocador;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Date getDataInicioReserva() {
		return dataInicioReserva;
	}

	public void setDataInicioReserva(Date dataInicioReserva) {
		this.dataInicioReserva = dataInicioReserva;
	}

	public Date getDataFinalReserva() {
		return dataFinalReserva;
	}

	public void setDataFinalReserva(Date dataFinalReserva) {
		this.dataFinalReserva = dataFinalReserva;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

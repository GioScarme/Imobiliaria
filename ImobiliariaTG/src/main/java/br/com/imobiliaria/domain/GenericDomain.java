package br.com.imobiliaria.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/* Essa classe serve para gerar chaves primárias, então toda classe que herdar essa vai 
 * ser gerado a chave primária ID
 * */

@SuppressWarnings("serial")
@MappedSuperclass // notação para dizer que essa classe não pertence a
					// uma tabela mas vai ser usado por outros para gerar
					// tabelas
public class GenericDomain implements Serializable {
	@Id //chave primária
	@GeneratedValue(strategy = GenerationType.AUTO) //auto incremento
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
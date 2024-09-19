package br.com.zgsolucoes.ps.sre

class UserTrade {

	Date data
	String tipoOperacao
	String mercado
	String prazo
	String instrument
	String especificacao
	BigDecimal quantidade
	BigDecimal preco
	BigDecimal valorTotal

	static constraints = {
		data nullable: true
		tipoOperacao nullable: true
		mercado nullable: true
		prazo nullable: true
		instrument nullable: true
		especificacao nullable: true
		quantidade nullable: true
		preco nullable: true
		valorTotal nullable: true
	}
	static mapping = {
		version false
	}
}

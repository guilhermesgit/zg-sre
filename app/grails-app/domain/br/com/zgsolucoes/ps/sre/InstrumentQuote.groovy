package br.com.zgsolucoes.ps.sre

class InstrumentQuote {

	String simbol
	BigDecimal price
	Date date
	static constraints = {
		simbol nullable: true
		price nullable: true
		date nullable: true
	}

	static mapping = {
		version false
	}
}

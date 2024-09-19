package br.com.zgsolucoes.ps.sre

import grails.converters.JSON

class InstrumentQuoteController {

	InstrumentQuoteService instrumentQuoteService

	def list() {
		render([quotes: instrumentQuoteService.list()] as JSON)
	}
}

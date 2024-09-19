package br.com.zgsolucoes.ps.sre

import grails.converters.JSON

class UserTradeController {

	UserTradeService userTradeService

	def list() {
		render([trades: userTradeService.list()] as JSON)
	}
}

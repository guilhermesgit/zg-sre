package br.com.zgsolucoes.ps.sre

import grails.converters.JSON

class HealthcheckController {

	def alive() {
		render([alive: 1] as JSON)
	}
}

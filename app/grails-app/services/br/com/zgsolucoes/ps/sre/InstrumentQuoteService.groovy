package br.com.zgsolucoes.ps.sre

import grails.gorm.transactions.Transactional

@Transactional
class InstrumentQuoteService {

	List<InstrumentQuote> list() {
		log.info('listando instrument quotes')
		InstrumentQuote.list()
	}
}

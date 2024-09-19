package br.com.zgsolucoes.ps.sre

import grails.gorm.transactions.Transactional

@Transactional
class UserTradeService {

	List<UserTrade> list() {
		log.info('listando user trades')
        UserTrade.list()
	}
}

package br.com.zgsolucoes.ps.sre

import grails.gorm.transactions.Transactional
import org.springframework.beans.factory.annotation.Value

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Transactional
class BackgroundJobService {
	@Value('${zgsolucoes.backgroundTask.threadPool}')
	int backgroundTaskThreadPool


	InstrumentQuoteService instrumentQuoteService
	UserTradeService userTradeService

	def execute() {
		final ExecutorService executorService = Executors.newFixedThreadPool(backgroundTaskThreadPool)
		log.info("ThreadPool configurado de $backgroundTaskThreadPool")
		log.info('iniciando job em background')
		final Closure<Void> taskToSubmit = {
			final List<InstrumentQuote> quotesList = instrumentQuoteService.list()
			final List<UserTrade> allUserTrade = []
			quotesList.each { final InstrumentQuote iq ->
				allUserTrade.addAll(userTradeService.list())
			}
			sleep(2_000)
			log.info('processamentos finalizados')
		}

		Thread.start {
			while (true) {
				final int seconds = Math.floor(Math.random() * 60 + 1)
				if (seconds % 4 == 0) {
					continue
				}
				log.info("aguardando ${seconds}s")
				sleep(seconds * 1_000)
				executorService.submit(taskToSubmit)
			}
		}
	}
}

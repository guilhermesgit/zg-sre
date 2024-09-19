import grails.util.BuildSettings
import grails.util.Environment
import org.springframework.boot.logging.logback.ColorConverter
import org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter

import java.nio.charset.Charset

conversionRule 'clr', ColorConverter
conversionRule 'wex', WhitespaceThrowableProxyConverter

def targetDir = BuildSettings.TARGET_DIR

appender('STDOUT', ConsoleAppender) {
	encoder(PatternLayoutEncoder) {
		pattern = "%level %logger - %msg%n"
	}
}
// See http://logback.qos.ch/manual/groovy.html for details on configuration
appender('STDOUT', FileAppender) {
	println("Utilizando diretório para logs: $targetDir")
	file = "${targetDir}/app-ps-sre.log"
	append = true
	encoder(PatternLayoutEncoder) {
		charset = Charset.forName('UTF-8')

		pattern =
				'%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} ' + // Date
						'%clr(%5p) ' + // Log level
						'%clr(---){faint} %clr([%15.15t]){faint} ' + // Thread
						'%clr(%-40.40logger{39}){cyan} %clr(:){faint} ' + // Logger
						'%m%n%wex' // Message
	}

	logger("br.com.zgsolucoes", INFO, ['STDOUT'], false)
}

if (Environment.isDevelopmentMode() && targetDir != null) {
	appender("FULL_STACKTRACE", FileAppender) {
		file = "${targetDir}/stacktrace.log"
		append = true
		encoder(PatternLayoutEncoder) {
			pattern = "%level %logger - %msg%n"
		}
	}
	logger("StackTrace", ERROR, ['FULL_STACKTRACE'], false)
}

root(ERROR, ['STDOUT'])

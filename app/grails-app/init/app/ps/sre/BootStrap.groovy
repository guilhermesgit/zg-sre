package app.ps.sre

import br.com.zgsolucoes.ps.sre.BackgroundJobService

class BootStrap {

    BackgroundJobService backgroundJobService

    def init = { servletContext ->
        backgroundJobService.execute()
    }

    def destroy = {
    }
}

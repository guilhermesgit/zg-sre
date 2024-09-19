import http from 'k6/http'
import { sleep, check } from 'k6'
export const options = {
    vus: 10,
    duration: '30s',
};

export default function () {
    let resInstrumentQuote = http.get('http://app-ps-sre-guilherme-soares.zeroglosa.com.br/instrumentQuote/list')
    check(resInstrumentQuote, { 'instrumentQuote success request': (r) => r.status === 200 })
    let resUserTrade = http.get('http://app-ps-sre-guilherme-soares.zeroglosa.com.br/userTrade/list')
    check(resUserTrade, { 'userTrade success request': (r) => r.status === 200 })
}
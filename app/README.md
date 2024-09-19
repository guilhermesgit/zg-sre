## App Bolsa Valores

Aplicação tem como finalidade armazenar os dados de transação e cotação de ações da bolsa de valores.


### Stack
- Java 8
- Grails Framework
- PostgreSQL

### Endpoints

`GET /instrumentQuote/list`

`GET /userTrade/list`

### Monitoramento
Configurado scrape para metrica prometheus

`GET /prometheus`

### Deploy K8S

```bash
 helm upgrade app-ps-sre chart/ -n zgservicos  --install --create-namespace
```
### Teste de stress

```bash
k6 run k6.js
```

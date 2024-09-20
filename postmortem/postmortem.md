## Postmortem de Incidente

Indisponbilidade da aplicação java app-ps-sre no namespaces zgservicos, pode reiniciando.

Data e Hora: 18/09/2024 14:00

Duração: 100s

Serviço: app-ps-sre

Impacto: Aplicação fora do ar e endpoints sem funcionamento para os usuários.

## Descrição do Problema
Foi avaliado o consumo do cluster , CPU e Memória logo, a primeira ação foi remover os probles para analisar se as aplicações continuariam fora do ar. Com essa alteração o problema ainda persistiu, adicionamos os request novamente e alteramos o values do app-ps-sre. O problema ainda persistiu consumindo muita carga de memória e cpu para a aplicação.

## Linha do Tempo grafana

[15/09/20:00]: Pod com status running depois de carregar o build dentro do kubeclt logs os endpoints funcionam.

[16/09/20:00]: Entre 80 a 100 segundos o pod é reiniciado, mesmo com os resources comentados.

[17/09/20:00]: Analisado via grafana o consumo do cluster em geral e configurado todos os exporters

[18/09/20:00]: Problemas no código com auto consumo do java levando a aplicação ficar em loop.

## Causa Raiz

Depois de analisar o consumo do cluster e aplicações em todos os namespaces a causa raiz do problema é a aplicação Java com alto consumo de cpu e atingindo 100% mesmo adicionando novas réplicas o problema persiste.

## Resolução

Necessário repassar ao setor de desenvolvimento as métricas apresentadas no grafana para efetuar os ajuster na aplicação que causa instabilidade no cluster em geral.

## Lições Aprendidas
[Lição 1]: Efetuar os testes no cluster de desenvolvimento.

[Lição 2]: Toda aplicação tem que ter o exporter para ser monitorada.

[Lição 3]: Necessário configurar eventos para notificar possíveis problemas, webhooks, e-mails.

## Ações de Melhoria

[Ação 1]: Adicionar mais workers nodes no cluster Kubernetes

[Ação 2]: Adiciondo cluster de desevolvimento para não impactar produção.

[Ação 3]: Necessário acompanhar as métricas do exporter da aplicação antes de ir para produção.

## Conclusão

Para ter resiliência nas aplicações , ter mais worker nodes , o control plane não poderá rodar pods e ter cluster de desenvolvimento para não causar a indisponbilidade nos clientes.


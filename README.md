# Sistema de Parquímetro - Relatório Técnico

Este repositório contém a implementação de um Sistema de Parquímetro baseado em uma arquitetura monolítica, usando Java Spring Boot e contêineres Docker para facilitar o empacotamento e implantação. O sistema também faz uso do serviço AWS SNS para notificações em tempo real relacionadas ao tempo estacionado.

## Arquitetura Monolítica

O sistema é projetado como uma aplicação monolítica, onde todos os componentes, como Registro de Condutores e Veículos, Registro de Forma de Pagamento, Controle de Tempo Estacionado e Emissão de Recibos, estão integrados em um único aplicativo Spring Boot. Essa abordagem simplifica o desenvolvimento e a implantação da aplicação.

## Utilização de Containers Docker

Cada módulo do sistema é encapsulado em um container Docker independente. Isso garante que o ambiente de execução seja consistente e portátil, facilitando a implantação em diferentes ambientes.

## Utilização de AWS SNS para Notificação

O AWS SNS (Simple Notification Service) é utilizado para notificar os condutores em relação ao tempo estacionado a cada hora. O sistema gera alertas periodicamente e envia notificações por meio do SNS para os dispositivos móveis dos condutores registrados. Isso garante que os condutores estejam cientes do tempo de estacionamento e das cobranças em andamento.

## Estratégias de Otimização para Consultas ao Banco de Dados

Para manter o desempenho do sistema e reduzir o número de consultas ao banco de dados, implementamos as seguintes estratégias:

- **Caching:** Utilizamos um sistema de cache para armazenar temporariamente dados frequentemente acessados, como informações sobre condutores e formas de pagamento.

- **Batch Processing:** Tarefas de processamento em lote são usadas para operações que envolvem várias consultas em lote, minimizando as consultas em tempo real.

- **Denormalização de Dados:** Em algumas situações, denormalizamos dados para reduzir a complexidade das consultas.

- **Uso de Índices:** Criamos índices eficazes nas tabelas do banco de dados para acelerar as consultas.

- **Otimização de Consultas:** Realizamos otimizações nas consultas SQL, evitando subconsultas e utilizando eficientemente as cláusulas JOIN.

## Escalabilidade dos Serviços

Embora a arquitetura seja monolítica, medidas são tomadas para garantir escalabilidade:

- O uso de containers Docker facilita a replicação dos serviços para lidar com cargas maiores.
- A configuração adequada de recursos no ambiente de execução permite escalonar verticalmente quando necessário.
- O uso de caches e otimizações de banco de dados ajuda a manter o desempenho à medida que o sistema cresce.

---

Este relatório técnico fornece uma visão geral da implementação do Sistema de Parquímetro, destacando a arquitetura monolítica, o uso de contêineres Docker, notificações com AWS SNS e estratégias de otimização de banco de dados. Ele também aborda as considerações de escalabilidade.

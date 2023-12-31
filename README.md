# Sistema de Parquímetro

Este repositório contém a implementação de um Sistema de Parquímetro baseado em uma arquitetura monolítica, usando Java Spring Boot e contêineres Docker para facilitar o empacotamento e implantação. O sistema também faz uso do serviço AWS SNS para notificações em tempo real relacionadas ao tempo estacionado.

## Arquitetura Monolítica

A arquitetura monolítica é uma abordagem de design de software em que todas as funcionalidades de um aplicativo são agrupadas em um único código-fonte e implantadas como uma única unidade. Para o Sistema de Parquímetro, optamos por essa arquitetura, uma vez que o aplicativo pode ser gerenciado de forma mais simples, especialmente para um escopo moderado de funcionalidades.

No contexto da arquitetura monolítica, o aplicativo Spring Boot é responsável por todos os aspectos do sistema, desde o registro de condutores e veículos até o controle de tempo estacionado e emissão de recibos. Os principais componentes, como controllers, serviços, modelos e repositórios, estão todos contidos em um único aplicativo.

Essa abordagem oferece simplicidade na implantação, testes e manutenção, tornando-a adequada para sistemas de tamanho moderado, como o Sistema de Parquímetro. No entanto, é importante ter em mente que a escalabilidade pode ser um desafio em aplicações monolíticas, especialmente à medida que crescem.


### Utilização de Containers Docker

O uso de containers Docker é essencial para manter a consistência e a portabilidade do ambiente de execução do Sistema de Parquímetro. Cada módulo do sistema, como Registro de Condutores e Veículos, Registro de Forma de Pagamento e outros, é empacotado em um container Docker independente.

Isso oferece várias vantagens:

- Portabilidade: Os containers podem ser executados em qualquer ambiente que suporte Docker, garantindo que o aplicativo funcione de maneira consistente em diferentes ambientes de desenvolvimento, teste e produção.

- Isolamento: Cada container é isolado, o que evita conflitos entre dependências e componentes do sistema.

- Gerenciamento Simplificado: O Docker simplifica o gerenciamento de dependências e versões, tornando a implantação mais eficiente.

O Docker também é útil para escalabilidade, pois permite a replicação de containers para lidar com cargas maiores. Além disso, a escalabilidade vertical (aumento de recursos em um único container) é uma opção para lidar com picos de carga.

### Utilização de AWS SNS para Notificação

O AWS SNS (Simple Notification Service) é usado para notificar os condutores sobre o tempo estacionado a cada hora. O sistema gera alertas periodicamente e envia notificações por meio do SNS para os dispositivos móveis dos condutores registrados.

Isso garante que os condutores estejam cientes do tempo de estacionamento e das cobranças em andamento. A integração com o SNS é feita por meio de APIs do AWS, que permitem o envio de notificações push para os dispositivos móveis.

Essa abordagem oferece notificações em tempo real, garantindo que os condutores sejam informados sobre o tempo de estacionamento e os pagamentos de forma oportuna, melhorando a experiência do usuário.

### Estratégias de Otimização para Consultas ao Banco de Dados

As estratégias de otimização de consultas ao banco de dados são cruciais para manter o desempenho do sistema e reduzir o número de consultas repetitivas. Essas estratégias incluem:

- Caching: A implementação de armazenamento em cache permite que os dados frequentemente acessados sejam mantidos em memória. Isso reduz a necessidade de consultas repetitivas ao banco de dados, melhorando o desempenho. No código Java, a configuração de caching é feita por meio de anotações como @Cacheable, que controlam quais resultados de métodos devem ser armazenados em cache.

- Batch Processing: O processamento em lote envolve o processamento eficiente de grandes volumes de dados em lotes. Para implementar o processamento em lote, o Spring Batch é uma escolha comum. Ele permite definir tarefas em lote, leituras/gravações de dados e configurações de tarefas de forma estruturada. Leituras e gravações em lote podem ser configuradas usando classes específicas, como FlatFileItemReader para ler dados de um arquivo ou JdbcBatchItemWriter para gravar dados no banco de dados. A configuração do processo em lote é feita por meio de arquivos XML ou código Java.

Essas estratégias ajudam a otimizar o acesso ao banco de dados, reduzindo o número de consultas e melhorando o desempenho geral do aplicativo.

## Escalabilidade dos Serviços

Embora a arquitetura seja monolítica, medidas são tomadas para garantir escalabilidade:

- O uso de containers Docker facilita a replicação dos serviços para lidar com cargas maiores.
- A configuração adequada de recursos no ambiente de execução permite escalonar verticalmente quando necessário.
- O uso de caches e otimizações de banco de dados ajuda a manter o desempenho à medida que o sistema cresce.

### Ferramentas e Tecnologias Utilizadas

- **Linguagem de Programação:** Java
- **Framework:** Spring Boot
- **Contêineres:** Docker
- **Serviço de Notificação:** AWS SNS
- **Frameworks e Bibliotecas:** Spring Batch, Lombok, Bean Validation, JPA
- **Padrão de Projeto:** Camada MVC


### Desafios Encontrados

Durante a implementação do Sistema de Parquímetro, enfrentamos vários desafios, incluindo:

- **Escalabilidade:** A arquitetura monolítica, embora ofereça simplicidade, pode apresentar desafios de escalabilidade à medida que o aplicativo cresce. Implementamos estratégias para escalabilidade vertical e replicação de containers para lidar com isso.

- **Otimização de Banco de Dados:** Garantir que as consultas ao banco de dados sejam eficientes foi um desafio, especialmente ao lidar com grande volume de dados. Implementamos caching e processamento em lote para mitigar esse desafio.

- **Integração com AWS SNS:** A integração com o serviço AWS SNS para notificações em tempo real exigiu um entendimento aprofundado da API e configuração adequada.

- **Construção de Projeto em Camada:** A estruturação do projeto em camadas no formato MVC exigiu a definição clara de responsabilidades de cada componente, facilitando a manutenção e o desenvolvimento futuro.

- **Annotations no Spring Boot:** A utilização de anotações como Lombok e Bean Validation simplificou o código, tornando-o menos verboso e mais fácil de ser mantido.

- **Utilização de DTO:** A adoção de objetos de transferência de dados (DTO) aprimorou a segurança das informações trafegadas na API, mantendo a responsabilidade das classes de domínio separada.

- **JPA para Manipulação do Banco de Dados:** O uso do JPA simplificou a manipulação do banco de dados, aproveitando os métodos úteis já existentes e facilitando a criação de consultas personalizadas.

- **Validação de Erros nas Requisições:** Através do ControlerAdvice do Spring, conseguimos criar tratativas específicas para possíveis exceções que podem ocorrer nas requisições, retornando erros claros com seus respectivos códigos de status HTTP.


---

Este relatório técnico fornece uma visão geral da implementação do Sistema de Parquímetro, destacando a arquitetura monolítica, o uso de contêineres Docker, notificações com AWS SNS e estratégias de otimização de banco de dados. Ele também aborda as considerações de escalabilidade.
